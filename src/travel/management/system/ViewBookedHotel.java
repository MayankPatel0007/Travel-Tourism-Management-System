package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.*;

public class ViewBookedHotel  extends JFrame implements ActionListener 
{
    JButton  back;
    
   ViewBookedHotel(String username)
   {
       setBounds(350,200,850,550);
       getContentPane().setBackground(Color.yellow);
       setLayout(null);
       
       JLabel text = new JLabel("View Booked Hotel Details");
       text.setFont(new Font("Tahoma",Font.BOLD,20));
       text.setBounds(60,5,300,30);
       add(text);

       JLabel lblusername=new JLabel("Username  :-");
       lblusername.setBounds(30,50,150,25);
       add(lblusername);

       JLabel labelusername=new JLabel();
       labelusername.setForeground(Color.red);
       labelusername.setBounds(190,50,150,25);
       add(labelusername);
       
       JLabel lblname=new JLabel("Id   :-");
       lblname.setBounds(30,90,150,25);
       add(lblname);

       JLabel labelid=new JLabel();
       labelid.setBounds(190,90,150,25);
       labelid.setForeground(Color.red);
       add(labelid);
       
       JLabel lblgender=new JLabel("ID Number  :-");
       lblgender.setBounds(30,130,150,25);
       add(lblgender);
       
       JLabel labelnumber=new JLabel();
       labelnumber.setForeground(Color.red);
       labelnumber.setBounds(190,130,150,25);
       add(labelnumber);

       JLabel lblpackage=new JLabel("Phone  :-");
       lblpackage.setBounds(30,170,150,25);
       add(lblpackage);

       JLabel labelpackage=new JLabel();
       labelpackage.setBounds(190,170,150,25);
       labelpackage.setForeground(Color.red);
       add(labelpackage);
       
       JLabel labelDays=new JLabel("Hotel Name  :-");
       labelDays.setBounds(30,210,150,25);
       add(labelDays);
       
       JLabel lblDays=new JLabel();
       lblDays.setBounds(190,210,150,25);
       lblDays.setForeground(Color.red);
       add(lblDays);

       JLabel lblnumber=new JLabel("Total Persons  :-");
       lblnumber.setBounds(30,250,150,25);
       add(lblnumber);

       JLabel labelpersons=new JLabel();
       labelpersons.setBounds(190,250,150,25);
       labelpersons.setForeground(Color.red);
       add(labelpersons);

       JLabel labelac=new JLabel("AC or NON-AC  :-");
       labelac.setBounds(30,290,150,25);
       add(labelac);
       
       JLabel lblac=new JLabel();
       lblac.setBounds(190,290,150,25);
       lblac.setForeground(Color.red);
       add(lblac);

       JLabel labelfood=new JLabel("is food Included  :-");
       labelfood.setBounds(30,330,150,25);
       add(labelfood);
       JLabel lblfood=new JLabel();
       lblfood.setBounds(190,330,150,25);
       lblfood.setForeground(Color.red);
       add(lblfood);
       
       JLabel labelName=new JLabel("Total Days  :-");
       labelName.setBounds(30,370,150,25);
       add(labelName);

       JLabel lblName=new JLabel();
       lblName.setBounds(190,370,150,25);
       lblName.setForeground(Color.red);
       add(lblName);
       
       JLabel lbladdress=new JLabel("Price  :-");
       lbladdress.setBounds(30,410,150,25);
       add(lbladdress);
       

       JLabel labeltotal=new JLabel();
       labeltotal.setForeground(Color.red);
       labeltotal.setBounds(190,410,150,25);
       add(labeltotal);


       back=new JButton("Back");
       back.setBackground(Color.WHITE);
       back.setForeground(Color.BLUE);
       back.setBounds(130,470,100,25);
       back.addActionListener(this);
       add(back);

       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
       Image i2=i1.getImage().getScaledInstance(500,400,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(350,6,500,450);
       add(image);

       try
       {
         Conn conn=new Conn();
         String query="select * from bookhotel where username =( '"+username+"')";
         ResultSet rs=conn.s.executeQuery(query);
         while(rs.next())
         {
             labelusername.setText(rs.getString("username"));
             lblDays.setText(rs.getString("name"));
             labelid.setText(rs.getString("id"));
             labelnumber.setText(rs.getString("number"));
             labelpersons.setText(rs.getString("persons"));
             labeltotal.setText(rs.getString("price"));
             lblac.setText(rs.getString("ac"));
             lblfood.setText(rs.getString("food"));
             lblName.setText(rs.getString("days"));
             labelpackage.setText(rs.getString("phone"));
         }
         
       }
       catch (Exception e){}
       setVisible(true);
   }
    @Override
  public void actionPerformed(ActionEvent ae)
  {
       setVisible(false);
  }
 
    public static void main(String[] args)
    {
        new ViewBookedHotel("");
    }
}
