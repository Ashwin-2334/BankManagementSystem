import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Transactions extends JFrame implements ActionListener{

    JButton deposit,withdrawal,balanceenquiry,pinchange,ministatement,exit;
    String pinnumber,cardnumber;

    Transactions(String pinnumber,String cardnumber)
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

        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(225, 260, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        image.add(text);

        deposit = new JButton("DEPOSIT");
        deposit.setBounds(160, 368, 160, 28);
        deposit.setFont(new Font("System", Font.BOLD,14));
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawal = new JButton("WITHDRAWAL");
        withdrawal.setBounds(350, 368, 160, 28);
        withdrawal.setFont(new Font("System", Font.BOLD,14));
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        ministatement = new JButton("MINI-STATEMENT");
        ministatement.setBounds(160, 400, 160, 28);
        ministatement.setFont(new Font("System", Font.BOLD,14));
        image.add(ministatement);
        
        balanceenquiry = new JButton("BALANCE");
        balanceenquiry.setBounds(350, 400, 160, 28);
        balanceenquiry.setFont(new Font("System", Font.BOLD,14));
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        pinchange = new JButton("CHANGE PIN");
        pinchange.setBounds(160, 430, 160, 28);
        pinchange.setFont(new Font("System", Font.BOLD,14));
        pinchange.addActionListener(this);
        image.add(pinchange);

        exit = new JButton("EXIT");
        exit.setBounds(350, 430, 160, 28);
        exit.setFont(new Font("System", Font.BOLD,14));
        exit.addActionListener(this);
        image.add(exit);


        setSize(900,800);
        setLocation(300,10);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Transactions("","");
    }

    @Override
    public void actionPerformed(ActionEvent ae)
     {
        if(ae.getSource() == exit)
        {
            System.exit(0);
        }
        else if(ae.getSource() == deposit)
        {
            setVisible(false);
            new Deposit(pinnumber,cardnumber).setVisible(true);
        }
        else if(ae.getSource() == withdrawal)
        {
            setVisible(false);
            new Withdrawal(pinnumber,cardnumber).setVisible(true);
        }
        else if(ae.getSource() == pinchange)
        {
            setVisible(false);
            new Pinchange(cardnumber,pinnumber).setVisible(true);
        }
        else if(ae.getSource() == balanceenquiry)
        {
            setVisible(false);
            new Balanceenq(cardnumber, pinnumber);
        }


     }
    
}
