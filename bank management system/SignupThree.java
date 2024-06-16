import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class SignupThree extends JFrame implements ActionListener {

    JButton cancel,done;
    String formno;
    Random random = new Random();
    String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);

    String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

    SignupThree(String formno)
    {
        this.formno = formno;

        JLabel accountDetails = new JLabel("Page 3: Account Details");
        accountDetails.setFont(new Font("Raleway",Font.BOLD,32));
        accountDetails.setBounds(230,70,450,40);
        add(accountDetails);

        JLabel cardNo = new JLabel("CARD NUMBER:");
        cardNo.setFont(new Font("Raleway",Font.BOLD,26));
        cardNo.setBounds(110,180,450,40);
        add(cardNo);

        JLabel excardNo = new JLabel(cardnumber);
        excardNo.setFont(new Font("Raleway",Font.BOLD,26));
        excardNo.setBounds(350,180,450,40);
        add(excardNo);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,26));
        pin.setBounds(110,240,450,40);
        add(pin);

        JLabel pnumber = new JLabel(pinnumber);
        pnumber.setFont(new Font("Raleway",Font.BOLD,26));
        pnumber.setBounds(350,240,450,40);
        add(pnumber);

        cancel = new JButton("CANCEL");
        cancel.setBounds(230, 350, 100, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);        
        cancel.addActionListener(this);
        add(cancel);

        done = new JButton("DONE");
        done.setBounds(530, 350, 100, 30);
        done.setBackground(Color.BLACK);
        done.setForeground(Color.WHITE);
        done.addActionListener(this);
        add(done);

        setTitle("SIGN UP PAGE THREE");
        setLayout(null);
        setSize(850,820);
        setLocation(350,10);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent ae)
     {
        if(ae.getSource() == done)
        {
           try
            {
                Conn C = new Conn();
                String query1 = "insert into signupthree values('"+formno+"', '"+cardnumber+"', '"+pinnumber+"')";
                C.s.executeUpdate(query1);
                setVisible(false);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }


        else if(ae.getSource() == cancel)
        {

        }
     }


    public static void main(String[] args) {
        new SignupThree("");
    }



    
}
