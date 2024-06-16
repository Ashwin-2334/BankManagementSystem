import javax.swing.*;
import java.awt.Font;
import java.awt.*;
import java.util.*;
import java.awt.event.*;


public class SignupOne extends JFrame implements ActionListener {

    long random;
    JTextField nameTextField,emailTextField,addressTextField,dobTextField;
    JButton next;
    JRadioButton male,female;

    SignupOne()
    {
        setLayout(null);
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        JLabel formNo = new JLabel("APPLICATION FORM NO-"+random);
        formNo.setFont(new Font("Raleway",Font.BOLD,36));
        formNo.setBounds(140,20,600,40);
        add(formNo);

        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,32));
        personalDetails.setBounds(210,70,450,40);
        add(personalDetails);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,24));
        name.setBounds(100,160,100,30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD,14));
        nameTextField.setBounds(340, 160, 300, 30);
        add(nameTextField);


        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,24));
        dob.setBounds(100,220,160,30);
        add(dob);

        dobTextField = new JTextField();
        dobTextField.setFont(new Font("Raleway", Font.BOLD,14));
        dobTextField.setBounds(340, 220, 300, 30);
        add(dobTextField);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,24));
        gender.setBounds(100,280,100,30);
        add(gender);

        male = new JRadioButton("MALE");
        male.setBounds(340,280,60,30);
        add(male);
        male.setBackground(Color.WHITE);

        female = new JRadioButton("FEMALE");
        female.setBounds(420,280,100,30);
        add(female);
        female.setBackground(Color.WHITE);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);


        JLabel email = new JLabel("Email:");
        email.setFont(new Font("Raleway",Font.BOLD,24));
        email.setBounds(100,340,160,30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD,14));
        emailTextField.setBounds(340, 340, 300, 30);
        add(emailTextField);

        

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,24));
        address.setBounds(100,400,160,30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD,14));
        addressTextField.setBounds(340, 400, 300, 30);
        add(addressTextField);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD,14));
        next.setBounds(560,450,80,30);
        next.addActionListener(this);
        add(next);

        setTitle("SIGN UP FORM PAGE-1");
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE); //Background color of view
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        String formno = "" + random;
        String name = nameTextField.getText();
        String dob = dobTextField.getText();
        String gender = null;
        String email = emailTextField.getText();
        String address = addressTextField.getText();
        if(male.isSelected()){
            gender = "Male";
        }
        else if(female.isSelected()){
            gender = "Female";
        }

        try{
            if (name.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Name is required");
            }
            else
            {
                Conn C = new Conn();
                String query = "insert into signup values('"+formno+"', '"+name+"', '"+dob+"', '"+gender+"', '"+email+"', '"+address+"')";
                C.s.executeUpdate(query);

                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignupOne();
    }
    
}
