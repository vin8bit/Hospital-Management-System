import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class MainForm extends JFrame implements ActionListener
{
  	JTextArea tf;
	JFrame    f;
	JMenuBar  m;
	JMenu     file,patient,rooms,staffs,help,record;
	JPanel panel;
	JMenuItem  l1,e1;
	JMenuItem  p1,p2,p3,p4,p5,p6;
	JMenuItem  r1,r2,r3,r4,r5,s1,s2,h1;
	JMenuItem  a1,a2,a3,a4,a5;
	JToolBar tbar;
	JButton t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
		public MainForm()
		{  
			super("Hospital Management System");
			setIconImage(new ImageIcon("image/logo.png").getImage());
			m=new JMenuBar();
			file=new JMenu("File");
			tbar= new JToolBar();
			t1=new JButton(new ImageIcon("image/officer.png"));
			tbar.add(t1);
			t1.setToolTipText("Patient Registration");
			tbar.addSeparator();
			t1.addActionListener(this);
			t2=new JButton(new ImageIcon("image/users.png"));
			tbar.add(t2);
			t2.setToolTipText("Patient Receipt Entry");
			t2.addActionListener(this);
			t3=new JButton(new ImageIcon("image/emp.png"));
			tbar.addSeparator();
			tbar.add(t3);
			t3.setToolTipText("Patient Information");
			t3.addActionListener(this);
			t4=new JButton(new ImageIcon("image/author.png"));
			tbar.addSeparator();
			tbar.add(t4);
			t4.setToolTipText("Patient CheckOut");
			t4.addActionListener(this);
			
			t5=new JButton(new ImageIcon("image/notes.gif"));
			tbar.addSeparator();
			tbar.add(t5);
			t5.setToolTipText("Add New Room");
			t5.addActionListener(this);

			t6=new JButton(new ImageIcon("image/files.gif"));
			tbar.addSeparator();
			tbar.add(t6);
			t6.setToolTipText("Room Information");
			t6.addActionListener(this);

			
			t7=new JButton(new ImageIcon("image/add.gif"));
			tbar.addSeparator();
			tbar.add(t7);
			t7.setToolTipText("Add New Ward");
			t7.addActionListener(this);
			
			
			t8=new JButton(new ImageIcon("image/ward.png"));
			tbar.addSeparator();
			tbar.add(t8);
			t8.setToolTipText("Ward Information");
			t8.addActionListener(this);
			
			t9=new JButton(new ImageIcon("image/addstaff.png"));
			tbar.addSeparator();
			tbar.add(t9);
			t9.setToolTipText("Add new Staff");
			t9.addActionListener(this);
		
			t10=new JButton(new ImageIcon("image/staff.png"));
			tbar.addSeparator();
			tbar.add(t10);
			t10.setToolTipText("Stafff Information");
			t10.addActionListener(this);		
	
			add(tbar,BorderLayout.NORTH);
			panel = new JPanel();
			panel.setBackground(Color.green);
			panel.add(new JLabel(new ImageIcon("image/m.jpg")));
			add(panel);
			m.add(file);
			patient=new JMenu("Patient");
			m.add(patient);
			rooms=new JMenu("Rooms");
			m.add(rooms);
			staffs=new JMenu("Staffs");
			m.add(staffs);
			record=new JMenu("Record");
			m.add(record);
			help=new JMenu("Help");
			m.add(help);


			//file
			l1=new JMenuItem("    Log out",new ImageIcon("image/keys.gif"));
			file.add(l1);
			l1.addActionListener(this);
			e1=new JMenuItem("    Exit",new ImageIcon("image/cancel.png"));
			e1.addActionListener(this);
			file.add(e1);
			
			//Patient
			p1=new JMenuItem("    Patient Registration",new ImageIcon("image/officer.png"));
			patient.add(p1);
			p1.addActionListener(this);
			p5=new JMenuItem("    Patient Receipt Entry",new ImageIcon("image/users.png"));
			patient.add(p5);
			p5.addActionListener(this);
			p3=new JMenuItem("    Patient Information",new ImageIcon("image/emp.png"));
			patient.add(p3);
			p3.addActionListener(this);
			p4=new JMenuItem("  Patient Check Out",new ImageIcon("image/author.png"));
			patient.add(p4);
			p4.addActionListener(this);
			
			


			//Rooms
			r1=new JMenuItem("  Add New Room  ",new ImageIcon("image/notes.gif"));
			rooms.add(r1);
			r1.addActionListener(this);
			r2=new JMenuItem("  Room Informatiom  ",new ImageIcon("image/files.gif"));
			rooms.add(r2);
			r2.addActionListener(this);
			r3=new JMenuItem("  Add New Ward  ",new ImageIcon("image/add.gif"));
			rooms.add(r3);
			r3.addActionListener(this);
			r4=new JMenuItem("  Ward Informatiom  ",new ImageIcon("image/ward.png"));
			rooms.add(r4);
			r4.addActionListener(this);


			//Staffs
			s1=new JMenuItem("  Add New Staff    ",new ImageIcon("image/addstaff.png"));
			staffs.add(s1);
			s1.addActionListener(this);
			s2=new JMenuItem("  Staff Informatiom    " ,new ImageIcon("image/staff.png"));
			s2.addActionListener(this);
			staffs.add(s2);


			
			//Record
			a1=new JMenuItem(" Registration Record  ",new ImageIcon("image/add.gif"));
			record.add(a1);
			a1.addActionListener(this);
			a2=new JMenuItem("  Receipt Record  ",new ImageIcon("image/add.gif"));
			record.add(a2);
			a2.addActionListener(this);
			a3=new JMenuItem("  Room Record  ",new ImageIcon("image/add.gif"));
			record.add(a3);
			a3.addActionListener(this);
			a4=new JMenuItem("  Ward Record  ",new ImageIcon("image/add.gif"));
			record.add(a4);
			a4.addActionListener(this);
			a5=new JMenuItem("  Staff Record  ",new ImageIcon("image/add.gif"));
			record.add(a5);
			a5.addActionListener(this);
			
			//Help
			h1=new JMenuItem("  Help    ",new ImageIcon("image/help.gif"));
			help.add(h1);
			h1.addActionListener(this);
			//setContentPane(new JLabel(new ImageIcon("image/m.jpg")));	
		    	setSize(1050,650);
		    	setLocationRelativeTo(null);
		    	setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			setJMenuBar(m);
		    	
		}

	public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==l1)
			{   	new Login(); dispose();		 }
			if(e.getSource()==e1)
			{   System.exit(0);		 }
			
			if(e.getSource()==h1)
			{   new Help(); dispose();		 }
			if(e.getSource()==p1||e.getSource()==t1)
			{    new Registration(); dispose();		 }
			if(e.getSource()==p3||e.getSource()==t3)
			{    new PInformation(); dispose();		 }
			if(e.getSource()==p4||e.getSource()==t4)
			{    new CheckOut(); dispose();		 }
			if(e.getSource()==p5||e.getSource()==t2)
			{    new PReceipt(); dispose();		 }
			if(e.getSource()==r1||e.getSource()==t5)
			{    new AddRoom(); dispose();		 }
			if(e.getSource()==r2||e.getSource()==t6)
			{    new RInformation(); dispose();		 }
			if(e.getSource()==r3||e.getSource()==t7)
			{    new AddWard(); dispose();		 }
			if(e.getSource()==r4||e.getSource()==t8)
			{    new Ward(); dispose();		 }
			if(e.getSource()==s1||e.getSource()==t9)
			{    new AddStaff(); dispose();		 }
			if(e.getSource()==s2||e.getSource()==t10)
			{    new Staff(); dispose();		 }

			try{
			if(e.getSource()==a1)
			{    new RegistrationRecord(); dispose();		 }
			if(e.getSource()==a2)
			{    new ReceiptRecord(); dispose();		 }
			if(e.getSource()==a3)
			{    new RoomRecord(); dispose();		 }
			if(e.getSource()==a4)
			{    new WardRecord(); dispose();		 }
			if(e.getSource()==a5)
			{    new StaffRecord(); dispose();		 }
			}
			catch(Exception c){}
			
		
		}
		public static void main(String [] args)
			{ new MainForm();  }
}