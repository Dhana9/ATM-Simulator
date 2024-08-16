package BMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener {
    JButton signUp, clear, signIn;
    JTextField cardNoField;
    JPasswordField pinField;
    Login() {
        setTitle("Automated Teller Machine");

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(90, 80, 90, 60);
        add(label);

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Oswald", Font.BOLD, 38));
        text.setBounds(200, 80, 320, 60);
        add(text);


        JLabel cardNo = new JLabel("Card No : ");
        cardNo.setFont(new Font("Rale way", Font.BOLD, 19));
        cardNo.setBounds(90, 190, 100, 40);
        add(cardNo);

        cardNoField = new JTextField();
        cardNoField.setBounds(200, 190, 320, 30);
        add(cardNoField);


        JLabel pin = new JLabel("PIN : ");
        pin.setFont(new Font("Rale way", Font.BOLD, 19));
        pin.setBounds(90, 230, 100, 40);
        add(pin);

        pinField = new JPasswordField();
        pinField.setBounds(200, 230, 320, 30);
        add(pinField);


        signUp = new JButton("SIGN UP");
        signUp.setBounds(200, 290, 150, 30);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        signUp.addActionListener(this);
        add(signUp);

        clear = new JButton("CLEAR");
        clear.setBounds(370, 290, 150, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signIn = new JButton("SIGN IN");
        signIn.setBounds(200, 330, 320, 30);
        signIn.setBackground(Color.BLACK);
        signIn.setForeground(Color.WHITE);
        signIn.addActionListener(this);
        add(signIn);

        getContentPane().setBackground(Color.WHITE);

        setSize(600, 500);
        setVisible(true);
        setLocation(350, 100);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == clear) {
            cardNoField.setText("");
            pinField.setText("");
        }
        else if(ae.getSource() == signUp) {
            setVisible(false);
            new SignUpOne().setVisible(true);
        }
        else if(ae.getSource() == signIn) {
            Con c = new Con();
            String cardNum = cardNoField.getText();
            String pinNum = pinField.getText();
            String query = "select * from Login where Card_Number = '" +cardNum+ "' and Pin = '" + pinNum + "'";

            try {
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Transaction(pinNum);
                } else {
                    System.out.println("Incorrect Card Number or Pin");
                }
            }
            catch(Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
