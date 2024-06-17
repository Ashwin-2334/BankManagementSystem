import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Pinchange extends JFrame implements ActionListener {

    String pinnumber,cardnumber;
    JTextField newpinField,rnewpinField;
    JButton changepin,back;



    Pinchange(String cardnumber,String pinnumber)
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

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        text.setBounds(255, 270, 400, 20);
        image.add(text);

        JLabel newpin = new JLabel("ENTER NEW PIN:");
        newpin.setForeground(Color.WHITE);
        newpin.setFont(new Font("System", Font.BOLD,16));
        newpin.setBounds(165, 370, 400, 20);
        image.add(newpin);

        newpinField = new JTextField();
        newpinField.setFont(new Font("Raleway", Font.BOLD,22));
        newpinField.setBounds(360,370,150,25);
        image.add(newpinField);

        JLabel rnewpin = new JLabel("RE-ENTER NEW PIN:");
        rnewpin.setForeground(Color.WHITE);
        rnewpin.setFont(new Font("System", Font.BOLD,16));
        rnewpin.setBounds(165, 405, 400, 20);
        image.add(rnewpin);

        rnewpinField = new JTextField();
        rnewpinField.setFont(new Font("Raleway", Font.BOLD,22));
        rnewpinField.setBounds(360,405,150,25);
        image.add(rnewpinField);

        changepin = new JButton("CHANGE PIN");
        changepin.setBounds(370, 440, 140, 28);
        changepin.setFont(new Font("System", Font.BOLD,14));
        changepin.addActionListener(this);
        image.add(changepin);

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
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource()== changepin)
        {
            try
            {
                String npin = newpinField.getText();
                String rpin = rnewpinField.getText();

                if(!npin.equals(rpin))
                {
                    JOptionPane.showMessageDialog(null, "Pin does not match");
                    return;
                }
                if(npin.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Enter New Pin");
                    return;
                }
                if(rpin.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Re-Enter New Pin");
                    return;
                }

                Conn conn = new Conn();
                String query = "update login set pin = '"+rpin+"' where pin ='"+pinnumber+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Pin Changed Successfully");
                setVisible(false);
                new Transactions(rpin,cardnumber).setVisible(true);

            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else
        {
            setVisible(false);
            new Transactions(pinnumber, cardnumber);
        }
    }

    public static void main(String[] args) {
        new Pinchange("","");
    }

    
}
