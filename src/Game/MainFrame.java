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

	/**
	 * Launch the application.
	 */
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
		int tahta =20;
		
		GamerA PlayerA = new GamerA();
		System.out.println("rank:" +PlayerA.getChoosing_Target_Cost() );
		
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
		int secret_gold=1;
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
			//System.out.println("Random NUM:"+(r+1)+" "+randomNum1[value]);
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
		String goldValues = "5";
		String GoldValues;
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
		int sayac=0,sayac2=0;
		for(i=0;i<tColumns;i++) {
			
			for(j=0;j<tRows;j++) {
					
				grid[i][j] = new JLabel("");
                grid[i][j].setBorder(new LineBorder(Color.BLACK));
                GamePanel.add(grid[i][j]);
                			
			for(int k1=0;k1<total_Gold;k1++) {
				
			if(((i*tRows)+j)==goldCoordinate.get(randomNum1[k1])) {
				gColumns.add(i);
				gRows.add(j);
				grid[i][j].setText("5");
				grid[i][j].setForeground(Color.YELLOW);
                grid[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                
                GamePanel.add(grid[i][j]);
                
                for(int k2=0;k2<total_Secret_Gold;k2++) {
                if(k1==randomNum2[k2]) {
                	grid[i][j].setFont(new java.awt.Font("Lucida Grande", 1, 0)); 
                	SecretGoldCoordinate[sayac2][0]=i;
                	sayac2++;
                	}
                else {
                	GoldCoordinate[sayac][0]=i;
                    GoldCoordinate[sayac][1]=j;

                }
                }
                sayac++;
						}
					}
				}
			}
		
		grid[0][0].setText("A");
		//grid[0][0].setForeground(Color.PINK);
		//grid[0][0].setHorizontalAlignment(SwingConstants.CENTER);
		
		int EnyakintopuzakA=0;
		int locationxA=0;
		int locationyA=0;
		int xuzak=0;
		int yuzak=0;
		int totaluzak=0;
		int enkucukuzak=500;
		int gidilecekx = 0;
		int gidileceky = 0;
		int totalGoldA = 0;
		int dongu=0;
		
		
			
				for(int k=0;k<sayac;k++) {
					int x=GoldCoordinate[k][0];
					int y=GoldCoordinate[k][1];
					
					if(grid[x][y].getText()=="0"||grid[x][y].getText()=="A") {
						continue;
						//break;
					}
					
					xuzak=GoldCoordinate[k][0]-locationxA;
					yuzak=GoldCoordinate[k][1]-locationyA;
					xuzak= Math.abs(xuzak);
					yuzak= Math.abs(yuzak);
					totaluzak=xuzak+yuzak;
					
					 if(totaluzak<enkucukuzak) {
						gidilecekx=GoldCoordinate[k][0];
						gidileceky=GoldCoordinate[k][1];
						enkucukuzak=totaluzak;
					}
					
				}

		
		if(gidilecekx+gidileceky<=3) {
			
		grid[locationxA][locationyA].setText("0");
		totalGoldA=totalGoldA+Integer.parseInt(grid[gidilecekx][gidileceky].getText());
		System.out.println("gidilecekler "+gidilecekx+" "+gidileceky);
		grid[gidilecekx][gidileceky].setText("A");
		grid[gidilecekx][gidileceky].setForeground(Color.PINK);
		locationxA=gidilecekx;
		locationyA=gidileceky;
	}
		else {
			if(gidilecekx>3) {
				locationxA=locationxA+3;
			}
			else if(gidileceky>3) {
				
			}
			
		}
		System.out.println(totalGoldA);
		//GoldCoordinate[gidilecekx][gidileceky];
		dongu++;
		xuzak=999999;
		yuzak=999999;
		totaluzak=999999;
		enkucukuzak=999999;
	
	}
}