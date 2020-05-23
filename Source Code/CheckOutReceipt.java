import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class CheckOutReceipt extends JFrame
{
	String username="system";
	String password="system";
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l19;
	JTextField ltf1,ltf2,ltf3,ltf4,ltf5,ltf6,ltf7,ltf8,ltf9,ltf10,ltf11,ltf12,ltf13,ltf14,ltf15,ltf16,ltf17,ltf19;
	JButton submit,clear,update,delete;
	Connection con;
	PreparedStatement stm;
	Statement stm2;
	ResultSet rs2;
	String up;
	int i;
	Checkbox box1,box2,box3;
	CheckboxGroup group;
	public CheckOutReceipt( String s1, String s2 ,String s3)
	{	
		super("Check out Receipt ");
		up=s1;
		
		
		setIconImage(new ImageIcon("image/logo.png").getImage());
		setSize(880,550);
		setLayout(null);
		setLocation(200,70);
		JPanel p=new JPanel();
		p.setLayout(null);
		p.setBounds(0,0,880,550);
		add(p);
		JLabel h1= new JLabel("Check Out Receipt ");
		Font font=new Font("Britannic",Font.PLAIN,25);
		h1.setFont(font);
		h1.setBounds(300,20,300,40);
		p.add(h1);



		//Details
		l1= new JLabel("Registration ID :");
		l1.setBounds(100,100,200,20);
		ltf1= new JTextField();
		ltf1.setBounds(240,100,150,20);
		p.add(l1);
		p.add(ltf1);

		l2= new JLabel("Receipt No :");
		l2.setBounds(100,140,200,20);
		ltf2= new JTextField();
		ltf2.setBounds(240,140,150,20);
		p.add(l2);
		p.add(ltf2);

		l3= new JLabel("Receipt Date :");
		l3.setBounds(100,180,200,20);
		ltf3= new JTextField();
		ltf3.setBounds(240,180,150,20);
		p.add(l3);
		p.add(ltf3);


		JLabel h2= new JLabel("Test Fees");
		Font font2=new Font("Britannic",Font.BOLD,15);
		h2.setFont(font2);
		h2.setBounds(100,220,200,40);
		p.add(h2);

		l4= new JLabel("Diagnosis Fees :");
		l4.setBounds(100,260,200,20);
		ltf4= new JTextField();
		ltf4.setBounds(240,260,100,20);
		p.add(l4);
		p.add(ltf4);
		
		l5= new JLabel("X-RAY Fess :");
		l5.setBounds(100,300,200,20);
		ltf5= new JTextField();
		ltf5.setBounds(240,300,100,20);
		p.add(l5);
		p.add(ltf5);
				
		l6= new JLabel("E.G.G. Fees :");
		l6.setBounds(100,340,200,20);
		ltf6= new JTextField();
		ltf6.setBounds(240,340,100,20);
		p.add(l6);
		p.add(ltf6);
		
		l9= new JLabel("Lab Test Fees :");
		l9.setBounds(360,260,200,20);
		ltf9= new JTextField();
		ltf9.setBounds(480,260,100,20);
		p.add(l9);
		p.add(ltf9);

		l10= new JLabel("Gastroscopy Fees :");
		l10.setBounds(360,300,200,20);
		ltf10= new JTextField();
		ltf10.setBounds(480,300,100,20);
		p.add(l10);
		p.add(ltf10);
		
		l11= new JLabel("USG Fees :");
		l11.setBounds(360,340,200,20);
		ltf11= new JTextField();
		ltf11.setBounds(480,340,100,20);
		p.add(l11);
		p.add(ltf11);


		l13= new JLabel("Indoor Injection Fees :");
		l13.setBounds(590,260,200,20);
		ltf13= new JTextField();
		ltf13.setBounds(720,260,100,20);
		p.add(l13);
		p.add(ltf13);

		l14= new JLabel("Calonoscopy Fees :");
		l14.setBounds(590,300,200,20);
		ltf14= new JTextField();
		ltf14.setBounds(720,300,100,20);
		p.add(l14);
		p.add(ltf14);

		l15= new JLabel("Total Fees :");
		l15.setBounds(100,380,200,20);
		ltf15= new JTextField();
		ltf15.setBounds(240,380,100,20);
		p.add(l15);
		p.add(ltf15);
		
		l7= new JLabel("Name :");
		l7.setBounds(500,100,200,20);
		ltf7= new JTextField();
		ltf7.setBounds(550,100,100,20);
		p.add(l7);
		p.add(ltf7);

		l19= new JLabel("Check Out Date :");
		l19.setBounds(660,100,150,20);
		ltf19= new JTextField();
		ltf19.setText(s3);
		ltf19.setBounds(750,100,100,20);
		p.add(l19);
		p.add(ltf19);
		

		l8= new JLabel("Age :");
		l8.setBounds(500,140,200,20);
		ltf8= new JTextField();
		ltf8.setBounds(550,140,40,20);
		p.add(l8);
		p.add(ltf8);
		
		

		l12= new JLabel("Gender :");
		l12.setBounds(610,140,60,20);
		ltf12= new JTextField();
		
		ltf12.setBounds(700,145,100,20);
		
		p.add(ltf12);
		p.add(l12);
		
		l16= new JLabel("Time :");
		l16.setBounds(500,180,60,20);
		ltf16= new JTextField();
		ltf16.setText(s2);
		ltf16.setBounds(550,180,100,20);
		p.add(l16);
		p.add(ltf16);
		
		l17= new JLabel("D.O.B :");
		l17.setBounds(670,180,60,20);
		ltf17= new JTextField();
		ltf17.setBounds(750,180,100,20);
		p.add(l17);
		p.add(ltf17);
		
		ltf1.setEditable(false);
		ltf2.setEditable(false);
		ltf3.setEditable(false);
		ltf4.setEditable(false);
		ltf5.setEditable(false);
		ltf6.setEditable(false);
		ltf7.setEditable(false);
		ltf8.setEditable(false);
		ltf9.setEditable(false);
		ltf10.setEditable(false);
		ltf11.setEditable(false);
		ltf12.setEditable(false);
		ltf13.setEditable(false);
		ltf14.setEditable(false);
		ltf15.setEditable(false);
		ltf16.setEditable(false);
		ltf17.setEditable(false);
		ltf19.setEditable(false);
		
		    try{	
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",username,password);
					stm2=con.createStatement();
					rs2= stm2.executeQuery("SELECT  *  FROM receipt WHERE registrationid="+up+" ");
						
				while(rs2.next())
					{
						
					ltf1.setText(rs2.getString(1));
					ltf2.setText(rs2.getString(2));
					ltf3.setText(rs2.getString(3));
					ltf4.setText(rs2.getString(4));
					ltf5.setText(rs2.getString(5));
					ltf6.setText(rs2.getString(6));
					ltf7.setText(rs2.getString(7));
					ltf8.setText(rs2.getString(8));
					ltf9.setText(rs2.getString(9));
					ltf10.setText(rs2.getString(10));
					ltf11.setText(rs2.getString(11));
					ltf12.setText(rs2.getString(12));
					ltf13.setText(rs2.getString(13));
					ltf14.setText(rs2.getString(14));
					ltf15.setText(rs2.getString(15));
					//ltf16.setText(rs2.getString(16));
					ltf17.setText(rs2.getString(17));
				
					}	i=1;	
					}
				catch(Exception pa){}


				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",username,password);
      					String query = "delete from registration where registrationid = ?";
      					PreparedStatement preparedStmt = conn.prepareStatement(query);
      					preparedStmt.setString(1, s1);
      					preparedStmt.execute();
      					conn.close();
								   }
								catch(Exception r){}


					try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",username,password);
      					String query = "delete from receipt where registrationid = ?";
      					PreparedStatement preparedStmt = conn.prepareStatement(query);
      					preparedStmt.setString(1, s1);
      					preparedStmt.execute();
      					conn.close();
				   	}
					catch(Exception r){}
	
		JLabel im=new JLabel(new ImageIcon("image/m1.jpg"));
		im.setBounds(0,0,880,550);
		p.add(im);
		add(p);
		addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e){   dispose(); }});
		setVisible(true);
	}
	
	

	


public static void main(String []args)
	{  // new CheckOutReceipt(); 
		}
}