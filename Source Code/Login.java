import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;
public class Login extends JFrame implements  ActionListener 
{

	
	String username="system";
	String password="system";
	JLabel userid,password1;
	JTextField useridtf;
	JPasswordField passwordtf;
	JButton login,login2,exit,table;
	Statement stm;
	Connection con;
	ResultSet rs;
	JPanel panel;
	public Login()
	{
		super("Login");
			
		
		 panel=new JPanel();
		panel.setLayout(null);
		panel.setBounds(0,0,400,300);
		panel.setBackground(Color.yellow);
		JLabel label1=new JLabel("Hospital  Management System");
		label1.setLayout(null);
		label1.setBounds(50,10,500,60);
		label1.setForeground(Color.blue);
		Font font=new Font("Rosewood Std",Font.BOLD,20);
		label1.setFont(font);
		userid= new JLabel("User ID :");
		userid.setLayout(null);
		userid.setBounds(100,100,100,20);
		panel.add(userid);
		password1= new JLabel("User Password :");
		password1.setLayout(null);
		password1.setBounds(100,140,100,20);
		panel.add(password1);
		useridtf= new JTextField();
		useridtf.setLayout(null);
		useridtf.setBounds(250,100,100,20);
		panel.add(useridtf);
		passwordtf= new JPasswordField();
		passwordtf.setBounds(250,140,100,20);
		passwordtf.setEchoChar('*');
		panel.add(passwordtf);
		login=new JButton("Login");
		login.setLayout(null);
		login.setBounds(100,200,100,30);
		login.addActionListener(this);
		panel.add(login);
		exit=new JButton("Exit");
		exit.setLayout(null);
		exit.setBounds(250,200,100,30);
		exit.addActionListener(this);
		panel.add(exit);
		setSize(400,300);
		setLayout(null);
		setIconImage(new ImageIcon("image/logo.png").getImage());
		setLocation(300,120);
		setResizable(false);
		addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e){dispose(); }});
		panel.add(label1);
		add(panel);
		setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent ea)
		{  
			char []c5=passwordtf.getPassword();
			String p5=String.valueOf(c5);
			
			
			int i=0,i1=0;
			if(ea.getSource()==exit)
			{  dispose(); }
						
			if(ea.getSource()==login)
			{	String s1,s2;
			s1=useridtf.getText();
			s2=p5;
			if((s1.isEmpty())||(s2.isEmpty()))
			{ 
			      JOptionPane.showMessageDialog(this,"ID or Password is Empty","Details",JOptionPane.ERROR_MESSAGE);
			}
		 	else{ 
				if(ea.getSource()==login)
			{
				try
				{	
						Class.forName("oracle.jdbc.driver.OracleDriver");
			                               		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",username,password);
						stm=con.createStatement();
						rs=stm.executeQuery("Select * from login");
							while (rs.next())
							{
								if(useridtf.getText().equals(rs.getString(1))&&p5.equals(rs.getString(2)))
								{
									i=1;
									break;
								}
							}
						if(i==1)
						{
						
							new MainForm();
							dispose();
							i=0;
						}
						else
						{             	
							
						JOptionPane.showMessageDialog(this,"User ID or Password Incorrect ","Details",JOptionPane.ERROR_MESSAGE);
						}
					}
							
					
				
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(this,e,"Details",JOptionPane.ERROR_MESSAGE);
					
				}
			}

				
		 } 
	}
		
		}
public static void main(String []args)
	{    try{
			UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
			}catch(Exception e){ } new Login();   }
}