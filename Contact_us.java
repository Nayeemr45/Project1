import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Contact_us extends Frame implements ActionListener{
	private TextField tf;
	private TextField tf2;
	private TextField tf3;
	private TextField tf4;
	public Contact_us(){
		super("Contact_us");
                
		Label l=new Label("Name");
		Label l2=new Label("Email");
		Label l3=new Label("Mobile No");
		Label l4=new Label("Message");
		
		tf=new TextField(28);
		tf2=new TextField(28);
		tf3=new TextField(28);
		tf4=new TextField(28);
                
		Button b=new Button("Send");
		Button b2=new Button("Cancel");
                
		add(l);add(tf);
		add(l2);add(tf2);
		add(l3);add(tf3);
		add(l4);add(tf4);
		add(b);add(b2);

		b.addActionListener(this);
                b2.addActionListener(this);
                
		setLayout(new FlowLayout());
                
		setSize(280,400);
		setLocation(750,250);
	}
	public void actionPerformed(ActionEvent ae){
		System.out.println("Button Pressed");
		String s=ae.getActionCommand();
		System.out.println(s);
		if(s.equals("Send")){
			String q="insert into contact values(null,'"+tf.getText()+"','"+tf2.getText()+"','"+tf3.getText()+"','"+tf4.getText()+"')";

			System.out.println(q);
			DataAccess da=new DataAccess();
			int c=da.updateDB(q);
			JOptionPane.showMessageDialog(this,c+" row(s) updated");
                        tf.setText("");
                        tf2.setText("");
                        tf3.setText("");
                        tf4.setText("");
		}else if(s.equals("Cancel")){
                        this.setVisible(false);
                }
                
	}
	public void paint(Graphics g){
		g.setColor(new Color(200,223,128));
		g.fillRect(0,0,400,400);
	}
}
