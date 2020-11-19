package Game;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
	int totalGoldA = gmA.getGold();
	int harcananaltinA=0;
	int kazanilanaltinA=0;
	int targetLengthx,targetLengthy;
	int moveA = 0;
	int topmoveA=0;
	
	Player gamerB = new GamerB();
	GamerB gmB = new GamerB();
	int [][] targetCoordinateB = new int [1][2];
	int [][] locationxyB= new int [1][2];

	int totalGoldB = gmB.getGold();
	int harcananaltinB=0;
	int kazanilanaltinB=0;
	int moveB = 0;
	int topmoveB=0;
	int targetLengthxB,targetLengthyB;

	Player gamerC = new GamerC();
	GamerC gmC = new GamerC();
	int [][] targetCoordinateC = new int [1][2];
	int [][] openSecretGold = new int [1][2];
	int [][] locationxyC= new int [1][2];
	
	int totalGoldC = gmC.getGold();
	int harcananaltinC=0;
	int kazanilanaltinC=0;
	int moveC = 0;
	int topmoveC=0;
	int targetLengthxC,targetLengthyC;

	int tmp=0;
	Player gamerD = new GamerD();
	GamerD gmD = new GamerD();
	int [][] targetCoordinateD = new int [1][2];
	int [][] locationxyD= new int [1][2];

	int totalGoldD = gmD.getGold();
	int harcananaltinD=0;
	int kazanilanaltinD=0;
	int moveD = 0;
	int topmoveD=0;
	int targetLengthxD,targetLengthyD;

	public MainFrame() {
		int tahtax=700;
		int tahtay=700;
		
		GamerA PlayerA = new GamerA();
		
		Board GameBoard = new Board();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, tahtax+100, tahtay+100);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// -----------------------------------------------------------------
				// Get Default Variable from the dosya.txt
				
				Path file = Paths.get("dosya.txt");
		       
				int [] defValues = new int [4];
				int valueStep = 0;
		        
				try (BufferedReader reader = Files.newBufferedReader(file)) {
				    String line = null;
				    while ((line = reader.readLine()) != null) {
				    	
				    	defValues[valueStep] = Integer.parseInt(line);
				    	valueStep++;
				        System.out.println("sıra : "+line+"  ");
				    }
				} catch (IOException x) {
				    System.err.format("IOException: %s%n", x);
				}
				
				GameBoard.setRows(defValues[0]);
				GameBoard.setColumns(defValues[1]);
				GameBoard.setGold_Rate(defValues[2]);
				GameBoard.setSecret_Gold_Rate(defValues[3]);
				GameBoard.setGold_Number(GameBoard.getRows()*GameBoard.getColumns()*GameBoard.getGold_Rate()/100);
				GameBoard.setSecret_Gold_Number( GameBoard.getGold_Number()*GameBoard.getSecret_Gold_Rate()/100);
			
				int tRows = GameBoard.getRows();
				int tColumns= GameBoard.getColumns();
				int total_Gold = (int) (GameBoard.getGold_Number());
				int total_Secret_Gold = (int) GameBoard.getSecret_Gold_Number();
				System.out.println("GETSLER . "+ GameBoard.getRows()+" " + GameBoard.getColumns()+" " + GameBoard.getGold_Number()+" " + GameBoard.getSecret_Gold_Number());
				
				
				// -----------------------------------------------------------------
				// Get Default Variable from the dosya.txt
						
					Path fileA = Paths.get("gamerA.txt");
				        
					int [] defValuesA = new int [4];
					valueStep = 0;
				        
					try (BufferedReader readerA = Files.newBufferedReader(fileA)) {
					    String lineA = null;
					    while ((lineA = readerA.readLine()) != null) {
					    	
					    	defValuesA[valueStep] = Integer.parseInt(lineA);
					    	valueStep++;
						    System.out.println("sıra : "+lineA+"  ");
						    }
						} catch (IOException x) {
						    System.err.format("IOException: %s%n", x);
						}
						gmA.setGold(defValuesA[0]);
						gmA.setMax_Move(defValuesA[1]);
						gmA.setMove_Cost(defValuesA[2]);
						gmA.setChoosing_Target_Cost(defValuesA[3]);
						
						// -----------------------------------------------------------------
						// Get Default Variable from the dosya.txt
								
							Path fileB = Paths.get("gamerB.txt");
						        
							int [] defValuesB = new int [4];
							valueStep = 0;
						        
							try (BufferedReader readerB = Files.newBufferedReader(fileB)) {
							    String lineB = null;
							    while ((lineB = readerB.readLine()) != null) {
							    	
							    	defValuesB[valueStep] = Integer.parseInt(lineB);
							    	valueStep++;
								    System.out.println("sıra : "+lineB+"  ");
								    
								    }
								} catch (IOException x) {
								    System.err.format("IOException: %s%n", x);
								}
							gmB.setGold(defValuesB[0]);
							gmB.setMax_Move(defValuesB[1]);
							gmB.setMove_Cost(defValuesB[2]);
							gmB.setChoosing_Target_Cost(defValuesB[3]);
							
								
								// -----------------------------------------------------------------
								// Get Default Variable from the dosya.txt
										
									Path fileC = Paths.get("gamerC.txt");
								        
									int [] defValuesC = new int [4];
									valueStep = 0;
								        
									try (BufferedReader readerC = Files.newBufferedReader(fileC)) {
									    String lineC = null;
									    while ((lineC = readerC.readLine()) != null) {
									    	
									    	defValuesC[valueStep] = Integer.parseInt(lineC);
									    	valueStep++;
										    System.out.println("sıra : "+lineC+"  ");
										    }
										} catch (IOException x) {
										    System.err.format("IOException: %s%n", x);
										}
												gmC.setGold(defValuesC[0]);
												gmC.setMax_Move(defValuesC[1]);
												gmC.setMove_Cost(defValuesC[2]);
												gmC.setChoosing_Target_Cost(defValuesC[3]);
									
										
										
										// -----------------------------------------------------------------
										// Get Default Variable from the dosya.txt
												
											Path fileD = Paths.get("gamerD.txt");
										        
											int [] defValuesD = new int [4];
											valueStep = 0;
										        
											try (BufferedReader readerD = Files.newBufferedReader(fileB)) {
											    String lineD = null;
											    while ((lineD = readerD.readLine()) != null) {
											    	
											    	defValuesD[valueStep] = Integer.parseInt(lineD);
											    	valueStep++;
												    System.out.println("sıra : "+lineD+"  ");
												    }
												} catch (IOException x) {
												    System.err.format("IOException: %s%n", x);
												}
												gmD.setGold(defValuesD[0]);
												gmD.setMax_Move(defValuesD[1]);
												gmD.setMove_Cost(defValuesD[2]);
												gmD.setChoosing_Target_Cost(defValuesD[3]);
				
				totalGoldA = gmA.getGold();
				totalGoldB = gmB.getGold();
				totalGoldC = gmC.getGold();
				totalGoldD = gmD.getGold();
				
				
				// -----------------------------------------------------------------
				// Get Random Number 1-397
				
				
				
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
		GamePanel.setBounds(0, 0, 684, 661);
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
		locationxyB [0][1]=tRows-1;
	
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
		targetCoordinateB[0][1]=tRows-1;
		
		targetCoordinateC[0][0]=tColumns-1;
		targetCoordinateC[0][1]=tRows-1;
		
		targetCoordinateD[0][0]=tColumns-1;
		targetCoordinateD[0][1]=0;
		
		
		
		File fileA2 = new File("locationA.txt");
        if (!fileA2.exists()) {
            try {
				fileA2.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
        FileWriter fileWriterA = null;
		try {
			fileWriterA = new FileWriter(fileA2, false);
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
        BufferedWriter bWriterA = new BufferedWriter(fileWriterA);
        
        
        File fileB2 = new File("locationB.txt");
        if (!fileB2.exists()) {
            try {
				fileB2.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
        FileWriter fileWriterB = null;
		try {
			fileWriterB = new FileWriter(fileB2, false);
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
        BufferedWriter bWriterB = new BufferedWriter(fileWriterB);
		
        
        File fileC2 = new File("locationC.txt");
        if (!fileC2.exists()) {
            try {
				fileC2.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
        FileWriter fileWriterC = null;
		try {
			fileWriterC = new FileWriter(fileC2, false);
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
        BufferedWriter bWriterC = new BufferedWriter(fileWriterC);
		
        File fileD2 = new File("locationD.txt");
        if (!fileD2.exists()) {
            try {
				fileD2.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
        FileWriter fileWriterD = null;
		try {
			fileWriterD = new FileWriter(fileD2, false);
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
        BufferedWriter bWriterD = new BufferedWriter(fileWriterD);
		
        
        
		
		
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
            		
            	if(totalGoldA>0) {	//A oyuncusu
            		
        			if( locationxyA[0][1]==targetCoordinate[0][1] && locationxyA[0][0]==targetCoordinate[0][0]  ) {
        				
        				targetCoordinate = gmA.chooseTargetA(total_Gold,GoldCoordinate,locationxyA);
        				
        				if(targetCoordinate[0][0]!=99&&targetCoordinate[0][1]!=99) {
        					harcananaltinA+=gmA.getChoosing_Target_Cost();
        					totalGoldA=totalGoldA-gmA.getChoosing_Target_Cost();// hedef belirleme maaliyeti
						}
        				
        				
        				
        				}
        			//System.out.println("b :" + b);
        			System.out.println("gidileceklerA "+targetCoordinate[0][0]+" "+targetCoordinate[0][1]);
        			
        			if(targetCoordinateB[0][0]!=99&&targetCoordinateB[0][1]!=99) {
        				targetLengthx = targetCoordinate[0][0] - locationxyA[0][0];
        				targetLengthy = targetCoordinate[0][1] - locationxyA[0][1];
            			}
            			else {
            				targetLengthx=0;
            				targetLengthy=0;
            			}

        			
        			
        		if(targetLengthx > 0) {
        		while(locationxyA[0][0]!=targetCoordinate[0][0] && moveA!=gmA.getMax_Move()) {
        			locationxyA[0][0]=locationxyA[0][0]+1;
        			grid[locationxyA[0][0]][locationxyA[0][1]].setBorder(new LineBorder(Color.CYAN));
        			//grid[locationxyA[0][0]][locationxyA[0][1]].setForeground(Color.RED);
        			grid[locationxyA[0][0]][locationxyA[0][1]].setHorizontalAlignment(SwingConstants.CENTER);
        			moveA++;
        			try {
						bWriterA.write(locationxyA[0][0]+"  "+locationxyA[0][1]+" , ");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        		}
        		}
        		else {
        			while(locationxyA[0][0]!=targetCoordinate[0][0] && moveA!=gmA.getMax_Move()) {
        				locationxyA[0][0]=locationxyA[0][0]-1;
        				grid[locationxyA[0][0]][locationxyA[0][1]].setBorder(new LineBorder(Color.CYAN));
        				//grid[locationxyA[0][0]][locationxyA[0][1]].setForeground(Color.RED);
        				grid[locationxyA[0][0]][locationxyA[0][1]].setHorizontalAlignment(SwingConstants.CENTER);
        				moveA++;
        				try {
    						bWriterA.write(locationxyA[0][0]+"  "+locationxyA[0][1]+" , ");
    					} catch (IOException e) {
    						// TODO Auto-generated catch block
    						e.printStackTrace();
    					}
        			}
        			
        		}
        		if(targetLengthy > 0) {
        		while(locationxyA[0][1]!=targetCoordinate[0][1] && moveA!=gmA.getMax_Move()) {
        			locationxyA[0][1]=locationxyA[0][1]+1;
        			grid[locationxyA[0][0]][locationxyA[0][1]].setBorder(new LineBorder(Color.CYAN));
        			//grid[locationxyA[0][0]][locationxyA[0][1]].setForeground(Color.RED);
        			grid[locationxyA[0][0]][locationxyA[0][1]].setHorizontalAlignment(SwingConstants.CENTER);
        			moveA++;
        			try {
						bWriterA.write(locationxyA[0][0]+"  "+locationxyA[0][1]+" , ");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        		}
        		}else {
        			while(locationxyA[0][1]!=targetCoordinate[0][1] && moveA!=gmA.getMax_Move()) {
        				locationxyA[0][1]=locationxyA[0][1]-1;
        				grid[locationxyA[0][0]][locationxyA[0][1]].setBorder(new LineBorder(Color.CYAN));
        				//grid[locationxyA[0][0]][locationxyA[0][1]].setForeground(Color.RED);
        				grid[locationxyA[0][0]][locationxyA[0][1]].setHorizontalAlignment(SwingConstants.CENTER);
        				moveA++;
        				try {
    						bWriterA.write(locationxyA[0][0]+"  "+locationxyA[0][1]+" , ");
    					} catch (IOException e) {
    						// TODO Auto-generated catch block
    						e.printStackTrace();
    					}
        			}
        		}
        		
    						try {
								bWriterA.newLine();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
        		if(locationxyA[0][1]==targetCoordinate[0][1] && locationxyA[0][0]==targetCoordinate[0][0]) {
        			grid[locationxyA[0][0]][locationxyA[0][1]].setForeground(Color.RED);
        		totalGoldA=totalGoldA+Integer.parseInt(grid[targetCoordinate[0][0]][targetCoordinate[0][1]].getText());
        		kazanilanaltinA+=Integer.parseInt(grid[targetCoordinate[0][0]][targetCoordinate[0][1]].getText());
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
        		if(moveA!=0) {
        		harcananaltinA+=gmA.getMove_Cost();
        		totalGoldA=totalGoldA-gmA.getMove_Cost();//adým atma maaliyeti
        		System.out.println("TotalA "+totalGoldA);
        		gmA.setGold(totalGoldA);
        		}
        		topmoveA+=moveA;
        		moveA = 0;			
        		//}
            	}
        		
        		
        		// -----------------------------------------------------------------
        		// B için altýn hedefi belirleme :
        		// -----------------------------------------------------------------
        		
            	grid[0][tRows-1].setText("0");
        		grid[0][tRows-1].setForeground(Color.RED);
        		grid[0][tRows-1].setHorizontalAlignment(SwingConstants.CENTER);
         
        		//for(int b=0;b<12;b++) {
        			//System.out.println("lokasyonx:"+locationxyB[0][0]+"lokasyony"+locationxyB[0][1]);
        			//System.out.println("gidilecekler "+targetCoordinateB[0][0]+" "+targetCoordinateB[0][1]);
            	
            	if(totalGoldB>0) {
            		
            	
        			if( locationxyB[0][1]==targetCoordinateB[0][1] && locationxyB[0][0]==targetCoordinateB[0][0] ) {
        				
        				targetCoordinateB = gmB.chooseTargetB(total_Gold,GoldCoordinate,locationxyB,grid);
        				
        				if(targetCoordinateB[0][0]!=99&&targetCoordinateB[0][1]!=99) {
        					harcananaltinB+=gmB.getChoosing_Target_Cost();
        					totalGoldB=totalGoldB-gmB.getChoosing_Target_Cost();// hedef belirleme maaliyeti
        					
						}
        				
        				}
        			//System.out.println("b :" + b);
        			System.out.println("gidileceklerB "+targetCoordinateB[0][0]+" "+targetCoordinateB[0][1]);
        			if(targetCoordinateB[0][0]!=99&&targetCoordinateB[0][1]!=99) {
        				
        			targetLengthxB = targetCoordinateB[0][0] - locationxyB[0][0];
        			targetLengthyB = targetCoordinateB[0][1] - locationxyB[0][1];
        			}
        			else {
        				targetLengthxB=0;
        				targetLengthyB=0;
        			}
        		if(targetLengthxB > 0) {
        		while(locationxyB[0][0]!=targetCoordinateB[0][0] && moveB!=gmB.getMax_Move()) {
        			locationxyB[0][0]=locationxyB[0][0]+1;
        			grid[locationxyB[0][0]][locationxyB[0][1]].setBorder(new LineBorder(Color.PINK));
        			grid[locationxyB[0][0]][locationxyB[0][1]].setHorizontalAlignment(SwingConstants.CENTER);
        			moveB++;
        			try {
						bWriterB.write(locationxyB[0][0]+"  "+locationxyB[0][1]+" , ");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        		}
        		}
        		else {
        			while(locationxyB[0][0]!=targetCoordinateB[0][0] && moveB!=gmB.getMax_Move()) {
        				locationxyB[0][0]=locationxyB[0][0]-1;
        				grid[locationxyB[0][0]][locationxyB[0][1]].setBorder(new LineBorder(Color.PINK));
        				grid[locationxyB[0][0]][locationxyB[0][1]].setHorizontalAlignment(SwingConstants.CENTER);
        				moveB++;
        				try {
    						bWriterB.write(locationxyB[0][0]+"  "+locationxyB[0][1]+" , ");
    					} catch (IOException e) {
    						// TODO Auto-generated catch block
    						e.printStackTrace();
    					}
        			}
        			
        		}
        		if(targetLengthyB > 0) {
        		while(locationxyB[0][1]!=targetCoordinateB[0][1] && moveB!=gmB.getMax_Move()) {
        			locationxyB[0][1]=locationxyB[0][1]+1;
        			grid[locationxyB[0][0]][locationxyB[0][1]].setBorder(new LineBorder(Color.PINK));
        			grid[locationxyB[0][0]][locationxyB[0][1]].setHorizontalAlignment(SwingConstants.CENTER);
        			moveB++;
        			try {
						bWriterB.write(locationxyB[0][0]+"  "+locationxyB[0][1]+" , ");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        		}
        		}else {
        			while(locationxyB[0][1]!=targetCoordinateB[0][1] && moveB!=gmB.getMax_Move()) {
        				locationxyB[0][1]=locationxyB[0][1]-1;
        				grid[locationxyB[0][0]][locationxyB[0][1]].setBorder(new LineBorder(Color.PINK));
        				grid[locationxyB[0][0]][locationxyB[0][1]].setHorizontalAlignment(SwingConstants.CENTER);
        				moveB++;
        				try {
    						bWriterB.write(locationxyB[0][0]+"  "+locationxyB[0][1]+" , ");
    					} catch (IOException e) {
    						// TODO Auto-generated catch block
    						e.printStackTrace();
    					}
        			}
        		}
        		
    						try {
								bWriterB.newLine();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
        		if(locationxyB[0][1]==targetCoordinateB[0][1] && locationxyB[0][0]==targetCoordinateB[0][0]) {
        			
        		grid[locationxyB[0][0]][locationxyB[0][1]].setForeground(Color.RED);
        		kazanilanaltinB+=Integer.parseInt(grid[targetCoordinateB[0][0]][targetCoordinateB[0][1]].getText());
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
        		if(moveB!=0) {
        		harcananaltinB+=gmB.getMove_Cost();
        		totalGoldB=totalGoldB-gmB.getMove_Cost();//adým atma maaliyeti
        		System.out.println("TotalB "+totalGoldB);
        		gmB.setGold(totalGoldB);
        		}
        		topmoveB+=moveB;
        		moveB = 0;			
            	}
        		//}
        		
        		// -----------------------------------------------------------------
        		//C için altýn hedefi belirleme :
        		// -----------------------------------------------------------------
        		
        		grid[tColumns-1][tRows-1].setText("0");
        		grid[tColumns-1][tRows-1].setForeground(Color.RED);
        		grid[tColumns-1][tRows-1].setHorizontalAlignment(SwingConstants.CENTER);
        		
        		
        		//for(int b=0;b<12;b++) {
        		if(totalGoldC>0) {
        			
        		
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
        						grid[openSecretGold[0][0]][openSecretGold[0][1]].setFont(new Font("Tahoma", Font.BOLD, 15));
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
        						grid[openSecretGold[0][0]][openSecretGold[0][1]].setFont(new Font("Tahoma", Font.BOLD, 15));
        						tmp++;
        							}
        					}
        				}
        				
        				targetCoordinateC = gmC.chooseTargetC(total_Gold,GoldCoordinate,locationxyC,grid);
        				if(targetCoordinateC[0][0]!=99&&targetCoordinateC[0][1]!=99) {
        					harcananaltinC+=gmC.getChoosing_Target_Cost();
        					totalGoldC=totalGoldC-gmC.getChoosing_Target_Cost();// hedef belirleme maaliyeti
						}
        			
        				
        				
        				}
        			//System.out.println("b :" + b);
        			System.out.println("gidileceklerC "+targetCoordinateC[0][0]+" "+targetCoordinateC[0][1]);
        			
        			if(targetCoordinateC[0][0]!=99&&targetCoordinateC[0][1]!=99) {
        				targetLengthxC = targetCoordinateC[0][0] - locationxyC[0][0];
        				targetLengthyC = targetCoordinateC[0][1] - locationxyC[0][1];
            			
            			}
            			else {
            				targetLengthxC=0;
            				targetLengthyC=0;
            			}

        			
        			
        			
        		if(targetLengthxC > 0) {
        		while(locationxyC[0][0]!=targetCoordinateC[0][0] && moveC!=gmC.getMax_Move()) {
        			locationxyC[0][0]=locationxyC[0][0]+1;
        			grid[locationxyC[0][0]][locationxyC[0][1]].setBorder(new LineBorder(Color.YELLOW));
        			grid[locationxyC[0][0]][locationxyC[0][1]].setHorizontalAlignment(SwingConstants.CENTER);
        			moveC++;
        			try {
						bWriterC.write(locationxyC[0][0]+"  "+locationxyC[0][1]+" , ");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        		}
        		}
        		else {
        			while(locationxyC[0][0]!=targetCoordinateC[0][0] && moveC!=gmC.getMax_Move()) {
        				locationxyC[0][0]=locationxyC[0][0]-1;
        				grid[locationxyC[0][0]][locationxyC[0][1]].setBorder(new LineBorder(Color.YELLOW));
        				grid[locationxyC[0][0]][locationxyC[0][1]].setHorizontalAlignment(SwingConstants.CENTER);
        				moveC++;
        				try {
    						bWriterC.write(locationxyC[0][0]+"  "+locationxyC[0][1]+" , ");
    					} catch (IOException e) {
    						// TODO Auto-generated catch block
    						e.printStackTrace();
    					}
        			}
        			
        		}
        		if(targetLengthyC > 0) {
        		while(locationxyC[0][1]!=targetCoordinateC[0][1] && moveC!=gmC.getMax_Move()) {
        			locationxyC[0][1]=locationxyC[0][1]+1;
        			grid[locationxyC[0][0]][locationxyC[0][1]].setBorder(new LineBorder(Color.YELLOW));
        			grid[locationxyC[0][0]][locationxyC[0][1]].setHorizontalAlignment(SwingConstants.CENTER);
        			moveC++;
        			try {
						bWriterC.write(locationxyC[0][0]+"  "+locationxyC[0][1]+" , ");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        		}
        		}else {
        			while(locationxyC[0][1]!=targetCoordinateC[0][1] && moveC!=gmC.getMax_Move()) {
        				locationxyC[0][1]=locationxyC[0][1]-1;
        				grid[locationxyC[0][0]][locationxyC[0][1]].setBorder(new LineBorder(Color.YELLOW));
        				grid[locationxyC[0][0]][locationxyC[0][1]].setHorizontalAlignment(SwingConstants.CENTER);
        				moveC++;
        				try {
    						bWriterC.write(locationxyC[0][0]+"  "+locationxyC[0][1]+" , ");
    					} catch (IOException e) {
    						// TODO Auto-generated catch block
    						e.printStackTrace();
    					}
        			}
        		}

				try {
					bWriterC.newLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
        		if(locationxyC[0][1]==targetCoordinateC[0][1] && locationxyC[0][0]==targetCoordinateC[0][0]) {
        			
        		kazanilanaltinC+=Integer.parseInt(grid[targetCoordinateC[0][0]][targetCoordinateC[0][1]].getText());
        		grid[locationxyC[0][0]][locationxyC[0][1]].setForeground(Color.RED);  			
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
        		if(moveC!=0) {
        		harcananaltinC+=gmC.getMove_Cost();
        		totalGoldC=totalGoldC-gmC.getMove_Cost();//adým atma maaliyeti
        		System.out.println("totalC "+totalGoldC);
        		gmC.setGold(totalGoldC);
        		}
        		topmoveC+=moveC;
        		moveC = 0;
        		
        		}
    			
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
        				

        				if(totalGoldD>0) {
        					
        				
        				//for(int b=0;b<12;b++) {
        					
        					if(locationxyD[0][1]==targetCoordinateD[0][1] && locationxyD[0][0]==targetCoordinateD[0][0]) {
        						
        						targetCoordinateD = gmD.chooseTargetD(total_Gold,GoldCoordinate,locationxyD,grid,targetCoordinate,targetCoordinateB,targetCoordinateC,hamleA,hamleB,hamleC);
        						if(targetCoordinateD[0][0]!=99&&targetCoordinateD[0][1]!=99) {
        							harcananaltinD+=gmD.getChoosing_Target_Cost();
        							totalGoldD=totalGoldD-gmD.getChoosing_Target_Cost();// hedef belirleme maaliyeti
        							
        						}
        						
        						}
        					
        					//System.out.println("b :" + b);
        					System.out.println("gidileceklerD "+targetCoordinateD[0][0]+" "+targetCoordinateD[0][1]);
        					
        					if(targetCoordinateD[0][0]!=99&&targetCoordinateD[0][1]!=99) {
                				targetLengthxD = targetCoordinateD[0][0] - locationxyD[0][0];
                				targetLengthyD = targetCoordinateD[0][1] - locationxyD[0][1];
        	        		
        	        			}
        	        			else {
        	        				targetLengthxD=0;
        	        				targetLengthyD=0;
        	        			}

        					
        					
        				if(targetLengthxD > 0) {
        				while(locationxyD[0][0]!=targetCoordinateD[0][0] && moveD!=gmD.getMax_Move()) {
        					locationxyD[0][0]=locationxyD[0][0]+1;
        					grid[locationxyD[0][0]][locationxyD[0][1]].setBorder(new LineBorder(Color.GREEN));
        					grid[locationxyD[0][0]][locationxyD[0][1]].setHorizontalAlignment(SwingConstants.CENTER);
        					moveD++;
        					try {
        						bWriterD.write(locationxyD[0][0]+"  "+locationxyD[0][1]+" , ");
        					} catch (IOException e) {
        						// TODO Auto-generated catch block
        						e.printStackTrace();
        					}
        				}
        				}
        				else {
        					while(locationxyD[0][0]!=targetCoordinateD[0][0] && moveD!=gmD.getMax_Move()) {
        						locationxyD[0][0]=locationxyD[0][0]-1;
        						grid[locationxyD[0][0]][locationxyD[0][1]].setBorder(new LineBorder(Color.GREEN));
        						grid[locationxyD[0][0]][locationxyD[0][1]].setHorizontalAlignment(SwingConstants.CENTER);
        						moveD++;
        						try {
            						bWriterD.write(locationxyD[0][0]+"  "+locationxyD[0][1]+" , ");
            					} catch (IOException e) {
            						// TODO Auto-generated catch block
            						e.printStackTrace();
            					}
        					}
        					
        				}
        				if(targetLengthyD > 0) {
        				while(locationxyD[0][1]!=targetCoordinateD[0][1] && moveD!=gmD.getMax_Move()) {
        					locationxyD[0][1]=locationxyD[0][1]+1;
        					grid[locationxyD[0][0]][locationxyD[0][1]].setBorder(new LineBorder(Color.GREEN));
        					grid[locationxyD[0][0]][locationxyD[0][1]].setHorizontalAlignment(SwingConstants.CENTER);
        					moveD++;
        					try {
        						bWriterD.write(locationxyD[0][0]+"  "+locationxyD[0][1]+" , ");
        					} catch (IOException e) {
        						// TODO Auto-generated catch block
        						e.printStackTrace();
        					}
        				}
        				}else {
        					while(locationxyD[0][1]!=targetCoordinateD[0][1] && moveD!=gmD.getMax_Move()) {
        						locationxyD[0][1]=locationxyD[0][1]-1;
        						grid[locationxyD[0][0]][locationxyD[0][1]].setBorder(new LineBorder(Color.GREEN));
        						grid[locationxyD[0][0]][locationxyD[0][1]].setHorizontalAlignment(SwingConstants.CENTER);
        						moveD++;
        						try {
            						bWriterD.write(locationxyD[0][0]+"  "+locationxyD[0][1]+" , ");
            					} catch (IOException e) {
            						// TODO Auto-generated catch block
            						e.printStackTrace();
            					}
        					}
        				}

						try {
							bWriterD.newLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
        				if(locationxyD[0][1]==targetCoordinateD[0][1] && locationxyD[0][0]==targetCoordinateD[0][0]) {

    					grid[locationxyD[0][0]][locationxyD[0][1]].setForeground(Color.RED);
    					kazanilanaltinD+=Integer.parseInt(grid[targetCoordinateD[0][0]][targetCoordinateD[0][1]].getText());
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
        				if(moveD!=0) {
        				harcananaltinD+=gmD.getMove_Cost();
        				totalGoldD=totalGoldD-gmD.getMove_Cost();//adım atma maaliyeti
        				System.out.println("totalD "+totalGoldD);
        				gmD.setGold(totalGoldD);
        					
        				}
        				topmoveD+=moveD;
        				moveD = 0;			
            	}
            	}
            	if(devam==false) {
            		System.out.println("TOPLAM ADİM "+topmoveA+"  "+topmoveB+"  "+topmoveC+"  "+topmoveD);
            		System.out.println("TOPLAM ALTİN "+totalGoldA+"  "+totalGoldB+"  "+totalGoldC+"  "+totalGoldD);
            		System.out.println("HARCANAN ALTİN "+harcananaltinA+"  "+harcananaltinB+"  "+harcananaltinC+"  "+harcananaltinD);
            		System.out.println("KAZANİLAN ALTİN "+kazanilanaltinA+"  "+kazanilanaltinB+"  "+kazanilanaltinC+"  "+kazanilanaltinD);
            		//çıkış komutu yazmamiz lazim fakat nasıl yapılacak bilmiyorum tem buraya
            		try {
						bWriterA.close();
						bWriterB.close();
						bWriterC.close();
						bWriterD.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            		
            		
            		timer.cancel();
            	}
            		devam=false;
            		
            	};
            	
        

 };
 
 timer.schedule(sayacTimerTask, 0, 3000);    
 	
				//}
		
	}
	
}