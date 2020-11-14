package Game;

public class GamerB extends Player {

	public GamerB() {
		super();
		// TODO Auto-generated constructor stub
		this.choosing_Target_Cost = 10;
	}

	public GamerB(int gold, int max_Move, int move_Cost, int choosing_Target_Cost, int rows, int columns) {
		super(gold, max_Move, move_Cost, choosing_Target_Cost, rows, columns);
		// TODO Auto-generated constructor stub
	}
	public int[][] chooseTargetA(int sayac, int [][]GoldCoordinate, int[][]locationxyA)
	{	
		int [][] targetCoordinate = new int [1][2];
		int xuzak,yuzak;
		int [] totaluzak = new int[sayac];
		int enkucukuzak = 999999;
		
		for(int k=0;k<sayac;k++) {
			
			
			xuzak=GoldCoordinate[k][0]-locationxyA[0][0];
			yuzak=GoldCoordinate[k][1]-locationxyA[0][1];
			xuzak= Math.abs(xuzak);
			yuzak= Math.abs(yuzak);
			totaluzak[k]=xuzak+yuzak;
			
			 if(totaluzak[k]<enkucukuzak) {
				targetCoordinate[0][0]=GoldCoordinate[k][0];
				targetCoordinate[0][1]=GoldCoordinate[k][1];
				enkucukuzak=totaluzak[k];
			}
			
			 
		}
		return targetCoordinate;

	}
	

}