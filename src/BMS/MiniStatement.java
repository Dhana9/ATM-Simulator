package BMS;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.awt.event.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {
    String pin;
    JButton back;
    public MiniStatement(String pin) {
        this.pin = pin;

        setTitle("Mini-Statement Frame");
        setLayout(null);

        JLabel bankName = new JLabel("DHANA FIRST BANK");
        bankName.setBounds(330, 30, 250, 30);
        bankName.setFont(new Font("System", Font.BOLD, 25));
        add(bankName);

        JLabel card = new JLabel();
        card.setBounds(150, 70, 400, 20);
        card.setFont(new Font("System", Font.BOLD, 18));
        add(card);

        JLabel mini = new JLabel();
        mini.setBounds(150, 100, 600, 400);
        mini.setFont(new Font("System", Font.BOLD, 18));
        add(mini);

        JScrollPane scrollPane = new JScrollPane(mini);
        scrollPane.setBounds(150, 100, 600, 400);
        add(scrollPane);

        try {
            Con c = new Con();
            ResultSet rs = c.s.executeQuery("select * from Login where Pin = '" + pin + "'");

            while(rs.next()) {
                card.setText("Card Number : "+rs.getString("Card_Number").substring(0, 4)+"XXXXXXXX"+rs.getString("Card_Number").substring(12, 16));

            }
        }
        catch(Exception e) {
            System.out.println(e);
        }

        JLabel tot = new JLabel();
        tot.setBounds(100, 520, 350, 20);
        tot.setFont(new Font("System", Font.BOLD, 20));
        add(tot);

        try {
            Con c = new Con();
            int balance = 0;
            ResultSet rs = c.s.executeQuery("select * from Bank where Pin = '"+pin+"'");
            Date date = new Date();

            while(rs.next()) {
                //mini.setText(mini.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><html>");
                mini.setText(mini.getText()+"<html>"+rs.getString("Date")+"&nbsp;&nbsp;&nbsp;"+rs.getString("Type")+"&nbsp;&nbsp;&nbsp;"+rs.getString("Amount")+"<br><html>");
                if(rs.getString("Type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("Amount"));
                }
                else {
                    balance -= Integer.parseInt(rs.getString("Amount"));
                }
            }
            tot.setText("Total Balance is : "+balance);
        }
        catch (Exception e) {
            System.out.println(e);
        }

        back = new JButton("Back");
        back.setBounds(680, 550, 100, 25);
        back.setFont(new Font("System", Font.BOLD, 22));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setVisible(true);
        setSize(900, 650);
        setLocation(200, 30);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == back) {
            setVisible(false);
            new Transaction(pin);
        }
    }
    public static void main(String[] args) {
        new MiniStatement("");
    }
}