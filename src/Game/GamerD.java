package Game;

import javax.swing.JLabel;

public class GamerD extends Player {

	public GamerD() {
		super();
		// TODO Auto-generated constructor stub
		this.choosing_Target_Cost = 20;
	}

	public GamerD(int gold, int max_Move, int move_Cost, int choosing_Target_Cost, int rows, int columns) {
		super(gold, max_Move, move_Cost, choosing_Target_Cost, rows, columns);
		// TODO Auto-generated constructor stub
	}

	public int[][] chooseTargetD(int sayac, int [][]GoldCoordinate, int[][]locationxyD, JLabel [][] grid ,int [][]targetCoordinateA,
								 int [][]targetCoordinateB, int [][]targetCoordinateC, int hamleA, int hamleB, int hamleC){
	
		int [] hamleSayisi = new int[sayac];
		int [][] targetCoordinate = new int [1][2];
		int xuzak=0,yuzak=0;
		int [] totaluzak = new int[sayac];
		int adim=0,kalan;
		int [] uygunSecim = new int[sayac];
		int enMantikli=0;
		int [] targetK = new int[3];
		int targetABC=1;
	
		for(int k=0;k<sayac;k++) {
			xuzak=GoldCoordinate[k][0]-locationxyD[0][0];
			yuzak=GoldCoordinate[k][1]-locationxyD[0][1];
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
			hamleSayisi[k] = adim;
		}
		else {
			uygunSecim[k]=-10000;
		}
	}
		for(int k=0;k<sayac;k++) {
		
			if(uygunSecim[k]>enMantikli) {
				targetK[0]=k;
				enMantikli=uygunSecim[k];
		}	
	}
			
		targetCoordinate[0][0] = GoldCoordinate[targetK[0]][0];
		targetCoordinate[0][1] = GoldCoordinate[targetK[0]][1];
		
		// |--------------------------------------|
		// |Diðer hamlelere göre hedef belirleme :|
		// |--------------------------------------|
		for(int deneABC = 0 ; deneABC < 3; deneABC++) {
		if(targetCoordinateA==targetCoordinate || targetCoordinateB==targetCoordinate || targetCoordinateC==targetCoordinate) {
			if(hamleSayisi[targetK[deneABC]] > hamleA || hamleSayisi[targetK[deneABC]] > hamleB || hamleSayisi[targetK[deneABC]] > hamleC) {
				
				for(int k=0;k<sayac;k++) {
					xuzak=GoldCoordinate[k][0]-locationxyD[0][0];
					yuzak=GoldCoordinate[k][1]-locationxyD[0][1];
					xuzak= Math.abs(xuzak);
					yuzak= Math.abs(yuzak);
					totaluzak[k]=xuzak+yuzak;
					adim=totaluzak[k]/3;
					kalan=totaluzak[k]%3;
				if(kalan!=0) {
					adim++;
				}
				if(GoldCoordinate[k][0]!= 99 && GoldCoordinate[k][1] != 99 && 
						GoldCoordinate[k][0] != GoldCoordinate[targetK[0]][0] && GoldCoordinate[k][1] != GoldCoordinate[targetK[0]][1] &&
								GoldCoordinate[k][0] != GoldCoordinate[targetK[1]][0] && GoldCoordinate[k][1] != GoldCoordinate[targetK[1]][1] &&
									GoldCoordinate[k][0] != GoldCoordinate[targetK[2]][0] && GoldCoordinate[k][1] != GoldCoordinate[targetK[2]][1]) {
					uygunSecim[k] = Integer.parseInt(grid[GoldCoordinate[k][0]][GoldCoordinate[k][1]].getText())-(adim*5);
					hamleSayisi[k] = adim;
				}
				else {
					uygunSecim[k]=-10000;
				}
			}
				for(int k=0;k<sayac;k++) {
				
					if(uygunSecim[k]>enMantikli) {
						targetK[targetABC]=k;
						enMantikli=uygunSecim[k];
				}				 
			}
				targetCoordinate[0][0] = GoldCoordinate[targetK[targetABC]][0];
				targetCoordinate[0][1] = GoldCoordinate[targetK[targetABC]][1];
				targetABC++;
			}
		}
		}
	
		return targetCoordinate;
	}


	
	
	
	
	
}
