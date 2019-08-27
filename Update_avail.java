import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Update_avail extends Frame implements ActionListener{
	private TextArea ta;
        private TextField tf,tf2;
        private int gv=0,np=0;
	public Update_avail(){
		super("Show Rent");
		Label l=new Label("Data From DB");
                Label l2=new Label("Enter Product no");
                Label l3=new Label("Enter available no");
		

		tf=new TextField(28);
		tf2=new TextField(28);
                
		ta=new TextArea(6,40);  //show info in TextArea
		Button b=new Button("Show Product Info");
		Button b2=new Button("Exit");
		Button b3=new Button("Update");
		add(l);add(ta);add(b);add(l2);add(tf);add(l3);add(tf2);add(b3);add(b2);
		b.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		setLayout(new FlowLayout());
		setSize(600,350);
		setLocation(650,250);
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
		}else if(s.equals("Update")){
			if(tf.getText().isEmpty() || tf2.getText().isEmpty()){
				JOptionPane.showMessageDialog(this,"Insert Value First");
				System.out.println("Insert Value");
			}else{
                    gv=Integer.parseInt(tf.getText());
                    np=Integer.parseInt(tf2.getText());
                      String sq="update product set available_no="+np+" where p_no="+gv ; 
                    
			System.out.println(sq);
			DataAccess da=new DataAccess();
			int c=da.updateDB(sq);
			JOptionPane.showMessageDialog(this,c+" Value(s) Updated");
                        tf.setText("");
                        tf2.setText("");
                }
		}else if(s.equals("Exit")){
			System.exit(0);
		}
		
	}
	public void paint(Graphics g){
		g.setColor(new Color(207,192,58));
		g.fillRect(0,0,600,350);
	}
}

