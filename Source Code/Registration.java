import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Registration extends JFrame implements ActionListener ,ItemListener
{
	String username="system";
	String password="system";
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16;
	JTextField ltf1,ltf2,ltf3,ltf4,ltf5,ltf6,ltf7,ltf8,ltf9,ltf10,ltf11,ltf12,ltf13,ltf14,ltf15,ltf16;
	JButton submit,clear,update,delete,room;
	Connection con;
	PreparedStatement stm;
	Statement stm2;
	ResultSet rs2 ;
	String up;
	int i,pass1,ph=0;
	Checkbox box1,box2,box3;
	CheckboxGroup group;
	java.time.LocalDateTime now = java.time.LocalDateTime.now();  
	java.time.format.DateTimeFormatter format = java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy");  
        	String is = now.format(format);  
	String d="11",m="11",y="11",rt1="01-01-1990";
	int  rm=0,rm1=0,de=0,regi;
	
	
	Choice choice1,choice2,choice3,choice1r,choice2r,choice3r;
	public  Registration()
	{
		super("Patient Registration");
		setIconImage(new ImageIcon("image/logo.png").getImage());
		setSize(800,580);
		setLayout(null);
		setLocation(200,70);
		JPanel p=new JPanel();
		p.setLayout(null);
		p.setBounds(0,0,800,650);
		add(p);
		JLabel h1= new JLabel("Patient Registration");
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
		
		try{
		Count1   co= new Count1();
			int au=201+co.call();
			ltf1.setText(String.valueOf(au));
			int au1=101+co.call();
			ltf2.setText(String.valueOf(au1));
			}
			catch(Exception c){}

		l3= new JLabel("Name :");
		l3.setBounds(100,180,200,20);
		ltf3= new JTextField();
		ltf3.setBounds(240,180,150,20);
		p.add(l3);
		p.add(ltf3);

		l4= new JLabel("Gender :");
		l4.setBounds(100,220,200,20);
		ltf4= new JTextField();
		ltf4.setBounds(420,220,60,20);
		group= new CheckboxGroup();
		box1 = new Checkbox("Male",false,group);
		box1.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e)
	{	ltf4.setText(((Checkbox)e.getItemSelectable()).getLabel());
	} });
		box1.setBounds(240,220,60,10);
		p.add(box1);
		box2 = new Checkbox("Female",false,group);
		box2.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e)
	{	ltf4.setText(((Checkbox)e.getItemSelectable()).getLabel());
	} });
		box2.setBounds(300,220,60,10);
		p.add(box2);
		box3 = new Checkbox("Other",false,group);
		box3.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e)
	{	ltf4.setText(((Checkbox)e.getItemSelectable()).getLabel());
	} });
		box3.setBounds(360,220,55,10);
		p.add(box3);
		p.add(l4);
		
		ltf4.setEditable(false);
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
	
		ltf10.setEditable(false);
		ltf9.setEditable(false);
		ltf11.setEditable(false);
		ltf12.setEditable(false);

		l13= new JLabel("Date  :");
		l13.setBounds(500,300,200,20);
		ltf13= new JTextField();
		ltf13.setBounds(600,300,150,20);
		ltf13.setText(is);
		JLabel date=new JLabel("DD-MM-YYYY");
		date.setBounds(600,320,150,20);
		p.add(date);
		ltf13.setEditable(false);
		p.add(l13);
		p.add(ltf13);
		
		l14= new JLabel("D.O.B  :");
		l14.setBounds(500,360,100,20);
		ltf14= new JTextField();
		ltf14.setBounds(600,400,150,20);
		ltf14.setText(rt1);
		
		ltf14.setEditable(false);
		p.add(l14);
		p.add(ltf14);
		
		choice1= new Choice();
		choice1.addItem("01");
		choice1.addItem("02");
		choice1.addItem("03");
		choice1.addItem("04");
		choice1.addItem("05");
		choice1.addItem("06");
		choice1.addItem("07");
		choice1.addItem("08");
		choice1.addItem("09");
		choice1.addItem("10");
		choice1.addItem("11");
		choice1.addItem("12");
		choice1.addItem("13");
		choice1.addItem("14");
		choice1.addItem("15");
		choice1.addItem("16");
		choice1.addItem("17");
		choice1.addItem("18");
		choice1.addItem("19");
		choice1.addItem("20");
		choice1.addItem("21");
		choice1.addItem("22");
		choice1.addItem("23");
		choice1.addItem("24");
		choice1.addItem("25");
		choice1.addItem("26");
		choice1.addItem("27");
		choice1.addItem("28");
		choice1.addItem("29");
		choice1.addItem("30");
		choice1.addItem("31");
		choice1.setBounds(600,360,40,20);
		choice1.addItemListener(this);
		p.add(choice1);

		choice2= new Choice();
		choice2.addItem("01");
		choice2.addItem("02");
		choice2.addItem("03");
		choice2.addItem("04");
		choice2.addItem("05");
		choice2.addItem("06");
		choice2.addItem("07");
		choice2.addItem("08");
		choice2.addItem("09");
		choice2.addItem("10");
		choice2.addItem("11");
		choice2.addItem("12");
		choice2.setBounds(650,360,40,20);
		choice2.addItemListener(this);
		p.add(choice2);
		
		choice3= new Choice();
		choice3.addItem("1990");
		choice3.addItem("1991");
		choice3.addItem("1992");
		choice3.addItem("1993");
		choice3.addItem("1994");
		choice3.addItem("1995");
		choice3.addItem("1996");
		choice3.addItem("1997");
		choice3.addItem("1998");
		choice3.addItem("1999");
		choice3.addItem("2000");
		choice3.addItem("2001");
		choice3.addItem("2002");
		choice3.addItem("2003");
		choice3.addItem("2004");
		choice3.addItem("2005");
		choice3.addItem("2006");
		choice3.addItem("2007");
		choice3.addItem("2009");
		choice3.addItem("2010");
		choice3.addItem("2012");
		choice3.addItem("2013");
		choice3.addItem("2014");
		choice3.addItem("2015");
		choice3.addItem("2016");
		choice3.addItem("2017");
		choice3.addItem("2018");
		choice3.setBounds(700,360,60,20);
		choice3.addItemListener(this);
		p.add(choice3);


		









		
		submit = new JButton("Submit",new ImageIcon("image/save.png"));
		submit.addActionListener(this);
		submit.setBounds(100,440,130,30);
		p.add(submit);	

		room = new JButton("Get Room",new ImageIcon("image/reset.png"));
		room.addActionListener(this);
		room.setBounds(350,480,130,30);
		p.add(room);	
		JLabel getlabel = new JLabel("Room information details get here");
		getlabel.setForeground(Color.red);
		getlabel.setBounds(150,480,250,30);
		p.add(getlabel);	
		
		update = new JButton("Update",new ImageIcon("image/regis.png"));
		update.addActionListener(this);
		update.setBounds(270,440,130,30);
		p.add(update);		
		
		clear = new JButton("Clear",new ImageIcon("image/reset.png"));
		clear.setBounds(440,440,130,30);
		clear.addActionListener( new ActionListener() {   
			public void actionPerformed(ActionEvent e)
				{ 	//ltf1.setText("");	
				 	//ltf2.setText("");
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
					//ltf13.setText("");
					dispose(); new Registration();

					}
		});  
		p.add(clear);		

		delete = new JButton("Delete",new ImageIcon("image/cancel.png"));
		delete.addActionListener(this);
		delete.setBounds(610,440,130,30);
		p.add(delete);
		JLabel im=new JLabel(new ImageIcon("image/m1.jpg"));
		im.setBounds(0,0,850,550);
		p.add(im);
		add(p);
		addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e){ new MainForm();  dispose(); }});
		setVisible(true);
	}

	
	public void itemStateChanged(ItemEvent e)
		{
			if(e.getStateChange()== ItemEvent.SELECTED)
			{ 	d=(String)choice1.getSelectedItem();
				m=(String)choice2.getSelectedItem();
				y=(String)choice3.getSelectedItem();
				rt1=d+"- "+m+"- "+y;
				ltf14.setText(rt1);
				System.out.println(rt1);
				
			}
		}

	

	public void actionPerformed(ActionEvent ea)
			{	String 	s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13;
					s1=ltf1.getText(); s2=ltf2.getText(); s3=ltf3.getText();  s4=ltf4.getText();  s5=ltf5.getText();  s6=ltf6.getText();  s7=ltf7.getText();
					 s8=ltf8.getText();  s9=ltf9.getText();  s10=ltf10.getText();  s11=ltf11.getText();  s12=ltf12.getText(); s13=ltf13.getText();
					ph=0;
				if(ea.getSource()==submit)
				{	regi=0;
					if(s1.isEmpty()||s2.isEmpty()||s3.isEmpty()||s4.isEmpty()||s5.isEmpty()||s6.isEmpty()||s7.isEmpty()||s8.isEmpty()||s9.isEmpty()||s10.isEmpty()||s11.isEmpty()||s12.isEmpty()||s13.isEmpty())
					{    JOptionPane.showMessageDialog(this,"Some Textfields is empty","Error",JOptionPane.ERROR_MESSAGE); }
					
					else
						{	
							if(i==1)
							{
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
							} 
							
							try{
						Class.forName("oracle.jdbc.driver.OracleDriver");
			                               		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",username,password);
						stm2=con.createStatement();
						rs2=stm2.executeQuery("Select * from registration");
							while (rs2.next())
							{
								if(s1.equals(rs2.getString(1)))
								{
									regi=1; 
									break;
								}
							} 
					}
							catch(Exception e){}
			

							pass1=0;
					   String i1 = ltf1.getText();
					   String i2=ltf2.getText();
					   String i3 = ltf5.getText();
					   String i4=ltf6.getText();
					   String i6=ltf9.getText();
					   String i7 = ltf10.getText();
					   String i8=ltf12.getText();	
					for(int y=0;y<i1.length(); ++y)
					{
						if(!Character.isDigit(i1.charAt(y)))
							{  pass1=7; ph=2;  }
					}
					for(int y1=0;y1<i2.length(); ++y1)
					{
						if(!Character.isDigit(i2.charAt(y1)))
						{  pass1=7; ph=3;   }
					}
					for(int y3=0;y3<i3.length(); ++y3)
					{
						if(!Character.isDigit(i3.charAt(y3)))
							{  pass1=7; ph=4;  }
					}
					for(int y4=0;y4<i4.length(); ++y4)
					{	
						 if(i4.length()<=9){ pass1=7; ph=1; }
						if(!Character.isDigit(i4.charAt(y4)))
						{  pass1=7; ph=1; }
						
						if(i4.length()>10)
							{ pass1=7; ph=1;  }
					}
					
					
					for(int y6=0;y6<i6.length(); ++y6)
					{
						if(!Character.isDigit(i6.charAt(y6)))
							{  pass1=7; ph=5;   }
					}
					for(int y7=0;y7<i7.length(); ++y7)
					{
						if(!Character.isDigit(i7.charAt(y7)))
						{  pass1=7; ph=6; }
					}
					for(int y8=0;y8<i8.length(); ++y8)
					{
						if(!Character.isDigit(i8.charAt(y8)))
						{  pass1=7; ph=7;  }
					}



						if(regi==0){
						if(pass1==0)
						{  pass1=0;

						   try        { Class.forName("oracle.jdbc.driver.OracleDriver");
							con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",username,password);
							stm =  con.prepareStatement("insert into registration values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
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
							stm.executeUpdate();
							JOptionPane.showMessageDialog(this,"Submit Successful","Success",JOptionPane.INFORMATION_MESSAGE);
							dispose(); new Registration();
							try{
							Count1   co= new Count1();
							int au=201+co.call();
							ltf1.setText(String.valueOf(au));
							int au1=101+co.call();
							ltf2.setText(String.valueOf(au1));
							}
							catch(Exception c){}
							//ltf1.setText("");	
				 			//ltf2.setText("");
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
							i=0;
							con.close();
							}
						catch(Exception e){JOptionPane.showMessageDialog(this,e,"Success",JOptionPane.INFORMATION_MESSAGE);}
							}
							else{pass1=0;  if(ph==1){ pass1=7; JOptionPane.showMessageDialog(this,"Incorrect Phone no","Error",JOptionPane.ERROR_MESSAGE);}
							if(ph==2){JOptionPane.showMessageDialog(this,"Incorrect Registration id","Error",JOptionPane.ERROR_MESSAGE);} 
							if(ph==3){JOptionPane.showMessageDialog(this,"Incorrect Pation id","Error",JOptionPane.ERROR_MESSAGE);}				
							if(ph==4){JOptionPane.showMessageDialog(this,"Incorrect Age","Error",JOptionPane.ERROR_MESSAGE);} 
							if(ph==5){  JOptionPane.showMessageDialog(this,"Incorrect Building no","Error",JOptionPane.ERROR_MESSAGE);}			
							if(ph==6){ JOptionPane.showMessageDialog(this,"Incorrect Room no","Error",JOptionPane.ERROR_MESSAGE);}
 							if(ph==7){ JOptionPane.showMessageDialog(this,"Incorrect Price","Error",JOptionPane.ERROR_MESSAGE);}} 
							}else{JOptionPane.showMessageDialog(this,"Registraton id already use","Error",JOptionPane.ERROR_MESSAGE);}
												
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
					ltf9.setText(rs2.getString(9));
					ltf10.setText(rs2.getString(10));
					ltf11.setText(rs2.getString(11));
					ltf12.setText(rs2.getString(12));
					ltf13.setText(rs2.getString(13));
					ltf14.setText(rs2.getString(14));
					}	i=1;	
					}
				catch(Exception p){JOptionPane.showMessageDialog(this,p,"Success",JOptionPane.INFORMATION_MESSAGE);}
					}
					else{}   
			     }
			if(ea.getSource()==delete)
				{	String ss=JOptionPane.showInputDialog(this,"Enter Registration ID");
					de=0;

					


				if(!ss.isEmpty())
				{
					try{
						Class.forName("oracle.jdbc.driver.OracleDriver");
			                               		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",username,password);
						stm2=con.createStatement();
						rs2=stm2.executeQuery("Select * from registration");
							while (rs2.next())
							{
								if(ss.equals(rs2.getString(1)))
								{
									de=1; 
									break;
								}
							} 
					}
							catch(Exception e){}
					if(de==1){	
			 	try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",username,password);
      				String query = "delete from registration where registrationid = ?";
      				PreparedStatement preparedStmt = conn.prepareStatement(query);
      				preparedStmt.setString(1, ss);
      				preparedStmt.execute();
				JOptionPane.showMessageDialog(this,"Delete Registation Successful","Success",JOptionPane.INFORMATION_MESSAGE);
				dispose(); new Registration();
      				conn.close();
				   }
				catch(Exception r){JOptionPane.showMessageDialog(this,r,"Success",JOptionPane.INFORMATION_MESSAGE);}
					}else{JOptionPane.showMessageDialog(this,"Incorrect Registraton id ","Error",JOptionPane.ERROR_MESSAGE);}	
				}else{JOptionPane.showMessageDialog(this,"Text field is empty","Error",JOptionPane.ERROR_MESSAGE);}
			
								
				}


			if(ea.getSource()==room)
				{   	rm=0;
					rm1=0;
					up="";
			 		up=JOptionPane.showInputDialog(this,"Enter Room No");
						
						try{
						Class.forName("oracle.jdbc.driver.OracleDriver");
			                               		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",username,password);
						stm2=con.createStatement();
						rs2=stm2.executeQuery("Select * from room");
							while (rs2.next())
							{
								if(up.equals(rs2.getString(1)))
								{
									rm=1; 
									break;
								}
							} 
							}
							catch(Exception e){}
							
				
						if(!up.isEmpty())
					{
						try{
						Class.forName("oracle.jdbc.driver.OracleDriver");
			                               		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",username,password);
						stm2=con.createStatement();
						rs2=stm2.executeQuery("Select * from registration");
							while (rs2.next())
							{
								if(up.equals(rs2.getString(10)))
								{
									rm1=1;	
								}
							} 
							}
							catch(Exception e){}
						
				if(rm==1)
				{        
				if(rm1==0){	
					
				         try{	
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",username,password);
					stm2=con.createStatement();
					rs2= stm2.executeQuery("SELECT  *  FROM room WHERE roomno="+up+" ");
					
						
				while(rs2.next())
					{
						
					ltf10.setText(rs2.getString(1));
					ltf9.setText(rs2.getString(2));
					ltf11.setText(rs2.getString(3));
					ltf12.setText(rs2.getString(4));
					}		
					}
				catch(Exception p){JOptionPane.showMessageDialog(this,p,"Success",JOptionPane.INFORMATION_MESSAGE);}
					
					
					}   
					else{JOptionPane.showMessageDialog(this,"Room not Available","Error",JOptionPane.ERROR_MESSAGE);}
					} else{JOptionPane.showMessageDialog(this,"Incorrect Room no","Error",JOptionPane.ERROR_MESSAGE);}
			     		}
					else{ JOptionPane.showMessageDialog(this,"Text field is empty","Error",JOptionPane.ERROR_MESSAGE);}
				}

			}
/*public static void main(String []args)
	{   new Registration();  }*/
}
		