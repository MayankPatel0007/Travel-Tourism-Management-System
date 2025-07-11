package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class BookPackage extends JFrame implements ActionListener
{
    Choice cpackage;
    JTextField tfperson;
    String username;
    JButton checkprice,bookpackage,back;
    JLabel labelnumber,labelphone,lbltotal,labelid,lblusername,lblperson,lblid,lblpackage,lblnumber,lblphone,labeltotal,labelusername;
    BookPackage(String username)
    {
        
        ImageIcon i1;
       i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
       
       Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(350,40,500,300);
       
       add(image);
       
       
        this.username=username;
        setBounds(450,200,900,500);
        setLayout(null);
        getContentPane().setBackground(Color.yellow);
        
        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(50,10,200,25);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);
        
        lblusername=new JLabel("Username");
        lblusername.setFont(new Font("Tahoma",Font.PLAIN,15));
       lblusername.setBounds(30,60,150,16);
       add(lblusername);

       labelusername=new JLabel();
       labelusername.setFont(new Font("Tahoma",Font.PLAIN,15));
       labelusername.setBounds(200,60,150,25);
       add(labelusername);

        lblpackage=new JLabel("Select Package");
       lblpackage.setFont(new Font("Tahoma",Font.PLAIN,15));
       lblpackage.setBounds(30,100,120,20);
       add(lblpackage);

       cpackage = new Choice ();
       cpackage.add("Gold package");
       cpackage.add("Silver package");
       cpackage.add("Bronze package");
       cpackage.setBounds(200,100,100,20);
       add(cpackage);

       lblperson=new JLabel("Total Person");
       lblperson.setBounds(30,140,120,20);
       lblperson.setFont(new Font("Tahoma",Font.PLAIN,15));
       add(lblperson);

       tfperson=new JTextField("1");
       tfperson.setBounds(200,140,100,25);
       
       add(tfperson);

       lblid=new JLabel("Id");
       lblid.setBounds(30,180,120,20);
       lblid.setFont(new Font("Tahoma",Font.PLAIN,15));
       add(lblid);

       labelid=new JLabel();
       labelid.setBounds(200,180,140,25);
       add(labelid);

       lblnumber=new JLabel("ID Number");
       lblnumber.setBounds(30,220,120,20);
       lblnumber.setFont(new Font("Tahoma",Font.PLAIN,15));
       add(lblnumber);

       labelnumber=new JLabel();
       labelnumber.setBounds(200,220,140,20);
       add(labelnumber);
       
       
       lblphone=new JLabel("Phone");
       lblphone.setBounds(30,260,120,20);
       lblphone.setFont(new Font("Tahoma",Font.PLAIN,15));
       add(lblphone);

        labelphone=new JLabel();
       labelphone.setBounds(200,260,140,20);
       add(labelphone);
       
       lbltotal=new JLabel("Total Price");
       lbltotal.setBounds(30,300,120,20);
       lbltotal.setFont(new Font("Tahoma",Font.PLAIN,15));
       add(lbltotal);

       labeltotal=new JLabel();
       labeltotal.setBounds(200,300,140,20);
       add(labeltotal);
       
        
       try{
         Conn conn=new Conn();
         String query="select * from customer where username =( '"+username+"')";
         ResultSet rs=conn.s.executeQuery(query);
         while(rs.next()){
             labelusername.setText(rs.getString("username"));
             labelid.setText(rs.getString("id"));
             labelnumber.setText(rs.getString("number"));
             labelphone.setText(rs.getString("phone"));
            
         }
       }
       catch (Exception e)
       {
           System.out.println(e);
       }
        setVisible(true);
        checkprice =new JButton("Check price ");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.white);
        checkprice.setBounds(60,380,120,25);
        add(checkprice);
        checkprice.addActionListener(this);
        
        bookpackage =new JButton("Book Package ");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.white);
        bookpackage.setBounds(200,380,120,25);
        add(bookpackage);
        bookpackage.addActionListener(this);
        
        back =new JButton("Back ");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(340,380,120,25);
        add(back);
        back.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
         
        if(ae.getSource()==checkprice)
        { 
            int cost = 0;
            String pack =cpackage.getSelectedItem();
           
            if(pack.equals("Gold package"))
            {
                cost=32000;
            }
            else if(pack.equals("Silver package"))
            {
                cost=25000;
            }
            else if(pack.equals("Bronze package"))
            {
                cost=12000;
            }
            int persons=Integer.parseInt(tfperson.getText());
            cost *= persons;
            labeltotal.setText(""+cost);
        }
        else if(ae.getSource()==back)
        {
            setVisible(false);
        }
        else if(ae.getSource()==bookpackage)
        {
            int cost = 0;
            String pack =cpackage.getSelectedItem();
           
            if(pack.equals("Gold package"))
            {
                cost=32000;
            }
            else if(pack.equals("Silver package"))
            {
                cost=25000;
            }
            else if(pack.equals("Bronze package"))
            {
                cost=12000;
            }
            int persons=Integer.parseInt(tfperson.getText());
            cost *= persons;
            labeltotal.setText(""+cost);
            
            try
            {
                Conn c=new Conn();
                c.s.executeUpdate("insert into bookpackage values ('"+labelusername.getText()+"','"+cpackage.getSelectedItem()+"','"+tfperson.getText()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labeltotal.getText()+"') ");
                JOptionPane.showMessageDialog(null,"Package is successfully booked");
                setVisible(false);
            }
            catch(Exception e)
            {
                System.out.print(e);
            }
        }
    }
   
    public static void main(String args[])
    {
        new BookPackage("");
    }
}


    
    

    

