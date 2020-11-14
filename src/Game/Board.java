package Game;

public class Board {
	
	// Variables
	// -------------------------------------------------------------
	
	public int rows;
	public int columns;
	public int gold_Number;
	public int gold_Rate;
	public int secret_Gold_Rate;
	public int secret_Gold_Number;
	public int [] gold_Value;
	
	// -------------------------------------------------------------
	// Constructor 
	// -------------------------------------------------------------
	public Board(int rows, int columns, int gold_Rate, int secret_Gold_Rate, int gold_Number, int secret_Gold_Number, int [] gold_Value) {
		super();
		this.rows = rows;
		this.columns = columns;
		this.gold_Rate = gold_Rate;
		this.secret_Gold_Rate = secret_Gold_Rate;
		this.gold_Number = gold_Number;
		this.secret_Gold_Number = secret_Gold_Number;
		this.gold_Value= gold_Value;
	}
	// -------------------------------------------------------------
	// Default Values
	// -------------------------------------------------------------
	public Board()
	{
		this.rows = 10;
		this.columns = 20;
		this.gold_Rate = 20;
		this.secret_Gold_Rate = 10;
		this.gold_Number = rows*columns*gold_Rate/100;
		this.secret_Gold_Number = gold_Number*secret_Gold_Rate/100;
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
	public float getGold_Rate() {
		return gold_Rate;
	}
	public void setGold_Rate(int gold_Rate) {
		this.gold_Rate = gold_Rate;
	}
	public int getSecret_Gold_Rate() {
		return secret_Gold_Rate;
	}
	public void setSecret_Gold_Rate(int secret_Gold_Rate) {
		this.secret_Gold_Rate = secret_Gold_Rate;
	}
	public int getGold_Number() {
		return gold_Number;
	}
	public void setGold_Number(int gold_Number) {
		this.gold_Number = gold_Number;
	}
	public int getSecret_Gold_Number() {
		return secret_Gold_Number;
	}
	public void setSecret_Gold_Number(int secret_Gold_Number) {
		this.secret_Gold_Number = secret_Gold_Number;
	}
	public int[] getGold_Value() {
		return gold_Value;
	}
	public void setGold_Value(int[] gold_Value) {
		this.gold_Value = gold_Value;
	}
	
	
	
	// -------------------------------------------------------------

	
}
