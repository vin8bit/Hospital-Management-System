import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import java.util.*;
public class AddRoom extends JFrame implements ActionListener
{
	String username="system";
	String password="1234";
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JTextField ltf1,ltf2,ltf3,ltf4,ltf5,ltf6,ltf7,ltf8;
	JButton submit,clear,update,delete;
	Connection con;
	PreparedStatement stm;
	Statement stm2;
	ResultSet rs2;
	String up;
	int i;
	int pass1;
	java.time.LocalDateTime now = java.time.LocalDateTime.now();  
	java.time.format.DateTimeFormatter format = java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy");  
        	String is = now.format(format);  
	DateFormat time1 = new SimpleDateFormat("HH:mm:ss");
	Calendar cal = Calendar.getInstance();
	String tim=time1.format(cal.getTime());
	int re=0,re1=0,ph1,ph2,ph3,ph4;
	
	public AddRoom()
	{
		super("Add New Room");
		setIconImage(new ImageIcon("image/logo.png").getImage());
		setSize(850,500);
		setLayout(null);
		//setContentPane(new JLabel(new ImageIcon("image/m.jpg")));
		setLocation(200,70);
		JPanel p=new JPanel();
		p.setLayout(null);
		p.setBounds(0,0,850,500);
		
		add(p);
		JLabel h1= new JLabel("Add New Room");
		Font font=new Font("Britannic",Font.PLAIN,25);
		h1.setFont(font);
		h1.setBounds(300,20,300,40);
		p.add(h1);
		
		//Details
		l1= new JLabel("Room No :");
		l1.setBounds(200,100,200,20);
		ltf1= new JTextField();
		ltf1.setBounds(340,100,150,20);
		p.add(l1);
		p.add(ltf1);

		l2= new JLabel("Building No :");
		l2.setBounds(200,140,200,20);
		ltf2= new JTextField();
		ltf2.setBounds(340,140,150,20);
		p.add(l2);
		p.add(ltf2);

		l3= new JLabel("Room Type :");
		l3.setBounds(200,180,200,20);
		ltf3= new JTextField();
		ltf3.setBounds(340,180,150,20);
		p.add(l3);
		p.add(ltf3);


		l4= new JLabel("Price :");
		l4.setBounds(200,220,200,20);
		ltf4= new JTextField();
		ltf4.setBounds(340,220,150,20);
		p.add(l4);
		p.add(ltf4);
		
		l5= new JLabel("Date :");
		l5.setBounds(200,260,200,20);
		ltf5= new JTextField();
		ltf5.setBounds(340,260,150,20);
		ltf5.setText(is);
		p.add(l5);
		p.add(ltf5);


		l6= new JLabel("Time :");
		l6.setBounds(200,300,200,20);
		ltf6= new JTextField();
		ltf6.setText(tim);
		ltf6.setBounds(340,300,150,20);
		p.add(l6);
		p.add(ltf6);
	

		l7= new JLabel("Bed No :");
		l7.setBounds(200,340,200,20);
		ltf7= new JTextField();
		ltf7.setBounds(340,340,150,20);
		p.add(l7);
		p.add(ltf7);
		
		ltf5.setEditable(false);
		ltf6.setEditable(false);
		update = new JButton("Update",new ImageIcon("image/regis.png"));
		update.addActionListener(this);
		update.setBounds(270,380,130,30);
		p.add(update);		


		clear = new JButton("Clear",new ImageIcon("image/reset.png"));
		clear.setBounds(440,380,130,30);
		p.add(clear);
		clear.addActionListener( new ActionListener() {   
			public void actionPerformed(ActionEvent e)
				{ 	ltf1.setText("");	
				 	ltf2.setText("");
					ltf3.setText("");
					ltf4.setText("");
					//ltf5.setText("");
					//ltf6.setText("");
					ltf1.setEditable(true);
					Calendar cal = Calendar.getInstance();
					tim=time1.format(cal.getTime());
					ltf6.setText(tim);
					ltf7.setText("");

					}
		});  
				
		
		submit = new JButton("Add Room",new ImageIcon("image/save.png"));
		submit.addActionListener(this);
		submit.setBounds(100,380,130,30);
		p.add(submit);
		
		delete = new JButton("Delete",new ImageIcon("image/cancel.png"));
		delete.addActionListener(this);
		delete.setBounds(610,380,130,30);
		p.add(delete);
		JLabel im=new JLabel(new ImageIcon("image/m1.jpg"));
		im.setBounds(0,0,850,850);
		p.add(im);
		add(p);
		addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e){ new MainForm();  dispose(); }});
		setVisible(true);
	}


	
	public void actionPerformed(ActionEvent ea)
	{

	String 	s1,s2,s3,s4,s5,s6,s7; 
					s1=ltf1.getText(); s2=ltf2.getText(); s3=ltf3.getText();  s4=ltf4.getText();  s5=ltf5.getText(); s6=ltf6.getText();  s7=ltf7.getText();
				if(ea.getSource()==submit)
				{	re=0;  ph1=0; ph2=0; ph3=0; ph4=0;

						if(i==1)
				{
			 	try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",username,password);
      				String query = "delete from room where roomno = ?";
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
						rs2=stm2.executeQuery("Select * from room");
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
			
					if(s1.isEmpty()||s2.isEmpty()||s3.isEmpty()||s4.isEmpty()||s5.isEmpty()||s6.isEmpty()||s7.isEmpty())
					{    JOptionPane.showMessageDialog(this,"Some Textfields is empty","Error",JOptionPane.ERROR_MESSAGE); }
					
					else
						{      

								pass1=0;
					   String i1 = ltf1.getText();
					   String i2=ltf2.getText();
					   String i3 = ltf4.getText();
					   String i4=ltf7.getText();
						
					for(int y=0;y<i1.length(); ++y)
					{
						if(!Character.isDigit(i1.charAt(y)))
							{  pass1=7; ph1=1;  }
					}
					for(int y1=0;y1<i2.length(); ++y1)
					{
						if(!Character.isDigit(i2.charAt(y1)))
						{  pass1=7; ph2=1; }
					}
					for(int y3=0;y3<i3.length(); ++y3)
					{
						if(!Character.isDigit(i3.charAt(y3)))
							{  pass1=7; ph3=1;  }
					}
					for(int y4=0;y4<i4.length(); ++y4)
					{
						if(!Character.isDigit(i4.charAt(y4)))
						{  pass1=7; ph4=1; }
					}

						







							
					if(re==0){
							if(pass1==0)
						{  pass1=0;

						   try        { Class.forName("oracle.jdbc.driver.OracleDriver");
							con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",username,password);
							stm =  con.prepareStatement("insert into room values(?,?,?,?,?,?,?)");
			                			stm.setString(1,ltf1.getText());
							stm.setString(2,ltf2.getText());
							stm.setString(3,ltf3.getText());	
							stm.setString(4,ltf4.getText());
							stm.setString(5,ltf5.getText());
							stm.setString(6,ltf6.getText());
							stm.setString(7,ltf7.getText());
							stm.executeUpdate();
							JOptionPane.showMessageDialog(this,"Add Room Successful","Success",JOptionPane.INFORMATION_MESSAGE);
							ltf1.setText("");	
				 			ltf2.setText("");
							ltf3.setText("");
							ltf4.setText("");
							//ltf5.setText("");
							//ltf6.setText("");
							ltf1.setEditable(true);
							Calendar cal = Calendar.getInstance();
							tim=time1.format(cal.getTime());
							ltf6.setText(tim);
							ltf7.setText("");

							i=0;
							con.close();

							}
						catch(Exception e){JOptionPane.showMessageDialog(this,e,"Success",JOptionPane.INFORMATION_MESSAGE);}						
						       }
						else{   pass1=0;  if(ph1==1) {JOptionPane.showMessageDialog(this,"Incorrect room no","Error",JOptionPane.ERROR_MESSAGE);}
						if(ph2==1) {JOptionPane.showMessageDialog(this,"Incorrect Building no","Error",JOptionPane.ERROR_MESSAGE);}
						if(ph3==1) {JOptionPane.showMessageDialog(this,"Incorrect Price","Error",JOptionPane.ERROR_MESSAGE);}
						if(ph4==1) {JOptionPane.showMessageDialog(this,"Incorrect  Bed no","Error",JOptionPane.ERROR_MESSAGE);}}
						}else{JOptionPane.showMessageDialog(this,"Roon no already add","Error",JOptionPane.ERROR_MESSAGE);}
						}


				}


			if(ea.getSource()==update)
				{   	
			 		up=JOptionPane.showInputDialog("Enter Room No ID"); 
					ltf1.setEditable(false);	
					
					if(!up.isEmpty())
					{
				         try{	
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",username,password);
					stm2=con.createStatement();
					rs2= stm2.executeQuery("SELECT  *  FROM room WHERE roomno="+up+" ");
						
				while(rs2.next())
					{
						
					ltf1.setText(rs2.getString(1));
					ltf2.setText(rs2.getString(2));
					ltf3.setText(rs2.getString(3));
					ltf4.setText(rs2.getString(4));
					ltf5.setText(rs2.getString(5));
					ltf6.setText(rs2.getString(6));
					ltf7.setText(rs2.getString(7));
					}	i=1;	
					}
				catch(Exception p){JOptionPane.showMessageDialog(this,p,"Success",JOptionPane.INFORMATION_MESSAGE);}
					}
					else{}   
			     }

			
				if(ea.getSource()==delete)
				{	re1=0;  String ss=JOptionPane.showInputDialog("Enter Room No");

					try{
						Class.forName("oracle.jdbc.driver.OracleDriver");
			                               		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",username,password);
						stm2=con.createStatement();
						rs2=stm2.executeQuery("Select * from room");
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
			

				if(re1==1){	
				if(!ss.isEmpty())
				{
			 	try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",username,password);
      				String query = "delete from room where roomno = ?";
      				PreparedStatement preparedStmt = conn.prepareStatement(query);
      				preparedStmt.setString(1, ss);
      				preparedStmt.execute();
				JOptionPane.showMessageDialog(this,"Delete Room Successful","Success",JOptionPane.INFORMATION_MESSAGE);
      				ltf1.setText("");	
				 			ltf2.setText("");
							ltf3.setText("");
							ltf4.setText("");
							//ltf5.setText("");
							//ltf6.setText("");
							Calendar cal = Calendar.getInstance();
							tim=time1.format(cal.getTime());
							ltf6.setText(tim);
							ltf7.setText("");

				conn.close();
				   }
				catch(Exception r){JOptionPane.showMessageDialog(this,r,"Success",JOptionPane.INFORMATION_MESSAGE);}
				} } else{ JOptionPane.showMessageDialog(this,"Incorrect room no","Error",JOptionPane.ERROR_MESSAGE); } 
								
				}


	}




/*public static void main(String []args)
	{  new AddRoom();  }*/
}
