package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login  extends JFrame implements ActionListener
{
    
    JButton login,signup,bpassword;
    JTextField tUserName;
    JPasswordField tPassWord;
   Login  ()
   {
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setSize(900,400);
       setLocation(500,200);
	setLayout(null);
        getContentPane().setBackground(Color.WHITE);
       
       JPanel p1;
       p1 = new JPanel();
       p1.setBackground(Color.white);
	p1.setBounds(0,0,400,400);
       add(p1);
       
       ImageIcon i1;
       i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
       Image i2=i1.getImage().getScaledInstance(380,350,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(100,120,200,200);
       
       p1.add(image);
       
       JPanel p2=new JPanel();
       p2.setLayout(null);
       p2.setBackground(Color.WHITE);
       p2.setBounds(380,30,450,300);
       add(p2);
       
       
       
       JLabel name=new JLabel("Travel And Tourism Managment");
       name.setBounds(60,-5,400,30);
       name.setFont(new Font("SERIF",Font.BOLD,25));
       name.setForeground(new Color(0, 128, 0));
       p2.add(name);
       
       JLabel lUserName=new JLabel("Username");
       lUserName.setBounds(60,35,100,25);
       lUserName.setFont(new Font("Niramala UI",Font.PLAIN,20));
       lUserName.setForeground(Color.BLACK);
       p2.add(lUserName);
       
       
       tUserName=new JTextField();
       tUserName.setBounds(60, 60, 300,30);
       p2.add(tUserName);
       
       
       JLabel lPassWord=new JLabel("Password");
       lPassWord.setBounds(60,100,100,25);
       lPassWord.setFont(new Font("Niramala UI",Font.PLAIN,20));
       lPassWord.setForeground(Color.BLACK);
       p2.add(lPassWord);
       
       tPassWord=new JPasswordField();
       tPassWord.setBounds(60, 124, 300,30);
       p2.add(tPassWord);
       
       login =new JButton("Login");
       login.setBounds(60,170,130,30);
       login.setBackground(new Color(70, 130, 180)); 
       login.setForeground(Color.WHITE);
       login.addActionListener(this);
       p2.add(login);
       
       
       signup =new JButton("Signup");
       signup.setBounds(220,170,130,30);
       signup.setBackground(new Color(70, 130, 180)); 
       signup.setForeground(Color.WHITE);
       signup.addActionListener(this);
       p2.add(signup);
       
       
       bpassword =new JButton("Forget PassWord");
       bpassword.setBounds(135,220,140,30);
       bpassword.setBackground(new Color(70, 130, 180));
       bpassword.setForeground(Color.WHITE);
       bpassword.addActionListener(this);
       p2.add(bpassword);
       
       
       JLabel text=new JLabel("Unable to log in");
       text.setBounds(300, 220, 100, 20);
       text.setForeground(Color.red);
       p2.add(text);
       
       
       setVisible(true);
   }
    @Override
   public void actionPerformed(ActionEvent ae)
   {
       if(ae.getSource()==login)
       {
           try
           {
               String username=tUserName.getText();
               String password=tPassWord.getText();
               String query="select * from account where username='"+username+"' AND password='"+password+"'";
               Conn c=new Conn();
               ResultSet rs=c.s.executeQuery(query);
               if(rs.next())
               {
                   setVisible(false);
                   new Loading(username);
               }
               else
               {
                   JOptionPane.showMessageDialog(null,"PassWord Or UserName Is Incorrect \n try again ");
               }
               
           }
           catch(Exception e)
           {
               System.out.println(e);
           }
       }
       else if(ae.getSource()==signup)
       {
           setVisible(false);
           new Signup();
       }
       else if(ae.getSource()==bpassword)
       {
           setVisible(false);
           new ForgetPassword();
       }
   }
   public static void main(String arg[]) throws InterruptedException
   {
       new Login ();
      
   }
}
