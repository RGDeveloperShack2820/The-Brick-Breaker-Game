

public class Get_Level{
		
		public int getScoreIncrement(String level){
			
			switch(level)
			{
				case "Easy":
					 return 4;
			    
				case "Intermediate":
					 return 4;
					 
				case "Hard":
					 return 5;
					 
				case "Legend":
					 return 10;
				
				default : return 0;	 
			}
		}
		
		public int getPaddleMovement(String level){
			
			switch(level)
			{
				case "Easy":
					 return 30;
			    
				case "Intermediate":
					 return 35;
					 
				case "Hard":
					 return 40;
					 
				case "Legend":
					 return 45;
				
				default : return 0;	 
			}
		}
		
		public int getBalldirX(String level){
			
			switch(level)
			{
				case "Easy":
					 return -3;
			    
				case "Intermediate":
					 return -4;
					 
				case "Hard":
					 return -5;
					 
				case "Legend":
					 return -6;
				
				default : return 0;	 
			}
		}
	
		public int getBalldirY(String level){
			
			switch(level)
			{
				case "Easy":
					 return -4;
			    
				case "Intermediate":
					 return -5;
					 
				case "Hard":
					 return -6;
					 
				case "Legend":
					 return -7;
				
				default : return 0;	 
			}
		}
		
		public int getTotalBricks(String level){
			
			switch(level)
			{
				case "Easy":
					 return getRows("Easy")*getColumns("Easy");
			    
				case "Intermediate":
					 return getRows("Intermediate")*getColumns("Intermediate");
					 
				case "Hard":
					 return getRows("Hard")*getColumns("Hard");
					 
				case "Legend":
					 return getRows("Legend")*getColumns("Legend");
				
				default : return 0;	 
			}
		}
		
		public int getRows(String level){
			
			switch(level)
			{
				case "Easy":
					 return 3;
			    
				case "Intermediate":
					 return 5;
					 
				case "Hard":
					 return 7;
					 
				case "Legend":
					 return 9;
				
				default : return 0;	 
			}
		}
		
		public int getColumns(String level){
			
			switch(level)
			{
				case "Easy":
					 return 5;
			    
				case "Intermediate":
					 return 6;
					 
				case "Hard":
					 return 6;
					 
				case "Legend":
					 return 7;
				
				default : return 0;	 
			}
		}
	
	
	
	
	
}
