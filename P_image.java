import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
 
class P_image extends JFrame implements ActionListener {
        private Container c;
        public Font f,f2,f3;
        private Payment pay;
        private JCheckBox ck,ck2,ck3,ck4;
	private JLabel lb5;
        private int n=0;
        private int st=0,st2=0,st3=0,st4=0,an=0,an2=0,an3=0,an4=0;
        private String m="";
        
        
		public P_image( )
        {
            
             c =this.getContentPane();
             c.setBackground(new Color(210,180,140));
             setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             c.setLayout(null);
             setBounds(380,115,1080,880);
             setTitle("Product Image");
             
			 pay=new Payment(this);


             f =new Font("Arial",Font.BOLD,22);
             f2 =new Font("Arial",Font.BOLD,15);
	     f3 =new Font("Arial",Font.BOLD,19);
		 
		 
             
            DataAccess da=new DataAccess();     //data access 
			String q="select p_no,price,available_no from product";
			ResultSet rs=null;
          try{
				rs=da.getData(q);
                                //System.out.println(rs);
			System.out.println("value From DB");		
			while(rs.next()){
                                            String n = rs.getString("p_no");
                                            String pr= rs.getString("price");
                                            String pr2= rs.getString("available_no");
                                            if(n.equals("1")){
                                                st=Integer.parseInt(pr);
                                                an=Integer.parseInt(pr2);
                                                     //System.out.println(st);
                                                   //  System.out.println(n);
                                            }else if(n.equals("2")){
                                                  st2=Integer.parseInt(pr);
                                                   an2=Integer.parseInt(pr2);
                                                  //System.out.println(st2);
                                                  //  System.out.println(n);
                                            }else if(n.equals("3")){
                                                  st3=Integer.parseInt(pr); 
                                                  an3=Integer.parseInt(pr2);
                                                //  System.out.println(st3);
                                                //  System.out.println(n);
                                            }else if(n.equals("4")){
                                                  st4=Integer.parseInt(pr);
                                                   an4=Integer.parseInt(pr2);
                                                //  System.out.println(st4);
                                                //  System.out.println(n);                                         
                                            }
                                            //System.out.println("price:---"+pr);
					}
          }
			catch(Exception ex){
				JOptionPane.showMessageDialog(this,"DB Error");
				//ex.printStackTrace();
			}

          ImageIcon  img = new ImageIcon(getClass().getResource("table.jpg"));
          JLabel l=new JLabel(img);
          l.setBounds(80,20,img.getIconWidth(),img.getIconHeight());
          c.add(l);
           
          ImageIcon  img2 = new ImageIcon(getClass().getResource("bookshelf.jpg"));
          JLabel l2=new JLabel(img2);
          l2.setBounds(620,20,img.getIconWidth(),img.getIconHeight());
          c.add(l2);
          
          ImageIcon  img3 = new ImageIcon(getClass().getResource("bed.jpg"));
          JLabel l3=new JLabel(img3);
          l3.setBounds(80,400,img.getIconWidth(),img.getIconHeight());
          c.add(l3);      
               
          ImageIcon  img4 = new ImageIcon(getClass().getResource("chair.jpg"));
          JLabel l4=new JLabel(img4);
          l4.setBounds(620,400,img.getIconWidth(),img.getIconHeight());
          c.add(l4);      
          

                               
           ck=new JCheckBox("P-ID:01");
          ck.setFont(f2);
          ck.setBounds(80, 370, 100, 20);
          ck.setBackground(new Color(210,180,140));
          c.add(ck);
          
           ck2=new JCheckBox("P-ID:02");
          ck2.setFont(f2);
          ck2.setBounds(620, 370, 100, 20);
          ck2.setBackground(new Color(210,180,140));
          c.add(ck2);
          
           ck3=new JCheckBox("P-ID:03");
          ck3.setBounds(80, 715, 100, 20);
          ck3.setFont(f2);
          ck3.setBackground(new Color(210,180,140));
          c.add(ck3);
          
           ck4=new JCheckBox("P-ID:04");
          ck4.setBounds(620, 715, 100, 20); 
          ck4.setFont(f2);
          ck4.setBackground(new Color(210,180,140));
          c.add(ck4);
                
                     
          
           JButton b=new JButton("Rent");
                b.setBackground(new Color(210,110,140));
                b.setFont(f);
                c.add(b);
                b.setBounds(440, 755, 120, 50);
                
           JLabel lb=new JLabel("Table::"+"Price-"+st+"::Available--"+an);
           lb.setBackground(new Color(210,180,140));
           lb.setFont(f2);
          lb.setBounds(100, 320, 300, 20);
          c.add(lb);
          
            JLabel lb2=new JLabel("Bookshelf::"+"Price-"+st4+"::Available--"+an4);
           lb2.setBackground(new Color(210,180,140));
           lb2.setFont(f2);
          lb2.setBounds(660, 320, 300, 20);
          c.add(lb2);
          
          JLabel lb3=new JLabel("Bed::"+"Price-"+st3+"::Available--"+an3);
           lb3.setBackground(new Color(210,180,140));
           lb3.setFont(f2);
          lb3.setBounds(100, 680, 300, 20);
          c.add(lb3);
          
          JLabel lb4=new JLabel("Chair::"+"Price-"+st2+"::Available--"+an2);
           lb4.setBackground(new Color(210,180,140));
           lb4.setFont(f2);
          lb4.setBounds(660, 690, 300, 20);
          c.add(lb4);
          
           lb5=new JLabel("Total Price-"+n);
           lb5.setBackground(new Color(224,255,255));
           lb5.setFont(f3);
          lb5.setBounds(80, 780, 150, 20);
          c.add(lb5);
          
          b.addActionListener(this);
          ck.addActionListener(this);
          ck2.addActionListener(this);
          ck3.addActionListener(this);
          ck4.addActionListener(this);       
}   
        
                  
                
          public void actionPerformed(ActionEvent e){
                 if(e.getSource()==ck){
                     n=n+st;

                     System.out.println(n);
                 }else if(e.getSource()==ck2){
                     n=n+st4;
                 System.out.println(n);
                 }else if(e.getSource()==ck3){
                     n=n+st3;
                 System.out.println(n);
                 }else if(e.getSource()==ck4){
                     n=n+st2;
                 System.out.println(n);
                 }    
                 m= Integer.toString(n); 
                lb5.setText("Total Price-"+m);
		String s=e.getActionCommand();
		if(s.equals("Rent")){
			String q="insert into rent values(null,'"+m+"',CURRENT_TIMESTAMP)";

			System.out.println(q);
			DataAccess da=new DataAccess();
			int c=da.updateDB(q);
			JOptionPane.showMessageDialog(this,c+" row(s) updated");
			this.setVisible(false);
			pay.setVisible(true);
                        System.out.println(n);
		}
                
                }        
        
}

 

