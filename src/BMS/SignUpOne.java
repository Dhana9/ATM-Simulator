package BMS;

import javax.swing.*;
import java.awt.*;
import java.time.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class SignUpOne extends JFrame implements ActionListener {
    long x;
    JTextField name1, fname1, email1, address1, city1, state1, pinCode1;
    JDateChooser dateChooser;
    JRadioButton male, female, other1, married, unmarried, other;
    JButton next;
    SignUpOne() {
        setTitle("Personal Details");

        setLayout(null);

        Random ran = new Random();
        x = Math.abs(ran.nextLong()%9000L);

        JLabel form = new JLabel("APPLICATION FORM NO. "+x);
        form.setBounds(250, 20, 600, 50);
        form.setFont(new Font("Rale way", Font.BOLD, 30));
        add(form);

        JLabel pageOne = new JLabel("Page 1 : Personal Details");
        pageOne.setBounds(300, 60, 400, 30);
        pageOne.setFont(new Font("Rale way", Font.BOLD, 20));
        add(pageOne);

        JLabel name = new JLabel("Name : ");
        name.setBounds(100, 110, 200, 20);
        name.setFont(new Font("Rale way", Font.BOLD, 20));
        add(name);

        name1 = new JTextField();
        name1.setBounds(300, 110, 500, 25);
        add(name1);

        JLabel fname = new JLabel("Father's Name : ");
        fname.setBounds(100, 150, 200, 20);
        fname.setFont(new Font("Rale way", Font.BOLD, 20));
        add(fname);

        fname1 = new JTextField();
        fname1.setBounds(300, 150, 500, 25);
        add(fname1);

        JLabel dob = new JLabel("Date of Birth : ");
        dob.setBounds(100, 190, 200, 20);
        dob.setFont(new Font("Rale way", Font.BOLD, 20));
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 190, 500, 25);
        add(dateChooser);

        JLabel gender = new JLabel("Gender : ");
        gender.setBounds(100, 230, 200, 20);
        gender.setFont(new Font("Rale way", Font.BOLD, 20));
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 230, 100, 20);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(500, 230, 100, 20);
        female.setBackground(Color.WHITE);
        add(female);

        other1 = new JRadioButton("Other");
        other1.setBounds(700, 230, 100, 20);
        other1.setBackground(Color.WHITE);
        add(other1);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other1);

        JLabel email = new JLabel("Email : ");
        email.setBounds(100, 270, 200, 20);
        email.setFont(new Font("Rale way", Font.BOLD, 20));
        add(email);

        email1 = new JTextField();
        email1.setBounds(300, 270, 500, 25);
        add(email1);

        JLabel marital = new JLabel("Marital Status : ");
        marital.setBounds(100, 310, 200, 20);
        marital.setFont(new Font("Rale way", Font.BOLD, 20));
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300, 310, 100, 20);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(500, 310, 100, 20);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(700, 310, 100, 20);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);

        JLabel address = new JLabel("Address : ");
        address.setBounds(100, 350, 200, 20);
        address.setFont(new Font("Rale way", Font.BOLD, 20));
        add(address);

        address1 = new JTextField();
        address1.setBounds(300, 350, 500, 25);
        add(address1);

        JLabel city = new JLabel("City : ");
        city.setBounds(100, 390, 200, 20);
        city.setFont(new Font("Rale way", Font.BOLD, 20));
        add(city);

        city1 = new JTextField();
        city1.setBounds(300, 390, 500, 25);
        add(city1);

        JLabel state = new JLabel("State : ");
        state.setBounds(100, 430, 200, 20);
        state.setFont(new Font("Rale way", Font.BOLD, 20));
        add(state);

        state1 = new JTextField();
        state1.setBounds(300, 430, 500, 25);
        add(state1);

        JLabel pinCode = new JLabel("Pin Code : ");
        pinCode.setBounds(100, 470, 200, 20);
        pinCode.setFont(new Font("Rale way", Font.BOLD, 20));
        add(pinCode);

        pinCode1 = new JTextField();
        pinCode1.setBounds(300, 470, 500, 25);
        add(pinCode1);

        next = new JButton("NEXT");
        next.setBounds(700, 510, 100, 25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        setSize(900, 600);
        setVisible(true);
        setLocation(200, 50);
        getContentPane().setBackground(Color.WHITE);

    }

    public void actionPerformed(ActionEvent ae) {
        String FormNum = "" + x;
        String Name = name1.getText().trim();
        String FName = fname1.getText().trim();
        String DOB = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String Gender = null;
        if(male.isSelected())
            Gender = "Male";
        else if(female.isSelected())
            Gender = "Female";
        else if(other1.isSelected())
            Gender = "Other";
        String email = email1.getText();
        String Marital_Status = null;
        if(married.isSelected())
            Marital_Status = "Married";
        else if(unmarried.isSelected())
            Marital_Status = "Unmarried";
        else if(other.isSelected())
            Marital_Status = "Other";
        String Address = address1.getText();
        String City = city1.getText();
        String State = state1.getText();
        String PinCode = pinCode1.getText();

        try {
            if(Name.equals("") || FName.equals("") || Address.equals("") || City.equals("") || State.equals("") || Gender == null || Marital_Status == null) {
                JOptionPane.showMessageDialog(null, "All fields are required");
                return;
            }
            else if(!isValidName(Name)) {
                JOptionPane.showMessageDialog(null, "Name is not Valid");
                return;
            }
            else if(!isValidName(FName)) {
                JOptionPane.showMessageDialog(null, "Father Name is not Valid");
                return;
            }
            else if(!isValidName(Address)) {
                JOptionPane.showMessageDialog(null, "Address is not Valid");
                return;
            }
            else if(!isValidName(State)) {
                JOptionPane.showMessageDialog(null, "State is not Valid");
                return;
            }
            else if(!isValidName(City)) {
                JOptionPane.showMessageDialog(null, "City is not Valid");
                return;
            }
            else if(!isValidEmail(email)) {
                JOptionPane.showMessageDialog(null, "Incorrect Email Pattern");
                return;
            }
            else if(!isValidPinCode(PinCode)) {
                JOptionPane.showMessageDialog(null, "Incorrect Pincode");
                return;
            }
            else {
                LocalDate currentDate = LocalDate.now();
                LocalDate dob = dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                long age = Period.between(dob, currentDate).getYears();
                if (age < 18) {
                    JOptionPane.showMessageDialog(null, "You must be 18 years or older to create a bank account.");
                    return; // Prevent further execution if age is less than 18
                }

                Con c = new Con();
                String query = "insert into SignUpOne values('" + FormNum + "', '" + Name + "', '" + FName + "', '" + DOB + "', '" + Gender + "', '" + email + "', '" + Marital_Status + "', '" + Address + "', '" + State + "', '" + City + "', '" + PinCode + "')";
                c.s.executeUpdate(query);
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        if(ae.getSource() == next) {
            setVisible(false);
            new SignUpTwo(FormNum).setVisible(true);
        }
    }

    private boolean isValidName(String name) {
        String[] nameComponents = name.trim().split("\\s+");
        for (String component : nameComponents) {
            if (!component.matches("^[a-zA-Z]{2,}$")) {
                return false;
            }
        }
        return true;
    }
    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9]+@[a-zA-Z]+\\.+[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
    }

    public boolean isValidPinCode(String pincode) {
        String pincodeRegex = "\\d{6}";
        return pincode.matches(pincodeRegex);
    }

    public static void main(String[] args) {
        new SignUpOne();
    }
}

