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
    private static Customer customer = new Customer (user, pinNum);
    static JLabel checkBal = new JLabel("$" + customer.getAccount().getCheckingBal());
    static JLabel saveBal = new JLabel("$" + customer.getAccount().getSavingBal());

    public static void introFrame() {
        Color background = new Color(28,36,52);
        Font courierNew = new Font("Courier New", Font.BOLD, 16);

        JFrame intro = new JFrame();
        intro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        intro.setPreferredSize(new Dimension(850, 650));
        intro.getContentPane().setBackground(background);
        intro.pack();

        JLabel name = new JLabel("Enter Name: ");
        name.setBounds(100, 105, 200, 100);
        name.setFont(courierNew);
        name.setForeground(Color.WHITE);

        JLabel pin = new JLabel("Create a PIN: ");
        pin.setBounds(100,165, 200, 100);
        pin.setForeground(Color.WHITE);

        JTextField name_field = new JTextField();
        name_field.setBounds(250,140,300,35);
        name_field.setFont(courierNew);
        name_field.setBorder(BorderFactory.createEmptyBorder());

        JTextField pin_field = new JTextField();
        pin_field.setBounds(250,200,300,35);
        pin_field.setFont(courierNew);
        pin_field.setBorder(BorderFactory.createEmptyBorder());

        JButton submit = new JButton("Create Account");
        submit.setBounds(100, 400, 175, 35);
        submit.setBackground(Color.white);
        submit.setFont(courierNew);
        submit.setBorderPainted(false);

        intro.add(name);
        intro.add(name_field);
        intro.add(pin);
        intro.add(pin_field);
        intro.add(submit);

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    user = name_field.getText();
                    pinNum = Integer.parseInt(pin_field.getText());
                    intro.dispose();
                    JFrame login = new JFrame();
                    login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    login.setPreferredSize(new Dimension(850, 650));
                    login.getContentPane().setBackground(background);
                    login.pack();

                    JLabel pin = new JLabel("Enter a PIN: ");
                    pin.setBounds(100,165, 200, 100);
                    pin.setForeground(Color.WHITE);

                    JTextField pin_field = new JTextField();
                    pin_field.setBounds(250,200,300,35);
                    pin_field.setFont(courierNew);
                    pin_field.setBorder(BorderFactory.createEmptyBorder());

                    JButton loginButton = new JButton("Login");
                    loginButton.setBounds(100, 400, 175, 35);
                    loginButton.setBackground(Color.white);
                    loginButton.setFont(courierNew);
                    loginButton.setBorderPainted(false);

                    login.add(pin);
                    login.add(pin_field);
                    login.add(loginButton);

                    login.setLayout(null);
                    login.setVisible(true);

                    loginButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (Integer.parseInt(pin_field.getText()) == pinNum){
                            login.setVisible(false);
                            mainFrame();
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Incorrect Pin!" );
                        }
                    }
                });

                }
                catch (NumberFormatException pinNum) {
                    JOptionPane.showMessageDialog(null, "Make sure you are entering a valid name or pin!" );
                }
            }
        });

        intro.setLayout(null);
        intro.setVisible(true);
    }
    public static void createBack(JFrame main, JFrame newFrame){
        Color PINK_RED = new Color(243, 4, 107);
        JButton back = new JButton("Back");
        back.setBounds(750, 565, 75, 30);
        back.setForeground(Color.WHITE);
        back.setBackground(PINK_RED);
        newFrame.add(back);
        back.setBorderPainted(false);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newFrame.dispose();
                main.setVisible(true);
            }
        });
    }

    public static void mainFrame() {

        // Colors + Fonts
        Color background = new Color(28,36,52);
        Color BLUE = new Color(40, 140, 215);
        Color LIGHT_BLUE = new Color(5, 180, 244);
        Color PINK_RED = new Color(243, 4, 107);
        Font courierNew = new Font("Courier New", Font.BOLD, 16);
        Font f2 = new Font("Courier New", Font.BOLD, 35);
        Font f3 = new Font("Courier New", Font.BOLD, 25);
        Font f4 = new Font("Courier New", Font.PLAIN, 16);

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
            buttonArr[i].setFont(courierNew);
        }

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(false);
                withdrawFrame.setVisible(true);
                JLabel fromAcc = new JLabel("From Account: ");
                JLabel withAmount = new JLabel("Withdraw Amount: ");
                fromAcc.setBounds(100, 105, 200, 100);
                withAmount.setBounds(100,165,200,100);
                createBack(mainFrame, withdrawFrame);

                JTextField fromAcc_field = new JTextField();
                JTextField withAmount_field = new JTextField();
                fromAcc_field.setBounds(260, 140, 300, 35);
                withAmount_field.setBounds(260, 200, 300, 35);

                JButton submit = new JButton("Submit");
                submit.setBounds(100, 400, 200, 35);
                withdrawFrame.add(submit);

                fromAcc.setFont(courierNew);
                withAmount.setFont(courierNew);
                fromAcc_field.setFont(courierNew);
                withAmount_field.setFont(courierNew);
                fromAcc.setForeground(Color.WHITE);
                withAmount.setForeground(Color.WHITE);
                submit.setBackground(Color.WHITE);
                submit.setFont(courierNew);
                submit.setBorderPainted(false);

                fromAcc_field.setBorder(BorderFactory.createEmptyBorder());
                withAmount_field.setBorder(BorderFactory.createEmptyBorder());

                withdrawFrame.add(fromAcc);
                withdrawFrame.add(fromAcc_field);
                withdrawFrame.add(withAmount);
                withdrawFrame.add(withAmount_field);
                withdrawFrame.add(submit);

                submit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            customer.getAccount().withdraw(Integer.parseInt(fromAcc_field.getText()), Double.parseDouble(withAmount_field.getText()));
                            checkBal.setText("$" + customer.getAccount().getCheckingBal());
                            saveBal.setText("$" + customer.getAccount().getSavingBal());
                            fromAcc_field.setText("");
                            withAmount_field.setText("");
                            withdrawFrame.setVisible(false);
                            mainFrame.setVisible(true);
                        }
                        catch (NumberFormatException pinNum) {
                            JOptionPane.showMessageDialog(null, "Make sure you are entering a valid number!" );
                        }
                    }
                });
            }
        });



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

                accNum.setFont(courierNew);
                depAmount.setFont(courierNew);
                accNum_field.setFont(courierNew);
                depAmount_field.setFont(courierNew);
                accNum.setForeground(Color.WHITE);
                depAmount.setForeground(Color.WHITE);
                submit.setBackground(Color.WHITE);
                submit.setFont(courierNew);
                submit.setBorderPainted(false);

                depAmount_field.setBorder(BorderFactory.createEmptyBorder());
                accNum_field.setBorder(BorderFactory.createEmptyBorder());

                depositFrame.add(accNum);
                depositFrame.add(accNum_field);
                depositFrame.add(depAmount);
                depositFrame.add(depAmount_field);
                depositFrame.add(submit);

                submit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            customer.getAccount().deposit(Integer.parseInt(accNum_field.getText()), Double.parseDouble(depAmount_field.getText()));
                            accNum_field.setText("");
                            depAmount_field.setText("");
                            checkBal.setText("$" + customer.getAccount().getCheckingBal());
                            saveBal.setText("$" + customer.getAccount().getSavingBal());
                        }
                        catch (NumberFormatException pinNum) {
                            JOptionPane.showMessageDialog(null, "Make sure you are entering a valid number!" );
                        }
                    }
                });
                createBack(mainFrame, depositFrame);

            }
        });


        transferButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(false);
                transferFrame.setVisible(true);
                JLabel from = new JLabel("From Account: ");
                JLabel to = new JLabel("To Account: ");
                JLabel amount = new JLabel("Amount: ");
                from.setBounds(100, 105, 200, 100);
                to.setBounds(100, 165, 200, 100);
                amount.setBounds(100, 225, 200, 100);

                JTextField from_field = new JTextField();
                JTextField to_field = new JTextField();
                JTextField amount_field = new JTextField();
                from_field.setBounds(250, 140, 300, 35);
                to_field.setBounds(250, 200, 300, 35);
                amount_field.setBounds(250, 260, 300, 35);

                JButton submit = new JButton("Submit");
                submit.setBounds(100, 400, 200, 35);
                transferFrame.add(submit);

                from.setFont(courierNew);
                to.setFont(courierNew);
                amount.setFont(courierNew);
                amount.setForeground(Color.WHITE);
                from.setForeground(Color.WHITE);
                to.setForeground(Color.WHITE);
                submit.setBackground(Color.WHITE);
                submit.setFont(courierNew);
                submit.setBorderPainted(false);

                from_field.setFont(courierNew);
                to_field.setFont(courierNew);
                amount_field.setFont(courierNew);

                from_field.setBorder(BorderFactory.createEmptyBorder());
                to_field.setBorder(BorderFactory.createEmptyBorder());
                amount_field.setBorder(BorderFactory.createEmptyBorder());

                transferFrame.add(from);
                transferFrame.add(from_field);
                transferFrame.add(to);
                transferFrame.add(to_field);
                transferFrame.add(amount_field);
                transferFrame.add(amount);
                transferFrame.add(submit);

                submit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            customer.getAccount().transfer(Integer.parseInt(from_field.getText()), Double.parseDouble(amount_field.getText()));
                            transferFrame.setVisible(false);
                            mainFrame.setVisible(true);
                            from_field.setText("");
                            to_field.setText("");
                            amount_field.setText("");
                            checkBal.setText("$" + customer.getAccount().getCheckingBal());
                            saveBal.setText("$" + customer.getAccount().getSavingBal());

                        } catch (NumberFormatException pinNum) {
                            JOptionPane.showMessageDialog(null, "");
                        }
                    }
                });

                createBack(mainFrame, transferFrame);

            }
        });



        pinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(false);
                pinFrame.setVisible(true);
                JLabel currentPin = new JLabel("Current Pin: ");
                JLabel newPin = new JLabel("New Pin: ");
                currentPin.setBounds(100, 105, 200, 100);
                newPin.setBounds(100,165,200,100);

                JTextField currentPin_field = new JTextField();
                JTextField newPin_field = new JTextField();
                currentPin_field.setBounds(250, 140, 300, 35);
                newPin_field.setBounds(250, 200, 300, 35);

                JButton submit = new JButton("Submit");
                submit.setBounds(100, 400, 200, 35);

                currentPin.setFont(courierNew);
                newPin.setFont(courierNew);
                currentPin.setForeground(Color.WHITE);
                newPin.setForeground(Color.WHITE);
                submit.setBackground(Color.WHITE);
                submit.setFont(courierNew);
                submit.setBorderPainted(false);

                currentPin_field.setFont(courierNew);
                newPin_field.setFont(courierNew);

                currentPin_field.setBorder(BorderFactory.createEmptyBorder());
                newPin_field.setBorder(BorderFactory.createEmptyBorder());

                pinFrame.add(currentPin);
                pinFrame.add(currentPin_field);
                pinFrame.add(newPin);
                pinFrame.add(newPin_field);
                pinFrame.add(submit);

                submit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            if (Integer.parseInt(currentPin_field.getText()) == pinNum){
                                pinNum = Integer.parseInt(newPin_field.getText());
                                JOptionPane.showMessageDialog(null, "Success!");
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Incorrect Pin Number!" );
                            }
                            currentPin_field.setText("");
                            newPin_field.setText("");
                        }
                        catch (NumberFormatException pinNum) {
                            JOptionPane.showMessageDialog(null, "Make sure you are entering a valid pin!" );
                        }
                    }
                });

                createBack(mainFrame, pinFrame);

            }
        });

        exit.addActionListener((event) -> System.exit(0));


        // Creates txt labels
        JLabel ATM = new JLabel("ATM");
        JLabel welcome = new JLabel("Welcome!");
        JLabel name = new JLabel(user);
        JLabel checking = new JLabel("Checking #1");
        JLabel saving = new JLabel("Saving #2");

        JLabel[] labels = {ATM, welcome, name, checking, checkBal, saving, saveBal};

        ATM.setBounds(25, -12, 100, 100);
        welcome.setBounds(25, 150, 100, 100);
        name.setBounds(25, 175, 200, 100);
        checking.setBounds(25, 225, 200, 100);
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
