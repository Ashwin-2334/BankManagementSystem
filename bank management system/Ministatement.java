import java.awt.*;
import java.sql.ResultSet;

import javax.swing.*;

public class Ministatement extends JFrame {

    Ministatement(String cardnumber,String pinnumber)
    {
        setTitle("MINI STATEMENT");
        setLayout(null);

        JLabel minis = new JLabel();
        minis.setBounds(20, 40, 400, 400);
        add (minis);

        try
        {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from bankstatement where card_number = '"+cardnumber+"'");
            while (rs.next()) 
            {
                minis.setText(minis.getText() +"<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("transaction_type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");

                
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }


        setSize(400,500);
        setLocation(300,10);
        getContentPane().setBackground(Color.WHITE);
        //setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ministatement("","");
    }
    
}
