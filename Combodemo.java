import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class Combodemo extends Frame implements ItemListener{

	private Choice ch;
        private Delete_rent dr;
        private Update_price up;
        private Admin_show as;
		private Show_customer sc;

	public Combodemo(){
		super("Option");
                
                dr=new Delete_rent();
                up=new Update_price();
                as=new Admin_show();
                sc=new Show_customer();
				
                ch=new Choice();
                
        ch.add("Select");
		ch.add("Show Payment Info");
		ch.add("Show Customer Info");
		ch.add("Update Price");
		ch.add("Delete Rent");
                
		add(ch);
                
		ch.addItemListener(this);
                
		setSize(280,400);
		setLocation(700,250);
                
		setLayout(new FlowLayout());
	}

	public void itemStateChanged(ItemEvent ie){
		String v=(String)ie.getItem();
               if(v.equals("Show Payment Info")){
                   as.setVisible(true);
              System.out.println("\n"+v+" selected");
               }else if(v.equals("Show Customer Info")){
                   sc.setVisible(true);
              System.out.println("\n"+v+" selected");
               }else if(v.equals("Update Price")){
                   up.setVisible(true);
              System.out.println("\n"+v+" selected");
               }else if(v.equals("Delete Rent")){
                   dr.setVisible(true);
              System.out.println("\n"+v+" selected");
               }				
	}
        public void paint(Graphics g){
		g.setColor(new Color(198,222,225));
		g.fillRect(0,0,280,400);
	}
}
       