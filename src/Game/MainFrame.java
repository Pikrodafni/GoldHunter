package Game;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	
	// -----------------------------------------------------------------
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	int sayac=0,sayac2=0;
	int [][] targetCoordinate = new int [1][2];
	int [][] locationxyA= new int [1][2];
	GamerA gmA = new GamerA();
	Player gamerA = new GamerA();
	int totalGoldA = gamerA.getGold();
	int targetLengthx,targetLengthy;
	int moveA = 0;
	
	Player gamerB = new GamerB();
	GamerB gmB = new GamerB();
	int [][] targetCoordinateB = new int [1][2];
	int [][] locationxyB= new int [1][2];

	int totalGoldB = gamerB.getGold();
	int moveB = 0;
	int targetLengthxB,targetLengthyB;

	Player gamerC = new GamerC();
	GamerC gmC = new GamerC();
	int [][] targetCoordinateC = new int [1][2];
	int [][] openSecretGold = new int [1][2];
	int [][] locationxyC= new int [1][2];
	
	int totalGoldC = gamerC.getGold();
	int moveC = 0;
	int targetLengthxC,targetLengthyC;

	int tmp=0;
	Player gamerD = new GamerD();
	GamerD gmD = new GamerD();
	int [][] targetCoordinateD = new int [1][2];
	int [][] locationxyD= new int [1][2];

	int totalGoldD = gamerD.getGold();
	int moveD = 0;
	int targetLengthxD,targetLengthyD;

	public MainFrame() {
		int tahtax=600;
		int tahtay=600;
		
		GamerA PlayerA = new GamerA();
		
		Board GameBoard = new Board();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, tahtax+100, tahtay+100);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		// -----------------------------------------------------------------
		// Get Random Number 1-397
		int total_Gold = GameBoard.getGold_Number();
		int total_Secret_Gold = GameBoard.getSecret_Gold_Number();
		int tRows = GameBoard.getRows();
		int tColumns= GameBoard.getColumns();
		ArrayList<Integer> gColumns = new ArrayList<Integer>();
		ArrayList<Integer> gRows = new ArrayList<Integer>();
		int [] randomNum1 = new int[total_Gold];
		int [] randomNum2 = new int[total_Secret_Gold];
		int value=0;
		int value2=0;
		boolean tf1 = false;
		boolean tf2 = false;
		
		for(int r=0;r<total_Gold+1;r++) {
			
			int temporaryRandomInt=(int)(Math.random() * (tRows*tColumns-5) + 1);
			int secret_RandomInt=(int)(Math.random() * (total_Gold-1) + 1);
			
			for(int g=0;g<total_Gold;g++) {
				if(randomNum1[g]==temporaryRandomInt)
				{
					tf1=true;
					r--;
				}
			}
			for(int h=0;h<total_Secret_Gold;h++)
			{
				if(randomNum2[h]==secret_RandomInt)
				{
					tf2=true;
					r--;
				}
			}
			if(tf1==false) {
			randomNum1[value]=temporaryRandomInt;
			
			value++;
			}
			tf1=false;
			if(tf2==false && value2!=total_Secret_Gold) {
				randomNum2[value2]=secret_RandomInt;
				System.out.println("Random SEc NUM:"+(r+1)+" "+randomNum2[value2]);
				value2++;
				}
				tf2=false;
			if(value==total_Gold) {
				break;
			}
		}
		// -----------------------------------------------------------------
       	ArrayList<Integer> goldCoordinate = new ArrayList<Integer>();
    		for(int i=1;i<(tRows*tColumns-1);i++) {
    			goldCoordinate.add(i);
    		}
    		goldCoordinate.remove(tRows-2);
    		goldCoordinate.remove((tColumns-1)*tRows-2);
    		
		int i=0,j=0;
		// -----------------------------------------------------------------
		// GoldRandom
		
		// -----------------------------------------------------------------
		// GAME PANEL
		
		JPanel GamePanel = new JPanel();
		GamePanel.setBounds(0, 0, 584, 561);
		contentPane.add(GamePanel);
		GamePanel.setVisible(true);
		GamePanel.setLayout(new GridLayout(tColumns,tRows));	
		GamePanel.setBackground(Color.DARK_GRAY);
		
		JLabel[][] grid = new JLabel[tColumns][tRows];
		int [][] GoldCoordinate = new int[total_Gold][2];
		int [][] SecretGoldCoordinate = new int[total_Gold][2];
		int [] goldValue = {5,10,15,20};
		
		
		
		String s = String.valueOf(false);
		boolean girdimi = false;
		int ata = 0;
	
		
		for(i=0;i<tColumns;i++) {
			
			for(j=0;j<tRows;j++) {
					
				grid[i][j] = new JLabel("");
                grid[i][j].setBorder(new LineBorder(Color.BLACK));
                GamePanel.add(grid[i][j]);
                			
			for(int k1=0;k1<total_Gold;k1++) {
				
			if(((i*tRows)+j)==goldCoordinate.get(randomNum1[k1])) {
					
					s=String.valueOf(goldValue[ata]);
					grid[i][j].setText(s);
					grid[i][j].setForeground(Color.YELLOW);
	                grid[i][j].setHorizontalAlignment(SwingConstants.CENTER);
	                ata++;
	                if(ata==4) {
	                	ata=0;
	                }
                
                GamePanel.add(grid[i][j]);
                
                for(int k2=0;k2<total_Secret_Gold;k2++) {
                    if(k1==randomNum2[k2]) {
                    	grid[i][j].setFont(new java.awt.Font("Lucida Grande", 1, 0));
                    	SecretGoldCoordinate[sayac2][0]=i;
                    	SecretGoldCoordinate[sayac2][1]=j;
                      	//System.out.println("secretGoldCoordinate:"+SecretGoldCoordinate[sayac2][0]+" "+	SecretGoldCoordinate[sayac2][1]);
                    	sayac2++;
                    	girdimi=true;
      
                    	}
                    
                    }
                    if(	girdimi==false) {
                    	GoldCoordinate[sayac][0]=i;
                        GoldCoordinate[sayac][1]=j;
                        sayac++;
                    }
                

                    girdimi=false;
                 
						}
					}
				}
			}
		System.out.println("sayyac:"+sayac);
		// -----------------------------------------------------------------
		// -----------------------------------------------------------------
 		grid[0][0].setText("0");
		grid[0][0].setForeground(Color.RED);
		grid[0][0].setHorizontalAlignment(SwingConstants.CENTER);
			
		
		locationxyA [0][0]=0;
		locationxyA [0][1]=0;
		
		locationxyB [0][0]=0;
		locationxyB [0][1]=9;
	
		locationxyC [0][0]=tColumns-1;
		locationxyC [0][1]=tRows-1;
		
		locationxyD [0][0]=tColumns-1;
		locationxyD [0][1]=0;

		
		// -----------------------------------------------------------------
		// A için altýn hedefi belirleme :
		// -----------------------------------------------------------------
		targetCoordinate[0][0]=0;
		targetCoordinate[0][1]=0;
		
		targetCoordinateB[0][0]=0;
		targetCoordinateB[0][1]=9;
		
		targetCoordinateC[0][0]=tColumns-1;
		targetCoordinateC[0][1]=tRows-1;
		
		targetCoordinateD[0][0]=tColumns-1;
		targetCoordinateD[0][1]=0;
		
		Timer timer = new Timer();
		TimerTask sayacTimerTask = new TimerTask() {
            
            int i=0,j=0,k=0;
            boolean devam=false;
            public void run() {  
 

   for(i=0;i<total_Gold;i++) {
	   if(GoldCoordinate[i][0]!=99 && GoldCoordinate[i][1]!=99) {
		   devam=true;
	   }
   }
            	if(devam==true) {
            		
            	
        		//for(int b=0;b<12;b++) {
        			
        			if( locationxyA[0][1]==targetCoordinate[0][1] && locationxyA[0][0]==targetCoordinate[0][0]  ) {	
        				
        				targetCoordinate = gmA.chooseTargetA(total_Gold,GoldCoordinate,locationxyA);
        				totalGoldA=totalGoldA-gmA.getChoosing_Target_Cost();// hedef belirleme maaliyeti
        				
        				}
        			//System.out.println("b :" + b);
        			System.out.println("gidileceklerA "+targetCoordinate[0][0]+" "+targetCoordinate[0][1]);
        			
        			targetLengthx = targetCoordinate[0][0] - locationxyA[0][0];
        			targetLengthy = targetCoordinate[0][1] - locationxyA[0][1];
        			
        		if(targetLengthx > 0) {
        		while(locationxyA[0][0]!=targetCoordinate[0][0] && moveA!=3) {
        			locationxyA[0][0]=locationxyA[0][0]+1;
        			grid[locationxyA[0][0]][locationxyA[0][1]].setBorder(new LineBorder(Color.CYAN));
        			grid[locationxyA[0][0]][locationxyA[0][1]].setForeground(Color.RED);
        			grid[locationxyA[0][0]][locationxyA[0][1]].setHorizontalAlignment(SwingConstants.CENTER);
        			moveA++;
        			
        		}
        		}
        		else {
        			while(locationxyA[0][0]!=targetCoordinate[0][0] && moveA!=3) {
        				locationxyA[0][0]=locationxyA[0][0]-1;
        				grid[locationxyA[0][0]][locationxyA[0][1]].setBorder(new LineBorder(Color.CYAN));
        				grid[locationxyA[0][0]][locationxyA[0][1]].setForeground(Color.RED);
        				grid[locationxyA[0][0]][locationxyA[0][1]].setHorizontalAlignment(SwingConstants.CENTER);
        				moveA++;
        			
        			}
        			
        		}
        		if(targetLengthy > 0) {
        		while(locationxyA[0][1]!=targetCoordinate[0][1] && moveA!=3) {
        			locationxyA[0][1]=locationxyA[0][1]+1;
        			grid[locationxyA[0][0]][locationxyA[0][1]].setBorder(new LineBorder(Color.CYAN));
        			grid[locationxyA[0][0]][locationxyA[0][1]].setForeground(Color.RED);
        			grid[locationxyA[0][0]][locationxyA[0][1]].setHorizontalAlignment(SwingConstants.CENTER);
        			moveA++;
        		
        		}
        		}else {
        			while(locationxyA[0][1]!=targetCoordinate[0][1] && moveA!=3) {
        				locationxyA[0][1]=locationxyA[0][1]-1;
        				grid[locationxyA[0][0]][locationxyA[0][1]].setBorder(new LineBorder(Color.CYAN));
        				grid[locationxyA[0][0]][locationxyA[0][1]].setForeground(Color.RED);
        				grid[locationxyA[0][0]][locationxyA[0][1]].setHorizontalAlignment(SwingConstants.CENTER);
        				moveA++;
        		
        			}
        		}
        		
        		if(locationxyA[0][1]==targetCoordinate[0][1] && locationxyA[0][0]==targetCoordinate[0][0]) {
        			
        		totalGoldA=totalGoldA+Integer.parseInt(grid[targetCoordinate[0][0]][targetCoordinate[0][1]].getText());
        		
        		for(int a=0;a<total_Gold;a++) {
        			if(GoldCoordinate[a][0]==targetCoordinate[0][0] && GoldCoordinate[a][1]==targetCoordinate[0][1]) {
        				GoldCoordinate[a][0]=99;
        				GoldCoordinate[a][1]=99;
        				
        				if(targetCoordinate[0][0]==targetCoordinateB[0][0]&&targetCoordinate[0][1]==targetCoordinateB[0][1] ){
							targetCoordinateB[0][0]=locationxyB[0][0];
							targetCoordinateB[0][1]=locationxyB[0][1];
						}
						if(targetCoordinate[0][0]==targetCoordinateC[0][0]&&targetCoordinate[0][1]==targetCoordinateC[0][1] ){
							targetCoordinateC[0][0]=locationxyC[0][0];
							targetCoordinateC[0][1]=locationxyC[0][1];
						}
						if(targetCoordinate[0][0]==targetCoordinateD[0][0]&&targetCoordinate[0][1]==targetCoordinateD[0][1] ){
							targetCoordinateD[0][0]=locationxyD[0][0];
							targetCoordinateD[0][1]=locationxyD[0][1];
						}
        			}
        		}
        		
        		}
        		totalGoldA=totalGoldA-gmA.getMove_Cost();//adým atma maaliyeti
        		System.out.println("TotalA"+totalGoldA);
        		moveA = 0;			
        		//}
        	
        		
        		
        		// -----------------------------------------------------------------
        		// B için altýn hedefi belirleme :
        		// -----------------------------------------------------------------
        		
        		grid[0][tRows-1].setText("0");
        		grid[0][tRows-1].setForeground(Color.RED);
        		grid[0][tRows-1].setHorizontalAlignment(SwingConstants.CENTER);
        		
        		
        		
        		//for(int b=0;b<12;b++) {
        			//System.out.println("lokasyonx:"+locationxyB[0][0]+"lokasyony"+locationxyB[0][1]);
        			//System.out.println("gidilecekler "+targetCoordinateB[0][0]+" "+targetCoordinateB[0][1]);
        			if( locationxyB[0][1]==targetCoordinateB[0][1] && locationxyB[0][0]==targetCoordinateB[0][0] ) {
        				
        				targetCoordinateB = gmB.chooseTargetB(total_Gold,GoldCoordinate,locationxyB,grid);
        				totalGoldB=totalGoldB-gmB.getChoosing_Target_Cost();// hedef belirleme maaliyeti
        				}
        			//System.out.println("b :" + b);
        			System.out.println("gidileceklerB "+targetCoordinateB[0][0]+" "+targetCoordinateB[0][1]);
        			
        			targetLengthxB = targetCoordinateB[0][0] - locationxyB[0][0];
        			targetLengthyB = targetCoordinateB[0][1] - locationxyB[0][1];
        			
        		if(targetLengthxB > 0) {
        		while(locationxyB[0][0]!=targetCoordinateB[0][0] && moveB!=3) {
        			locationxyB[0][0]=locationxyB[0][0]+1;
        			grid[locationxyB[0][0]][locationxyB[0][1]].setBorder(new LineBorder(Color.CYAN));
        			grid[locationxyB[0][0]][locationxyB[0][1]].setForeground(Color.RED);
        			grid[locationxyB[0][0]][locationxyB[0][1]].setHorizontalAlignment(SwingConstants.CENTER);
        			moveB++;
        		
        		}
        		}
        		else {
        			while(locationxyB[0][0]!=targetCoordinateB[0][0] && moveB!=3) {
        				locationxyB[0][0]=locationxyB[0][0]-1;
        				grid[locationxyB[0][0]][locationxyB[0][1]].setBorder(new LineBorder(Color.CYAN));
        				grid[locationxyB[0][0]][locationxyB[0][1]].setForeground(Color.RED);
        				grid[locationxyB[0][0]][locationxyB[0][1]].setHorizontalAlignment(SwingConstants.CENTER);
        				moveB++;
        			
        			}
        			
        		}
        		if(targetLengthyB > 0) {
        		while(locationxyB[0][1]!=targetCoordinateB[0][1] && moveB!=3) {
        			locationxyB[0][1]=locationxyB[0][1]+1;
        			grid[locationxyB[0][0]][locationxyB[0][1]].setBorder(new LineBorder(Color.CYAN));
        			grid[locationxyB[0][0]][locationxyB[0][1]].setForeground(Color.RED);
        			grid[locationxyB[0][0]][locationxyB[0][1]].setHorizontalAlignment(SwingConstants.CENTER);
        			moveB++;
        		
        		}
        		}else {
        			while(locationxyB[0][1]!=targetCoordinateB[0][1] && moveB!=3) {
        				locationxyB[0][1]=locationxyB[0][1]-1;
        				grid[locationxyB[0][0]][locationxyB[0][1]].setBorder(new LineBorder(Color.CYAN));
        				grid[locationxyB[0][0]][locationxyB[0][1]].setForeground(Color.RED);
        				grid[locationxyB[0][0]][locationxyB[0][1]].setHorizontalAlignment(SwingConstants.CENTER);
        				moveB++;
        			
        			}
        		}
        		
        		if(locationxyB[0][1]==targetCoordinateB[0][1] && locationxyB[0][0]==targetCoordinateB[0][0]) {
        			
        		totalGoldB=totalGoldB+Integer.parseInt(grid[targetCoordinateB[0][0]][targetCoordinateB[0][1]].getText());
        		
        		for(int a=0;a<total_Gold;a++) {
        			if(GoldCoordinate[a][0]==targetCoordinateB[0][0] && GoldCoordinate[a][1]==targetCoordinateB[0][1]) {
        				GoldCoordinate[a][0]=99;
        				GoldCoordinate[a][1]=99;
        				if(targetCoordinateB[0][0]==targetCoordinate[0][0]&&targetCoordinateB[0][1]==targetCoordinate[0][1] ){
							targetCoordinate[0][0]=locationxyA[0][0];
							targetCoordinate[0][1]=locationxyA[0][1];
						}
						if(targetCoordinateB[0][0]==targetCoordinateC[0][0]&&targetCoordinateB[0][1]==targetCoordinateC[0][1] ){
							targetCoordinateC[0][0]=locationxyC[0][0];
							targetCoordinateC[0][1]=locationxyC[0][1];
						}
						if(targetCoordinateB[0][0]==targetCoordinateD[0][0]&&targetCoordinateB[0][1]==targetCoordinateD[0][1] ){
							targetCoordinateD[0][0]=locationxyD[0][0];
							targetCoordinateD[0][1]=locationxyD[0][1];
						}
        				
        			}
        		}
        		
        		}
        		totalGoldB=totalGoldB-gmB.getMove_Cost();//adým atma maaliyeti
        		System.out.println("TotalB"+totalGoldB);
        		moveB = 0;			
        		//}
        		
        		// -----------------------------------------------------------------
        		//C için altýn hedefi belirleme :
        		// -----------------------------------------------------------------
        		
        		grid[tColumns-1][tRows-1].setText("0");
        		grid[tColumns-1][tRows-1].setForeground(Color.RED);
        		grid[tColumns-1][tRows-1].setHorizontalAlignment(SwingConstants.CENTER);
        		
        		
        		//for(int b=0;b<12;b++) {
        			
        			if(locationxyC[0][1]==targetCoordinateC[0][1] && locationxyC[0][0]==targetCoordinateC[0][0] ) {
        				
        				
        				openSecretGold=gmC.openSecretGold(sayac,sayac2,GoldCoordinate,SecretGoldCoordinate, locationxyC, grid);
        				for(i=0;i<sayac2;i++) {
        					if(openSecretGold[0][0]==SecretGoldCoordinate[i][0]&&openSecretGold[0][1]==SecretGoldCoordinate[i][1]) {
        						if(openSecretGold[0][0]!= 99 && openSecretGold[0][1] != 99) {
        						System.out.println("acılacak:"+openSecretGold[0][0]+" "+openSecretGold[0][1]);
        						GoldCoordinate[sayac+tmp][0]=openSecretGold[0][0];
        						GoldCoordinate[sayac+tmp][1]=openSecretGold[0][1];
        						SecretGoldCoordinate[i][0]=99;
        						SecretGoldCoordinate[i][1]=99;
        						grid[openSecretGold[0][0]][openSecretGold[0][1]].setForeground(Color.BLUE);
        						grid[openSecretGold[0][0]][openSecretGold[0][1]].setFont(new Font("Tahoma", Font.BOLD, 30));
        						tmp++;
        							}
        					}
        				}
        				openSecretGold=gmC.openSecretGold(sayac,sayac2,GoldCoordinate,SecretGoldCoordinate, locationxyC, grid);
        				for(i=0;i<sayac2;i++) {
        					if(openSecretGold[0][0]==SecretGoldCoordinate[i][0]&&openSecretGold[0][1]==SecretGoldCoordinate[i][1]) {
        						if(openSecretGold[0][0]!= 99 && openSecretGold[0][1] != 99) {
        						System.out.println("acılacak:"+openSecretGold[0][0]+" "+openSecretGold[0][1]);
        						GoldCoordinate[sayac+tmp][0]=openSecretGold[0][0];
        						GoldCoordinate[sayac+tmp][1]=openSecretGold[0][1];
        						SecretGoldCoordinate[i][0]=99;
        						SecretGoldCoordinate[i][1]=99;
        						grid[openSecretGold[0][0]][openSecretGold[0][1]].setForeground(Color.BLUE);
        						grid[openSecretGold[0][0]][openSecretGold[0][1]].setFont(new Font("Tahoma", Font.BOLD, 30));
        						tmp++;
        							}
        					}
        				}
        				
        				targetCoordinateC = gmC.chooseTargetC(total_Gold,GoldCoordinate,locationxyC,grid);
        				totalGoldC=totalGoldC-gmC.getChoosing_Target_Cost();// hedef belirleme maaliyeti
        				
        				
        				}
        			//System.out.println("b :" + b);
        			System.out.println("gidileceklerC "+targetCoordinateC[0][0]+" "+targetCoordinateC[0][1]);
        			
        			targetLengthxC = targetCoordinateC[0][0] - locationxyC[0][0];
        			targetLengthyC = targetCoordinateC[0][1] - locationxyC[0][1];
        			
        		if(targetLengthxC > 0) {
        		while(locationxyC[0][0]!=targetCoordinateC[0][0] && moveC!=3) {
        			locationxyC[0][0]=locationxyC[0][0]+1;
        			grid[locationxyC[0][0]][locationxyC[0][1]].setBorder(new LineBorder(Color.CYAN));
        			grid[locationxyC[0][0]][locationxyC[0][1]].setForeground(Color.RED);
        			grid[locationxyC[0][0]][locationxyC[0][1]].setHorizontalAlignment(SwingConstants.CENTER);
        			moveC++;
        			
        		}
        		}
        		else {
        			while(locationxyC[0][0]!=targetCoordinateC[0][0] && moveC!=3) {
        				locationxyC[0][0]=locationxyC[0][0]-1;
        				grid[locationxyC[0][0]][locationxyC[0][1]].setBorder(new LineBorder(Color.CYAN));
        				grid[locationxyC[0][0]][locationxyC[0][1]].setForeground(Color.RED);
        				grid[locationxyC[0][0]][locationxyC[0][1]].setHorizontalAlignment(SwingConstants.CENTER);
        				moveC++;
        			
        			}
        			
        		}
        		if(targetLengthyC > 0) {
        		while(locationxyC[0][1]!=targetCoordinateC[0][1] && moveC!=3) {
        			locationxyC[0][1]=locationxyC[0][1]+1;
        			grid[locationxyC[0][0]][locationxyC[0][1]].setBorder(new LineBorder(Color.CYAN));
        			grid[locationxyC[0][0]][locationxyC[0][1]].setForeground(Color.RED);
        			grid[locationxyC[0][0]][locationxyC[0][1]].setHorizontalAlignment(SwingConstants.CENTER);
        			moveC++;
        			
        		}
        		}else {
        			while(locationxyC[0][1]!=targetCoordinateC[0][1] && moveC!=3) {
        				locationxyC[0][1]=locationxyC[0][1]-1;
        				grid[locationxyC[0][0]][locationxyC[0][1]].setBorder(new LineBorder(Color.CYAN));
        				grid[locationxyC[0][0]][locationxyC[0][1]].setForeground(Color.RED);
        				grid[locationxyC[0][0]][locationxyC[0][1]].setHorizontalAlignment(SwingConstants.CENTER);
        				moveC++;
        			
        			}
        		}
        		
        		if(locationxyC[0][1]==targetCoordinateC[0][1] && locationxyC[0][0]==targetCoordinateC[0][0]) {
        			
        		totalGoldC=totalGoldC+Integer.parseInt(grid[targetCoordinateC[0][0]][targetCoordinateC[0][1]].getText());
        		
        		for(int a=0;a<total_Gold;a++) {
        			if(GoldCoordinate[a][0]==targetCoordinateC[0][0] && GoldCoordinate[a][1]==targetCoordinateC[0][1]) {
        				GoldCoordinate[a][0]=99;
        				GoldCoordinate[a][1]=99;
        				
        				if(targetCoordinateC[0][0]==targetCoordinate[0][0]&&targetCoordinateC[0][1]==targetCoordinate[0][1] ){
							targetCoordinate[0][0]=locationxyA[0][0];
							targetCoordinate[0][1]=locationxyA[0][1];
						}
						if(targetCoordinateC[0][0]==targetCoordinateB[0][0]&&targetCoordinateC[0][1]==targetCoordinateB[0][1] ){
							targetCoordinateB[0][0]=locationxyB[0][0];
							targetCoordinateB[0][1]=locationxyB[0][1];
						}
						if(targetCoordinateC[0][0]==targetCoordinateD[0][0]&&targetCoordinateC[0][1]==targetCoordinateD[0][1] ){
							targetCoordinateD[0][0]=locationxyD[0][0];
							targetCoordinateD[0][1]=locationxyD[0][1];
						}
        				
        			}
        		}
        		
        		}
        		totalGoldC=totalGoldC-gmC.getMove_Cost();//adým atma maaliyeti
        		System.out.println("totalC"+totalGoldC);
        		moveC = 0;
        		
        		
        		//}
        		
        		// -----------------------------------------------------------------
        				// D için altın hedefi belirleme :
        				// -----------------------------------------------------------------
        				
        				int hamleA = gmA.adimSayisiA(total_Gold,GoldCoordinate,locationxyA);
        				int hamleB = gmB.adimSayisiB(total_Gold, GoldCoordinate, locationxyB, grid);
        				int hamleC = gmC.adimSayisiC(total_Gold, GoldCoordinate, locationxyC, grid);
        				grid[tColumns-1][0].setText("0");
        				grid[tColumns-1][0].setForeground(Color.RED);
        				grid[tColumns-1][0].setHorizontalAlignment(SwingConstants.CENTER);
        				

        				
        				//for(int b=0;b<12;b++) {
        					
        					if(locationxyD[0][1]==targetCoordinateD[0][1] && locationxyD[0][0]==targetCoordinateD[0][0]) {
        						
        						targetCoordinateD = gmD.chooseTargetD(total_Gold,GoldCoordinate,locationxyD,grid,targetCoordinate,targetCoordinateB,targetCoordinateC,hamleA,hamleB,hamleC);
        						totalGoldD=totalGoldD-gmD.getChoosing_Target_Cost();// hedef belirleme maaliyeti
        						}
        					
        					//System.out.println("b :" + b);
        					System.out.println("gidileceklerD "+targetCoordinateD[0][0]+" "+targetCoordinateD[0][1]);
        					
        					targetLengthxD = targetCoordinateD[0][0] - locationxyD[0][0];
        					targetLengthyD = targetCoordinateD[0][1] - locationxyD[0][1];
        					
        				if(targetLengthxD > 0) {
        				while(locationxyD[0][0]!=targetCoordinateD[0][0] && moveD!=3) {
        					locationxyD[0][0]=locationxyD[0][0]+1;
        					grid[locationxyD[0][0]][locationxyD[0][1]].setBorder(new LineBorder(Color.CYAN));
        					grid[locationxyD[0][0]][locationxyD[0][1]].setForeground(Color.RED);
        					grid[locationxyD[0][0]][locationxyD[0][1]].setHorizontalAlignment(SwingConstants.CENTER);
        					moveD++;
        				
        				}
        				}
        				else {
        					while(locationxyD[0][0]!=targetCoordinateD[0][0] && moveD!=3) {
        						locationxyD[0][0]=locationxyD[0][0]-1;
        						grid[locationxyD[0][0]][locationxyD[0][1]].setBorder(new LineBorder(Color.CYAN));
        						grid[locationxyD[0][0]][locationxyD[0][1]].setForeground(Color.RED);
        						grid[locationxyD[0][0]][locationxyD[0][1]].setHorizontalAlignment(SwingConstants.CENTER);
        						moveD++;
        						
        					}
        					
        				}
        				if(targetLengthyD > 0) {
        				while(locationxyD[0][1]!=targetCoordinateD[0][1] && moveD!=3) {
        					locationxyD[0][1]=locationxyD[0][1]+1;
        					grid[locationxyD[0][0]][locationxyD[0][1]].setBorder(new LineBorder(Color.CYAN));
        					grid[locationxyD[0][0]][locationxyD[0][1]].setForeground(Color.RED);
        					grid[locationxyD[0][0]][locationxyD[0][1]].setHorizontalAlignment(SwingConstants.CENTER);
        					moveD++;
        				
        				}
        				}else {
        					while(locationxyD[0][1]!=targetCoordinateD[0][1] && moveD!=3) {
        						locationxyD[0][1]=locationxyD[0][1]-1;
        						grid[locationxyD[0][0]][locationxyD[0][1]].setBorder(new LineBorder(Color.CYAN));
        						grid[locationxyD[0][0]][locationxyD[0][1]].setForeground(Color.RED);
        						grid[locationxyD[0][0]][locationxyD[0][1]].setHorizontalAlignment(SwingConstants.CENTER);
        						moveD++;
        						
        					}
        				}
        				
        				if(locationxyD[0][1]==targetCoordinateD[0][1] && locationxyD[0][0]==targetCoordinateD[0][0]) {
        					
        				totalGoldD=totalGoldD+Integer.parseInt(grid[targetCoordinateD[0][0]][targetCoordinateD[0][1]].getText());
        				
        				for(int a=0;a<total_Gold;a++) {
        					if(GoldCoordinate[a][0]==targetCoordinateD[0][0] && GoldCoordinate[a][1]==targetCoordinateD[0][1]) {
        						GoldCoordinate[a][0]=99;
        						GoldCoordinate[a][1]=99;
        						if(targetCoordinateD[0][0]==targetCoordinate[0][0]&&targetCoordinateD[0][1]==targetCoordinate[0][1] ){
        							targetCoordinate[0][0]=locationxyA[0][0];
        							targetCoordinate[0][1]=locationxyA[0][1];
        						}
        						if(targetCoordinateD[0][0]==targetCoordinateB[0][0]&&targetCoordinateD[0][1]==targetCoordinateB[0][1] ){
        							targetCoordinateB[0][0]=locationxyB[0][0];
        							targetCoordinateB[0][1]=locationxyB[0][1];
        						}
        						if(targetCoordinateD[0][0]==targetCoordinateC[0][0]&&targetCoordinateD[0][1]==targetCoordinateC[0][1] ){
        							targetCoordinateC[0][0]=locationxyC[0][0];
        							targetCoordinateC[0][1]=locationxyC[0][1];
        						}
        						
        						
        						
        					}
        				}
        				
        				}
        				totalGoldD=totalGoldD-gmD.getMove_Cost();//adım atma maaliyeti
        				System.out.println(totalGoldD);
        				moveD = 0;			
            	}
            	};
            	
        

 };
 timer.schedule(sayacTimerTask, 0, 1000);    
 	
				//}
		
	}
	
}