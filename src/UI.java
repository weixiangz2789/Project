import org.w3c.dom.Text;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

public class UI {
    private static String user;
    private static int pinNum;

    public static void introFrame() {

        Color background = new Color(28,36,52);
        Font f1 = new Font(Font.SANS_SERIF, Font.BOLD, 22);

        JFrame intro = new JFrame();
        intro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        intro.setPreferredSize(new Dimension(850, 650));
        intro.getContentPane().setBackground(background);
        intro.pack();

        JLabel name = new JLabel("Enter Name: ");
        JLabel pin = new JLabel("Create a PIN: ");
        name.setBounds(100, 105, 200, 100);
        pin.setBounds(100,165, 200, 100);

        JTextField name_field = new JTextField();
        JTextField pin_field = new JTextField();
        name_field.setBounds(250,140,300,35);
        pin_field.setBounds(250,200,300,35);

        name.setForeground(Color.WHITE);
        pin.setForeground(Color.WHITE);
        intro.add(name_field);
        intro.add(name);
        intro.add(pin);
        intro.add(pin_field);

        JButton submit = new JButton("Submit");
        submit.setBounds(100, 400, 200, 35);
        intro.add(submit);

        name.setFont(f1);
        name_field.setFont(f1);
        pin.setFont(f1);
        pin_field.setFont(f1);
        submit.setBackground(Color.white);
        submit.setFont(f1);
        submit.setBorderPainted(false);

        name_field.setBorder(BorderFactory.createEmptyBorder());
        pin_field.setBorder(BorderFactory.createEmptyBorder());

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    user = name_field.getText();
                    pinNum = Integer.parseInt(pin_field.getText());
                    createFrame();
                    intro.dispose();
                }
                catch (NumberFormatException pinNum) {
                    JOptionPane.showMessageDialog(null, "Make sure you are entering a valid name or pin!" );
                }
            }
        });

        intro.setLayout(null);
        intro.setVisible(true);
    }

    public static void createFrame() {
        Customer customer = new Customer (user, pinNum);

        // Colors + Fonts
        Color background = new Color(28,36,52);
        Color BLUE = new Color(40, 140, 215);
        Color LIGHT_BLUE = new Color(5, 180, 244);
        Color PINK_RED = new Color(243, 4, 107);
        Font f1 = new Font(Font.SANS_SERIF, Font.BOLD, 16);
        Font f2 = new Font(Font.SANS_SERIF, Font.BOLD, 35);
        Font f3 = new Font(Font.SANS_SERIF, Font.BOLD, 22);
        Font f4 = new Font(Font.SANS_SERIF, Font.PLAIN, 16);

        //  Creates Frames
        JFrame mainFrame = new JFrame();
        JFrame withdrawFrame = new JFrame();
        JFrame depositFrame = new JFrame();
        JFrame transferFrame = new JFrame();
        JFrame pinFrame = new JFrame();

        JFrame[] frames = {mainFrame, withdrawFrame, depositFrame, transferFrame, pinFrame};

        for (int i = 0; i < frames.length; i ++) {
            frames[i].setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frames[i].setPreferredSize(new Dimension(850, 650));
            frames[i].getContentPane().setBackground(background);
            frames[i].pack();
            frames[i].setLayout(null);
            if (i == 0) {
                frames[i].setVisible(true);
            }
        }

        // Creates Buttons
        JButton withdrawButton = new JButton("Withdraw");
        JButton depositButton = new JButton("Deposit");
        JButton transferButton = new JButton("Transfer");
        JButton pinButton = new JButton("Change PIN");
        JButton exit = new JButton("EXIT");
        JButton[] buttonArr = {withdrawButton, depositButton, transferButton, pinButton, exit};
        withdrawButton.setBounds(325, 200, 225, 100);
        depositButton.setBounds(575, 200, 225, 100);
        transferButton.setBounds(325, 325, 225, 100);
        pinButton.setBounds(575, 325, 225, 100);
        exit.setBounds(750, 565, 75, 30);
        for (int i = 0; i < 5; i++) {
            mainFrame.add(buttonArr[i]);
            buttonArr[i].setForeground(Color.WHITE);
            buttonArr[i].setBackground(LIGHT_BLUE);
            buttonArr[i].setBorderPainted(false);
            if (i == 4) {
                exit.setBackground(PINK_RED);
            }
            buttonArr[i].setFont(f1);
        }


        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(false);
                depositFrame.setVisible(true);
                JLabel accNum = new JLabel("Account Number: ");
                JLabel depAmount = new JLabel("Deposit Amount: ");
                accNum.setBounds(100, 105, 200, 100);
                depAmount.setBounds(100,165,200,100);

                JTextField accNum_field = new JTextField();
                JTextField depAmount_field = new JTextField();
                accNum_field.setBounds(250, 140, 300, 35);
                depAmount_field.setBounds(250, 200, 300, 35);

                JButton submit = new JButton("Submit");
                submit.setBounds(100, 400, 200, 35);
                depositFrame.add(submit);

                accNum.setFont(f1);
                depAmount.setFont(f1);
                accNum.setForeground(Color.WHITE);
                depAmount.setForeground(Color.WHITE);
                submit.setBackground(Color.WHITE);
                submit.setFont(f1);
                submit.setBorderPainted(false);

                depAmount_field.setBorder(BorderFactory.createEmptyBorder());
                accNum_field.setBorder(BorderFactory.createEmptyBorder());

                depositFrame.add(accNum);
                depositFrame.add(accNum_field);
                depositFrame.add(depAmount);
                depositFrame.add(depAmount_field);
                depositFrame.add(submit);

                JButton back = new JButton("Back");
                back.setBounds(750, 565, 75, 30);
                back.setForeground(Color.WHITE);
                back.setBackground(PINK_RED);
                depositFrame.add(back);

                submit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            customer.getAccount().deposit(Integer.parseInt(accNum_field.getText()), Double.parseDouble(depAmount_field.getText()));
                            depositFrame.setVisible(false);
                            mainFrame.setVisible(true);

                        }
                        catch (NumberFormatException pinNum) {
                            JOptionPane.showMessageDialog(null, "Make sure you are entering a valid number!" );
                        }
                    }
                });

                back.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        pinFrame.dispose();
                        mainFrame.setVisible(true);
                    }
                });

            }
        });

        pinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(false);
                pinFrame.setVisible(true);
                JLabel accNum = new JLabel("Account Number: ");
                JLabel depAmount = new JLabel("Deposit Amount: ");
                accNum.setBounds(100, 105, 200, 100);
                depAmount.setBounds(100,165,200,100);

                JTextField accNum_field = new JTextField();
                JTextField depAmount_field = new JTextField();
                accNum_field.setBounds(250, 140, 300, 35);
                depAmount_field.setBounds(250, 200, 300, 35);

                JButton submit = new JButton("Submit");
                submit.setBounds(100, 400, 200, 35);
                depositFrame.add(submit);

                accNum.setFont(f1);
                depAmount.setFont(f1);
                accNum.setForeground(Color.WHITE);
                depAmount.setForeground(Color.WHITE);
                submit.setBackground(Color.WHITE);
                submit.setFont(f1);
                submit.setBorderPainted(false);

                depAmount_field.setBorder(BorderFactory.createEmptyBorder());
                accNum_field.setBorder(BorderFactory.createEmptyBorder());

                pinFrame.add(accNum);
                pinFrame.add(accNum_field);
                pinFrame.add(depAmount);
                pinFrame.add(depAmount_field);
                pinFrame.add(submit);

                JButton back = new JButton("Back");
                back.setBounds(750, 565, 75, 30);
                back.setForeground(Color.WHITE);
                back.setBackground(PINK_RED);
                pinFrame.add(back);

                submit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {

                        }
                        catch (NumberFormatException pinNum) {
                            JOptionPane.showMessageDialog(null, "Make sure you are entering a valid pin!" );
                        }
                    }
                });

                back.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        pinFrame.dispose();
                        mainFrame.setVisible(true);
                    }
                });

            }
        });

        exit.addActionListener((event) -> System.exit(0));


        // Creates txt labels
        JLabel ATM = new JLabel("ATM");
        JLabel welcome = new JLabel("Welcome!");
        JLabel name = new JLabel(user);
        JLabel checking = new JLabel("Checking #1");
        JLabel checkBal = new JLabel("$" + Double.toString(customer.getAccount().getCheckingBal()));
        JLabel saving = new JLabel("Saving #2");
        JLabel saveBal = new JLabel("$" + Double.toString(customer.getAccount().getSavingBal()));

        JLabel[] labels = {ATM, welcome, name, checking, checkBal, saving, saveBal};

        ATM.setBounds(25, -12, 100, 100);
        welcome.setBounds(25, 150, 100, 100);
        name.setBounds(25, 175, 200, 100);
        checking.setBounds(25, 225, 100, 100);
        checkBal.setBounds(25, 250, 100, 100);
        saving.setBounds(25, 300, 100, 100);
        saveBal.setBounds(25, 325, 100, 100);

        for (int i = 0; i < labels.length; i ++){
            mainFrame.add(labels[i]);
            if (i == 0){
                labels[i].setFont(f2);
                labels[i].setForeground(Color.WHITE);
            }
            else if (i % 2 == 1){
                labels[i].setFont(f4);
                labels[i].setForeground(BLUE);
            }
            else{
                labels[i].setFont(f3);
                labels[i].setForeground(Color.WHITE);
            }
        }

        mainFrame.setVisible(true);
    }
}