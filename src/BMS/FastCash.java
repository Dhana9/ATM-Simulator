package BMS;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;


public class FastCash extends JFrame implements ActionListener {
    JButton thou, twoThou, fiveThou, tenThou, twenThou, fifThou, back;
    int balance = 0;
    String pin;
    public FastCash(String pin) {
        this.pin = pin;

        setTitle("Fast-Cash Frame");
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 900, 600);
        add(img);

        JLabel head = new JLabel("Please select your FastCash : ");
        head.setBounds(170, 190, 300, 25);
        head.setFont(new Font("Rale way", Font.BOLD, 20));
        head.setForeground(Color.WHITE);
        img.add(head);

        thou = new JButton("Rs.1000");
        thou.setBounds(140, 250, 170, 25);
        thou.setFont(new Font("Rale way", Font.BOLD, 20));
        thou.setBackground(Color.WHITE);
        thou.setForeground(Color.BLACK);
        thou.addActionListener(this);
        img.add(thou);

        twoThou = new JButton("Rs.2000");
        twoThou.setBounds(333, 250, 170, 25);
        twoThou.setFont(new Font("Rale way", Font.BOLD, 20));
        twoThou.setBackground(Color.WHITE);
        twoThou.setForeground(Color.BLACK);
        twoThou.addActionListener(this);
        img.add(twoThou);

        fiveThou = new JButton("Rs.5000");
        fiveThou.setBounds(140, 280, 170, 25);
        fiveThou.setFont(new Font("Rale way", Font.BOLD, 20));
        fiveThou.setBackground(Color.WHITE);
        fiveThou.setForeground(Color.BLACK);
        fiveThou.addActionListener(this);
        img.add(fiveThou);

        tenThou = new JButton("Rs.10000");
        tenThou.setBounds(333, 280, 170, 25);
        tenThou.setFont(new Font("Rale way", Font.BOLD, 20));
        tenThou.setBackground(Color.WHITE);
        tenThou.setForeground(Color.BLACK);
        tenThou.addActionListener(this);
        img.add(tenThou);

        twenThou = new JButton("Rs.20000");
        twenThou.setBounds(140, 310, 170, 25);
        twenThou.setFont(new Font("Rale way", Font.BOLD, 20));
        twenThou.setBackground(Color.WHITE);
        twenThou.setForeground(Color.BLACK);
        twenThou.addActionListener(this);
        img.add(twenThou);

        fifThou = new JButton("Rs.50000");
        fifThou.setBounds(333, 310, 170, 25);
        fifThou.setFont(new Font("Rale way", Font.BOLD, 20));
        fifThou.setBackground(Color.WHITE);
        fifThou.setForeground(Color.BLACK);
        fifThou.addActionListener(this);
        img.add(fifThou);

        back = new JButton("Exit");
        back.setBounds(240, 340, 170, 25);
        back.setFont(new Font("Rale way", Font.BOLD, 20));
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
        else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Con c = new Con();
            try {
                ResultSet rs = c.s.executeQuery("select * from Bank where Pin = '"+pin+"'");
                while(rs.next()) {
                    if(rs.getString("Type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("Amount"));
                    }
                    if(rs.getString("Type").equals("Withdrawl")) {
                        balance -= Integer.parseInt(rs.getString("Amount"));
                    }
                }

                if((ae.getSource() != back) && balance < Integer.parseInt((amount))) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                else {
                    Date date = new Date();
                    String query = "insert into Bank values('" + pin + "', '" + date + "', 'Withdrawl', '" + amount + "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Amount '" + amount + "' is withdrawn");
                }
            }
            catch(Exception e) {
                System.out.println(e);
            }
        }

    }
    public static void main(String[] args) {
        new FastCash("");
    }
}
