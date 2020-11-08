package Game;

public class Board {
	
	// Variables
	// -------------------------------------------------------------
	
	public int rows;
	public int columns;
	public float gold_Rate;
	public float secret_Gold_Rate;
	
	// -------------------------------------------------------------
	// Constructor 
	// -------------------------------------------------------------
	public Board(int rows, int columns, float gold_Rate, float secret_Gold_Rate) {
		super();
		this.rows = rows;
		this.columns = columns;
		this.gold_Rate = gold_Rate;
		this.secret_Gold_Rate = secret_Gold_Rate;
	}
	// -------------------------------------------------------------
	// Default Values
	// -------------------------------------------------------------
	public Board()
	{
		this.rows = 20;
		this.columns = 20;
		this.gold_Rate = 20/100;
		this.secret_Gold_Rate = 10/100;
	}
	// -------------------------------------------------------------
	// Field of Getters and Setters
	// -------------------------------------------------------------
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getColumns() {
		return columns;
	}
	public void setColumns(int columns) {
		this.columns = columns;
	}
	// -------------------------------------------------------------
	/*public int[][] gold_Placement(int location[][]) {
		
		location[][] = null;
		return location;
	}*/
	
}
