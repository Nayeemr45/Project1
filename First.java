import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;


class First extends JFrame implements ActionListener {
    private Container c;
    public Font f,f2,f3;
    public String txt,txt2;
	public Login log;
	public Signup sign;
	public Admin ad;
	public Assistant as;
	public About_us ab;
	public Contact_us co;
	public Product pr;
        
	public First()
        {
             c =this.getContentPane();   
             c.setBackground(new Color(130,240,115));
             setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //Exit
			 c.setLayout(null);
             setBounds(190,90,1550,782);
             setTitle("Home");
             
             
             f =new Font("Arial",Font.CENTER_BASELINE,22);      //Font
             f2=new Font("sansserif",Font.BOLD,48);
             f3=new Font("Arial",Font.ROMAN_BASELINE,18);

			log=new Login();
			sign=new Signup();
			ad=new Admin();
			as=new Assistant();
			ab=new About_us();
			co=new Contact_us();
			
						
             ImageIcon  img5 = new ImageIcon(getClass().getResource("back1.jpg")); //Background Image
	         JLabel  label=new JLabel(img5);
             label.setBounds(0,0,img5.getIconWidth(),img5.getIconHeight());
             c.add(label);			
					
			
                 txt="Welcome to Furniture Rent System";   //Title
                JLabel l=new JLabel();
		       l.setForeground(Color.WHITE);
                l.setText(txt);
		l.setBounds(300,90,1000,100);
                l.setFont(f2);
 		label.add(l);
        
				
               
                
		txt2="<html><h1>Furniture Rent System is the first Furniture rental platform in Bangladesh with the aim to improving living standards without needing to spend a lot and also it has no commitments! You can simply pay for as long as you use the furniture and change whenever you want to adapt to a new trend! We create uniquely designed furniture that's shaped and crafted by true enthusiasts, with a perpetual focus on personality, pride and sustainability. Our vision unites the finest carpentry traditions with modern furniture design through the fusion of timeless steel, brass, copper, bronze, and wood.<br>Wood is our main source of inspiration. The love of organic material and uncompromising focus on quality is evident throughout the process, from the first design sketches to the Final moments where the furniture is finished and surface treated by hand.</h1>";
		JLabel l2=new JLabel();
                l2.setText(txt2);
                l2.setBounds(25,220,1500,270);
		label.add(l2);
                
                JButton b=new JButton("LogIn As Customer");
                b.setBackground(new Color(206,165,41));
                b.setFont(f);
                label.add(b);
                b.setBounds(330, 630, 260, 50);
                
                
                 JButton b2=new JButton("SignUp");
                b2.setBackground(new Color(206,165,41));
                b2.setFont(f);
                label.add(b2);
                b2.setBounds(1040, 630, 150, 50);
				
				
		JButton b3=new JButton("LogIn As Admin");
                b3.setBackground(new Color(206,165,41));
                b3.setFont(f);
                label.add(b3);
                b3.setBounds(590, 630, 200, 50);
                
                
                 JButton b4=new JButton("LogIn As Assistant");
                b4.setBackground(new Color(206,165,41));
                b4.setFont(f);
                label.add(b4);
                b4.setBounds(790, 630, 250, 50);
				
				
		JButton b5=new JButton("About Us");
                b5.setBackground(new Color(206,165,41));
                b5.setFont(f3);
                label.add(b5);
                b5.setBounds(650, 680, 140, 50);
                
                
                 JButton b6=new JButton("Contact Us");
                b6.setBackground(new Color(206,165,41));
                b6.setFont(f3);
                label.add(b6);
                b6.setBounds(790, 680, 140, 50);
                
                

                
       		b.addActionListener(this);
       		b2.addActionListener(this);
			b3.addActionListener(this);
       		b4.addActionListener(this);
       		b5.addActionListener(this);
       		b6.addActionListener(this);
}   
        public void actionPerformed(ActionEvent e){
		String s=e.getActionCommand();
		if(s.equals("LogIn As Customer")){
			this.setVisible(false);
			log.setVisible(true);
		}else if(s.equals("SignUp")){
			this.setVisible(false);
			sign.setVisible(true);
		}else if(s.equals("Show Product")){
			this.setVisible(false);
			pr.setVisible(true);
		}else if(s.equals("LogIn As Admin")){
			this.setVisible(false);
			ad.setVisible(true);
		}else if(s.equals("LogIn As Assistant")){
			this.setVisible(false);
			as.setVisible(true);
		}else if(s.equals("About Us")){
			ab.setVisible(true);
		}else if(s.equals("Contact Us")){
			co.setVisible(true);
		}
	}
        
}

 