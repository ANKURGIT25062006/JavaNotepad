

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class About extends JFrame implements ActionListener{
    public About() {
        setBounds(400, 100, 600, 500);
        setLayout(null);

        ImageIcon i1 = new ImageIcon("D:\\JavaNotepad\\windows11_transparent.png");
        Image i2 = i1.getImage().getScaledInstance(300, 60, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel headerIcon = new JLabel(i3);
        headerIcon.setBounds(70,40,400,100);
        add(headerIcon);

        ImageIcon i4 = new ImageIcon("D:\\JavaNotepad\\Notepadogo3.png");
        Image i5 = i4.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel icon = new JLabel(i6);
        icon.setBounds(50,180,70,70);
        add(icon);

        JLabel text = new JLabel("<html>My Notepad is a simple and lightweight text editor.<br>Version:1.0.0(OS Build Java)<br>Developed By:Ankur Kumar Mishra</html>");
        text.setBounds(150,100,500,200);
        text.setFont(new Font("SAN_SERIF",Font.PLAIN,18));
        add(text);

        JButton b1 =new JButton("Ok");
        b1.addActionListener(this);
        b1.setFocusPainted(false);
        b1.setBounds(150,350,120,25);
        add(b1);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){

        this.setVisible(false);


}

public static void main(String[] args){

    new About();

    }
}
