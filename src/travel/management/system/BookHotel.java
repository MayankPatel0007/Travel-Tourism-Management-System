package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class BookHotel extends JFrame implements ActionListener
{
    Choice chotel ,cac ,cfood;
    JTextField tfperson ,tfdays;
    String username;
    JButton checkprice,bookpackage,back;
    JLabel labelnumber,labelphone,lbltotal,labelid,lblusername,lblperson,lblid,lblpackage,lblnumber,lblphone,labelusername,lbldays,lblac , lblfood ,labelprice;
    BookHotel(String username)
    {
        
        ImageIcon i1;
       i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
       
       Image i2=i1.getImage().getScaledInstance(550,450,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(500,50,550,450);
       
       add(image);
           
        this.username=username;
        setBounds(350,200,1100,600);
        setLayout(null);
        getContentPane().setBackground(Color.yellow);
        
        JLabel text = new JLabel("BOOK Hotel");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);
        
        lblusername=new JLabel("Username");
        lblusername.setFont(new Font("Tahoma",Font.PLAIN,15));
       lblusername.setBounds(40,70,100,20);
       add(lblusername);

       labelusername=new JLabel();
       labelusername.setFont(new Font("Tahoma",Font.PLAIN,15));
       labelusername.setBounds(250,70,200,20);
       add(labelusername);

        lblpackage=new JLabel("Select Hotel");
       lblpackage.setFont(new Font("Tahoma",Font.PLAIN,15));
       lblpackage.setBounds(40,110,150,20);
       add(lblpackage);

       chotel = new Choice ();   
       chotel.setBounds(250,110,200,60);
       add(chotel);
       
        try {
           Conn c = new Conn();
           ResultSet rs = c.s.executeQuery("select * from hotel");
           while(rs.next()){
               chotel.add(rs.getString("name"));
           }
        } catch (Exception e) {
            e.printStackTrace();
        }

       lblperson=new JLabel("Total Person");
       lblperson.setBounds(40,150,150,25);
       lblperson.setFont(new Font("Tahoma",Font.PLAIN,15));
       add(lblperson);

       tfperson=new JTextField();
       tfperson.setBounds(250,150,200,25);      
       add(tfperson);
       
       lbldays=new JLabel("No. of days");
       lbldays.setBounds(40,190,150,25);
       lbldays.setFont(new Font("Tahoma",Font.PLAIN,15));
       add(lbldays);

       tfdays=new JTextField();
       tfdays.setBounds(250,190,200,25);      
       add(tfdays);
       
       lblac=new JLabel("AC/Non-AC");
       lblac.setBounds(40,230,150,25);
       lblac.setFont(new Font("Tahoma",Font.PLAIN,15));
       add(lblac);
       
       cac = new Choice (); 
       cac.add("AC");
       cac.add("Non-AC");
       cac.setBounds(250,230,200,20);
       add(cac);
       
       lblfood=new JLabel("Food included");
       lblfood.setBounds(40,270,150,25);
       lblfood.setFont(new Font("Tahoma",Font.PLAIN,15));
       add(lblfood);
       
       cfood = new Choice (); 
       cfood.add("Yes");
       cfood.add("No");
       cfood.setBounds(250,270,200,20);
       add(cfood);

       lblid=new JLabel("Id");
       lblid.setBounds(40,310,150,20);
       lblid.setFont(new Font("Tahoma",Font.PLAIN,15));
       add(lblid);

       labelid=new JLabel();
       labelid.setBounds(250,310,200,25);
       add(labelid);

       lblnumber=new JLabel("ID Number");
       lblnumber.setBounds(40,350,150,25);
       lblnumber.setFont(new Font("Tahoma",Font.PLAIN,15));
       add(lblnumber);

       labelnumber=new JLabel();
       labelnumber.setBounds(250,350,150,25);
       add(labelnumber);
       
       
       lblphone=new JLabel("Phone");
       lblphone.setBounds(40,390,150,20);
       lblphone.setFont(new Font("Tahoma",Font.PLAIN,15));
       add(lblphone);

        labelphone=new JLabel();
       labelphone.setBounds(250,390,200,25);
       add(labelphone);
       
       lbltotal=new JLabel("Total Price");
       lbltotal.setBounds(40,430,150,25);
       lbltotal.setFont(new Font("Tahoma",Font.PLAIN,15));
       add(lbltotal);
       
       labelprice = new JLabel();
       labelprice.setBounds(250 , 430 , 150 , 25);
       add(labelprice);
       
       
        
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
        checkprice.setBounds(60,490,120,25);
        add(checkprice);
        checkprice.addActionListener(this);
        
        bookpackage =new JButton("Book Hotel ");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.white);
        bookpackage.setBounds(200,490,120,25);
        add(bookpackage);
        bookpackage.addActionListener(this);
        
        back =new JButton("Back ");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(340,490,120,25);
        add(back);
        back.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
         
        if(ae.getSource()==checkprice)
        { 
            try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel where name = '"+chotel.getSelectedItem()+"'");
            while(rs.next()){
                int cost = Integer.parseInt(rs.getString("costperperson"));
                int food = Integer.parseInt(rs.getString("foodincluded"));
                int ac = Integer.parseInt(rs.getString("acroom"));
                
                int person = Integer.parseInt(tfperson.getText());
                int days = Integer.parseInt(tfdays.getText());
                
                String acselected = cac.getSelectedItem();
                String foodselected = cfood.getSelectedItem();
                
                if(person * days > 0){
                    int total = 0 ;
                    total += acselected.equals("AC") ? ac : 0;
                    total += foodselected.equals("Yes") ? food : 0;
                    total += cost;
                    total = total * person * days;
                    labelprice.setText(" Rs "+total);         
                }
                else{
                    JOptionPane.showMessageDialog(null, "please enter a valid number");
                }
                
            }
            }

           catch(Exception e){
                e.printStackTrace();
            }
        }
       
        else if(ae.getSource()==bookpackage)
        {
            
            
            try
            {
                Conn c=new Conn();
                c.s.executeUpdate("insert into bookhotel values('"+labelusername.getText()+"','"+chotel.getSelectedItem()+"','"+tfperson.getText()+"','" +tfdays.getText()+"','"+cac.getSelectedItem()+"','"+cfood.getSelectedItem()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"') ");
                JOptionPane.showMessageDialog(null,"Hotel booked Successfully");
                setVisible(false);
            }
            catch(Exception e)
            {
                System.out.print(e);
            }
        }else{
            setVisible(false);
    }
    }
   
    public static void main(String[] args)
    {
        new BookHotel("");
    }
}


    
    

    

