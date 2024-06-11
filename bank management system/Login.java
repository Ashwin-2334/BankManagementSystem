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

        label.setBounds(70,10,150,150);
        // Specifing the location where it has to put in the view

        add(label);
        // this puts it to the view


        //Adding Welcome text to View
        JLabel text = new JLabel("Welcome To ATM");
        text.setFont(new Font("Osward", Font.BOLD, 36));
        text.setBounds(215,70,500,40);
        add(text);



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