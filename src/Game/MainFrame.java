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
		
		int i=0,j=0;
		// -----------------------------------------------------------------
		// GoldRandom
		ArrayList<Integer> goldCoordinate = new ArrayList<Integer>();
		for(i=1;i<(tRows*tColumns-1);i++) {
			goldCoordinate.add(i);
		}
		goldCoordinate.remove(tRows-2);
		goldCoordinate.remove((tColumns-1)*tRows-2);
		
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
		
		Player gamerA = new GamerA();
		
		String s = String.valueOf(false);
		boolean girdimi = false;
		int ata = 0;
		int sayac=0,sayac2=0;
		
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
		// -----------------------------------------------------------------
		// -----------------------------------------------------------------
/*
		grid[0][0].setText("0");
		grid[0][0].setForeground(Color.RED);
		grid[0][0].setHorizontalAlignment(SwingConstants.CENTER);
			
		int [][] targetCoordinate = new int [1][2];
		int [][] locationxyA= new int [1][2];
		locationxyA [0][0]=0;
		locationxyA [0][1]=0;
		int totalGoldA = gamerA.getGold();
		int moveA = 0;
		int targetLengthx,targetLengthy;
		// -----------------------------------------------------------------
		// A için altýn hedefi belirleme :
		// -----------------------------------------------------------------
		targetCoordinate[0][0]=0;
		targetCoordinate[0][1]=0;
		
		GamerA gmA = new GamerA();
		for(int b=0;b<12;b++) {
			
			if(locationxyA[0][1]==targetCoordinate[0][1] && locationxyA[0][0]==targetCoordinate[0][0]) {	
				targetCoordinate = gmA.chooseTargetA(sayac,GoldCoordinate,locationxyA);
				totalGoldA=totalGoldA-5;// hedef belirleme maaliyeti
				
				}
			System.out.println("b :" + b);
			System.out.println("gidilecekler "+targetCoordinate[0][0]+" "+targetCoordinate[0][1]);
		
			targetLengthx = targetCoordinate[0][0] - locationxyA[0][0];
			targetLengthy = targetCoordinate[0][1] - locationxyA[0][1];
		if(targetLengthx > 0) {
		while(locationxyA[0][0]!=targetCoordinate[0][0] && moveA!=3) {
			locationxyA[0][0]=locationxyA[0][0]+1;
			grid[locationxyA[0][0]][locationxyA[0][1]].setBorder(new LineBorder(Color.CYAN));
			grid[locationxyA[0][0]][locationxyA[0][1]].setForeground(Color.RED);
			grid[locationxyA[0][0]][locationxyA[0][1]].setHorizontalAlignment(SwingConstants.CENTER);
			moveA++;
			for(int scrt=0;scrt<sayac2;scrt++) {
				if(locationxyA[0][0]==SecretGoldCoordinate[scrt][0] && locationxyA[0][1]==SecretGoldCoordinate[scrt][1])
				{
					grid[locationxyA[0][0]][locationxyA[0][1]].setFont(new Font("Tahoma", Font.BOLD, 12));
					grid[locationxyA[0][0]][locationxyA[0][1]].setForeground(Color.MAGENTA);
					totalGoldA=totalGoldA+Integer.parseInt(grid[locationxyA[0][0]][locationxyA[0][1]].getText());
					System.out.println("girdi girdi");
				}
			}
		}
		}
		else {
			while(locationxyA[0][0]!=targetCoordinate[0][0] && moveA!=3) {
				locationxyA[0][0]=locationxyA[0][0]-1;
				grid[locationxyA[0][0]][locationxyA[0][1]].setBorder(new LineBorder(Color.CYAN));
				grid[locationxyA[0][0]][locationxyA[0][1]].setForeground(Color.RED);
				grid[locationxyA[0][0]][locationxyA[0][1]].setHorizontalAlignment(SwingConstants.CENTER);
				moveA++;
				for(int scrt=0;scrt<sayac2;scrt++) {
					if(locationxyA[0][0]==SecretGoldCoordinate[scrt][0] && locationxyA[0][1]==SecretGoldCoordinate[scrt][1])
					{
						grid[locationxyA[0][0]][locationxyA[0][1]].setFont(new Font("Tahoma", Font.BOLD, 12));
						grid[locationxyA[0][0]][locationxyA[0][1]].setForeground(Color.MAGENTA);
						totalGoldA=totalGoldA+Integer.parseInt(grid[locationxyA[0][0]][locationxyA[0][1]].getText());
						System.out.println("girdi girdi");
					}
				}
			}
			
		}
		if(targetLengthy > 0) {
		while(locationxyA[0][1]!=targetCoordinate[0][1] && moveA!=3) {
			locationxyA[0][1]=locationxyA[0][1]+1;
			grid[locationxyA[0][0]][locationxyA[0][1]].setBorder(new LineBorder(Color.CYAN));
			grid[locationxyA[0][0]][locationxyA[0][1]].setForeground(Color.RED);
			grid[locationxyA[0][0]][locationxyA[0][1]].setHorizontalAlignment(SwingConstants.CENTER);
			moveA++;
			for(int scrt=0;scrt<sayac2;scrt++) {
				if(locationxyA[0][0]==SecretGoldCoordinate[scrt][0] && locationxyA[0][1]==SecretGoldCoordinate[scrt][1])
				{
					grid[locationxyA[0][0]][locationxyA[0][1]].setFont(new Font("Tahoma", Font.BOLD, 12));
					grid[locationxyA[0][0]][locationxyA[0][1]].setForeground(Color.MAGENTA);
					totalGoldA=totalGoldA+Integer.parseInt(grid[locationxyA[0][0]][locationxyA[0][1]].getText());
					System.out.println("girdi girdi");
				}
			}
		}
		}else {
			while(locationxyA[0][1]!=targetCoordinate[0][1] && moveA!=3) {
				locationxyA[0][1]=locationxyA[0][1]-1;
				grid[locationxyA[0][0]][locationxyA[0][1]].setBorder(new LineBorder(Color.CYAN));
				grid[locationxyA[0][0]][locationxyA[0][1]].setForeground(Color.RED);
				grid[locationxyA[0][0]][locationxyA[0][1]].setHorizontalAlignment(SwingConstants.CENTER);
				moveA++;
				for(int scrt=0;scrt<sayac2;scrt++) {
					if(locationxyA[0][0]==SecretGoldCoordinate[scrt][0] && locationxyA[0][1]==SecretGoldCoordinate[scrt][1])
					{
						grid[locationxyA[0][0]][locationxyA[0][1]].setFont(new Font("Tahoma", Font.BOLD, 12));
						grid[locationxyA[0][0]][locationxyA[0][1]].setForeground(Color.MAGENTA);
						totalGoldA=totalGoldA+Integer.parseInt(grid[locationxyA[0][0]][locationxyA[0][1]].getText());
						System.out.println("girdi girdi");
					}
				}
			}
		}
		
		if(locationxyA[0][1]==targetCoordinate[0][1] && locationxyA[0][0]==targetCoordinate[0][0]) {
			
		totalGoldA=totalGoldA+Integer.parseInt(grid[targetCoordinate[0][0]][targetCoordinate[0][1]].getText());
		
		for(int a=0;a<total_Gold;a++) {
			if(GoldCoordinate[a][0]==targetCoordinate[0][0] && GoldCoordinate[a][1]==targetCoordinate[0][1]) {
				GoldCoordinate[a][0]=99;
				GoldCoordinate[a][1]=99;
			}
		}
		
		}
		totalGoldA=totalGoldA-5;//adým atma maaliyeti
		System.out.println(totalGoldA);
		moveA = 0;			
		}
	*/
		
		
		// -----------------------------------------------------------------
		// B için altýn hedefi belirleme :
		// -----------------------------------------------------------------
		grid[0][9].setText("0");
		grid[0][9].setForeground(Color.RED);
		grid[0][9].setHorizontalAlignment(SwingConstants.CENTER);
		
		Player gamerB = new GamerB();
		GamerB gmB = new GamerB();
		int [][] targetCoordinateB = new int [1][2];
		int [][] locationxyB= new int [1][2];
		locationxyB [0][0]=0;
		locationxyB [0][1]=9;
		int totalGoldB = gamerB.getGold();
		int moveB = 0;
		int targetLengthxB,targetLengthyB;
		targetCoordinateB[0][0]=0;
		targetCoordinateB[0][1]=9;
		
		for(int b=0;b<12;b++) {
			//System.out.println("lokasyonx:"+locationxyB[0][0]+"lokasyony"+locationxyB[0][1]);
			//System.out.println("gidilecekler "+targetCoordinateB[0][0]+" "+targetCoordinateB[0][1]);
			if(locationxyB[0][1]==targetCoordinateB[0][1] && locationxyB[0][0]==targetCoordinateB[0][0]) {
				
				targetCoordinateB = gmB.chooseTargetB(sayac,GoldCoordinate,locationxyB,grid);
				totalGoldB=totalGoldB-5;// hedef belirleme maaliyeti
				}
			System.out.println("b :" + b);
			System.out.println("gidilecekler "+targetCoordinateB[0][0]+" "+targetCoordinateB[0][1]);
		
			targetLengthxB = targetCoordinateB[0][0] - locationxyB[0][0];
			targetLengthyB = targetCoordinateB[0][1] - locationxyB[0][1];
		if(targetLengthxB > 0) {
		while(locationxyB[0][0]!=targetCoordinateB[0][0] && moveB!=3) {
			locationxyB[0][0]=locationxyB[0][0]+1;
			grid[locationxyB[0][0]][locationxyB[0][1]].setBorder(new LineBorder(Color.CYAN));
			grid[locationxyB[0][0]][locationxyB[0][1]].setForeground(Color.RED);
			grid[locationxyB[0][0]][locationxyB[0][1]].setHorizontalAlignment(SwingConstants.CENTER);
			moveB++;
			for(int scrt=0;scrt<sayac2;scrt++) {
				if(locationxyB[0][0]==SecretGoldCoordinate[scrt][0] && locationxyB[0][1]==SecretGoldCoordinate[scrt][1])
				{
					grid[locationxyB[0][0]][locationxyB[0][1]].setFont(new Font("Tahoma", Font.BOLD, 12));
					grid[locationxyB[0][0]][locationxyB[0][1]].setForeground(Color.MAGENTA);
					totalGoldB=totalGoldB+Integer.parseInt(grid[locationxyB[0][0]][locationxyB[0][1]].getText());
					System.out.println("girdi girdi");
				}
			}
		}
		}
		else {
			while(locationxyB[0][0]!=targetCoordinateB[0][0] && moveB!=3) {
				locationxyB[0][0]=locationxyB[0][0]-1;
				grid[locationxyB[0][0]][locationxyB[0][1]].setBorder(new LineBorder(Color.CYAN));
				grid[locationxyB[0][0]][locationxyB[0][1]].setForeground(Color.RED);
				grid[locationxyB[0][0]][locationxyB[0][1]].setHorizontalAlignment(SwingConstants.CENTER);
				moveB++;
				for(int scrt=0;scrt<sayac2;scrt++) {
					if(locationxyB[0][0]==SecretGoldCoordinate[scrt][0] && locationxyB[0][1]==SecretGoldCoordinate[scrt][1])
					{
						grid[locationxyB[0][0]][locationxyB[0][1]].setFont(new Font("Tahoma", Font.BOLD, 12));
						grid[locationxyB[0][0]][locationxyB[0][1]].setForeground(Color.MAGENTA);
						totalGoldB=totalGoldB+Integer.parseInt(grid[locationxyB[0][0]][locationxyB[0][1]].getText());
						System.out.println("girdi girdi");
					}
				}
			}
			
		}
		if(targetLengthyB > 0) {
		while(locationxyB[0][1]!=targetCoordinateB[0][1] && moveB!=3) {
			locationxyB[0][1]=locationxyB[0][1]+1;
			grid[locationxyB[0][0]][locationxyB[0][1]].setBorder(new LineBorder(Color.CYAN));
			grid[locationxyB[0][0]][locationxyB[0][1]].setForeground(Color.RED);
			grid[locationxyB[0][0]][locationxyB[0][1]].setHorizontalAlignment(SwingConstants.CENTER);
			moveB++;
			for(int scrt=0;scrt<sayac2;scrt++) {
				if(locationxyB[0][0]==SecretGoldCoordinate[scrt][0] && locationxyB[0][1]==SecretGoldCoordinate[scrt][1])
				{
					grid[locationxyB[0][0]][locationxyB[0][1]].setFont(new Font("Tahoma", Font.BOLD, 12));
					grid[locationxyB[0][0]][locationxyB[0][1]].setForeground(Color.MAGENTA);
					totalGoldB=totalGoldB+Integer.parseInt(grid[locationxyB[0][0]][locationxyB[0][1]].getText());
					System.out.println("girdi girdi");
				}
			}
		}
		}else {
			while(locationxyB[0][1]!=targetCoordinateB[0][1] && moveB!=3) {
				locationxyB[0][1]=locationxyB[0][1]-1;
				grid[locationxyB[0][0]][locationxyB[0][1]].setBorder(new LineBorder(Color.CYAN));
				grid[locationxyB[0][0]][locationxyB[0][1]].setForeground(Color.RED);
				grid[locationxyB[0][0]][locationxyB[0][1]].setHorizontalAlignment(SwingConstants.CENTER);
				moveB++;
				for(int scrt=0;scrt<sayac2;scrt++) {
					if(locationxyB[0][0]==SecretGoldCoordinate[scrt][0] && locationxyB[0][1]==SecretGoldCoordinate[scrt][1])
					{
						grid[locationxyB[0][0]][locationxyB[0][1]].setFont(new Font("Tahoma", Font.BOLD, 12));
						grid[locationxyB[0][0]][locationxyB[0][1]].setForeground(Color.MAGENTA);
						totalGoldB=totalGoldB+Integer.parseInt(grid[locationxyB[0][0]][locationxyB[0][1]].getText());
						System.out.println("girdi girdi");
					}
				}
			}
		}
		
		if(locationxyB[0][1]==targetCoordinateB[0][1] && locationxyB[0][0]==targetCoordinateB[0][0]) {
			
		totalGoldB=totalGoldB+Integer.parseInt(grid[targetCoordinateB[0][0]][targetCoordinateB[0][1]].getText());
		
		for(int a=0;a<total_Gold;a++) {
			if(GoldCoordinate[a][0]==targetCoordinateB[0][0] && GoldCoordinate[a][1]==targetCoordinateB[0][1]) {
				GoldCoordinate[a][0]=99;
				GoldCoordinate[a][1]=99;
			}
		}
		
		}
		totalGoldB=totalGoldB-5;//adým atma maaliyeti
		System.out.println(totalGoldB);
		moveB = 0;			
		}
	
		
	}
}