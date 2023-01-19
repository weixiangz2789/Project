import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class UI {
    private static String user;
    private static int pinNum;
    private static DecimalFormat df = new DecimalFormat("0.00");
    private static Customer customer = new Customer (user, pinNum);
    static JLabel checkBal = new JLabel("$" + df.format(customer.getAccount().getCheckingBal()));
    static JLabel saveBal = new JLabel("$" + df.format(customer.getAccount().getSavingBal()));

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
                user = name_field.getText();
                pinNum = Integer.parseInt(pin_field.getText());
                intro.dispose();
                createLogin();
            }
            });
        intro.setLayout(null);
        intro.setVisible(true);
    }
    public static void createLogin(){
        Color background = new Color(28,36,52);
        Font courierNew = new Font("Courier New", Font.BOLD, 16);

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
                        try {
                            if (Integer.parseInt(pin_field.getText()) == pinNum) {
                                login.setVisible(false);
                                mainFrame();
                            } else {
                                JOptionPane.showMessageDialog(null, "Incorrect Pin!");
                            }
                        } catch (NumberFormatException pinNum) {
                            JOptionPane.showMessageDialog(null, "Make sure you are entering a valid name or pin!");
                        }
                    }
            });
    }

    public static void createBack(JFrame main, JFrame newFrame){
        Color PINK_RED = new Color(243, 4, 107);
        JButton back = new JButton("Back");
        back.setBounds(750, 565, 75, 30);
        back.setForeground(Color.WHITE);
        back.setBackground(PINK_RED);
        back.setBorderPainted(false);
        newFrame.add(back);
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
                createBack(mainFrame, withdrawFrame);

                JLabel fromAcc = new JLabel("From Account: ");
                fromAcc.setBounds(100, 105, 200, 100);
                fromAcc.setFont(courierNew);
                fromAcc.setForeground(Color.WHITE);

                JLabel withAmount = new JLabel("Withdraw Amount: ");
                withAmount.setBounds(100,165,200,100);
                withAmount.setFont(courierNew);
                withAmount.setForeground(Color.WHITE);

                JLabel fiveAmount = new JLabel("Amount of $5: ");
                fiveAmount.setBounds(100,225,200,100);
                fiveAmount.setFont(courierNew);
                fiveAmount.setForeground(Color.WHITE);

                JLabel twentyAmount = new JLabel("Amount of $20: ");
                twentyAmount.setBounds(100,285,200,100);
                twentyAmount.setFont(courierNew);
                twentyAmount.setForeground(Color.WHITE);

                JTextField fromAcc_field = new JTextField();
                fromAcc_field.setBounds(260, 140, 300, 35);
                fromAcc_field.setFont(courierNew);
                fromAcc_field.setBorder(BorderFactory.createEmptyBorder());

                JTextField withAmount_field = new JTextField();
                withAmount_field.setBounds(260, 200, 300, 35);
                withAmount_field.setFont(courierNew);
                withAmount_field.setBorder(BorderFactory.createEmptyBorder());

                JTextField fiveAmount_field = new JTextField();
                fiveAmount_field.setBounds(260, 260, 300, 35);
                fiveAmount_field.setFont(courierNew);
                fiveAmount_field.setBorder(BorderFactory.createEmptyBorder());

                JTextField twentyAmount_field = new JTextField();
                twentyAmount_field.setBounds(260, 320, 300, 35);
                twentyAmount_field.setFont(courierNew);
                twentyAmount_field.setBorder(BorderFactory.createEmptyBorder());

                JButton submit = new JButton("Submit");
                submit.setBounds(100, 400, 200, 35);
                submit.setBackground(Color.WHITE);
                submit.setFont(courierNew);
                submit.setBorderPainted(false);

                withdrawFrame.add(fromAcc);
                withdrawFrame.add(fromAcc_field);
                withdrawFrame.add(withAmount);
                withdrawFrame.add(withAmount_field);
                withdrawFrame.add(submit);
                withdrawFrame.add(fiveAmount);
                withdrawFrame.add(twentyAmount);
                withdrawFrame.add(twentyAmount);
                withdrawFrame.add(fiveAmount_field);
                withdrawFrame.add(twentyAmount_field);

                submit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int fives = 0;
                        int twenty = 0;
                        if (!fiveAmount_field.getText().equals("")) {
                            fives = Integer.parseInt(fiveAmount_field.getText());
                        }
                        if (!twentyAmount_field.getText().equals("")) {
                            twenty = Integer.parseInt(twentyAmount_field.getText());
                        }
                        int total = (fives*5) + (twenty * 20);
                        if (!fromAcc_field.getText().equals("1") && !fromAcc_field.getText().equals("2")){
                            JOptionPane.showMessageDialog(null, "The account does not exist!" );
                        }
                        else if (fromAcc_field.getText().equals("1") && Integer.parseInt(withAmount_field.getText()) > customer.getAccount().getCheckingBal()){
                            JOptionPane.showMessageDialog(null, "Insufficient Funds!" );
                        }
                        else if (fromAcc_field.getText().equals("2") && Integer.parseInt(withAmount_field.getText()) > customer.getAccount().getSavingBal()){
                            JOptionPane.showMessageDialog(null, "Insufficient Funds!" );
                        }
                        else if (total != Integer.parseInt(withAmount_field.getText())){
                            JOptionPane.showMessageDialog(null, "The amount you're trying to withdraw does not match up!" );
                        }
                        else if ((total == Integer.parseInt(withAmount_field.getText()))){
                            customer.getAccount().withdraw(Integer.parseInt(fromAcc_field.getText()), Integer.parseInt(withAmount_field.getText()));
                            checkBal.setText("$" + df.format(customer.getAccount().getCheckingBal()));
                            saveBal.setText("$" + df.format(customer.getAccount().getSavingBal()));
                            fromAcc_field.setText("");
                            withAmount_field.setText("");
                            fiveAmount_field.setText("");
                            twentyAmount_field.setText("");
                            JOptionPane.showMessageDialog(null, customer.getAccount().getRecentTransaction());
                            withdrawFrame.setVisible(false);
                            mainFrame.setVisible(false);
                            createLogin();
                        }
                        else{
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
                createBack(mainFrame, depositFrame);

                JLabel accNum = new JLabel("Account Number: ");
                accNum.setBounds(100, 105, 200, 100);
                accNum.setFont(courierNew);
                accNum.setForeground(Color.WHITE);

                JLabel depAmount = new JLabel("Deposit Amount: ");
                depAmount.setBounds(100,165,200,100);
                depAmount.setFont(courierNew);
                depAmount.setForeground(Color.WHITE);

                JTextField accNum_field = new JTextField();
                accNum_field.setBounds(250, 140, 300, 35);
                accNum_field.setFont(courierNew);
                accNum_field.setBorder(BorderFactory.createEmptyBorder());

                JTextField depAmount_field = new JTextField();
                depAmount_field.setBounds(250, 200, 300, 35);
                depAmount_field.setFont(courierNew);
                depAmount_field.setBorder(BorderFactory.createEmptyBorder());

                JButton submit = new JButton("Submit");
                submit.setBounds(100, 400, 200, 35);
                submit.setBackground(Color.WHITE);
                submit.setFont(courierNew);
                submit.setBorderPainted(false);

                depositFrame.add(accNum);
                depositFrame.add(accNum_field);
                depositFrame.add(depAmount);
                depositFrame.add(depAmount_field);
                depositFrame.add(submit);

                submit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (!accNum_field.getText().equals("1") && !accNum_field.getText().equals("2")){
                            JOptionPane.showMessageDialog(null, "The account does not exist!" );
                        }
                        else {
                            try {
                                customer.getAccount().deposit(Integer.parseInt(accNum_field.getText()), Double.parseDouble(depAmount_field.getText()));
                                accNum_field.setText("");
                                depAmount_field.setText("");
                                checkBal.setText("$" + df.format(customer.getAccount().getCheckingBal()));
                                saveBal.setText("$" + df.format(customer.getAccount().getSavingBal()));
                                JOptionPane.showMessageDialog(null, customer.getAccount().getRecentTransaction());
                                mainFrame.setVisible(false);
                                depositFrame.setVisible(false);
                                createLogin();
                            } catch (NumberFormatException pinNum) {
                                JOptionPane.showMessageDialog(null, "Make sure you are entering a valid number!");
                            }
                        }
                    }
                });
            }
        });


        transferButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(false);
                transferFrame.setVisible(true);
                createBack(mainFrame, transferFrame);

                JLabel from = new JLabel("From Account: ");
                from.setBounds(100, 105, 200, 100);
                from.setFont(courierNew);
                from.setForeground(Color.WHITE);

                JLabel to = new JLabel("To Account: ");
                to.setBounds(100, 165, 200, 100);
                to.setFont(courierNew);
                to.setForeground(Color.WHITE);

                JLabel amount = new JLabel("Amount: ");
                amount.setBounds(100, 225, 200, 100);
                amount.setFont(courierNew);
                amount.setForeground(Color.WHITE);

                JTextField from_field = new JTextField();
                from_field.setBounds(250, 140, 300, 35);
                from_field.setFont(courierNew);
                from_field.setBorder(BorderFactory.createEmptyBorder());

                JTextField to_field = new JTextField();
                to_field.setBounds(250, 200, 300, 35);
                to_field.setFont(courierNew);
                to_field.setBorder(BorderFactory.createEmptyBorder());

                JTextField amount_field = new JTextField();
                amount_field.setBounds(250, 260, 300, 35);
                amount_field.setFont(courierNew);
                amount_field.setBorder(BorderFactory.createEmptyBorder());

                JButton submit = new JButton("Submit");
                submit.setBounds(100, 400, 200, 35);
                submit.setBackground(Color.WHITE);
                submit.setFont(courierNew);
                submit.setBorderPainted(false);

                transferFrame.add(from);
                transferFrame.add(from_field);
                transferFrame.add(to);;
                transferFrame.add(to_field);
                transferFrame.add(amount_field);
                transferFrame.add(amount);
                transferFrame.add(submit);

                submit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (!from_field.getText().equals("1") && !from_field.getText().equals("2")){
                            JOptionPane.showMessageDialog(null, "The account does not exist!" );
                        }
                        else if (!to_field.getText().equals("1") && !to_field.getText().equals("2")){
                            JOptionPane.showMessageDialog(null, "The account does not exist!" );
                        }
                        else if (from_field.getText().equals(to_field.getText())){
                            JOptionPane.showMessageDialog(null, "You can't transfer money to the same account!" );
                        }
                        else if (customer.getAccount().transferable(Integer.parseInt(from_field.getText()), Double.parseDouble(amount_field.getText()))) {
                            customer.getAccount().transfer(Integer.parseInt(from_field.getText()), Double.parseDouble(amount_field.getText()));
                            from_field.setText("");
                            to_field.setText("");
                            amount_field.setText("");
                            checkBal.setText("$" + df.format(customer.getAccount().getCheckingBal()));
                            saveBal.setText("$" + df.format(customer.getAccount().getSavingBal()));
                            JOptionPane.showMessageDialog(null, customer.getAccount().getRecentTransaction());
                            mainFrame.setVisible(false);
                            depositFrame.setVisible(false);
                            createLogin();
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Insufficient Funds!" );
                        }
                    }
                });
            }
        });

        pinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(false);
                pinFrame.setVisible(true);
                createBack(mainFrame, pinFrame);

                JLabel currentPin = new JLabel("Current Pin: ");
                currentPin.setBounds(100, 105, 200, 100);
                currentPin.setFont(courierNew);
                currentPin.setForeground(Color.WHITE);

                JLabel newPin = new JLabel("New Pin: ");
                newPin.setBounds(100,165,200,100);
                newPin.setFont(courierNew);
                newPin.setForeground(Color.WHITE);

                JTextField currentPin_field = new JTextField();
                currentPin_field.setBounds(250, 140, 300, 35);
                currentPin_field.setFont(courierNew);
                currentPin_field.setBorder(BorderFactory.createEmptyBorder());

                JTextField newPin_field = new JTextField();
                newPin_field.setBounds(250, 200, 300, 35);
                newPin_field.setFont(courierNew);
                newPin_field.setBorder(BorderFactory.createEmptyBorder());

                JButton submit = new JButton("Submit");
                submit.setBounds(100, 400, 200, 35);
                submit.setBackground(Color.WHITE);
                submit.setFont(courierNew);
                submit.setBorderPainted(false);

                pinFrame.add(currentPin);
                pinFrame.add(currentPin_field);
                pinFrame.add(newPin);
                pinFrame.add(newPin_field);
                pinFrame.add(submit);

                submit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            if (currentPin_field.getText().equals(newPin_field.getText())){
                                JOptionPane.showMessageDialog(null, "Your pin number has not changed!" );
                            }
                            else if  (Integer.parseInt(currentPin_field.getText()) == pinNum){
                                customer.setPin(Integer.parseInt(newPin_field.getText()));
                                pinNum = customer.getPin();
                                JOptionPane.showMessageDialog(null, customer.getAccount().getRecentTransaction());
                                currentPin_field.setText("");
                                newPin_field.setText("");
                                mainFrame.setVisible(false);
                                pinFrame.setVisible(false);
                                createLogin();
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Incorrect Pin Number!" );
                            }
                        }
                        catch (NumberFormatException pinNum) {
                            JOptionPane.showMessageDialog(null, "Make sure you are entering a valid pin!" );
                        }
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
        JLabel saving = new JLabel("Saving #2");

        JLabel[] labels = {ATM, welcome, name, checking, checkBal, saving, saveBal};

        ATM.setBounds(25, -12, 100, 100);
        welcome.setBounds(25, 150, 100, 100);
        name.setBounds(25, 175, 300, 100);
        checking.setBounds(25, 225, 200, 100);
        checkBal.setBounds(25, 250, 250, 100);
        saving.setBounds(25, 300, 100, 100);
        saveBal.setBounds(25, 325, 250, 100);

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
