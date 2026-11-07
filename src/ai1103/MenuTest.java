package ai1103;

import center.SetFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class MenuTest extends JFrame {
    JTextArea textArea = new JTextArea();
    JFileChooser fileChooser = new JFileChooser();
    JFrame frame;
    // 툴바 아이콘 배열에 save 추가 (new, open, save, close, white, blue, magenta)
    String[] iconFileNames = {"new", "open", "save", "close", "white", "blue", "magenta"};
    Color[] colorNames = {Color.WHITE, Color.BLUE, Color.MAGENTA};
    JButton[] btn = new JButton[7]; // 툴바 버튼 7개로 수정

    public MenuTest(){
        frame = this;
        JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane);

        JToolBar toolBar = new JToolBar();
        add("North", toolBar);

        for (int i = 0; i < btn.length; i++) {
            btn[i] = new JButton(new ImageIcon("toolbar/" + iconFileNames[i] + ".png"));
            btn[i].addActionListener(btnListener);
            toolBar.add(btn[i]);
        }

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        JMenuItem newMenuItem = new JMenuItem("New");   // textArea의 문자열 초기화
        JMenuItem openMenuItem = new JMenuItem("Open"); // 파일 불러오기
        JMenuItem saveMenuItem = new JMenuItem("Save"); // 파일 저장하기 (추가된 부분)
        JMenuItem closeMenuItem = new JMenuItem("Close");// 프로그램 종료

        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem); // 메뉴에 Save 추가
        fileMenu.add(closeMenuItem);

        JMenuItem WhiteMenuItem = new JMenuItem("White");
        JMenuItem blueMenuItem = new JMenuItem("Blue");
        JMenuItem magentaMenuItem = new JMenuItem("Magenta");

        editMenu.add(WhiteMenuItem);
        editMenu.add(blueMenuItem);
        editMenu.add(magentaMenuItem);

        newMenuItem.addActionListener(fileListener);
        openMenuItem.addActionListener(fileListener);
        saveMenuItem.addActionListener(fileListener); // Save 리스너 등록
        closeMenuItem.addActionListener(fileListener);

        WhiteMenuItem.addActionListener(backgroundListener);
        blueMenuItem.addActionListener(backgroundListener);
        magentaMenuItem.addActionListener(backgroundListener);

        SetFrame.setFrame(this, "메뉴만들기", 500, 500);
    }

    ActionListener fileListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            File selectedFile;
            switch (e.getActionCommand()){
                case "New":
                    textArea.setText("");
                    break;
                case "Open":
                    if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
                        selectedFile = fileChooser.getSelectedFile();
                        textArea.setText(readFile(selectedFile));
                    }
                    break;
                case "Save": // Save 기능 구현
                    if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
                        selectedFile = fileChooser.getSelectedFile();
                        saveFile(selectedFile);
                    }
                    break;
                case "Close":
                    System.exit(0);
                    break;
            }
        }
    };

    ActionListener btnListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton eBtn = (JButton) e.getSource();
            File selectedFile;

            if(eBtn == btn[0]){
                textArea.setText("");
            } else if (eBtn == btn[1]) {
                if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fileChooser.getSelectedFile();
                    textArea.setText(readFile(selectedFile));
                }
            } else if (eBtn == btn[2]) { // 툴바의 세 번째 버튼(Save)
                if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fileChooser.getSelectedFile();
                    saveFile(selectedFile);
                }
            } else if (eBtn == btn[3]) { // 툴바의 네 번째 버튼(Close)
                System.exit(0);
            }

            // 색상 버튼 인덱스 조정 (버튼이 늘어남에 따라 배경색 버튼은 4번 인덱스부터 시작)
            for (int i = 0; i < colorNames.length; i++) {
                if(eBtn == btn[i + 4]){
                    textArea.setBackground(colorNames[i]);
                }
            }
        }
    };

    ActionListener backgroundListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Color color = null;
            switch (e.getActionCommand()) {
                case "White":
                    color = Color.WHITE;
                    break;
                case "Blue" :
                    color = Color.BLUE;
                    break;
                case "Magenta" :
                    color = Color.MAGENTA;
                    break;
            }
            textArea.setBackground(color);
        }
    };

    public String readFile(File selectedFile){
        String totalLines = "";
        try{
            String line = "";
            FileReader fr = new FileReader(selectedFile);
            BufferedReader br = new BufferedReader(fr);
            while((line = br.readLine()) != null){
                totalLines += line + "\n";
            }
            br.close();
        }catch (FileNotFoundException e) {
            textArea.setText("File not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return totalLines;
    }

    // 파일 저장을 담당하는 메서드 추가
    public void saveFile(File selectedFile) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(selectedFile));
            bw.write(textArea.getText());
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new MenuTest();
    }
}