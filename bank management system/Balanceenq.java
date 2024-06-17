import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Balanceenq extends JFrame implements ActionListener {

    JButton back;
    String cardnumber,pinnumber;

    Balanceenq(String cardnumber,String pinnumber)
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

        back = new JButton("BACK");
        back.setBounds(370, 440, 140, 28);
        back.setFont(new Font("System", Font.BOLD,14));
        back.addActionListener(this);
        image.add(back);

        Conn conn = new Conn();
        int balance = 0;
        try{
            ResultSet rs = conn.s.executeQuery("select * from bankstatement where card_number = '"+cardnumber+"'");
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
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        JLabel text = new JLabel("YOUR CURRENT ACCOUNT BALANCE: Rs."+balance);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,14));
        text.setBounds(165, 370, 400, 20);
        image.add(text);

        setSize(900,800);
        setLocation(300,10);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Balanceenq("","");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pinnumber,cardnumber).setVisible(true);
        
    }
    
}
