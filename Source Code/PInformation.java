import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class PInformation extends JFrame implements ActionListener
{
	String username="system";
	String password="system";
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
	JTextField ltf1,ltf2,ltf3,ltf4,ltf5,ltf6,ltf7,ltf8,ltf9,ltf10,ltf11,ltf12,ltf13,ltf14,ltf15;
	JButton submit,clear,update,delete;
	Connection con;
	PreparedStatement stm;
	Statement stm2;
	ResultSet rs2;
	String up;
	public  PInformation()
	{
		super("Patient Information");
		setIconImage(new ImageIcon("image/logo.png").getImage());
		setSize(800,550);
		setLayout(null);
		setLocation(200,70);
		JPanel p=new JPanel();
		p.setLayout(null);
		p.setBounds(0,0,800,550);
		add(p);
		JLabel h1= new JLabel("Patient Information");
		Font font=new Font("Britannic",Font.PLAIN,25);
		h1.setFont(font);
		h1.setBounds(300,20,300,40);
		p.add(h1);
	
		//Details
		l2= new JLabel("Patien ID :");
		l2.setBounds(100,140,200,20);
		ltf2= new JTextField();
		ltf2.setBounds(240,140,150,20);
		p.add(l2);
		p.add(ltf2);

		l3= new JLabel("Name :");
		l3.setBounds(100,180,200,20);
		ltf3= new JTextField();
		ltf3.setBounds(240,180,150,20);
		p.add(l3);
		p.add(ltf3);

		l4= new JLabel("Gender :");
		l4.setBounds(100,220,200,20);
		ltf4= new JTextField();
		ltf4.setBounds(240,220,150,20);
		p.add(l4);
		p.add(ltf4);
		
		l5= new JLabel("Age :");
		l5.setBounds(100,260,200,20);
		ltf5= new JTextField();
		ltf5.setBounds(240,260,150,20);
		p.add(l5);
		p.add(ltf5);
				
		l6= new JLabel("Phone :");
		l6.setBounds(100,300,200,20);
		ltf6= new JTextField();
		ltf6.setBounds(240,300,150,20);
		p.add(l6);
		p.add(ltf6);
		
		l7= new JLabel("Address :");
		l7.setBounds(100,340,200,20);
		ltf7= new JTextField();
		ltf7.setBounds(240,340,150,20);
		p.add(l7);
		p.add(ltf7);
		

		l8= new JLabel("Status of Diease :");
		l8.setBounds(100,380,200,20);
		ltf8= new JTextField();
		ltf8.setBounds(240,380,150,20);
		p.add(l8);
		p.add(ltf8);
		
		JLabel h2= new JLabel("Room Information");
		Font font2=new Font("Britannic",Font.BOLD,15);
		h2.setFont(font2);
		h2.setBounds(530,100,200,40);
		p.add(h2);

		l9= new JLabel("Building :");
		l9.setBounds(500,140,200,20);
		ltf9= new JTextField();
		ltf9.setBounds(600,140,150,20);
		p.add(l9);
		p.add(ltf9);

		l10= new JLabel("Room No :");
		l10.setBounds(500,180,200,20);
		ltf10= new JTextField();
		ltf10.setBounds(600,180,150,20);
		p.add(l10);
		p.add(ltf10);

		l11= new JLabel("Room Type :");
		l11.setBounds(500,220,200,20);
		ltf11= new JTextField();
		ltf11.setBounds(600,220,150,20);
		p.add(l11);
		p.add(ltf11);
		
		l12= new JLabel("Price :");
		l12.setBounds(500,260,200,20);
		ltf12= new JTextField();
		ltf12.setBounds(600,260,150,20);
		p.add(l12);
		p.add(ltf12);
		
		l13= new JLabel("Date  :");
		l13.setBounds(500,300,200,20);
		ltf13= new JTextField();
		ltf13.setBounds(600,300,150,20);
		p.add(l13);
		p.add(ltf13);
				

		update = new JButton("Search",new ImageIcon("image/search.png"));
		update.addActionListener(this);
		update.setBounds(270,440,130,30);
		p.add(update);		
		
		clear = new JButton("Clear",new ImageIcon("image/reset.png"));
		clear.setBounds(440,440,130,30);
		p.add(clear);
		clear.addActionListener( new ActionListener() {   
			public void actionPerformed(ActionEvent e)
				{ 	
				 	ltf2.setText("");
					ltf3.setText("");
					ltf4.setText("");
					ltf5.setText("");
					ltf6.setText("");
					ltf7.setText("");
					ltf8.setText("");
					ltf9.setText("");
					ltf10.setText("");
					ltf11.setText("");
					ltf12.setText("");
					ltf13.setText("");
					}
		});  
				

		
		JLabel im=new JLabel(new ImageIcon("image/m1.jpg"));
		im.setBounds(0,0,850,550);
		p.add(im);
		add(p);
		addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e){ new MainForm();  dispose(); }});
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ea)
			{	
				if(ea.getSource()==update)
				{   	
			 		up=JOptionPane.showInputDialog("Enter Patient ID"); 
				        
					if(!up.isEmpty())
					{
				         try{	
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",username,password);
					stm2=con.createStatement();
					rs2= stm2.executeQuery("SELECT  *  FROM registration WHERE patientid="+up+" ");
					System.out.println("avsk");
						
				while(rs2.next())
					{
						
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
					}	
					}
				catch(Exception p){JOptionPane.showMessageDialog(this,p,"Success",JOptionPane.INFORMATION_MESSAGE);}
					}
					else{}
				}   
			     }


			
/*public static void main(String []args)
	{   new PInformation();  }*/
}
		