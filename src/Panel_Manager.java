import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Panel_Manager {
    
	JFrame b;
	Gameplay g ;
	Get_Level a;
	public Panel_Manager(boolean restart) {
		
		
		
		 JFrame f=new JFrame();
		 Difficulty d= new Difficulty();
         a=new Get_Level();
		 
		 JButton easy= new JButton("EASY");
		 easy.setBounds(415, 250, 250, 70);
		 easy.setBackground(Color.white);
		 easy.setFont(new Font("cyberpunks", Font.PLAIN, 30));
		 easy.setForeground(Color.black);
		 
		 
		 JButton intermediate= new JButton("INTERMEDIATE");
		 intermediate.setBounds(415, 340, 250, 70);
		 intermediate.setBackground(Color.white);
		 intermediate.setFont(new Font("cyberpunks", Font.PLAIN, 30));
		 intermediate.setForeground(Color.black);
		 
		 
		 JButton hard= new JButton("HARD");
		 hard.setBounds(415, 430, 250, 70);
		 hard.setBackground(Color.white);
		 hard.setFont(new Font("cyberpunks", Font.PLAIN, 30));
		 hard.setForeground(Color.black);
		 
		 
		 JButton legend= new JButton("LEGEND");
		 legend.setBounds(415, 520, 250, 70);
		 legend.setBackground(Color.white);
		 legend.setFont(new Font("cyberpunks", Font.PLAIN, 30));
		 legend.setForeground(Color.black);
		 
		 easy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				System.out.println("easy clicked");
			
				g =new Gameplay(a.getRows("Easy"),a.getColumns("Easy"),a.getBalldirX("Easy"),a.getBalldirY("Easy"),a.getScoreIncrement("Easy"),"Easy",a.getPaddleMovement("Easy"));
                f.dispose();
                b=new JFrame();

    		 	b.setTitle("The Brick Breaker");
    			b.setBounds(230,15 , 1080, 800);
    			b.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
    			b.setVisible(true);
    			b.setResizable(false);
    			b.add(g);
						
			}
		});
		 
		 
		
		 intermediate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				System.out.println("intermediate clicked");
				
			    g =new Gameplay(a.getRows("Intermediate"),a.getColumns("Intermediate"),a.getBalldirX("Intermediate"),a.getBalldirY("Intermediate"),a.getScoreIncrement("Intermediate"),"Intermediate",a.getPaddleMovement("Intermediate"));
	            f.dispose();
	            b=new JFrame();

	   		 	b.setTitle("The Brick Breaker");
	   			b.setBounds(230,15 , 1080, 800);
	   			b.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
	   			b.setVisible(true);
	   			b.setResizable(false);
				b.add(g);
				
			}
		});
		 
		
		 hard.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("hard clicked");
				
			   g =new Gameplay(a.getRows("Hard"),a.getColumns("Hard"),a.getBalldirX("Hard"),a.getBalldirY("Hard"),a.getScoreIncrement("Hard"),"Hard",a.getPaddleMovement("Hard"));
               f.dispose();
  			
               b=new JFrame();

   		 	b.setTitle("The Brick Breaker");
   			b.setBounds(230,15 , 1080, 800);
   			b.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
   			b.setVisible(true);
   			b.setResizable(false);
				b.add(g);
				
			}
		});
		 
		
		 legend.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("legend clicked");
				
				 g =new Gameplay(a.getRows("Legend"),a.getColumns("Legend"),a.getBalldirX("Legend"),a.getBalldirY("Legend"),a.getScoreIncrement("Legend"),"Legend",a.getPaddleMovement("Legend"));
               f.dispose();
               b=new JFrame();

   		 	b.setTitle("The Brick Breaker");
   			b.setBounds(230,15 , 1080, 800);
   			b.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
   			b.setVisible(true);
   			b.setResizable(false);
				b.add(g);
				
			}
		});
		 
		 	f.setTitle("The Brick Breaker");
			f.setBounds(230,15 , 1080, 800);
			f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
			f.setVisible(true);
			f.setResizable(false);
			f.add(easy);
			f.add(intermediate);
			f.add(hard);
			f.add(legend);
			f.add(d);
			
	}
}
