import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import java.util.*;


public class PReceipt extends JFrame implements ActionListener  ,ItemListener
{
	String username="system";
	String password="system";
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17;
	JTextField ltf1,ltf2,ltf3,ltf4,ltf5,ltf6,ltf7,ltf8,ltf9,ltf10,ltf11,ltf12,ltf13,ltf14,ltf15,ltf16,ltf17;
	JButton submit,clear,update,delete,search;
	Connection con;
	PreparedStatement stm;
	Statement stm2;
	ResultSet rs2;
	String up;
	int i,pass1;
	Checkbox box1,box2,box3;
	CheckboxGroup group;
	java.time.LocalDateTime now = java.time.LocalDateTime.now();  
	java.time.format.DateTimeFormatter format = java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy");  
        	String is = now.format(format);  
	DateFormat time1 = new SimpleDateFormat("HH:mm:ss");
	Calendar cal = Calendar.getInstance();
	String tim=time1.format(cal.getTime());
	int f1=0,f2=0,f3=0 ,f4=0 ,f5=0, f6=0, f7=0 ,f8=0,sear=0,sear1=0;

	public PReceipt()
	{
		super("Patient Receipt Entry");
		setIconImage(new ImageIcon("image/logo.png").getImage());
		setSize(920,550);
		setLayout(null);
		setLocation(200,70);
		JPanel p=new JPanel();
		p.setLayout(null);
		p.setBounds(0,0,920,550);
		add(p);
		JLabel h1= new JLabel("Patient Receipt Entry");
		Font font=new Font("Britannic",Font.PLAIN,25);
		h1.setFont(font);
		h1.setBounds(300,20,300,40);
		p.add(h1);



		//Details
		l1= new JLabel("Registration ID :");
		l1.setBounds(100,100,200,20);
		ltf1= new JTextField();
		ltf1.setBounds(240,100,150,20);
		ltf1.setEditable(false);
		p.add(l1);
		p.add(ltf1);

		l2= new JLabel("Receipt No :");
		l2.setBounds(100,140,200,20);
		ltf2= new JTextField();
		try{
		Count1   co= new Count1();
			int au1=1+co.call2();
			ltf2.setText(String.valueOf(au1));
			}
			catch(Exception c){}
		ltf2.setBounds(240,140,150,20);
		p.add(l2);
		p.add(ltf2);

		l3= new JLabel("Receipt Date :");
		l3.setBounds(100,180,200,20);
		ltf3= new JTextField();
		ltf3.setBounds(240,180,150,20);
		ltf3.setEditable(false);
		ltf3.setText(is);
		
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
		ltf4.setText("0");
		ltf4.setBounds(240,260,100,20);
		p.add(l4);
		p.add(ltf4);
		
		l5= new JLabel("X-RAY Fees :");
		l5.setBounds(100,300,200,20);
		ltf5= new JTextField();
		ltf5.setText("0");
		ltf5.setBounds(240,300,100,20);
		p.add(l5);
		p.add(ltf5);
				
		l6= new JLabel("E.G.G. Fees :");
		l6.setBounds(100,340,200,20);
		ltf6= new JTextField();
		ltf6.setText("0");
		ltf6.setBounds(240,340,100,20);
		p.add(l6);
		p.add(ltf6);
		
		l9= new JLabel("Lab Test Fees :");
		l9.setBounds(360,260,200,20);
		ltf9= new JTextField();
		ltf9.setText("0");
		ltf9.setBounds(480,260,100,20);
		p.add(l9);
		p.add(ltf9);

		l10= new JLabel("Gastroscopy Fees :");
		l10.setBounds(360,300,200,20);
		ltf10= new JTextField();
		ltf10.setText("0");
		ltf10.setBounds(480,300,100,20);
		p.add(l10);
		p.add(ltf10);
		
		l11= new JLabel("USG Fees :");
		l11.setBounds(360,340,200,20);
		ltf11= new JTextField();
		ltf11.setText("0");
		ltf11.setBounds(480,340,100,20);
		p.add(l11);
		p.add(ltf11);


		l13= new JLabel("Indoor Injection Fees :");
		l13.setBounds(590,260,200,20);
		ltf13= new JTextField();
		ltf13.setText("0");
		ltf13.setBounds(720,260,100,20);
		p.add(l13);
		p.add(ltf13);

		l14= new JLabel("Calonoscopy Fees :");
		l14.setBounds(590,300,200,20);
		ltf14= new JTextField();
		ltf14.setText("0");
		ltf14.setBounds(720,300,100,20);
		p.add(l14);
		p.add(ltf14);

		l15= new JLabel("Total Fees :");
		
		l15.setBounds(100,380,200,20);
		ltf15= new JTextField();
		ltf15.setText("0");
		ltf15.setBounds(240,380,100,20);
		//p.add(l15);
		//p.add(ltf15);
		
		l7= new JLabel("Name :");
		l7.setBounds(500,100,200,20);
		ltf7= new JTextField();
		ltf7.setBounds(550,100,100,20);
		p.add(l7);
		ltf7.setEditable(false);
		p.add(ltf7);
		

		l8= new JLabel("Age :");
		l8.setBounds(500,140,200,20);
		ltf8= new JTextField();
		ltf8.setBounds(550,140,40,20);
		ltf8.setEditable(false);
		p.add(l8);
		p.add(ltf8);
		
		

		l12= new JLabel("Gender :");
		l12.setBounds(610,140,60,20);
		ltf12= new JTextField();
		ltf12.setBounds(700,145,150,20);
		p.add(ltf12);
		ltf12.setEditable(false);
		p.add(l12);
		
		l16= new JLabel("Time :");
		l16.setBounds(500,180,60,20);
		ltf16= new JTextField();
		ltf16.setText(tim);
		ltf16.setEditable(false);
		ltf16.setBounds(550,180,100,20);
		p.add(l16);
		
		p.add(ltf16);
		
		l17= new JLabel("D.O.B :");
		l17.setBounds(670,180,60,20);
		ltf17= new JTextField();
		ltf17.setBounds(750,180,100,20);
		ltf17.setEditable(false);
		p.add(l17);
		p.add(ltf17);


		
		update = new JButton("Update",new ImageIcon("image/regis.png"));
		update.addActionListener(this);
		update.setBounds(270,440,130,30);
		p.add(update);		


		clear = new JButton("Clear",new ImageIcon("image/reset.png"));
		clear.setBounds(440,440,130,30);
		clear.addActionListener( new ActionListener() {   
			public void actionPerformed(ActionEvent e)
				{ 	ltf1.setText("");	
				 	//ltf2.setText("");
					//ltf3.setText("");
					try{
				Count1   co= new Count1();
					int au1=1+co.call2();
					ltf2.setText(String.valueOf(au1));
					}
					catch(Exception c){}
					ltf4.setText("0");
					ltf5.setText("0");
					ltf6.setText("0");
					ltf9.setText("0");
					ltf10.setText("0");
					ltf11.setText("0");
					ltf13.setText("0");
					ltf14.setText("0");
					ltf7.setText("");
					ltf8.setText("");
					
					ltf12.setText("");
					
					ltf17.setText("");
					Calendar cal = Calendar.getInstance();
					tim=time1.format(cal.getTime());
					ltf16.setText(tim);

					}
		});  
		p.add(clear);		
		
		submit = new JButton("Submit",new ImageIcon("image/save.png"));
		submit.addActionListener(this);
		submit.setBounds(100,440,130,30);
		p.add(submit);
		
		delete = new JButton("Delete",new ImageIcon("image/cancel.png"));
		delete.addActionListener(this);
		delete.setBounds(610,440,130,30);
		p.add(delete);
		search = new JButton("Search",new ImageIcon("image/search.png"));
		search.addActionListener(this);
		search.setBounds(750,440,130,30);
		p.add(search);
		JLabel getlabel = new JLabel("First step search registration then submit");
		getlabel.setForeground(Color.red);
		getlabel.setBounds(600,480,250,30);
		p.add(getlabel);	

		JLabel im=new JLabel(new ImageIcon("image/m1.jpg"));
		im.setBounds(0,0,920,550);
		p.add(im);
		add(p);
		addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e){ new MainForm();  dispose(); }});
		setVisible(true);
	}
	
	public void itemStateChanged(ItemEvent e)
	{	ltf12.setText(((Checkbox)e.getItemSelectable()).getLabel());
	}

	public void actionPerformed(ActionEvent ea)
	{

	String 	s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17;
	s4="0"; s5="0"; s6="0"; s9="0"; s10="0"; s11="0"; s13="0"; s14="0";		
					s1=ltf1.getText(); s2=ltf2.getText(); s3=ltf3.getText();  s4=ltf4.getText();  s5=ltf5.getText();  s6=ltf6.getText();  s7=ltf7.getText();
					 s8=ltf8.getText();  s9=ltf9.getText();  s10=ltf10.getText();  s11=ltf11.getText();  s12=ltf12.getText();  s13=ltf13.getText();
					 s14=ltf14.getText();  s15=ltf15.getText();  s16=ltf16.getText();  s17=ltf17.getText();
					
				if(ea.getSource()==submit)
				{	
					



					if(s1.isEmpty()||s2.isEmpty()||s3.isEmpty()||s7.isEmpty()||s8.isEmpty()||s12.isEmpty()||s15.isEmpty()||s16.isEmpty()||s17.isEmpty())
					{    JOptionPane.showMessageDialog(this,"Some Textfields is empty","Error",JOptionPane.ERROR_MESSAGE); }
					
					else
						{      

						pass1=0;
					   String i1 = ltf1.getText();
					   String i2=ltf2.getText();
					   String i3 = ltf4.getText();
					   String i4=ltf5.getText();
					   String i5 = ltf6.getText();
					   String i6=ltf9.getText();
					   String i7 = ltf10.getText();
					   String i8=ltf11.getText();
					   String i9 = ltf13.getText();
					   String i10=ltf14.getText();
					   String i11 = ltf15.getText();
					   String i12=ltf8.getText();	
					for(int y=0;y<i1.length(); ++y)
					{
						if(!Character.isDigit(i1.charAt(y)))
							{  pass1=7;  }
					}
					for(int y1=0;y1<i2.length(); ++y1)
					{
						if(!Character.isDigit(i2.charAt(y1)))
						{  pass1=7;  }
					}
					for(int y3=0;y3<i3.length(); ++y3)
					{
						if(!Character.isDigit(i3.charAt(y3)))
							{  pass1=7;  }
					}
					for(int y4=0;y4<i4.length(); ++y4)
					{
						if(!Character.isDigit(i4.charAt(y4)))
						{  pass1=7;  }
						if(y4==10)
							{ pass1=7;   }
					}
					for(int y5=0;y5<i5.length(); ++y5)
					{
						if(!Character.isDigit(i5.charAt(y5)))
							{  pass1=7;  }
					}
					for(int y5=0;y5<i5.length(); ++y5)
					{
						if(!Character.isDigit(i5.charAt(y5)))
						{  pass1=7;  }
					}
					for(int y6=0;y6<i6.length(); ++y6)
					{
						if(!Character.isDigit(i6.charAt(y6)))
							{  pass1=7;  }
					}
					for(int y7=0;y7<i7.length(); ++y7)
					{
						if(!Character.isDigit(i7.charAt(y7)))
						{  pass1=7;  }
					}
					for(int y8=0;y8<i8.length(); ++y8)
					{
						if(!Character.isDigit(i8.charAt(y8)))
						{  pass1=7;  }
					}
					for(int y9=0;y9<i9.length(); ++y9)
					{
						if(!Character.isDigit(i9.charAt(y9)))
						{  pass1=7;  }
					}
					for(int y10=0;y10<i10.length(); ++y10)
					{
						if(!Character.isDigit(i10.charAt(y10)))
							{  pass1=7;  }
					}
					for(int y11=0;y11<i11.length(); ++y11)
					{
						if(!Character.isDigit(i11.charAt(y11)))
						{  pass1=7;  }
					}
					for(int y12=0;y12<i12.length(); ++y12)
					{
						if(!Character.isDigit(i12.charAt(y12)))
						{  pass1=7;  }
					}








							if(i==1)
				{
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
				}


						if(pass1==0)
						{
							 f1=Integer.parseInt(s4);
					 f2=Integer.parseInt(s5);
					 f3=Integer.parseInt(s6);
					 f4=Integer.parseInt(s9);
					 f5=Integer.parseInt(s10);
					 f6=Integer.parseInt(s11);
					 f7=Integer.parseInt(s13);
					 f8=Integer.parseInt(s14);


					int tot=f1+f2+f3+f4+f5+f6+f7+f8;
					System.out.println(tot);
					String to=String.valueOf(tot);
					ltf15.setText(to);
							pass1=0;

						   try        { Class.forName("oracle.jdbc.driver.OracleDriver");
							con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",username,password);
							stm =  con.prepareStatement("insert into receipt values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			                			stm.setString(1,ltf1.getText());
							stm.setString(2,ltf2.getText());
							stm.setString(3,ltf3.getText());	
							stm.setString(4,ltf4.getText());
							stm.setString(5,ltf5.getText());
							stm.setString(6,ltf6.getText());
							stm.setString(7,ltf7.getText());
							stm.setString(8,ltf8.getText());	
							stm.setString(9,ltf9.getText());
							stm.setString(10,ltf10.getText());
							stm.setString(11,ltf11.getText());
							stm.setString(12,ltf12.getText());
							stm.setString(13,ltf13.getText());
							stm.setString(14,ltf14.getText());
							stm.setString(15,ltf15.getText());
							stm.setString(16,ltf16.getText());
							stm.setString(17,ltf17.getText());
							stm.executeUpdate();
							JOptionPane.showMessageDialog(this,"Submit Successful","Success",JOptionPane.INFORMATION_MESSAGE);
							try{
						Count1   co= new Count1();
							int au1=1+co.call2();
							ltf2.setText(String.valueOf(au1));
							}catch(Exception c){}
							ltf1.setText("");	
							ltf7.setText("");
							ltf8.setText("");
							ltf12.setText("");
							ltf4.setText("0");
					ltf5.setText("0");
					ltf6.setText("0");
					ltf9.setText("0");
					ltf10.setText("0");
					ltf11.setText("0");
					ltf13.setText("0");
					ltf14.setText("0");
							
							Calendar cal = Calendar.getInstance();
							tim=time1.format(cal.getTime());
							ltf16.setText(tim);
							ltf17.setText("");
							i=0;
							con.close();

							}
						catch(Exception e){JOptionPane.showMessageDialog(this,e,"Success",JOptionPane.INFORMATION_MESSAGE);}						
							}
						else{    pass1=0;  JOptionPane.showMessageDialog(this,"Number input error","Success",JOptionPane.ERROR_MESSAGE); }
						}


				}

				if(ea.getSource()==update)
				{   	
			 		up=JOptionPane.showInputDialog(this,"Enter Registration ID"); 
				        
					if(!up.isEmpty())
					{
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
					ltf16.setText(rs2.getString(16));
					ltf17.setText(rs2.getString(17));
				
					}	i=1;	con.close();
					}
				catch(Exception p){JOptionPane.showMessageDialog(this,p,"Success",JOptionPane.INFORMATION_MESSAGE);}
					}
					else{}   
			     }



			if(ea.getSource()==delete)
				{	String ss=JOptionPane.showInputDialog(this,"Enter Registration ID");
					sear1=0;
					try{
						Class.forName("oracle.jdbc.driver.OracleDriver");
			                               		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",username,password);
						stm2=con.createStatement();
						rs2=stm2.executeQuery("Select * from receipt");
							while (rs2.next())
							{
								if(ss.equals(rs2.getString(1)))
								{
									sear1=1; 
									break;
								}
							} 
					}
							catch(Exception e){}


				if(!ss.isEmpty())
				{
					if(sear1==1){
			 	try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",username,password);
      				String query = "delete from receipt where registrationid = ?";
      				PreparedStatement preparedStmt = conn.prepareStatement(query);
      				preparedStmt.setString(1, ss);
      				preparedStmt.execute();
				JOptionPane.showMessageDialog(this,"Delete Receipt Successful","Success",JOptionPane.INFORMATION_MESSAGE);
				ltf1.setText("");	
				 	//ltf2.setText("");
					//ltf3.setText("");
					try{
				Count1   co= new Count1();
					int au1=1+co.call2();
					ltf2.setText(String.valueOf(au1));
					}
					catch(Exception c){}
					
					
					ltf7.setText("");
					ltf8.setText("");
					ltf12.setText("");
					Calendar cal = Calendar.getInstance();
					tim=time1.format(cal.getTime());
					ltf16.setText(tim);
					ltf17.setText("");

      				conn.close();
				   }
				catch(Exception r){JOptionPane.showMessageDialog(this,r,"Success",JOptionPane.INFORMATION_MESSAGE);}
				}else{JOptionPane.showMessageDialog(this,"Incorrect  ID ","Error",JOptionPane.ERROR_MESSAGE);} }
								
				}

			
				if(ea.getSource()==search)
				{   	sear=0;
			 		up=JOptionPane.showInputDialog(this,"Enter Registration ID"); 
					try{
						Class.forName("oracle.jdbc.driver.OracleDriver");
			                               		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",username,password);
						stm2=con.createStatement();
						rs2=stm2.executeQuery("Select * from receipt");
							while (rs2.next())
							{
								if(up.equals(rs2.getString(1)))
								{
									sear=1; 
									break;
								}
							} 
					}
							catch(Exception e){}
				        
					if(!up.isEmpty())
					{ if(sear==0){
				         try{	
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",username,password);
					stm2=con.createStatement();
					rs2= stm2.executeQuery("SELECT  *  FROM registration WHERE registrationid="+up+" ");
						
				while(rs2.next())
					{
						
					ltf1.setText(rs2.getString(1));
					ltf7.setText(rs2.getString(3));
					ltf12.setText(rs2.getString(4));
					ltf8.setText(rs2.getString(5));
					ltf17.setText(rs2.getString(14));
				
					}	i=1;	con.close();
					} 
				catch(Exception p){JOptionPane.showMessageDialog(this,p,"Success",JOptionPane.INFORMATION_MESSAGE);}
					} else{JOptionPane.showMessageDialog(this,"This id already fill receipt","Error",JOptionPane.ERROR_MESSAGE);}}
					else{}   
			     }


	}

/*public static void main(String []args)
	{   new PReceipt(); }*/
}