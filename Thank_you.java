import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

 


class Thank_you extends JFrame  {
        private Container c;
        private Font f2;
	public Thank_you( )
        {
             c =this.getContentPane();
             c.setBackground(new Color(0,139,139));
             setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             c.setLayout(null);
             setBounds(680,355,500,300);
             setTitle("Thank_You");
             
             f2 =new Font("Arial",Font.BOLD,22);
           
           JLabel lb=new JLabel("Thak you for use our System.");
           lb.setBackground(new Color(0,139,139));
           lb.setForeground(new Color(248,248,255));
           lb.setFont(f2);
          lb.setBounds(25, 30, 300, 20);
          c.add(lb);
        
}
}

