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
import javax.swing.JOptionPane;


public class Delete_rent extends Frame implements ActionListener{
	private TextArea ta;
        private TextField tf;
        private int gv=0;
	public Delete_rent( ){
		super("Show Rent");
                
		Label l=new Label("Data From DB");
                Label l2=new Label("Enter Rent no");
		
		tf=new TextField(28);
		ta=new TextArea(6,40);
                
		Button b=new Button("Show Rent Info");
		Button b2=new Button("Exit");
		Button b3=new Button("Delete");
                
		add(l);add(ta);add(b);add(l2);add(tf);add(b3);add(b2);
                
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
		if(s.equals("Show Rent Info")){
			try{
				DataAccess da=new DataAccess();ResultSet rs=null;
				rs=da.getData("select rent_no,price,date from rent");
				while(rs.next()){
					String str=rs.getInt("rent_no")+"--Price:"+rs.getString("price")+"--Date:"+rs.getString("date");
					ta.append(str+"\n");
				}
			}catch(Exception ex){ex.printStackTrace();}
		}else if(s.equals("Delete")){
			if(tf.getText().isEmpty()){
				JOptionPane.showMessageDialog(this,"Insert Value First");
				System.out.println("Insert Value");
			}else{
                    gv=Integer.parseInt(tf.getText());
                      String sq="delete from rent where rent_no="+gv ; 
                    
			System.out.println(sq);
			DataAccess da=new DataAccess();
			int c=da.updateDB(sq);
			JOptionPane.showMessageDialog(this,c+" row(s) Deleted");
                        tf.setText("");
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
