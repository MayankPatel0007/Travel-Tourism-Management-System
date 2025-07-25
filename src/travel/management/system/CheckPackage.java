package travel.management.system;
import javax.swing.*;
import java.awt.*;
public class CheckPackage extends JFrame{
    
    CheckPackage(){
        setBounds(450,200,900,600);
        
      String[] package1 = new String[]{"BRONZE PACKAGE","3 days and 2 Nights", "Airport Assistance at Aiport", "Half Day City Tour", "Welcome drinks on Arrival", "Daily Buffet", "Full Day 3 Island Cruise", "English Speaking Guide", "BOOK NOW", "Summer Special", "Rs 12000 only","package1.jpg"};
      String[] package2 = new String[]{"SILVER PACKAGE","4 days and 3 Nights", "Entrance Free Tickets", "Meet and Greet at Aiport", "Welcome drinks on Arrival", "Night Safari", "Full Day 3 Island Cruise", "Cruise with Dinner", "BOOK NOW", "Winter Special", "Rs 25000 only","package2.jpg"};
      String[] package3 = new String[]{"GOLD PACKAGE","6 days and 5 Nights", "Return Airfare", "Free Clubbing & other Games", "Welcome drinks on Arrival", "Daily Buffet", "Stay in 5 Star Hotel", "BBQ Dinner", "BOOK NOW", "Winter Special", "Rs 32000 only","package3.jpg"};
      
        JTabbedPane tab = new JTabbedPane();
        JPanel p1 = createPackage(package1);
        tab.addTab("Package 1", null, p1);
        
        JPanel p2 = createPackage(package2);
        tab.addTab("Package 2", null, p2);
        
        JPanel p3 = createPackage(package3);
        tab.addTab("Package 3", null, p3);
        add(tab);
        
        
        setVisible(true);
    }
    public JPanel createPackage(String[] pack)
    {
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(70, 130, 180));
        
        JLabel l1 = new JLabel(pack[0]);
        l1.setBounds(300, 5, 300, 30);
        l1.setForeground(Color.YELLOW);
        l1.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(l1);
        
        JLabel l2 = new JLabel(pack[1]);
        l2.setBounds(30,60, 300, 30);
        l2.setForeground(Color.ORANGE);
        l2.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l2);
        
        JLabel l3 = new JLabel(pack[2]);
        l3.setBounds(30,110, 300, 30);
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l3);
        
        JLabel l4 = new JLabel(pack[3]);
        l4.setBounds(30,160, 300, 30);
        l4.setForeground(Color.ORANGE);
        l4.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l4);
        
        JLabel l5 = new JLabel(pack[4]);
        l5.setBounds(30,210, 300, 30);
        l5.setForeground(Color.WHITE);
        l5.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l5);
        
        JLabel l6 = new JLabel(pack[5]);
        l6.setBounds(30,260, 300, 30);
        l6.setForeground(Color.ORANGE);
        l6.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l6);
        
        JLabel l7 = new JLabel(pack[6]);
        l7.setBounds(30,310, 300, 30);
        l7.setForeground(Color.WHITE);
        l7.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l7);
        
        JLabel l8 = new JLabel(pack[7]);
        l8.setBounds(30,360, 300, 30);
        l8.setForeground(Color.ORANGE);
        l8.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l8);
        
        JLabel l9 = new JLabel(pack[8]);
        l9.setBounds(60,430, 300, 30);
        l9.setForeground(Color.GREEN);
        l9.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(l9);
        
        JLabel l10 = new JLabel(pack[9]);
        l10.setBounds(80,480, 300, 30);
        l10.setForeground(Color.CYAN);
        l10.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(l10);
        
        JLabel l11 = new JLabel(pack[10]);
        l11.setBounds(500,480, 300, 30);
        l11.setForeground(Color.PINK);
        l11.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(l11);
        
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/"+pack[11]));
       Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(350,100,500,300);
       p1.add(image);
       
       return p1;
    }
   public static void main(String[] args)
   {
       new CheckPackage();
   }
}
