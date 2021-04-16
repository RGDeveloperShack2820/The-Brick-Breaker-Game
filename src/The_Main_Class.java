import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

class Difficulty extends JPanel{
	
	public void paint(Graphics g) {

		//frame 
        g.setColor(Color.black);
		g.fillRect(5,5 , 1060, 760);
		
		
		//border
		
		g.setColor(Color.yellow);
		g.fillRect(0, 5, 5, 760);//left
		g.fillRect(0, 0, 1080, 5);//top
		g.fillRect(1061, 5, 5, 760);//right
		
		//text
		g.setColor(Color.white);
		g.setFont( new Font("cyberpunks", Font.PLAIN, 50));
		g.drawString("Choose Your Difficulty :", 250, 100);
				
	}
	
}
public class The_Main_Class {
 
public static void main(String[] args) {
		
		Panel_Manager p=new Panel_Manager(false);

			
   }

}
