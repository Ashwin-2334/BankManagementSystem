import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Transactions extends JFrame implements ActionListener{

    JButton deposit,withdrawal,balanceenq,pinchange,ministatement,exit;
    String pinnumber;

    Transactions(String pinnumber)
    {
        this.pinnumber = pinnumber;
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
        image.add(deposit);

        withdrawal = new JButton("WITHDRAWAL");
        withdrawal.setBounds(350, 368, 160, 28);
        withdrawal.setFont(new Font("System", Font.BOLD,14));
        image.add(withdrawal);

        ministatement = new JButton("MINI-STATEMENT");
        ministatement.setBounds(160, 400, 160, 28);
        ministatement.setFont(new Font("System", Font.BOLD,14));
        image.add(ministatement);
        
        balanceenq = new JButton("BALANCE");
        balanceenq.setBounds(350, 400, 160, 28);
        balanceenq.setFont(new Font("System", Font.BOLD,14));
        image.add(balanceenq);
        
        pinchange = new JButton("CHANGE PIN");
        pinchange.setBounds(160, 430, 160, 28);
        pinchange.setFont(new Font("System", Font.BOLD,14));
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
        new Transactions("");
    }

    @Override
    public void actionPerformed(ActionEvent ae)
     {
        if(ae.getSource() == exit)
        {
            System.exit(0);
        }

     }
    
}
