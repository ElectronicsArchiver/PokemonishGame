package client;
import java.awt.*;
import java.awt.event.*;
// import java.io.IOException;

import javax.swing.*;

public class ClientUI extends JFrame{
    
    public static void main(String[] args) {
        // debug
        ClientUI client = new ClientUI();
        client.setStatus("newStatus");
        String[] testWaza = {"hello", "he", "ll", "o"};
        client.setWaza(testWaza);
        client.log("1\n");
        client.log("2\n");
        client.setImage("client/image/a.png");
        client.setHp(20);
        client.setButtonAction(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
              JOptionPane.showMessageDialog
              (null, client.getSelectedWaza());
            }
        });
        client.clearLog();
    }
    
    JLabel imageLabel;
    JLabel statusLabel;
    JList<String> wazaList;
    JButton okButton;
    JTextArea logArea;
    JProgressBar hpBar;

    ClientUI() {
        setTitle("Pokemonish Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        getContentPane().setLayout(new FlowLayout());
        
        imageLabel = new JLabel("no image");
        imageLabel.setBounds(5, 5, 100, 100);
        statusLabel = new JLabel("wait for status");
        hpBar = new JProgressBar(1, 100);
        hpBar.setBounds(0, 0, 100, 5);
        hpBar.setValue(100);
        String[] initialList = {"a", "b", "c", "d"};
        wazaList = new JList<>(initialList);
        okButton = new JButton("OK");
        logArea = new JTextArea("log start...\n", 5, 20);

        //TODO: set size of each component
        
        getContentPane().add(imageLabel);
        getContentPane().add(statusLabel);
        getContentPane().add(hpBar);
        getContentPane().add(wazaList);
        getContentPane().add(okButton);
        getContentPane().add(logArea);
        setVisible(true);
    }    

    public void setStatus(String newStatus) {
        statusLabel.setText(newStatus);
    }

    public void setWaza(String[] newWaza) {
        wazaList.setListData(newWaza);
    }

    public void setImage(String file) {
        ImageIcon icon = new ImageIcon(file);
        imageLabel.setIcon(icon);
        imageLabel.setText("");
    }

    public void setButtonAction(ActionListener a) {
        okButton.addActionListener(a);
    }

    public void log(String log) {
        logArea.append(log);
    }

    public void clearLog() {
        logArea.setText(null);
    }

    public void setHp(int hp){
        // from 0 to 100 integer
        hpBar.setValue(hp);
    }

    public int getSelectedWaza(){
        return wazaList.getSelectedIndex();
    }
}