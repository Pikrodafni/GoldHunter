package Game;

public class Player extends Menu{
	
	// Variables deneme1
	// -------------------------------------------------------------
	public int gold;
	public int max_Move;
	public int move_Cost;
	public int choosing_Target_Cost;
	// -------------------------------------------------------------
	// Constructor
	// -------------------------------------------------------------
	public Player(int gold, int max_Move, int move_Cost, int choosing_Target_Cost, int rows, int columns) {
		super();
		this.gold = gold;
		this.max_Move = max_Move;
		this.move_Cost = move_Cost;
		this.choosing_Target_Cost = choosing_Target_Cost;
		
	}
	// -------------------------------------------------------------
	// Default Values
	// -------------------------------------------------------------
	public Player()
	{
		this.gold = 200;
		this.max_Move = 3;
		this.move_Cost = 5;
	}
	// -------------------------------------------------------------
	// Field of Getters and Setters
	// -------------------------------------------------------------
	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getMax_Move() {
		return max_Move;
	}

	public void setMax_Move(int max_Move) {
		this.max_Move = max_Move;
	}

	public int getMove_Cost() {
		return move_Cost;
	}

	public void setMove_Cost(int move_Cost) {
		this.move_Cost = move_Cost;
	}

	public int getChoosing_Target_Cost() {
		return choosing_Target_Cost;
	}

	public void setChoosing_Target_Cost(int choosing_Target_Cost) {
		this.choosing_Target_Cost = choosing_Target_Cost;
	}
	
	// -------------------------------------------------------------
	// deneme2
	
}
