import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;

//Swing API is basically used for graphical user interface

//import java.awt.*;

public class Login extends JFrame {

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


        JLabel card_No = new JLabel("CARD NUMBER:");
        card_No.setFont(new Font("SansSerif", Font.BOLD, 26));
        card_No.setBounds(175,180,500,40);
        add(card_No);

        JTextField cardNoTextField = new JTextField();
        cardNoTextField.setBounds(390, 190, 240, 25);
        add(cardNoTextField);

        JLabel pin = new JLabel("PIN NUMBER:");
        pin.setFont(new Font("SansSerif", Font.BOLD, 26));
        pin.setBounds(175,230,500,40);
        add(pin);

        JTextField pinTextField = new JTextField();
        pinTextField.setBounds(390, 240, 240, 25);
        add(pinTextField);

        JButton login = new JButton("SIGN IN");
        login.setBounds(390, 290, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        add(login);

        JButton clear = new JButton("CLEAR");
        clear.setBounds(530, 290, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        add(clear);
        
        JButton signup = new JButton("SIGN UP");
        signup.setBounds(455, 350, 100, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        add(signup);

        



        setTitle("AUTOMATED TELLER MACHINE");
        setSize(800, 480); //This line creates the view
        setVisible(true);
        setLocation(350,200);
        getContentPane().setBackground(Color.WHITE); //Background color of view



    }

    public static void main(String[] args) {
        new Login();
    }    
}