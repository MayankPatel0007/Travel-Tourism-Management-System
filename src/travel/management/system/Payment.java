package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URI;

public class Payment extends JFrame implements ActionListener {
    JButton pay, back;

    Payment() {
        setBounds(500, 200, 800, 601);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/paytm.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(800, 601, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 601);
        add(image);

        pay = new JButton("Pay");
        pay.setBounds(420, 5, 80, 35);
        pay.setBackground(new Color(0, 0, 139));
        pay.setForeground(Color.WHITE);
        pay.addActionListener(this);
        image.add(pay);

        back = new JButton("Back");
        back.setBounds(520, 5, 80, 35);
        back.setBackground(new Color(0, 0, 139));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        image.add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == pay) {
            // Open Paytm in the default browser when the Pay button is clicked
            try {
                Desktop.getDesktop().browse(new URI("https://paytm.com/rent-payment"));
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Failed to open Paytm in the browser.");
            }
        } else if (ae.getSource() == back) {
            setVisible(false); // Close the window on back button click
        }
    }

    public static void main(String[] args) {
        new Payment();
    }
}

