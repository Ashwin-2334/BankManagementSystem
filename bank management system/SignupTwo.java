import javax.swing.*;
//import java.awt.Font;
import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.*;
import java.awt.event.*;

//implements ActionListener add this next to Jframe


public class SignupTwo extends JFrame implements ActionListener {

    
    JTextField aadhaarTextField,panTextField;
    JButton next;    
    @SuppressWarnings("rawtypes")
    JComboBox education;
    String formno; 

    @SuppressWarnings({ "rawtypes", "unchecked" })
    SignupTwo(String formno)
    {
        this.formno = formno;
        setLayout(null);
        
   
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,32));
        additionalDetails.setBounds(210,70,450,40);
        add(additionalDetails);

        JLabel eduquali = new JLabel("Qualification:");
        eduquali.setFont(new Font("Raleway",Font.BOLD,24));
        eduquali.setBounds(100,200,250,30);
        add(eduquali);

        String educationalValues[] = {"12th Pass","Under-Graduate","Post-graduate","Others"};
        
        education = new JComboBox(educationalValues);
        education.setBackground(Color.WHITE);
        education.setBounds(340,200,300,30);
        add(education);

        JLabel aadhaar = new JLabel("Aadhaar Number:");
        aadhaar.setFont(new Font("Raleway",Font.BOLD,24));
        aadhaar.setBounds(100,260,250,30);
        add(aadhaar);

        aadhaarTextField = new JTextField();
        aadhaarTextField.setFont(new Font("Raleway", Font.BOLD,14));
        aadhaarTextField.setBounds(340, 260, 300, 30);
        add(aadhaarTextField);


        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway",Font.BOLD,24));
        pan.setBounds(100,320,160,30);
        add(pan);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD,14));
        panTextField.setBounds(340, 320, 300, 30);
        add(panTextField);         

        

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD,14));
        next.setBounds(560,450,80,30);
        next.addActionListener(this);
        add(next);

        setTitle("SIGN UP FORM PAGE-2");
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE); //Background color of view
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        //String formno = "" + random;
        String edu = (String) education.getSelectedItem();
        String aadhaar = aadhaarTextField.getText();
        String pan = panTextField.getText();     
               

        try{   
                    
            Conn C = new Conn();
            String query = "insert into signuptwo values('"+formno+"', '"+edu+"', '"+aadhaar+"', '"+pan+"')";
            C.s.executeUpdate(query);
            setVisible(false);
            new SignupThree(formno).setVisible(true);

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignupTwo("");
    }
    
}
