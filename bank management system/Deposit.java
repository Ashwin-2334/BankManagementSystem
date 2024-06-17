import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{

    JTextField amount;
    JButton deposit,back;
    String cardnumber,pinnumber;

    Deposit(String pinnumber,String cardnumber)
    {
        this.pinnumber = pinnumber;
        this.cardnumber = cardnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 800);
        add(image);

        JLabel text = new JLabel("ENTER THE AMOUNT TO BE DEPOSITED");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        text.setBounds(185, 270, 400, 20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD,22));
        amount.setBounds(210,310,250,25);
        image.add(amount);

        deposit = new JButton("DEPOSIT");
        deposit.setBounds(370, 440, 140, 28);
        deposit.setFont(new Font("System", Font.BOLD,14));
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("BACK");
        back.setBounds(370, 470, 140, 28);
        back.setFont(new Font("System", Font.BOLD,14));
        back.addActionListener(this);
        image.add(back);

        setSize(900,800);
        setLocation(300,10);
        setUndecorated(true);
        setVisible(true);
    }

    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == deposit)
        {
            

                String amtdeposited = amount.getText();                
                Date date = new Date();
                if(amtdeposited.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please Enter the amount");
                }
                else
                {
                    try
                    {
                    Conn conn = new Conn();
                    String query = "insert into bankstatement values('"+cardnumber+"', 'DEPOSIT', '"+amtdeposited+"', '"+date+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs."+amtdeposited+" Deposited Successfully");
                    setVisible(false);
                    new Transactions(pinnumber, cardnumber).setVisible(true);
                }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
                }
        }
        else if (ae.getSource() == back)
        {
            setVisible(false);
            new Transactions(pinnumber,cardnumber).setVisible(true);
        }
        
    }
    public static void main(String[] args) {
        new Deposit("","");
    }
    
}

