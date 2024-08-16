package BMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignUpThree extends JFrame implements ActionListener {
    JRadioButton savAcc, fixDep, curAcc, recDep;
    JCheckBox atm, banking, mobBank, alert, cheque, statement, declare;
    JButton sub, can;
    String formNum;
    public SignUpThree(String formNo) {
        formNum = formNo;

        setTitle("Account Details");
        setLayout(null);

        JLabel pageThree = new JLabel("Page 3 : Account Details");
        pageThree.setBounds(300, 40, 400, 30);
        pageThree.setFont(new Font("Rale way", Font.BOLD, 25));
        add(pageThree);

        JLabel accountType = new JLabel("Account Type : ");
        accountType.setBounds(100, 100, 200, 25);
        accountType.setFont(new Font("Rale way", Font.BOLD, 20));
        add(accountType);

        savAcc = new JRadioButton("Saving Account");
        savAcc.setBounds(100, 140, 250, 20);
        savAcc.setFont(new Font("rale way", Font.BOLD, 15));
        savAcc.setBackground(Color.WHITE);
        add(savAcc);

        fixDep = new JRadioButton("Fixed Deposit Account");
        fixDep.setBounds(360, 140, 250, 20);
        fixDep.setFont(new Font("rale way", Font.BOLD, 15));
        fixDep.setBackground(Color.WHITE);
        add(fixDep);

        curAcc = new JRadioButton("Current Account");
        curAcc.setBounds(100, 170, 250, 20);
        curAcc.setFont(new Font("rale way", Font.BOLD, 15));
        curAcc.setBackground(Color.WHITE);
        add(curAcc);

        recDep = new JRadioButton("Recurring Deposit Account");
        recDep.setBounds(360, 170, 250, 20);
        recDep.setFont(new Font("rale way", Font.BOLD, 15));
        recDep.setBackground(Color.WHITE);
        add(recDep);

        ButtonGroup b1 = new ButtonGroup();
        b1.add(savAcc);
        b1.add(fixDep);
        b1.add(curAcc);
        b1.add(recDep);

        JLabel cardNum = new JLabel("Card Number : ");
        cardNum.setBounds(100, 210, 200, 25);
        cardNum.setFont(new Font("Rale way", Font.BOLD, 20));
        add(cardNum);

        JLabel cardNum1 = new JLabel("XXXX-XXXX-XXXX-xxxx");
        cardNum1.setBounds(310, 210, 300, 25);
        cardNum1.setFont(new Font("Rale way", Font.BOLD, 20));
        add(cardNum1);

        JLabel pin = new JLabel("Pin Number : ");
        pin.setBounds(100, 250, 200, 25);
        pin.setFont(new Font("Rale way", Font.BOLD, 20));
        add(pin);

        JLabel pin1 = new JLabel("XXXX");
        pin1.setBounds(310, 250, 300, 25);
        pin1.setFont(new Font("Rale way", Font.BOLD, 20));
        add(pin1);

        JLabel services = new JLabel("Services Required : ");
        services.setBounds(100, 290, 200, 25);
        services.setFont(new Font("Rale way", Font.BOLD, 20));
        add(services);

        atm = new JCheckBox("ATM Card");
        atm.setBounds(100, 330, 250, 20);
        atm.setFont(new Font("Rale way", Font.BOLD, 15));
        atm.setBackground(Color.WHITE);
        add(atm);

        banking = new JCheckBox("Internet Banking");
        banking.setBounds(360, 330, 250, 20);
        banking.setFont(new Font("Rale way", Font.BOLD, 15));
        banking.setBackground(Color.WHITE);
        add(banking);

        mobBank = new JCheckBox("Mobile Banking");
        mobBank.setBounds(100, 360, 250, 20);
        mobBank.setFont(new Font("Rale way", Font.BOLD, 15));
        mobBank.setBackground(Color.WHITE);
        add(mobBank);

        alert = new JCheckBox("Email & SMS Alerts");
        alert.setBounds(360, 360, 250, 20);
        alert.setFont(new Font("Rale way", Font.BOLD, 15));
        alert.setBackground(Color.WHITE);
        add(alert);

        cheque = new JCheckBox("Cheque Book");
        cheque.setBounds(100, 390, 250, 20);
        cheque.setFont(new Font("Rale way", Font.BOLD, 15));
        cheque.setBackground(Color.WHITE);
        add(cheque);

        statement = new JCheckBox("E-Statement");
        statement.setBounds(360, 390, 250, 20);
        statement.setFont(new Font("Rale way", Font.BOLD, 15));
        statement.setBackground(Color.WHITE);
        add(statement);

        declare = new JCheckBox("I hereby declare that all the entered details are correct");
        declare.setBounds(100, 440, 600, 18);
        declare.setFont(new Font("Rale way", Font.BOLD, 20));
        declare.setBackground(Color.WHITE);
        add(declare);

        sub = new JButton("Submit");
        sub.setBounds(300, 480, 100, 25);
        sub.setFont(new Font("Raleway", Font.BOLD, 20));
        sub.setBackground(Color.BLACK);
        sub.setForeground(Color.WHITE);
        sub.addActionListener(this);
        add(sub);

        can = new JButton("Cancel");
        can.setBounds(500, 480, 100, 25);
        can.setFont(new Font("Raleway", Font.BOLD, 20));
        can.setBackground(Color.BLACK);
        can.setForeground(Color.WHITE);
        can.addActionListener(this);
        add(can);

        setVisible(true);
        setSize(900, 600);
        setLocation(200, 50);
        getContentPane().setBackground(Color.WHITE);
    }
    public void actionPerformed(ActionEvent ae) {
        String accountType = "";
        if(savAcc.isSelected())
            accountType = "Saving Account";
        if(fixDep.isSelected())
            accountType = "Fixed Deposit Account";
        if(curAcc.isSelected())
            accountType = "Current Account";
        if(recDep.isSelected())
            accountType ="Recurring Deposit Account";

        Random rand = new Random();
        String card = "" + Math.abs((rand.nextLong()%9000000000000000L) + 1000000000000000L);
        String pin = "" + Math.abs((rand.nextLong()%9000L) + 1000L);


        String facility = "";
        if(atm.isSelected())
            facility += "ATM Card, ";
        if(banking.isSelected())
            facility += "Internet Banking, ";
        if(mobBank.isSelected())
            facility += "Mobile Banking, ";
        if(alert.isSelected())
            facility += "Email & SMS Alerts, ";
        if(cheque.isSelected())
            facility += "Cheque Book, ";
        if(statement.isSelected())
            facility += "E-Statement";


// Remove trailing comma and space
        //facility = facility.replaceAll(", $", "");

        String dec = null;
        if(declare.isSelected())
            dec = "declare";

        try {
            if(ae.getSource() == can) {
                //System.exit(0);
                setVisible(false);
                new Login();
            }
            else if(accountType.equals(""))
                JOptionPane.showMessageDialog(null, "Account Type is required");
            else if(ae.getSource() == sub) {
                if(dec == null) {
                    JOptionPane.showMessageDialog(null, "To proceed tick the Declaration");
                    return;
                }
                Con c = new Con();
                String query = "insert into SignUpThree values('" + formNum + "', '" + accountType + "', '" + card + "', '" + pin + "', '" + facility + "')";
                String query1 = "insert into Login values('"+formNum+"', '"+card+"', '"+pin+"')";
                c.s.executeUpdate(query);
                c.s.executeUpdate(query1);
                JOptionPane.showMessageDialog(null, "Card Number : "+card+"\nPin Number : "+pin);
                setVisible(false);
                new Login().setVisible(true);
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new SignUpThree("");
    }
}

