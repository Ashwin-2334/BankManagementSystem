import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.*;

public class Withdrawal extends JFrame implements ActionListener{

    JTextField amount;
    JButton withdraw,back;
    String cardnumber,pinnumber;

    Withdrawal(String pinnumber,String cardnumber)
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

        JLabel text = new JLabel("ENTER THE AMOUNT TO BE WITHDRAWED");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        text.setBounds(175, 270, 400, 20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD,22));
        amount.setBounds(210,310,250,25);
        image.add(amount);

        withdraw = new JButton("WITHDRAW");
        withdraw.setBounds(370, 440, 140, 28);
        withdraw.setFont(new Font("System", Font.BOLD,14));
        withdraw.addActionListener(this);
        image.add(withdraw);

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
        
        if(ae.getSource() == withdraw)
        {
            

                String amtwithdrawed = amount.getText();                
                Date date = new Date();
                if(amtwithdrawed.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please Enter the amount");
                }
                else
                {
                    try
                    {
                    Conn conn = new Conn();
                    ResultSet rs = conn.s.executeQuery("select * from bankstatement where card_number = '"+cardnumber+"'");
                    int balance = 0;
                    while (rs.next())
                    {
                        if(rs.getString("transaction_type").equals("DEPOSIT"))
                        {
                            balance += Integer.parseInt(rs.getString("amount"));
                        }
                        else
                        {
                            balance -= Integer.parseInt(rs.getString("amount"));                            
                        }                        
                    }
                    
                    if (balance < Integer.parseInt(amtwithdrawed)) {
                        JOptionPane.showMessageDialog(null,"Insufficient balance");
                        return;
                    }

                    String query = "insert into bankstatement values('"+cardnumber+"', 'WITHDRAWAL', '"+amtwithdrawed+"', '"+date+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs."+amtwithdrawed+" Withdrawed Successfully");
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
        new Withdrawal("","");
    }
    
}

