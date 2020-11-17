package Game;

public class GamerA extends Player {

	public GamerA() {
		super();
		// TODO Auto-generated constructor stub
		this.choosing_Target_Cost = 5;
	}

	public GamerA(int gold, int max_Move, int move_Cost, int choosing_Target_Cost, int rows, int columns) {
		super(gold, max_Move, move_Cost, choosing_Target_Cost, rows, columns);
		// TODO Auto-generated constructor stub
	}
	
	public int[][] chooseTargetA(int sayac, int [][]GoldCoordinate, int[][]locationxyA)
	{
		int [][] targetCoordinate = new int [1][2];
		int xuzak,yuzak,totaluzak;
		int enkucukuzak = 999999999;
		
		for(int k=0;k<sayac;k++) {
			
			
			xuzak=GoldCoordinate[k][0]-locationxyA[0][0];
			yuzak=GoldCoordinate[k][1]-locationxyA[0][1];
			xuzak= Math.abs(xuzak);
			yuzak= Math.abs(yuzak);
			totaluzak=xuzak+yuzak;
			
			 if(totaluzak<enkucukuzak) {
				targetCoordinate[0][0]=GoldCoordinate[k][0];
				targetCoordinate[0][1]=GoldCoordinate[k][1];
				enkucukuzak=totaluzak;
			}
			
			 
		}
		return targetCoordinate;

	}
	
	public int adimSayisiA(int sayac, int [][]GoldCoordinate, int[][]locationxyA)
	{	
		int [] hamleSayisi = new int[sayac];
		int [][] targetCoordinate = new int [1][2];
		int xuzak,yuzak;
		int [] totaluzak = new int[sayac];
		int enkucukuzak = 999999999;
		int adim=0,kalan,targetK=0;
		for(int k=0;k<sayac;k++) {
			
			
			xuzak=GoldCoordinate[k][0]-locationxyA[0][0];
			yuzak=GoldCoordinate[k][1]-locationxyA[0][1];
			xuzak= Math.abs(xuzak);
			yuzak= Math.abs(yuzak);
			totaluzak[k]=xuzak+yuzak;
			adim=totaluzak[k]/3;
			kalan=totaluzak[k]%3;
			if(kalan!=0) {
				adim++;
			}
			hamleSayisi[k] = adim;
			
			 if(totaluzak[k]<enkucukuzak) {
				targetCoordinate[0][0]=GoldCoordinate[k][0];
				targetCoordinate[0][1]=GoldCoordinate[k][1];
				enkucukuzak=totaluzak[k];
				targetK=k;
			}
			
			 
		}
		return hamleSayisi[targetK];

	}
	

}
