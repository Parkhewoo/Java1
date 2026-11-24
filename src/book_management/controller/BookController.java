package book_management.controller;

import book_management.domain.Book;
import book_management.repository.BookRepository;
import book_management.view.BookInsertPan;
import book_management.view.BookSearchPan;
import book_management.view.BookUpdatePan;
import book_management.view.center.SetFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class BookController extends JFrame {
    JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
    BookRepository repository;
    ArrayList<Book> bookList;
    JComboBox<String> combo;
    BookSearchPan searchPan;
    BookInsertPan insertPan;
    BookUpdatePan updatePan;
    JTable updateTable;

    public BookController() {
        searchPan = new BookSearchPan();
        combo = searchPan.getCombo();
        repository = new BookRepository();
        bookList = repository.select(searchPan.getSearchWord(), combo.getSelectedIndex());
        searchPan.setBookList(bookList);
        searchPan.initView();

        insertPan = new BookInsertPan();
        insertPan.setBookList(bookList);
        insertPan.initView();

        updatePan = new BookUpdatePan();
        updatePan.setBookList(bookList);
        updatePan.initView();


        JButton btnSearch = searchPan.getBtnSearch();
        btnSearch.addActionListener(btnSearchListener);

        JButton btnInsert = insertPan.getBtnInsert();
        btnInsert.addActionListener(btnInsertListener);

        updateTable = updatePan.getTable();
        updateTable.addMouseListener(updateTableListener);
        JButton btnUpdate = updatePan.getBtnUpdate();
        btnUpdate.addActionListener(btnUpdateListener);

        tabbedPane.add("도서 검색", searchPan);
        tabbedPane.add("도서 추가", insertPan);
        tabbedPane.add("수정 및 삭제", updatePan);

        tabbedPane.addMouseListener(tabbedPaneListener);

        add(tabbedPane);

        SetFrame.setFrame(this, "도서관리 시스템", 700, 600);
    }

    ActionListener btnSearchListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            bookList = repository.select(searchPan.getSearchWord(), combo.getSelectedIndex());
            searchPan.setBookList(bookList);
            searchPan.putSearchResult();
        }
    };
    ActionListener btnInsertListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Book book = insertPan.getBook();
            repository.insert(book);
            ArrayList<Book> insertBookList = new ArrayList<Book>();
            insertBookList = repository.select("", 0);
            insertPan.setBookList(insertBookList);
            insertPan.putSearchResult();
        }
    };

    MouseAdapter updateTableListener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 1) {
                int rowIndex = updateTable.getSelectedRow();
                updatePan.setTextField(rowIndex);
            }

            if (e.getClickCount() == 2) {
                int result = JOptionPane.showConfirmDialog(BookController.this, "정말로 삭제하시겠습니까?", "삭제",
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (result == 0) {//0: yes, 1: no
                    DefaultTableModel model = updatePan.getModel();
                    int rowIndex = updateTable.getSelectedRow();
                    String isbn = (String) model.getValueAt(rowIndex, 0);
                    repository.delete(isbn);
                    bookList = repository.select("", 0);
                    updatePan.setBookList(bookList);
                    updatePan.putSearchResult();
                }
            }
        }
    };

    ActionListener btnUpdateListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Book book = updatePan.getBook();
            repository.update(book);
            ArrayList<Book> updateBookList = new ArrayList<Book>();
            updateBookList = repository.select("", 0);
            updatePan.setBookList(updateBookList);
            updatePan.putSearchResult();
        }
    };

    MouseAdapter tabbedPaneListener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int tabIndex = tabbedPane.getSelectedIndex();
            bookList = repository.select("", 0);
            switch (tabIndex) {
                case 0:
                    searchPan.setBookList(bookList);
                    searchPan.putSearchResult();
                    break;
                case 1:
                    insertPan.setBookList(bookList);
                    insertPan.putSearchResult();
                    break;
                case 2:
                    updatePan.setBookList(bookList);
                    updatePan.putSearchResult();
                    break;
            }
        }
    };

    public static void main(String[] args) {
        new BookController();
    }
}
