import java.awt.Frame;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class About_us extends Frame implements ActionListener{
	public About_us(){
		super("About Us");

                Label l=new Label("Rent furniture that fits to your taste and budget");                //Label
		Label l2=new Label("More cost effective then buying new furniture or shipping");
		Label l3=new Label("Rent from 4 weeks up to 5 years");
		Label l4=new Label("Flexible and high level service");
		Label l5=new Label("More than 5 years of experience");
		Label l6=new Label("An attractive all-inclusive rental formula so you can be at home with ease");		
                                                                        
		Button a=new Button("Exit");                                       //Button
                Button a2=new Button("Cancel");

		add(l);add(l2);add(l3);add(l4);                                    //add
                add(l5);add(l6);add(a);add(a2);
				
		a.addActionListener(this);                                         //ActionListener
                a2.addActionListener(this); 
                
		setLayout(new FlowLayout());
                
		setSize(460,300);                                                   //setSize
		setLocation(700,250);                                               //setLocation
	}
		public void actionPerformed(ActionEvent ae){
		String s=ae.getActionCommand();
                    if(s.equals("Exit")){
			System.exit(0);
                    }else if(s.equals("Cancel")){
                         this.setVisible(false);
                    }
    }
                    public void paint(Graphics g){
                        g.setColor(new Color(195,223,108));
                        g.fillRect(0,0,460,400);
                    }		
}



