import javax.swing.*;

//Swing API is basically used for graphical user interface

public class Login extends JFrame {

    Login() //Constructor
    {
        setSize(800, 480);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }    
}