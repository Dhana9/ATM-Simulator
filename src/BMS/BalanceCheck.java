package BMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceCheck extends JFrame implements ActionListener{
    String pin;
    int balance = 0;
    JButton back;
    public BalanceCheck(String pin) {
        this.pin = pin;

        setTitle("Balance Enquiry");
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 900, 600);
        add(img);

        Con c = new Con();
        try {
            ResultSet rs = c.s.executeQuery("select * from Bank where Pin = '" + pin + "'");
            while(rs.next()) {
                if (rs.getString("Type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("Amount"));
                }
                else {
                    balance -= Integer.parseInt(rs.getString("Amount"));
                }
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }

        JLabel head = new JLabel("YOUR CURRENT BALANCE IS  "+balance);
        head.setBounds(170, 160, 300, 20);
        head.setFont(new Font("Rale way", Font.BOLD, 15));
        head.setForeground(Color.WHITE);
        img.add(head);

        back = new JButton("BACK");
        back.setBounds(380, 335, 110, 25);
        back.setFont(new Font("Rale way", Font.BOLD, 15));
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        img.add(back);

        setVisible(true);
        setSize(900, 650);
        getContentPane().setBackground(Color.GRAY);
        setLocation(200, 30);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == back) {
            setVisible(false);
            new Transaction(pin).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new BalanceCheck("");
    }
}
