import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Admin_show extends Frame implements ActionListener{
	private TextArea ta;
	public Admin_show( ){
		super("Show Payment");
                
		Label l=new Label("Data From DB");
		ta=new TextArea(6,40);
		Button b=new Button("Show Payment Info");
		Button b2=new Button("Exit");
                
		add(l);add(ta);add(b);add(b2);
                
		b.addActionListener(this);
		b2.addActionListener(this);
                
		setLayout(new FlowLayout());
                
		setSize(400,400);
		setLocation(750,250);
	}
	public void actionPerformed(ActionEvent ae){
		String s=ae.getActionCommand();
		System.out.println(ta.getText());
		ta.setText("");
		if(s.equals("Show Payment Info")){
    try{
	    DataAccess da=new DataAccess();ResultSet rs=null;
	    rs=da.getData("select payment_no,payment_method,payment_date from payment");
	while(rs.next()){  
	String str=rs.getInt("payment_no")+"--Method:"+rs.getString("payment_method")+"--Date:"+rs.getString("payment_date");//get data from Database
		    ta.append(str+"\n");  //print 
				}
			}catch(Exception ex){ex.printStackTrace();}
		}else if(s.equals("Exit")){
			System.exit(0);  //Exit
		}
	}
	public void paint(Graphics g){
		g.setColor(new Color(207,192,58));
		g.fillRect(0,0,400,400);
	}
}