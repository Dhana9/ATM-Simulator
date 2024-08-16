package BMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener {
    JButton dep, drawl, fastCash, mini, pinChange, bal, back;
    String pin;
    public Transaction(String pin) {
        this.pin = pin;

        setTitle("Transaction Frame");
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 900, 600);
        add(img);

        JLabel minny = new JLabel("DHANA FIRST BANK");
        minny.setBounds(220, 90, 300, 25);
        minny.setFont(new Font("System", Font.BOLD, 25));
        minny.setForeground(Color.BLACK);
        img.add(minny);

        JLabel head = new JLabel("PLEASE SELECT YOUR TRANSACTION");
        head.setBounds(170, 190, 300, 25);
        head.setFont(new Font("System", Font.BOLD, 15));
        head.setForeground(Color.WHITE);
        img.add(head);

        dep = new JButton("DEPOSIT");
        dep.setBounds(140, 250, 170, 25);
        dep.setFont(new Font("Rale way", Font.BOLD, 13));
        dep.setBackground(Color.WHITE);
        dep.setForeground(Color.BLACK);
        dep.addActionListener(this);
        img.add(dep);

        drawl = new JButton("CASH WITHDRAWL");
        drawl.setBounds(333, 250, 170, 25);
        drawl.setFont(new Font("Rale way", Font.BOLD, 13));
        drawl.setBackground(Color.WHITE);
        drawl.setForeground(Color.BLACK);
        drawl.addActionListener(this);
        img.add(drawl);

        fastCash = new JButton("FAST CASH");
        fastCash.setBounds(140, 280, 170, 25);
        fastCash.setFont(new Font("Rale way", Font.BOLD, 13));
        fastCash.setBackground(Color.WHITE);
        fastCash.setForeground(Color.BLACK);
        fastCash.addActionListener(this);
        img.add(fastCash);

        mini = new JButton("MINI-STATEMENT");
        mini.setBounds(333, 280, 170, 25);
        mini.setFont(new Font("Rale way", Font.BOLD, 13));
        mini.setBackground(Color.WHITE);
        mini.setForeground(Color.BLACK);
        mini.addActionListener(this);
        img.add(mini);

        pinChange = new JButton("PIN CHANGE");
        pinChange.setBounds(140, 310, 170, 25);
        pinChange.setFont(new Font("Rale way", Font.BOLD, 13));
        pinChange.setBackground(Color.WHITE);
        pinChange.setForeground(Color.BLACK);
        pinChange.addActionListener(this);
        img.add(pinChange);

        bal = new JButton("CHECK BALANCE");
        bal.setBounds(333, 310, 170, 25);
        bal.setFont(new Font("Rale way", Font.BOLD, 13));
        bal.setBackground(Color.WHITE);
        bal.setForeground(Color.BLACK);
        bal.addActionListener(this);
        img.add(bal);

        back = new JButton("EXIT");
        back.setBounds(240, 340, 170, 25);
        back.setFont(new Font("Rale way", Font.BOLD, 13));
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
        if(ae.getSource() == back)
            System.exit(0);
        if(ae.getSource() == dep) {
            setVisible(false);
            new Deposit(pin).setVisible(true);
        }
        if(ae.getSource() == drawl) {
            setVisible(false);
            new Withdrawl(pin).setVisible(true);
        }
        if(ae.getSource() == fastCash) {
            setVisible(false);
            new FastCash(pin).setVisible(true);
        }
        if(ae.getSource() == pinChange) {
            setVisible(false);
            new PinChange(pin).setVisible(true);
        }
        if(ae.getSource() == bal) {
            setVisible(false);
            new BalanceCheck(pin).setVisible(true);
        }
        if(ae.getSource() == mini) {
            setVisible(false);
            new MiniStatement(pin).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Transaction("");
    }
}
