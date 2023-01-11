import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class gui {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1000, 800));
        Color DARK_BLUE   = new Color(11,58,151,255);
        Color BLUE = new Color(1,180,245,255);
        Color PINK_RED = new Color(246,0,107,255);
        Font  f1  = new Font(Font.SANS_SERIF,  Font.BOLD, 16);
        frame.getContentPane().setBackground(DARK_BLUE);
        frame.pack();
        frame.setVisible(true);

        JButton button1 = new JButton("Withdraw");
        JButton button2 = new JButton("Deposit");
        JButton button3 = new JButton("Transfer");
        JButton button4 = new JButton("Change PIN");
        JButton button5 = new JButton("EXIT");
        button1.setBounds(500,200,200,100);
        button2.setBounds(725,200,200,100);
        button3.setBounds(500,325,200,100);
        button4.setBounds(725,325,200,100);
        button5.setBounds(900,725,75,30);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.add(button5);
        button1.setForeground(Color.WHITE);
        button2.setForeground(Color.WHITE);
        button3.setForeground(Color.WHITE);
        button4.setForeground(Color.WHITE);
        button5.setForeground(Color.WHITE);
        button1.setBackground(BLUE);
        button2.setBackground(BLUE);
        button3.setBackground(BLUE);
        button4.setBackground(BLUE);
        button5.setBackground(PINK_RED);
        button1.setFont(f1);
        button2.setFont(f1);
        button3.setFont(f1);
        button4.setFont(f1);
        button5.setFont(f1);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}