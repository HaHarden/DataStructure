package com.swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test {
    private JLabel control;
    private JButton ok;
    private JButton submit;
    private JButton cancel;
    private JLabel status;
    private JPanel panel;

    public Test() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //e.getActionCommand() 结果为 button的text值
                if(e.getActionCommand().equals("OK")) {
                    status.setText("OK is clicked");
                }
                else if(e.getActionCommand().equals("Submit")) {
                    status.setText("Submit is clicked");
                }
                else if(e.getActionCommand().equals("Cancel")) {
                    status.setText("Cancel is clicked");
                }
            }
        };
        ok.addActionListener(listener);
        cancel.addActionListener(listener);
        submit.addActionListener(listener);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("myTest");
        Test test = new Test();
//        test.panel.setSize(800, 800);
        frame.setContentPane(test.panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
    }
}
