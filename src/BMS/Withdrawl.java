package BMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;
public class Withdrawl extends JFrame implements ActionListener {
    JTextField drawlAmount;
    JButton dep, back;
    String pin;
    public Withdrawl(String pin) {
        this.pin = pin;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 550, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 900, 550);
        add(img);

        JLabel text = new JLabel("ENTER THE AMOUNT YOU WANT TO WITHDRAW");
        text.setBounds(150, 160, 360, 25);
        text.setFont(new Font("Rale way", Font.BOLD, 15));
        text.setForeground(Color.WHITE);
        img.add(text);

        drawlAmount = new JTextField();
        drawlAmount.setBounds(150, 200, 350, 20);
        drawlAmount.setFont(new Font("Rale way", Font.BOLD, 17));
        drawlAmount.setForeground(Color.BLACK);
        img.add(drawlAmount);

        dep = new JButton("WITHDRAW");
        dep.setBounds(380, 285, 120, 20);
        dep.setFont(new Font("Rale way", Font.BOLD, 15));
        dep.setForeground(Color.BLACK);
        dep.addActionListener(this);
        img.add(dep);

        back = new JButton("BACK");
        back.setBounds(380, 310, 120, 20);
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
        if(ae.getSource() == dep) {
            try {
                String amount = drawlAmount.getText();
                Date date = new Date();
                Con c = new Con();

                int balance = 0;
                ResultSet rs = c.s.executeQuery("select * from Bank where Pin = '"+pin+"'");
                while(rs.next()) {
                    if(rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("Amount"));
                    }
                    else {
                        balance -= Integer.parseInt(rs.getString("Amount"));
                    }
                }

                if(balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    drawlAmount.setText("");
                    return;
                }

                String query = "insert into Bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Amount '"+amount+"' is withdrawn");
                setVisible(false);
                new Transaction(pin).setVisible(true);
            }
            catch(Exception e) {
                System.out.println(e);
            }
        }
        else if(ae.getSource() == back) {
            setVisible(false);
            new Transaction(pin).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Withdrawl("");
    }
}
