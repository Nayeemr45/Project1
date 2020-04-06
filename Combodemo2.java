import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class Combodemo2 extends Frame implements ItemListener{

	private Choice ch;
        private Update_avail up;
        private Assistant_show as;

	public Combodemo2(){
		super("Option");
                up=new Update_avail();
                as=new Assistant_show();
                ch=new Choice();
                
                ch.add("Select");
		ch.add("Show Rent Info");
		ch.add("Update Product availability");
                
		add(ch);
                
		ch.addItemListener(this);
                
		setSize(280,400);
		setLocation(700,250);;
                
		setLayout(new FlowLayout());
	}

	public void itemStateChanged(ItemEvent ie){
		String v=(String)ie.getItem();
               if(v.equals("Show Rent Info")){
                   as.setVisible(true);
              System.out.println("\n"+v+" selected");
               }else if(v.equals("Update Product availability")){
                   up.setVisible(true);
              System.out.println("\n"+v+" selected");
               }				
	}
        public void paint(Graphics g){
		g.setColor(new Color(198,222,225));
		g.fillRect(0,0,280,400);
	}
}
       