package gorodilov;


import jdk.nashorn.internal.runtime.regexp.joni.Warnings;
import sun.plugin2.message.ShowDocumentMessage;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

class MyWindow extends JFrame {
    public MyWindow() {
        setTitle("Chat window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);


////////////////////////////////////////////////////////////////
        JMenuBar mainMenu = new JMenuBar();
        JMenu mFile = new JMenu("Menu");
        JMenu mEdit = new JMenu("Help");
        JMenuItem miFileNew = new JMenuItem("Clear");
        JMenuItem miFileExit = new JMenuItem("Exit");
        JMenuItem miEditHelp = new JMenuItem("?");

        setJMenuBar(mainMenu);
        mainMenu.add(mFile);
        mainMenu.add(mEdit);
        mainMenu.add(mEdit);
        mFile.add(miFileNew);
        mFile.addSeparator();
        mFile.add(miFileExit);
        mEdit.add(miEditHelp);
        miFileExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        miFileNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MyWindow();
            }
        });

        miEditHelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Help не работает");
            }
        });
        
/////////////////////////////////////////////////////////////
        JPanel centerpanel = new JPanel();
        JPanel bottompanel = new JPanel();
        centerpanel.setBackground(Color.lightGray);
        bottompanel.setBackground(Color.gray);
        add(centerpanel, BorderLayout.CENTER);
        add(bottompanel, BorderLayout.SOUTH);
        centerpanel.setLayout(new BorderLayout());
        bottompanel.setLayout(new FlowLayout());


        JTextArea jta = new JTextArea();
        jta.setEditable(false);

        JScrollPane jsp = new JScrollPane(jta);
        centerpanel.add(jsp,BorderLayout.CENTER);

        JTextField jtf = new JTextField();
        bottompanel.add(jtf);
        jtf.setPreferredSize(new Dimension(300,20));

        JButton button = new JButton("Send");
        bottompanel.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jta.append(jtf.getText() + "\n");
                jtf.setText(" ");
                jtf.grabFocus();
            }
        });
         jtf.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jta.append(jtf.getText() + "\n");
                    jtf.setText(" ");
                    jtf.grabFocus();
                }
        });

         setVisible(true);
    }
}


public class Main {

    public static void main(String[] args)
    {
      new MyWindow();
       }
}
