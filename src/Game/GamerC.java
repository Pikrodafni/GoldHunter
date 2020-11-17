package Game;

import javax.swing.JLabel;

public class GamerC extends Player {

	public GamerC() {
		super();
		// TODO Auto-generated constructor stub
		this.choosing_Target_Cost = 15;
	}

	public GamerC(int gold, int max_Move, int move_Cost, int choosing_Target_Cost, int rows, int columns) {
		super(gold, max_Move, move_Cost, choosing_Target_Cost, rows, columns);
		// TODO Auto-generated constructor stub
	}
	
	public int[][] chooseTargetC(int sayac, int [][]GoldCoordinate, int[][]locationxyB, JLabel [][] grid)
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
	
	public int[][] openSecretGold(int sayac,int sayac2, int [][]GoldCoordinate,int [][]SecretGoldCoordinate, int[][]locationxyB, JLabel [][] grid)
	{
		int [][] openGold = new int [1][2];
		int xuzak=0,yuzak=0,enyakin=9999,targetK=0;
		int [] totaluzak = new int[sayac2];
		
		for(int k=0;k<sayac2;k++) {
			
			xuzak=SecretGoldCoordinate[k][0]-locationxyB[0][0];
			yuzak=SecretGoldCoordinate[k][1]-locationxyB[0][1];
			xuzak= Math.abs(xuzak);
			yuzak= Math.abs(yuzak);
			totaluzak[k]=xuzak+yuzak;
			
			if(totaluzak[k]<enyakin) {
				enyakin=totaluzak[k];
				targetK=k;
				
			}
			
		}
		
		openGold[0][0] = SecretGoldCoordinate[targetK][0];
		openGold[0][1] = SecretGoldCoordinate[targetK][1];
		
		//System.out.println(SecretGoldCoordinate[targetK][0]+" "+SecretGoldCoordinate[targetK][1]+"opengold");
		return openGold;

	}

	public int adimSayisiC(int sayac, int [][]GoldCoordinate, int[][]locationxyC , JLabel [][] grid) {
		
		int [] hamleSayisi = new int[sayac];
		int [][] targetCoordinate = new int [1][2];
		int xuzak=0,yuzak=0;
		int [] totaluzak = new int[sayac];
		int adim=0,kalan;
		int [] uygunSecim = new int[sayac];
		int enMantikli=0;
		int targetK=0;
		
		for(int k=0;k<sayac;k++) {
			xuzak=GoldCoordinate[k][0]-locationxyC[0][0];
			yuzak=GoldCoordinate[k][1]-locationxyC[0][1];
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
				targetK=k;
				enMantikli=uygunSecim[k];
			}				 
		}
				
		targetCoordinate[0][0] = GoldCoordinate[targetK][0];
		targetCoordinate[0][1] = GoldCoordinate[targetK][1];
		
		return hamleSayisi[targetK];
	}
	
	
}