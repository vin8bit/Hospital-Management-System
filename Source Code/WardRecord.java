import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.regex.*;
import java.sql.*;

public class WardRecord extends JFrame implements ActionListener
{
	JTextField tf1;
	JButton b1,b2;
	String columns[]={"Room no","Floor","Building","Room type","Numbe of bed","Unit price"};
	TableModel tmodel;
	JTable jtable;
	TableRowSorter<TableModel> rsorter;
	int i=0,k=0,l=0,p=0,y=0,j=0,i1=0; 
	Connection con;
	Statement stm;
	String user="system";
	String pass="system";
	Count1 count=new Count1();
	int g=9+count.call5();
	Object array[][] = new Object[g][9];
	
	ResultSet rs;
	public WardRecord() throws Exception
	{
		setIconImage(new ImageIcon("image/logo.png").getImage());
		
		
			
		try
			{
			
	
			 Class.forName("oracle.jdbc.driver.OracleDriver");
		            	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
			stm= con.createStatement(); 
			rs= stm.executeQuery("SELECT *  FROM ward");	
			
			while(rs.next())
			{   
				array[i++][0]=rs.getObject("ROOMNO");
				array[k++][1]=rs.getObject("FLOOR");
				array[l++][2]=rs.getObject("BUILDING");
				array[p++][3]=rs.getObject("ROOMTYPE");
				array[y++][4]=rs.getObject("NUMBEROFBED");
				array[j++][5]=rs.getObject("UNITPRICE");
				
				}      
			con.close();	
				
			}
		catch(SQLException e)
		{   	JOptionPane.showMessageDialog(this,e,"Error",JOptionPane.INFORMATION_MESSAGE);
			 } 



		setTitle("Ward Record");
		setSize(800,550);
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		
		p1.setBackground(Color.yellow);
		add(p1,BorderLayout.EAST);
		p2.setBackground(Color.yellow);
		add(p2,BorderLayout.NORTH);
		
				
		JLabel l1=new JLabel("Ward Record");
		Font font=new Font("Algerian",Font.BOLD,25);
		l1.setFont(font);
		p2.add(l1);
		tf1= new JTextField(10);
		p1.add(tf1);		
		b1= new JButton("Search",new ImageIcon("image/search.png"));
		b1.addActionListener(this);
		p1.add(b1);
		tmodel= new DefaultTableModel(array,columns);
		jtable=new JTable(tmodel);
		rsorter = new TableRowSorter<TableModel>(tmodel);
		JScrollPane jspane=new JScrollPane(jtable);
		jtable.setRowSorter(rsorter);
		add(jspane,BorderLayout.CENTER);
		
		addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e){ new MainForm();  dispose(); }});
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent er)
		{
			if(er.getSource()==b1)
				{ 
				String text=tf1.getText();
					if(text.length()==0)
					{     rsorter.setRowFilter(null);  }
					rsorter.setRowFilter(RowFilter.regexFilter(text));
				}
				

		}

public static void main(String []args) throws Exception
	{ new WardRecord(); }

}
		