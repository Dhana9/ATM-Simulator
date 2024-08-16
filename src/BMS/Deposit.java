package BMS;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {
    JTextField depAmount;
    JButton dep, back;
    String pin;
    public Deposit(String pin) {
        this.pin = pin;

        setTitle("Deposit Frame");
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 550, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 900, 550);
        add(img);

        JLabel text = new JLabel("ENTER THE AMOUNT YOU WANT TO DEPOSIT");
        text.setBounds(155, 160, 350, 25);
        text.setFont(new Font("Rale way", Font.BOLD, 15));
        text.setForeground(Color.WHITE);
        img.add(text);

        depAmount = new JTextField();
        depAmount.setBounds(150, 200, 350, 20);
        depAmount.setFont(new Font("Rale way", Font.BOLD, 17));
        depAmount.setForeground(Color.BLACK);
        img.add(depAmount);

        dep = new JButton("DEPOSIT");
        dep.setBounds(390, 285, 110, 20);
        dep.setFont(new Font("Rale way", Font.BOLD, 15));
        dep.setForeground(Color.BLACK);
        dep.addActionListener(this);
        img.add(dep);

        back = new JButton("BACK");
        back.setBounds(390, 310, 110, 20);
        back.setFont(new Font("Rale way", Font.BOLD, 15));
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
        else if(ae.getSource() == dep) {
            try {
                Con c = new Con();
                Date date = new Date();
                //String pin = pinNum.getText();
                String amount = depAmount.getText();
                String query = "insert into Bank values('" + pin + "', '" + date + "', 'Deposit', '" + amount + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Amount '"+amount+"' deposited Successfully");
                setVisible(false);
                new Transaction(pin);
            }
            catch(Exception e) {
                System.out.println(e);
            }

        }
    }
    public static void main(String[] args) {
        new Deposit("");
    }
}
