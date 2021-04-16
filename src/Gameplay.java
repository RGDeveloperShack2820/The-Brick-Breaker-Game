import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Gameplay extends JPanel implements KeyListener,ActionListener {

	//booleans variables
	private boolean play=false;
	private boolean Enter_pressed= false;
    private boolean pause=true;
    private boolean restart=false;
    
	//level dependent variables
	private int score_increment;
	private String level;
	private int paddle_movement;
	private int balldirX;
	private int balldirY;
	private int totalBricks;
	
	//initial setup variables
	private int paddleX=455;
	private int score=0;
	private int delay=1;
	private int ballposX=300;
	private int ballposY=500;
	
	//object variables
	private Timer timer;
	private Graphics2D g2d;
	private BricksGenerator brickmap;
	private Get_Level d;
	
	
	public Gameplay(int row,int column, int balldirX, int balldirY, int score_increment, String level, int paddle_movement) {
	    
		this.balldirX=balldirX;
		this.balldirY=balldirY;
		this.score_increment=score_increment;
		this.totalBricks=row*column;
		this.level=level;
		this.paddle_movement=paddle_movement;
		
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		
		timer= new Timer(delay, this);
		timer.start();
		
		brickmap=new BricksGenerator(row, column);
		d=new Get_Level();
	}
	
	public void paint(Graphics g) {


		//frame 
        g.setColor(Color.black);
		g.fillRect(5,5 , 1060, 760);
		
		
		//border
		
		g.setColor(Color.yellow);
		g.fillRect(0, 5, 5, 760);//left
		g.fillRect(0, 0, 1080, 5);//top
		g.fillRect(1061, 5, 5, 760);//right
		
		if (Enter_pressed==true) {

			System.out.println("in game");
			//scores
			g.setColor(Color.YELLOW);
			g.setFont(new Font("serif",Font.BOLD,20));
			g.drawString("Score : "+score, 950, 30);
			
			//levels
			g.setColor(Color.WHITE);
			g.setFont(new Font("serif",Font.BOLD,20));
			g.drawString("Level : "+level, 480, 30);
			
			
			//bricks
			brickmap.draw((Graphics2D)g);
			
			//paddle
			g.setColor(Color.cyan);
			g.fillRect(paddleX, 730, 150, 20);
	
			//pause Text
			if (pause==true) {
				
				System.out.println("paused");
				g.setFont(new Font("arial",Font.BOLD,20));
				g.drawString("PAUSED (Press Space TO Resume)",370 , 380);
			}
			
			//ball
			g.setColor(Color.orange);
			g.fillOval(ballposX, ballposY, 20, 20);
			
			
			//game over text
			if (ballposY>760) {
				
				System.out.println("gameover");
				play=false;
				balldirX=0;
				balldirY=0;
				restart=true;
				
				g.setColor(Color.RED);
				g.setFont(new Font("arial",Font.BOLD,40));
				g.drawString("GAME OVER",400 , 380);
				
				//restart
				g.setColor(Color.cyan);
				g.setFont( new Font("arial", Font.PLAIN, 15));
				g.drawString("Press Enter To Play Again..", 430, 420 );
				
			}
			
			// you won
			if (totalBricks==0) {
				
				System.out.println("you won");
				play=false;
				balldirX=0;
				balldirY=0;
				restart=true;
				
				g.setColor(Color.WHITE);
				g.setFont(new Font("cyberpunks",Font.PLAIN,70));
				g.drawString("$ YOU WON $",350 , 380);
				
				//restart
				g.setColor(Color.cyan);
				g.setFont( new Font("arial", Font.PLAIN, 15));
				g.drawString("Press Enter To Play Again..", 455, 420 );
				
			}
					
			
		}
		else {
			
			System.out.println("in Main Menu");
			//game name
			g.setColor(Color.WHITE);
			g.setFont(new Font("cyberpunks", Font.PLAIN, 50));
			g.drawString("The Brick Breaker", 330, 235);
			
			//play game
			g.setColor(Color.cyan);
			g.setFont( new Font("arial", Font.PLAIN, 25));
			g.drawString("Press Enter To Play...", 425, 350 );
			
			//signature
			g.setColor(Color.white);
			g.setFont( new Font("arial", Font.BOLD, 20));
			g.drawString("Developed By : Rohit Gupta", 790, 750);
			
			
			this.g2d=(Graphics2D)g;
			
			//game name container
			g2d.setColor(Color.WHITE);
			g2d.setStroke(new BasicStroke(10));
			g2d.drawRect(190, 150, 700, 150);
		}
		
		g.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
	    
		//Ball Movement
		if (pause==false) {
			
			//paddle and ball intersection
			if (new Rectangle(ballposX,ballposY,20,20).intersects(new Rectangle(paddleX,730,150,20)) ) {
				
				balldirY= -balldirY;
			}
			
			ball_movement_freeSpace();//ball movement in empty frame
			bricksCollisonCode();//detecting brick collision & removing the brick
		
			
	  }	
		repaint();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
	
	
	@Override
	public void keyPressed(KeyEvent e) {

		//handling paddle movement
		
		if (play==true&&pause==false) {
			
			//right movement
			if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
				if (paddleX >=911 ) {
					paddleX=911;
				}
				else {
					moveRight();
				}
			}
			
			//left movement
			if (e.getKeyCode()==KeyEvent.VK_LEFT) {
				if (paddleX <=5 ) {
					paddleX=5;
				}
				else {
					moveLeft();
				}
			}
		}
		else {
			

			if (e.getKeyCode()==KeyEvent.VK_ENTER) {
				
				if (restart==true) {
					

					play=false;
				    Enter_pressed= false;
				    pause=true;
				    restart=false;
				    
					 score=0;
					 paddleX=455;
			
					
					 ballposX=300;
					 ballposY=500;
					 System.out.println(level+"---------------------------------------------------------------------");
					 score_increment=d.getScoreIncrement(level);
				     paddle_movement=d.getPaddleMovement(level);
				     balldirX=d.getBalldirX(level);
					 balldirY=d.getBalldirY(level);
					 totalBricks=d.getTotalBricks(level);
					
					 brickmap=new BricksGenerator(d.getRows(level), d.getColumns(level));	
					 
					 System.out.println(d.getRows(level)+" "+d.getColumns(level)+" "+d.getBalldirX(level)+" "+d.getBalldirY(level)+" "+d.getScoreIncrement(level)+" "+d.getPaddleMovement(level));
					 
					
					
					
					
					
				}
				else {
					
					Enter_pressed=true;
					play=true;
				}
			}
			
		}
		
		if (Enter_pressed==true&&play==true) {
			
			if (e.getKeyCode()==KeyEvent.VK_SPACE) {

				if (pause==true) {
					
					pause=false;
					timer.start();	
				}
				else {
					
					pause= true;
					timer.stop();
					repaint();	
				}		
			}
		}
	}
	
	public void moveRight() {
		
		paddleX+=paddle_movement;
	}
	
    public void moveLeft() {
		
    	paddleX-=paddle_movement;
	}
    
    
    public void ball_movement_freeSpace() {
    	
	    	
			//initial movement
			ballposX+=balldirX;
			ballposY+=balldirY;
		
			//left border collision
		if (ballposX <=0) {
			
			balldirX= -balldirX;
		}
		  //Top border collision
		if (ballposY<=5) {
			
			balldirY= -balldirY;
		}
		  //right Border collision
		if (ballposX >=1040) {
	
			balldirX= -balldirX;
		}
}
    
    public void bricksCollisonCode() {
    	
     A:	for (int i = 0; i < brickmap.bricks.length; i++) {
			for (int j = 0; j < brickmap.bricks[0].length; j++) {
	          if(brickmap.bricks[i][j]>0) {
	        	  
	        	  int brickx= j*brickmap.brickWidth+140;
	        	  int bricky=  i*brickmap.brickHeight+80;
			
	        	  Rectangle brickRect= new Rectangle(brickx,bricky, brickmap.brickWidth, brickmap.brickHeight);
	        	  Rectangle ballRect= new Rectangle(ballposX, ballposY, 20, 20);
	        	 
	        	  
	        	  if (ballRect.intersects(brickRect)) {
					brickmap.setBrickValue(0, i, j);
					totalBricks--;
					score=score+score_increment;
					
					if (ballposX +19 <= brickx || ballposX +1 >=brickx + brickmap.brickWidth) {
						
						balldirX= -balldirX;
						
					}
					else {
						balldirY= -balldirY;
					}
					
					break A;
				}
			  }							
			}
		}
    }
}
