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

public class Signup extends Frame implements ActionListener{
	private TextField tf;
	private TextField tf2;
	private TextField tf3;
	private TextField tf4;
	public Signup(){
		super("SignUp");
		Label l=new Label("User Name");
		Label l2=new Label("Password");
		Label l3=new Label("email");
		Label l4=new Label("Mobile No");

		tf=new TextField(28);
		tf2=new TextField(28);
		tf3=new TextField(28);
		tf4=new TextField(28);

                Button b=new Button("Signup");
		Button b1=new Button("Exit");
                
		add(l);add(tf);
		add(l2);add(tf2);
		add(l3);add(tf3);
		add(l4);add(tf4);
		add(b);add(b1);
                
		l.setBounds(10,35,100,15);
		tf.setBounds(110,35,100,20);
		l2.setBounds(10,55,100,15);
		tf2.setBounds(110,55,100,20);
		l3.setBounds(10,35,100,15);
		tf3.setBounds(110,35,100,20);
		l4.setBounds(10,55,100,15);
		tf4.setBounds(110,55,100,20);
                b.setBounds(110,85,100,25);
                
		b.addActionListener(this); 
		b1.addActionListener(this);
                
		setLayout(new FlowLayout());
                
		setSize(280,400);
		setLocation(300,0);
	}
	public void actionPerformed(ActionEvent ae){
		System.out.println("Button Pressed");
		String s=ae.getActionCommand();
		System.out.println(s);
		if(s.equals("Signup")){
			if(tf.getText().isEmpty() || tf2.getText().isEmpty() || tf3.getText().isEmpty() || tf4.getText().isEmpty()){
				JOptionPane.showMessageDialog(this,"Insert Value First");
				System.out.println("Insert Value");
			}else{
			String q="insert into customer values(null,'"+tf.getText()+"','"+tf2.getText()+"','"+tf3.getText()+"','"+tf4.getText()+"','1')";

			System.out.println(q);
			DataAccess da=new DataAccess();
			int c=da.updateDB(q);
			JOptionPane.showMessageDialog(this,c+" row(s) updated");
		}
		}
		else if(s.equals("Exit")){
			System.exit(0);
		}
	}
	public void paint(Graphics g){
		g.setColor(new Color(198,255,193));
		g.fillRect(0,0,400,400);
	}
}