package Game;

import javax.swing.JLabel;

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
	public int[][] chooseTargetB(int sayac, int [][]GoldCoordinate, int[][]locationxyB, JLabel [][] grid)
	{
		int [][] targetCoordinate = new int [1][2];
		int xuzak=0,yuzak=0;
		int [] totaluzak = new int[sayac];
		int adim=0,kalan;
		int [] uygunSecim = new int[sayac];
		int enMantikli=-10000;
		int targetK=0;
		
		for(int k=0;k<sayac;k++) {
			xuzak=GoldCoordinate[k][0]-locationxyB[0][0];
			yuzak=GoldCoordinate[k][1]-locationxyB[0][1];
			xuzak= Math.abs(xuzak);
			yuzak= Math.abs(yuzak);
			totaluzak[k]=xuzak+yuzak;
			adim=totaluzak[k]/3;
			kalan=totaluzak[k]%3;
			if(kalan!=0) {
				adim++;
			}
			if(GoldCoordinate[k][0]!= 99 && GoldCoordinate[k][1] != 99) {
			uygunSecim[k] = Integer.parseInt(grid[GoldCoordinate[k][0]][GoldCoordinate[k][1]].getText())-(adim*5);
			}
			else {
				uygunSecim[k]=-10000;
			}
		}
		for(int k=0;k<sayac;k++) {
			
			if(uygunSecim[k]>enMantikli) {
				targetK=k;
				enMantikli=uygunSecim[k];
			}				 
		}
				
		targetCoordinate[0][0] = GoldCoordinate[targetK][0];
		targetCoordinate[0][1] = GoldCoordinate[targetK][1];
				
		return targetCoordinate;

	}
	
	public int adimSayisiB(int sayac, int [][]GoldCoordinate, int[][]locationxyB , JLabel [][] grid) {
		
		int [] hamleSayisi = new int[sayac];
		int [][] targetCoordinate = new int [1][2];
		int xuzak=0,yuzak=0;
		int [] totaluzak = new int[sayac];
		int adim=0,kalan;
		int [] uygunSecim = new int[sayac];
		int enMantikli=0;
		int targetK=0;
		
		for(int k=0;k<sayac;k++) {
			xuzak=GoldCoordinate[k][0]-locationxyB[0][0];
			yuzak=GoldCoordinate[k][1]-locationxyB[0][1];
			xuzak= Math.abs(xuzak);
			yuzak= Math.abs(yuzak);
			totaluzak[k]=xuzak+yuzak;
			adim=totaluzak[k]/3;
			kalan=totaluzak[k]%3;
			if(kalan!=0) {
				adim++;
			}
			if(GoldCoordinate[k][0] != 99 && GoldCoordinate[k][1] != 99) {
			uygunSecim[k] = Integer.parseInt(grid[GoldCoordinate[k][0]][GoldCoordinate[k][1]].getText())-(adim*5);
			hamleSayisi[k] = adim;
			}
			else {
				uygunSecim[k]=-10000;
			}
		}
		for(int k=0;k<sayac;k++) {
			
			if(uygunSecim[k]>enMantikli) {
				targetK=k;
				enMantikli=uygunSecim[k];
			}				 
		}
				
		targetCoordinate[0][0] = GoldCoordinate[targetK][0];
		targetCoordinate[0][1] = GoldCoordinate[targetK][1];
		
		return hamleSayisi[targetK];
	}

}