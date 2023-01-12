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

        // Colors + Fonts
        Color DARK_BLUE = new Color(13, 61, 150);
        Color BLUE = new Color(40, 140, 215);
        Color LIGHT_BLUE = new Color(5, 180, 244);
        Color PINK_RED = new Color(243, 4, 107);
        Font f1 = new Font(Font.SANS_SERIF, Font.BOLD, 16);
        Font f2 = new Font(Font.SANS_SERIF, Font.BOLD, 35);
        Font f3 = new Font(Font.SANS_SERIF, Font.BOLD, 22);
        Font f4 = new Font(Font.SANS_SERIF, Font.PLAIN, 16);

        //  Creates Frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(850, 650));
        frame.getContentPane().setBackground(DARK_BLUE);
        frame.pack();
        frame.setVisible(true);

        // Creates Buttons
        JButton button1 = new JButton("Withdraw");
        JButton button2 = new JButton("Deposit");
        JButton button3 = new JButton("Transfer");
        JButton button4 = new JButton("Change PIN");
        JButton button5 = new JButton("EXIT");
        JButton[] buttonArr = {button1, button2, button3, button4, button5};
        button1.setBounds(325, 200, 225, 100);
        button2.setBounds(575, 200, 225, 100);
        button3.setBounds(325, 325, 225, 100);
        button4.setBounds(575, 325, 225, 100);
        button5.setBounds(750, 565, 75, 30);
        for (int i = 0; i < 5; i++) {
            frame.add(buttonArr[i]);
            buttonArr[i].setForeground(Color.WHITE);
            buttonArr[i].setBackground(LIGHT_BLUE);
            buttonArr[i].setBorderPainted(false);
            if (i == 4) {
                button5.setBackground(PINK_RED);
            }
            buttonArr[i].setFont(f1);
        }

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);

            }
        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                JFrame frame1 = new JFrame();
                frame1.setPreferredSize(new Dimension(850, 650));
                frame1.getContentPane().setBackground(Color.DARK_GRAY);
                frame1.pack();
                frame1.setVisible(true);

                JButton back = new JButton();
                back.setBounds(100, 100, 1, 1);
                back.setForeground(Color.WHITE);
                back.setBackground(PINK_RED);
                frame1.add(back);

                back.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame1.dispose();
                        frame.setVisible(true);
                    }
                });

            }
        });
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                JFrame frame1 = new JFrame();
                frame1.setPreferredSize(new Dimension(850, 650));
                frame1.getContentPane().setBackground(Color.DARK_GRAY);
                frame1.pack();
                frame1.setVisible(true);

                JButton back = new JButton();
                back.setBounds(750, 565, 75, 30);
                back.setForeground(Color.WHITE);
                back.setBackground(PINK_RED);
                frame1.add(back);

                back.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame1.dispose();
                        frame.setVisible(true);
                    }
                });

            }
        });
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);

            }
        });
        button5.addActionListener((event) -> System.exit(0));


        // Creates txt labels
        JLabel ATM = new JLabel("ATM");
        JLabel Welcome = new JLabel("Welcome!");
        JLabel name = new JLabel(user);
        JLabel Checking = new JLabel("Checking #1");
        JLabel CheckBal = new JLabel("$925.74");
        JLabel Saving = new JLabel("Saving #2");
        JLabel SavingBal = new JLabel("$1018.10");

        ATM.setBounds(25, -12, 100, 100);
        Welcome.setBounds(25, 150, 100, 100);
        name.setBounds(25, 175, 200, 100);
        Checking.setBounds(25, 225, 100, 100);
        CheckBal.setBounds(25, 250, 100, 100);
        Saving.setBounds(25, 300, 100, 100);
        SavingBal.setBounds(25, 325, 100, 100);

        ATM.setFont(f2);
        Welcome.setFont(f4);
        name.setFont(f3);
        Checking.setFont(f4);
        CheckBal.setFont(f3);
        Saving.setFont(f4);
        SavingBal.setFont(f3);

        ATM.setForeground(Color.WHITE);
        Welcome.setForeground(BLUE);
        name.setForeground(Color.WHITE);
        Checking.setForeground(BLUE);
        CheckBal.setForeground(Color.WHITE);
        Saving.setForeground(BLUE);
        SavingBal.setForeground(Color.WHITE);


        frame.add(name);
        frame.add(ATM);
        frame.add(Welcome);
        frame.add(Checking);
        frame.add(CheckBal);
        frame.add(Saving);
        frame.add(SavingBal);


        frame.setLayout(null);
        frame.setVisible(true);
    }
}