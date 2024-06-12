import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//Swing API is basically used for graphical user interface

//import java.awt.*;

public class Login extends JFrame implements ActionListener {

    JButton login,signup,clear;
    JTextField cardNoTextField;
    JPasswordField pinTextField;


    Login() //Constructor
    {
        setLayout(null);        

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("banklogo.png"));
        // Assigns the image to a class type ImagIcon, why icon because we can only place icons on view

        Image i2 = i1.getImage().getScaledInstance(125, 125, Image.SCALE_DEFAULT);
        // now inorder to scale we cant scale icons hence i converted it into image
        
        ImageIcon i3 = new ImageIcon(i2);
        // After scaling it I converted it back into type icon

        JLabel label = new JLabel(i3);
        // this is used for putting the img to the view

        label.setBounds(130,10,150,150);
        // Specifing the location where it has to put in the view

        add(label);
        // this puts it to the view


        //Adding Welcome text to View
        JLabel text = new JLabel("Welcome To ATM");
        text.setFont(new Font("Osward", Font.BOLD, 36));
        text.setBounds(285,70,500,40);
        add(text);

        //Adding Card_No text to View
        JLabel card_No = new JLabel("CARD NUMBER:");
        card_No.setFont(new Font("SansSerif", Font.BOLD, 26));
        card_No.setBounds(175,180,500,40);
        add(card_No);

        //Adding Card Field to View
        cardNoTextField = new JTextField();
        cardNoTextField.setBounds(390, 190, 240, 25);
        cardNoTextField.setFont(new Font("Arial", Font.BOLD,16));
        add(cardNoTextField);

        //Adding Pin text to View
        JLabel pin = new JLabel("PIN NUMBER:");
        pin.setFont(new Font("SansSerif", Font.BOLD, 26));
        pin.setBounds(175,230,500,40);
        add(pin);

        //Adding Pin Field to View
        pinTextField = new JPasswordField();
        pinTextField.setBounds(390, 240, 240, 25);
        pinTextField.setFont(new Font("Arial", Font.BOLD,14));
        add(pinTextField);

        //Adding SignUp button to View
        login = new JButton("SIGN IN");
        login.setBounds(390, 290, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        //Adding Clear button to view
        clear = new JButton("CLEAR");
        clear.setBounds(530, 290, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        //Adding Signup button to view
        signup = new JButton("SIGN UP");
        signup.setBounds(455, 350, 100, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        



        setTitle("AUTOMATED TELLER MACHINE");
        setSize(800, 480); //This line creates the view
        setVisible(true);
        setLocation(350,200);
        getContentPane().setBackground(Color.WHITE); //Background color of view



    }

    @Override
    public void actionPerformed(ActionEvent ae) {
         
        if(ae.getSource() == clear)
        {
            cardNoTextField.setText(null);
            pinTextField.setText(null);
        }
        else if(ae.getSource() == login)
        {

        }
        else if(ae.getSource() == signup)
        {

        }
        
       
    }    
   

    public static void main(String[] args) {
        new Login();
    }

}