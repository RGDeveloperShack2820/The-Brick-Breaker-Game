import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class BricksGenerator {

   public int[][] bricks;
   public int brickWidth;
   public int brickHeight;
   
   
   public BricksGenerator(int row , int column) {
	   
	   bricks= new int[row][column];
	   
	   for (int i = 0; i < bricks.length; i++) {
		for (int j = 0; j < bricks[0].length; j++) {
			
			bricks[i][j]=1;
		}
	}
	   
	   brickWidth=800/column;
	   brickHeight=200/row;
   }
   
   public void draw(Graphics2D g2d) {
	   
	   for (int i = 0; i < bricks.length; i++) {
			for (int j = 0; j < bricks[0].length; j++) {
				
				if(bricks[i][j]>0) {
				g2d.setColor(Color.white);
				g2d.fillRect(j*brickWidth+140, i*brickHeight+80, brickWidth, brickHeight);
				
				g2d.setStroke(new BasicStroke(3));
				g2d.setColor(Color.black);
				g2d.drawRect(j*brickWidth+140, i*brickHeight+80, brickWidth, brickHeight);
			
				}
			}	
		}
   }
   
   public void setBrickValue(int vlaue, int row ,int column) {
	   
	   bricks[row][column]=vlaue;
   }
}
