import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class AddStaff extends JFrame implements ActionListener ,ItemListener
{
	String username="system";
	String password="system";
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
	JTextField ltf1,ltf2,ltf3,ltf4,ltf5,ltf6,ltf7,ltf8,ltf9,ltf10;
	JButton submit,clear,update,delete;
	Connection con;
	PreparedStatement stm;
	Statement stm2;
	ResultSet rs2;
	String up;
	int i,pass1;
	Checkbox box1,box2,box3;
	CheckboxGroup group;
	Choice choice1,choice2,choice3,choice4,choice5,choice9;
	String d="11",m="11",y="11",rt1="01-01-1990";
	int ph1,ph2,ph3,re1=0,re=0;
	
	
	public AddStaff()
	{
		super("Add New Staff");
		setIconImage(new ImageIcon("image/logo.png").getImage());
		setSize(850,650);
		setLayout(null);
		setLocation(200,70);
		JPanel p=new JPanel();
		p.setLayout(null);
		p.setBounds(0,0,850,650);
		add(p);
		



		JLabel h1= new JLabel("Add New Staff");
		Font font=new Font("Britannic",Font.PLAIN,25);
		h1.setFont(font);
		h1.setBounds(300,20,300,40);
		p.add(h1);
		
		//Details
		l1= new JLabel("ID :");
		l1.setBounds(200,100,200,20);
		ltf1= new JTextField();
		ltf1.setBounds(340,100,150,20);
		try{
		Count1   co= new Count1();
			int au=1+co.call3();
			ltf1.setText(String.valueOf(au));
			}
			catch(Exception c){}
		p.add(l1);
		p.add(ltf1);

		l2= new JLabel("Name :");
		l2.setBounds(200,140,200,20);
		ltf2= new JTextField();
		ltf2.setBounds(340,140,150,20);
		p.add(l2);
		p.add(ltf2);

		l3= new JLabel("Gender :");
		l3.setBounds(200,180,200,20);
		ltf3= new JTextField();
		group= new CheckboxGroup();
		box1 = new Checkbox("Male",false,group);
		box1.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent e)
		{	ltf3.setText(((Checkbox)e.getItemSelectable()).getLabel());
		}
		});
		box1.setBounds(340,180,60,10);
		p.add(box1);
		box2 = new Checkbox("Female",false,group);
		box2.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent e)
		{	ltf3.setText(((Checkbox)e.getItemSelectable()).getLabel());
		}
		});
		box2.setBounds(400,180,60,10);
		p.add(box2);
		box3 = new Checkbox("Other",false,group);
		box3.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent e)
		{	ltf3.setText(((Checkbox)e.getItemSelectable()).getLabel());
		}
		});
		box3.setBounds(470,180,60,10);
		ltf3.setBounds(520,180,60,20);
		ltf3.setEditable(false);
		p.add(ltf3);
		p.add(box3);
		p.add(l3);
		


		l4= new JLabel("Designation :");
		l4.setBounds(200,220,200,20);
		ltf4= new JTextField();
		ltf4.setBounds(520,220,150,20);

		choice9=new  Choice();
		choice9.addItem("");
		choice9.addItem("Doctor");
		choice9.addItem("Manager");
		choice9.addItem("Nurse");
		choice9.addItem("Security Guard");
		choice9.addItem("Other");
		choice9.addItemListener(new ItemListener()
				{
					public void itemStateChanged(ItemEvent v)
					{
						ltf4.setText((String)choice9.getSelectedItem());
					}
				});
		choice9.setBounds(340,220,150,20);		
		ltf4.setEditable(false);
		p.add(choice9);
		p.add(l4);
		p.add(ltf4);
		
		l5= new JLabel("Salary :");
		l5.setBounds(200,260,200,20);
		ltf5= new JTextField();
		ltf5.setBounds(340,260,150,20);
		p.add(l5);
		p.add(ltf5);
		
		l6= new JLabel("Phone :");
		l6.setBounds(200,300,200,20);
		ltf6= new JTextField();
		ltf6.setBounds(340,300,150,20);
		p.add(l6);
		p.add(ltf6);

		l7= new JLabel("Address :");
		l7.setBounds(200,340,200,20);
		ltf7= new JTextField();
		ltf7.setBounds(340,340,150,20);
		p.add(ltf7);
		p.add(l7);
		
		l8= new JLabel("Qualification :");
		l8.setBounds(200,380,200,20);
		ltf8= new JTextField();
		ltf8.setBounds(520,380,150,20);
		ltf8.setEditable(false);
		choice5=new  Choice();
		choice5.addItem("");
		choice5.addItem("B.A");
		choice5.addItem("M.A");
		choice5.addItem("B.com");
		choice5.addItem("M.com");
		choice5.addItem("B.Sc");
		choice5.addItem("M.Sc");
		choice5.addItem("B.Tech");
		choice5.addItem("M.Tech");
		choice5.addItem("10 th");
		choice5.addItem("12 th");
		choice5.addItemListener(new ItemListener()
				{
					public void itemStateChanged(ItemEvent v)
					{
						ltf8.setText((String)choice5.getSelectedItem());
					}
				});
		choice5.setBounds(340,380,150,20);
		p.add(choice5);
		p.add(ltf8);
		p.add(l8);

		l9= new JLabel("D.O.B :");
		l9.setBounds(200,420,100,20);
		ltf9= new JTextField();
		ltf9.setEditable(false);
		ltf9.setText(rt1);
		ltf9.setBounds(520,420,150,20);
		p.add(ltf9);
		p.add(l9);
		
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
		choice1.setBounds(340,420,40,20);
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
		choice2.setBounds(390,420,40,20);
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
		choice3.setBounds(440,420,60,20);
		choice3.addItemListener(this);
		p.add(choice3);



		
		l10= new JLabel("ID Proof :");
		l10.setBounds(200,460,200,20);
		ltf10= new JTextField();
		ltf10.setBounds(520,460,150,20);
		ltf10.setEditable(false);
		choice4=new  Choice();
		choice4.addItem("");
		choice4.addItem("Addhaar card");
		choice4.addItem("Pan card");
		choice4.addItem("Voter ID");
		choice4.addItem("Driving License");
		choice4.addItem("Passport");
		choice4.addItemListener(new ItemListener()
				{
					public void itemStateChanged(ItemEvent v)
					{
						ltf10.setText((String)choice4.getSelectedItem());
					}
				});
		choice4.setBounds(340,460,150,20);
		p.add(choice4);
		p.add(ltf10);
		p.add(l10);
	
	
		update = new JButton("Update",new ImageIcon("image/regis.png"));
		update.addActionListener(this);
		update.setBounds(270,500,130,30);
		p.add(update);		


		clear = new JButton("Clear",new ImageIcon("image/reset.png"));
		clear.setBounds(440,500,130,30);
		p.add(clear);
		clear.addActionListener( new ActionListener() {   
			public void actionPerformed(ActionEvent e)
				{ 	dispose();   new AddStaff();
					ltf1.setText("");	
				 	ltf2.setText("");
					ltf3.setText("");
					ltf4.setText("");
					ltf5.setText("");
					ltf6.setText("");
					ltf7.setText("");
					ltf8.setText("");
					ltf9.setText("");
					ltf10.setText("");
					}
		});  
				
		
		submit = new JButton("Add Staff",new ImageIcon("image/save.png"));
		submit.addActionListener(this);
		submit.setBounds(100,500,130,30);
		p.add(submit);
		
		delete = new JButton("Delete",new ImageIcon("image/cancel.png"));
		delete.addActionListener(this);
		delete.setBounds(610,500,130,30);
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
				ltf9.setText(rt1);
				System.out.println(rt1);
				
			}
		}

	
	
	public void actionPerformed(ActionEvent ea)
	{

	String 	s1,s2,s3,s4,s5,s6,s7,s8,s9,s10;
		ph1=0; ph2=0; ph3=0; re=0;
					s1=ltf1.getText(); s2=ltf2.getText(); s3=ltf3.getText();  s4=ltf4.getText();  s5=ltf5.getText(); s6=ltf6.getText();s7=ltf7.getText(); s8=ltf8.getText(); s9=ltf9.getText();s10=ltf10.getText();
				if(ea.getSource()==submit)
				{
					if(s1.isEmpty()||s2.isEmpty()||s3.isEmpty()||s4.isEmpty()||s5.isEmpty()||s6.isEmpty()||s7.isEmpty()||s8.isEmpty()||s9.isEmpty()||s10.isEmpty())
					{    JOptionPane.showMessageDialog(this,"Some Textfields is empty","Error",JOptionPane.ERROR_MESSAGE); }
					
					else
						{      

						if(i==1)
				{
			 	try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",username,password);
      				String query = "delete from staff where id = ?";
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
						rs2=stm2.executeQuery("Select * from staff");
							while (rs2.next())
							{
								if(s1.equals(rs2.getString(1)))
								{
									re=1; 
									break;
								}
							} 
					}
							catch(Exception e){}

						pass1=0;
					   String i1 = ltf1.getText();
					   String i2=ltf5.getText();
					   String i3 = ltf6.getText();	
					for(int y=0;y<i1.length(); ++y)
					{
						if(!Character.isDigit(i1.charAt(y)))
							{  pass1=7; ph1=1; }
					}
					for(int y1=0;y1<i2.length(); ++y1)
					{
						if(!Character.isDigit(i2.charAt(y1)))
						{  pass1=7; ph2=1; }
					}
					
					for(int y3=0;y3<i3.length(); ++y3)
					{
						 if(i3.length()<=9){ pass1=7; ph3=1; }
						if(!Character.isDigit(i3.charAt(y3)))
						{  pass1=7; ph3=1; }
						if(i3.length()>10)
							{ pass1=7; ph3=1;  }
					}



							

						if(re==0){
						if(pass1==0)
						{	pass1=0;

						   try        { Class.forName("oracle.jdbc.driver.OracleDriver");
							con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",username,password);
							stm =  con.prepareStatement("insert into staff values(?,?,?,?,?,?,?,?,?,?)");
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

							stm.executeUpdate();
							JOptionPane.showMessageDialog(this,"Add Staff Successful","Success",JOptionPane.INFORMATION_MESSAGE);
							dispose();   new AddStaff();
							ltf1.setText("");	
				 			ltf2.setText("");
							ltf3.setText("");
							ltf4.setText("");
							ltf5.setText("");
							ltf6.setText("");
							ltf7.setText("");
							ltf8.setText("");
							ltf9.setText("");
							ltf10.setText("");
							i=0;
							con.close();

							}
						catch(Exception e){JOptionPane.showMessageDialog(this,e,"Success",JOptionPane.INFORMATION_MESSAGE);}						
						   }
						else {   pass1=0; if(ph1==1){JOptionPane.showMessageDialog(this,"Incorrect ID","Error",JOptionPane.ERROR_MESSAGE);}
							if(ph2==1){JOptionPane.showMessageDialog(this,"Incorrect Salary","Error",JOptionPane.ERROR_MESSAGE);}
							if(ph3==1){JOptionPane.showMessageDialog(this,"Incorrect Phone no","Error",JOptionPane.ERROR_MESSAGE);}
							} 
						}else{JOptionPane.showMessageDialog(this,"ID already use","Error",JOptionPane.ERROR_MESSAGE);}
						}


				}


			if(ea.getSource()==update)
				{   	
			 		up=JOptionPane.showInputDialog("Enter ID "); 
				        
					if(!up.isEmpty())
					{
				         try{	
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",username,password);
					stm2=con.createStatement();
					rs2= stm2.executeQuery("SELECT  *  FROM staff WHERE id="+up+" ");
						
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
					}	i=1;	
					}
				catch(Exception p){JOptionPane.showMessageDialog(this,p,"Success",JOptionPane.INFORMATION_MESSAGE);}
					}
					else{}   
			     }

			
				if(ea.getSource()==delete)
				{	re1=0; String ss=JOptionPane.showInputDialog("Enter ID");
					try{
						Class.forName("oracle.jdbc.driver.OracleDriver");
			                               		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",username,password);
						stm2=con.createStatement();
						rs2=stm2.executeQuery("Select * from staff");
							while (rs2.next())
							{
								if(ss.equals(rs2.getString(1)))
								{
									re1=1; 
									break;
								}
							} 
					}
							catch(Exception e){}


				if(!ss.isEmpty())
				{if(re1==1){
			 	try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",username,password);
      				String query = "delete from staff where id = ?";
      				PreparedStatement preparedStmt = conn.prepareStatement(query);
      				preparedStmt.setString(1, ss);
      				preparedStmt.execute();
				JOptionPane.showMessageDialog(this,"Delete Staff Successful","Success",JOptionPane.INFORMATION_MESSAGE);
				dispose();   new AddStaff();
      				conn.close();
				   }
				catch(Exception r){JOptionPane.showMessageDialog(this,r,"Success",JOptionPane.INFORMATION_MESSAGE);}}
				else{JOptionPane.showMessageDialog(this,"Incorrect ID","Error",JOptionPane.ERROR_MESSAGE);}
				}
								
				}


	}




public static void main(String []args)
	{  new AddStaff();  }
}
