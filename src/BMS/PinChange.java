package BMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {
    JPasswordField pinNum, repinNum;
    JButton change, back;
    String pin;
    public PinChange(String pin) {
        this.pin = pin;
        setTitle("Pin Change Frame");

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 900, 600);
        add(img);

        JLabel head = new JLabel("CHANGE THE PIN");
        head.setBounds(250, 150, 200, 25);
        head.setFont(new Font("Raleway", Font.BOLD, 15));
        head.setForeground(Color.WHITE);
        img.add(head);

        JLabel newPin = new JLabel("NEW PIN");
        newPin.setBounds(150, 190, 200, 25);
        newPin.setFont(new Font("Rale way", Font.BOLD, 15));
        //newPin.setBackground(Color.BLACK);
        newPin.setForeground(Color.WHITE);
        img.add(newPin);

        pinNum = new JPasswordField();
        pinNum.setBounds(350, 190, 130, 25);
        pinNum.setFont(new Font("Rale way", Font.BOLD, 15));
        pinNum.setBackground(Color.WHITE);
        pinNum.setForeground(Color.BLACK);
        img.add(pinNum);

        JLabel renewPin = new JLabel("RE-ENTER NEW PIN");
        renewPin.setBounds(150, 220, 200, 25);
        renewPin.setFont(new Font("Rale way", Font.BOLD, 15));
        //renewPin.setBackground(Color.BLACK);
        renewPin.setForeground(Color.WHITE);
        img.add(renewPin);

        repinNum = new JPasswordField();
        repinNum.setBounds(350, 220, 130, 25);
        repinNum.setFont(new Font("Rale way", Font.BOLD, 15));
        repinNum.setBackground(Color.WHITE);
        repinNum.setForeground(Color.BLACK);
        img.add(repinNum);

        change = new JButton("CHANGE");
        change.setBounds(380, 310, 110, 25);
        change.setFont(new Font("Rale way", Font.BOLD, 15));
        change.setBackground(Color.WHITE);
        change.setForeground(Color.BLACK);
        change.addActionListener(this);
        img.add(change);

        back = new JButton("BACK");
        back.setBounds(380, 340, 110, 25);
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
        if(ae.getSource() == change) {
            String pin1 = pinNum.getText();
            String pin2 = repinNum.getText();

            if(pin1.equals("")) {
                JOptionPane.showMessageDialog(null,"enter the pin");
                return;
            }
            else if(pin2.equals("")) {
                JOptionPane.showMessageDialog(null,"Re-enter the pin");
                return;
            }
            else if(!pin1.equals(pin2)) {
                JOptionPane.showMessageDialog(null,"Pins are Mismatched");
                return;
            }
            else {
                Con c = new Con();
                try {
                    if(pin1.length() == 4) {
                        String query1 = "update Login set Pin = '" + pin1 + "' where Pin = '" + pin + "'";
                        String query2 = "update SignUpThree set Pin = '" + pin1 + "' where Pin = '" + pin + "'";
                        String query3 = "update Bank set Pin = '" + pin1 + "' where Pin = '" + pin + "'";
                        c.s.executeUpdate(query1);
                        c.s.executeUpdate(query2);
                        c.s.executeUpdate(query3);
                        JOptionPane.showMessageDialog(null, "Pin changed successfully");
                        setVisible(false);
                        new Transaction(pin1).setVisible(true);
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Pin length should be four");
                        return;
                    }
                }
                catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }
    public static void main(String[] args) {
        new PinChange("");
    }
}
