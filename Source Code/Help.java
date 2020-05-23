import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Help extends JFrame 
{
	JPanel panel;
 
		public Help()
		{  
			super("Help");
			setIconImage(new ImageIcon("image/logo.png").getImage());
			setLayout(null);
			setSize(800,600);
			panel = new JPanel();
			panel.setBackground(Color.white);
			panel.setBounds(0,0,800,600);
			panel.setLayout(null);
			add(panel);
			
			JLabel l1=new JLabel("Only students help.");
			l1.setBounds(50,100,400,40);
			Font font=new Font("Britannic",Font.PLAIN,25);
			l1.setFont(font);
			JLabel l2=new JLabel("Any college project relatives solutions comment now.");
			l2.setBounds(50,200,600,40);
			Font font2=new Font("Britannic",Font.PLAIN,25);
			l2.setFont(font2);
			JLabel l3=new JLabel("Note : This project is very simple.");
			l3.setBounds(50,300,500,40);
			Font font1=new Font("Britannic",Font.PLAIN,25);
			l3.setFont(font1);
			panel.add(l1);
			panel.add(l2);
		    	panel.add(l3);
			JLabel im=new JLabel(new ImageIcon("image/n.jpg"));
		im.setBounds(0,600,850,850);
		panel.add(im);
		addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e){ new MainForm();  dispose(); }});
		    	setLocation(200,70);
		    	setVisible(true);
		    	
		}


	/*public static void main(String [] args)
			{ new Help();  }*/
}