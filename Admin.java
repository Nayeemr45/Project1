import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Admin extends Frame implements ActionListener{
	private TextField tf;
	private TextField tf2;
	boolean ret;
        private Combodemo cb;
	public Admin(){
		super("Java Admin Window");
                
                cb=new Combodemo();
                
		Label l=new Label("User Name");
		Label l2=new Label("Password");
                
		tf=new TextField(28);
		tf2=new TextField(28);
		tf2.setEchoChar('*');
                
		Button b=new Button("Login");
		Button b2=new Button("Exit");
                
		add(l);add(tf);add(l2);add(tf2);add(b);add(b2);
                
		b.addActionListener(this);
		b2.addActionListener(this);
                
		setLayout(new FlowLayout());
                
		setSize(280,400);
		setLocation(700,250);
                
                tf.setText("");
		tf2.setText("");
	}
	public void actionPerformed(ActionEvent ae){
		String s=ae.getActionCommand();
		if(s.equals("Login")){
			if(tf.getText().isEmpty() || tf2.getText().isEmpty()){
				JOptionPane.showMessageDialog(this,"Insert Value First");
				System.out.println("Insert Value");
			}else{
			DataAccess da=new DataAccess();     //Data Access
                        
			String typedName=tf.getText();      //getText from TextField 
			String typedPass=tf2.getText();
                        
			String q="select user_name,pass from admin";        //query
			ResultSet rs=null;
                        
			System.out.println("Button pressed");		
				try{
				rs=da.getData(q);                           //getData from Database
				System.out.println(q);
				System.out.println("value From DB");
                                
				while(rs.next()){
					String n = rs.getString("user_name");
					String p= rs.getString("Pass");
					System.out.println("User_name:---"+n);
					System.out.println("Password:---"+p);
					if(n.equals(typedName) && p.equals(typedPass)){
						System.out.println("Correct Cred.");
						ret=true;
						break;
					}
					else if(n!=typedName && p!=typedPass){
						System.out.println("Not Correct Cred.");
						ret=false;					    
					}
				}
				if(ret==true){
					JOptionPane.showMessageDialog(this,"Correct Cred.");
					this.setVisible(false);
					cb.setVisible(true);
				}else if(ret==false){
					JOptionPane.showMessageDialog(this,"Not Correct Cred.");
                                        tf.setText("");
					tf2.setText("");
				}
					}
				
			catch(Exception ex){
				JOptionPane.showMessageDialog(this,"DB Error");
				ex.printStackTrace();           //Exeption Type
			}
			}
		}
		else if(s.equals("Exit")){
			System.exit(0);
		}
	}
	public void paint(Graphics g){
		g.setColor(new Color(198,222,225));
		g.fillRect(0,0,280,400);
	}
}