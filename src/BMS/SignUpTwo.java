package BMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener {
    JComboBox rel, cat, inc, edu, occ;
    JTextField panText, aadharText;
    JRadioButton v1, v2, x1, x2;
    String FormNum;
    public SignUpTwo(String FormNum) {
        this.FormNum = FormNum;

        setTitle("Additional Details");
        setLayout(null);

        JLabel pageTwo = new JLabel("Page 2 : Additional Details");
        pageTwo.setBounds(250, 30, 400, 40);
        pageTwo.setFont(new Font("Rale way", Font.BOLD, 30));
        add(pageTwo);

        JLabel religion = new JLabel("Religion : ");
        religion.setBounds(150, 90, 300, 30);
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        add(religion);

        String[] val1 = {"Hindu", "Christian", "Muslim", "Sikh", "Jain", "Other"};
        rel = new JComboBox(val1);
        rel.setBounds(450, 90, 300, 30);
        rel.setBackground(Color.WHITE);
        add(rel);

        JLabel category = new JLabel("Category : ");
        category.setBounds(150, 130, 300, 30);
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        add(category);

        String[] val2 = {"General", "BC", "SC", "ST", "other"};
        cat = new JComboBox(val2);
        cat.setBounds(450, 130, 300, 30);
        cat.setBackground(Color.WHITE);
        add(cat);

        JLabel income = new JLabel("Income : ");
        income.setBounds(150, 170, 300, 30);
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        add(income);

        String[] val3 = {"NULL", "< 100000", "< 200000", "< 500000", "< 1000000", "> 1000000"};
        inc = new JComboBox(val3);
        inc.setBounds(450, 170, 300, 30);
        inc.setBackground(Color.WHITE);
        add(inc);

        JLabel education = new JLabel("Educational Qualification : ");
        education.setBounds(150, 210, 300, 30);
        education.setFont(new Font("Raleway", Font.BOLD, 20));
        add(education);

        String[] val4 = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Other"};
        edu = new JComboBox(val4);
        edu.setBounds(450, 210, 300, 30);
        edu.setBackground(Color.WHITE);
        add(edu);

        JLabel occupation = new JLabel("Occupation : ");
        occupation.setBounds(150, 250, 300, 30);
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        add(occupation);

        String[] val5 = {"Student", "Salaried", "Self-Employed", "Business", "Retired", "Other"};
        occ = new JComboBox(val5);
        occ.setBounds(450, 250, 300, 30);
        occ.setBackground(Color.WHITE);
        add(occ);

        JLabel pan = new JLabel("PAN Number : ");
        pan.setBounds(150, 290, 300, 30);
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        add(pan);

        panText = new JTextField();
        panText.setBounds(450, 290, 300, 30);
        add(panText);

        JLabel aadhar = new JLabel("Aadhar Number : ");
        aadhar.setBounds(150, 330, 300, 30);
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        add(aadhar);

        aadharText = new JTextField();
        aadharText.setBounds(450, 330, 300, 30);
        add(aadharText);

        JLabel citizen = new JLabel("Senior Citizen : ");
        citizen.setBounds(150, 370, 300, 30);
        citizen.setFont(new Font("Raleway", Font.BOLD, 20));
        add(citizen);

        v1 = new JRadioButton("YES");
        v1.setBounds(450, 370, 100, 30);
        v1.setBackground(Color.WHITE);
        add(v1);

        v2 = new JRadioButton("NO");
        v2.setBounds(600, 370, 100, 30);
        v2.setBackground(Color.WHITE);
        add(v2);

        ButtonGroup v = new ButtonGroup();
        v.add(v1);
        v.add(v2);

        JLabel account = new JLabel("Existing Account : ");
        account.setBounds(150, 410, 300, 30);
        account.setFont(new Font("Raleway", Font.BOLD, 20));
        add(account);

        x1 = new JRadioButton("YES");
        x1.setBounds(450, 410, 100, 30);
        x1.setBackground(Color.WHITE);
        add(x1);

        x2 = new JRadioButton("NO");
        x2.setBounds(600, 410, 100, 30);
        x2.setBackground(Color.WHITE);
        add(x2);

        ButtonGroup x = new ButtonGroup();
        x.add(x1);
        x.add(x2);

        JButton next = new JButton("NEXT");
        next.setBounds(600, 500, 100, 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        setVisible(true);
        setSize(900, 600);
        setLocation(200, 50);
        getContentPane().setBackground(Color.WHITE);
    }
    public void actionPerformed(ActionEvent ae) {
        String FormNo = FormNum;
        String rel1 = (String) rel.getSelectedItem();
        String cat1 = (String) cat.getSelectedItem();
        String inc1 = (String) inc.getSelectedItem();
        String edu1 = (String) edu.getSelectedItem();
        String occ1 = (String) occ.getSelectedItem();
        String pan1 = panText.getText().trim();
        String aadhar1 = aadharText.getText().trim();

        String Senior_Citizen = null;
        if(v1.isSelected())
            Senior_Citizen = "YES";
        if(v2.isSelected())
            Senior_Citizen = "NO";

        String Existing_Account = null;
        if(x1.isSelected())
            Existing_Account = "YES";
        if(x2.isSelected())
            Existing_Account = "NO";

        try {
            if(rel1.equals("") || cat1.equals("") || inc1.equals("") || edu1.equals("") || occ1.equals("") || Senior_Citizen == null || Existing_Account == null) {
                JOptionPane.showMessageDialog(null, "All fields are required");
                return;
            }
            else if(!isValidAadhar(aadhar1)) {
                JOptionPane.showMessageDialog(null, "Not a valid Aadhar");
                return;
            }
            else if(!isValidPancard(pan1)) {
                JOptionPane.showMessageDialog(null,"Not a valid Pancard");
                return;
            }
            else {
                Con c = new Con();
                String query = "insert into SignUpTwo values('" + FormNo + "', '" + rel1 + "', '" + cat1 + "', '" + inc1 + "', '" + edu1 + "', '" + occ1 + "', '" + pan1 + "', '" + aadhar1 + "', '" + Senior_Citizen + "', '" + Existing_Account + "')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignUpThree(FormNum).setVisible(true);
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
    private boolean isValidAadhar(String aadhar) {
        String aadharRegex = "^[0-9]{12}$";
        return aadhar.matches(aadharRegex);
    }

    private boolean isValidPancard(String pancard) {
        String pancardRegex = "^[a-zA-Z]{5}+[0-9]{4}+[a-zA-Z]{1}$";
        return pancard.matches(pancardRegex);
    }

    public static void main(String[] args) {
        new SignUpTwo("");
    }
}
