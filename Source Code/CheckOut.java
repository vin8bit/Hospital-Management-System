import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.time.*;
import java.util.*;
import java.text.*;
public class CheckOut extends JFrame implements ActionListener
{
	String username="system";
	String password="system";
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16;
	JTextField ltf1,ltf2,ltf3,ltf4,ltf5,ltf6,ltf7,ltf8,ltf9,ltf10,ltf11,ltf12,ltf13,ltf14,ltf15,ltf16;
	JButton submit,clear,update,delete;
	Connection con;
	PreparedStatement stm;
	Statement stm2;
	ResultSet rs2;
	String up;
	int i;
	java.time.LocalDateTime now = java.time.LocalDateTime.now();  
	java.time.format.DateTimeFormatter format = java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy");  
        	String is = now.format(format);  
	DateFormat time1 = new SimpleDateFormat("HH:mm:ss");
	Calendar cal = Calendar.getInstance();
	String tim=time1.format(cal.getTime());
	public  CheckOut()
	{
		super("Check Out");
		setIconImage(new ImageIcon("image/logo.png").getImage());
		setSize(800,550);
		setLayout(null);
		setLocation(200,70);
		JPanel p=new JPanel();
		p.setLayout(null);
		p.setBounds(0,0,800,550);
		add(p);
		JLabel h1= new JLabel("Patient CheckOut");
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
		
		

		l9= new JLabel("Date In :");
		l9.setBounds(500,100,200,20);
		ltf9= new JTextField();
		ltf9.setBounds(600,100,150,20);
		p.add(l9);
		p.add(ltf9);

		l10= new JLabel("Date Out :");
		l10.setBounds(500,140,200,20);
		ltf10= new JTextField();
		ltf10.setText(is);
		ltf10.setEditable(false);
		ltf10.setBounds(600,140,150,20);
		p.add(l10);
		p.add(ltf10);
				
		l11= new JLabel("Time :");
		l11.setBounds(500,180,200,20);
		ltf11= new JTextField();
		ltf11.setBounds(600,180,150,20);
		p.add(l11);
		ltf11.setText(tim);
		ltf11.setEditable(false);
		p.add(ltf11);

		ltf1.setEditable(false);
		ltf2.setEditable(false);
		ltf3.setEditable(false);
		ltf4.setEditable(false);
		ltf5.setEditable(false);
		ltf6.setEditable(false);
		ltf7.setEditable(false);
		ltf8.setEditable(false);
		ltf9.setEditable(false);		

		submit = new JButton("Check out",new ImageIcon("image/save.png"));
		submit.addActionListener(this);
		submit.setBounds(200,440,130,30);
		p.add(submit );		

		update = new JButton("Search",new ImageIcon("image/search.png"));
		update.addActionListener(this);
		update.setBounds(370,440,130,30);
		p.add(update);		
		
		clear = new JButton("Clear",new ImageIcon("image/reset.png"));
		clear.setBounds(540,440,130,30);
		clear.addActionListener( new ActionListener() {   
			public void actionPerformed(ActionEvent e)
				{ 	ltf1.setText("");	
				 	ltf2.setText("");
					ltf3.setText("");
					ltf4.setText("");
					ltf5.setText("");
					ltf6.setText("");
					ltf7.setText("");
					ltf8.setText("");
					ltf9.setText("");
					//ltf10.setText("");
					//ltf11.setText("");
					Calendar cal = Calendar.getInstance();
					tim=time1.format(cal.getTime());
					ltf11.setText(tim);
					

					}
		});  
		p.add(clear);		

		
		JLabel im=new JLabel(new ImageIcon("image/m1.jpg"));
		im.setBounds(0,0,850,550);
		p.add(im);
		add(p);
		addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e){ new MainForm();  dispose(); }});
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ea)
			{	String 	s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13;
					s1=ltf1.getText(); s2=ltf2.getText(); s3=ltf3.getText();  s4=ltf4.getText();  s5=ltf5.getText();  s6=ltf6.getText();  s7=ltf7.getText();
					 s8=ltf8.getText();   s9=ltf9.getText(); s10=ltf10.getText(); s11=ltf11.getText();

				if(ea.getSource()==submit)
				{
					if(s1.isEmpty()||s2.isEmpty()||s3.isEmpty()||s4.isEmpty()||s5.isEmpty()||s6.isEmpty()||s7.isEmpty()||s8.isEmpty()||s9.isEmpty()||s10.isEmpty()||s11.isEmpty())
					{    JOptionPane.showMessageDialog(this,"Some Textfields is empty","Error",JOptionPane.ERROR_MESSAGE); }
					
					else
						{
							
					JOptionPane.showMessageDialog(this,"Check out Success","Error",JOptionPane.INFORMATION_MESSAGE);
					CheckOutReceipt    cr=new CheckOutReceipt(s1,s11,s10);
		
					ltf1.setText("");	
				 	ltf2.setText("");
					ltf3.setText("");
					ltf4.setText("");
					ltf5.setText("");
					ltf6.setText("");
					ltf7.setText("");
					ltf8.setText("");
					ltf9.setText("");
					//ltf10.setText("");
					//ltf11.setText("");
					Calendar cal = Calendar.getInstance();
					tim=time1.format(cal.getTime());
					ltf11.setText(tim);
					

										
						
						}


				}
			


				if(ea.getSource()==update)
				{   	
			 		up=JOptionPane.showInputDialog("Enter Registration ID"); 
				        
					if(!up.isEmpty())
					{
				         try{	
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",username,password);
					stm2=con.createStatement();
					rs2= stm2.executeQuery("SELECT  *  FROM registration WHERE registrationid="+up+" ");
					System.out.println("avsk");
						
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
					//ltf9.setText(rs2.getString(9));
					//ltf10.setText(rs2.getString(10));
					//ltf11.setText(rs2.getString(11));
					//ltf12.setText(rs2.getString(12));
					ltf9.setText(rs2.getString(13));
					}	i=1;	
					}
				catch(Exception p){JOptionPane.showMessageDialog(this,p,"Success",JOptionPane.INFORMATION_MESSAGE);}
					}
					else{}   
			     }
			

			}
/*public static void main(String []args)
	{   new CheckOut();  }*/
}
		