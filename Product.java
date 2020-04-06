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
import java.sql.SQLException;

public class Product extends Frame implements ActionListener{
	private TextArea ta;
	private P_image pi;
	public Product( ){
		super("Product");
		
		pi=new P_image();
		
		Label l=new Label("Data From DB");
		ta=new TextArea(6,40);
                
		Button b=new Button("Show Product Info");
		Button b2=new Button("Exit");
		Button b3=new Button("Rent");
		add(l);add(ta);
		add(b);add(b2);add(b3);
		b.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		setLayout(new FlowLayout());
		setSize(400,400);
		setLocation(750,250);
	}
	public void actionPerformed(ActionEvent ae){
		String s=ae.getActionCommand();
		System.out.println(ta.getText());
		ta.setText("");
		if(s.equals("Show Product Info")){
			try{
				DataAccess da=new DataAccess();ResultSet rs=null;
				rs=da.getData("select p_no,p_name,price,available_no from product");
				while(rs.next()){
					String str=rs.getInt("p_no")+"--Name:"+rs.getString("p_name")+"--Price:"+rs.getInt("price")+"--Available_no:"+rs.getInt("available_no");
					ta.append(str+"\n");
				}
			}catch(Exception ex){ex.printStackTrace();}
		}
		else if(s.equals("Rent")){
			pi.setVisible(true);
			this.setVisible(false);
		}else if(s.equals("Exit")){
			System.exit(0);
		}
	}
	public void paint(Graphics g){
		g.setColor(new Color(207,192,58));
		g.fillRect(0,0,400,400);
	}
}