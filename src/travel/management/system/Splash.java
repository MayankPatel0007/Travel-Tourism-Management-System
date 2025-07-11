package travel.management.system;
import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable{
    Thread thread;
    Splash()
    {
//        setSize(1300,750);
//        setLocation(300,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splashpage.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(1300, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        setVisible(true);
        thread=new Thread(this);
        thread.start();
    }
    public void run()
    {
        try{
            Thread.sleep(7000);
              new Login();
              setVisible(false);
        }
        catch(Exception e)
        {
        }
        
    }
    public static void main(String[] args)
    {
        Splash f1 = new Splash();
        int x=1;
        for(int i=1; i<=500;x+=7,i+=6){
            f1.setLocation(900-(x+i)/2,400-(i/2));
            f1.setSize(x+i,i+(x/2));
            try{
                Thread.sleep(10);
            }catch(Exception e){}
        }
    }
}
