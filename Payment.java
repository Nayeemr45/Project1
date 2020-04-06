import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
 


class Payment extends JFrame implements ActionListener{
        private Container c;
        private Font f,f2,f3;
        private P_image pi;
        private JRadioButton rb,rb2,rb3;
        private Thank_you th;
	private String m="";
	public Payment(P_image p)
        {
            pi=p;
            th=new Thank_you();
			
             c =this.getContentPane();
             c.setBackground(new Color(0,139,139));
             setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             c.setLayout(null);
             setBounds(680,355,500,300);
             setTitle("Payment");
             
             f =new Font("Arial",Font.BOLD,25);
             f2 =new Font("Arial",Font.BOLD,22);
             f3 =new Font("Arial",Font.BOLD,18);
             
           ButtonGroup bg=new ButtonGroup();
          
          rb=new JRadioButton("Cash");
          rb.setFont(f2);
          rb.setForeground(new Color(0,255,255));                
          rb.setBounds(80, 80, 80, 20);
          rb.setBackground(new Color(0,139,139));
          c.add(rb);
          
          rb2=new JRadioButton("Card");
          rb2.setFont(f2);
          rb2.setForeground(new Color(0,255,255));                
          rb2.setBounds(190, 80, 80, 20);
          rb2.setBackground(new Color(0,139,139));
          c.add(rb2);
          
           rb3=new JRadioButton("Check");
          rb3.setBounds(300, 80, 100, 20);
          rb3.setForeground(new Color(0,255,255));                
          rb3.setFont(f2);
          rb3.setBackground(new Color(0,139,139));
          c.add(rb3);
          
          bg.add(rb);
          bg.add(rb2);
          bg.add(rb3);
          
                JButton b=new JButton("Confirm");
                b.setBackground(new Color(0,206,209));
                b.setForeground(new Color(255,255,255));
                b.setFont(f);
                c.add(b);
                b.setBounds(160, 190, 128, 50);
                
                JLabel lb=new JLabel("Select Payment Method:");
                lb.setBackground(new Color(0,139,139));
                lb.setForeground(new Color(248,248,255));
                lb.setFont(f3);
                lb.setBounds(10, 20, 300, 20);
                c.add(lb);
          
          b.addActionListener(this);
          rb.addActionListener(this);
          rb2.addActionListener(this);
          rb3.addActionListener(this);
        
}
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==rb){
					m="Cash";
                 }else if(e.getSource()==rb2){
					m="Card";
                 }else if(e.getSource()==rb3){
					m="Check";
                 }
		String s=e.getActionCommand();
		if(s.equals("Confirm")){
			String q="insert into payment values(null,'"+m+"',CURRENT_TIMESTAMP)";

			System.out.println(q);
			DataAccess da=new DataAccess();
			int c=da.updateDB(q);
			JOptionPane.showMessageDialog(this,c+" row(s) updated");
            JOptionPane.showMessageDialog(this,"Confirm Succesfull");
                        th.setVisible(true);
			this.setVisible(false);
		}
                }
}

