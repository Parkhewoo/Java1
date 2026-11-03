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
    String[] iconFileNames = {"new", "open", "close", "white", "blue", "magenta"};
    Color[] colorNames= {Color.WHITE, Color.BLUE, Color.MAGENTA};
    JButton[] btn = new JButton[6];

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

        JMenuItem newMenuItem = new JMenuItem("New");//textArea의 문자열 초기화
        JMenuItem openMenuItem = new JMenuItem("Open");//JFileChooser(showOpenDialog() 사용)
        JMenuItem closeMenuItem = new JMenuItem("Close");//System.EXIT
        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(closeMenuItem);

        JMenuItem WhiteMenuItem = new JMenuItem("White");
        JMenuItem blueMenuItem = new JMenuItem("Blue");
        JMenuItem magentaMenuItem = new JMenuItem("Magenta");

        editMenu.add(WhiteMenuItem);
        editMenu.add(blueMenuItem);
        editMenu.add(magentaMenuItem);

        newMenuItem.addActionListener(fileListener);
        openMenuItem.addActionListener(fileListener);
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
                    fileChooser.showOpenDialog(frame);
                    selectedFile = fileChooser.getSelectedFile();
                    textArea.setText(readFile(selectedFile));
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
                fileChooser.showOpenDialog(frame);
                selectedFile = fileChooser.getSelectedFile();
                textArea.setText(readFile(selectedFile));
            } else if (eBtn == btn[2]) {
                System.exit(0);
            }

            for (int i = 0; i < colorNames.length; i++) {
                if(eBtn == btn[i + 3]){
                    textArea.setBackground(colorNames[i]);
                }
            }
            
        }
    };

    ActionListener backgroundListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            Color color = null;
            switch ( e.getActionCommand()) {
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
            while((line =br.readLine()) != null){
                totalLines += line + "\n";
            }
        }catch (FileNotFoundException e) {
            textArea.setText("File not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return totalLines;
    }

    public static void main(String[] args) {
        new MenuTest();
    }
}
