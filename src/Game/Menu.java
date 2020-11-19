package Game;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import java.awt.ComponentOrientation;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import javax.swing.JTree;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;

public class Menu extends JFrame {

	private JPanel contentPane;
	public JTextField textRows;
	private JTextField textColumns;
	private JTextField goldRate;
	private JTextField secretGoldRate;
	private JTextField gold;
	private JTextField maxMove;
	private JTextField moveCost;
	private JTextField targetCost;
	public String getRow;
	public String getColumns;
	public String getNgold;
	public String getNsgold;
	public String getGoldA;
	public String getMaxmoveA;
	public String getMovecostA;
	public String getTargetcostA;
	public String getGoldB;
	public String getMaxmoveB;
	public String getMovecostB;
	public String getTargetcostB;
	public String getGoldC;
	public String getMaxmoveC;
	public String getMovecostC;
	public String getTargetcostC;
	public String getGoldD;
	public String getMaxmoveD;
	public String getMovecostD;
	public String getTargetcostD;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 992, 475);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel labelSetting = new JLabel("Game Settings");
		labelSetting.setForeground(SystemColor.info);
		labelSetting.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelSetting.setHorizontalAlignment(SwingConstants.CENTER);
		labelSetting.setBounds(62, 101, 174, 36);
		panel.add(labelSetting);
		
		textRows = new JTextField();
		textRows.setHorizontalAlignment(SwingConstants.CENTER);
		textRows.setText("20");
		textRows.setBackground(SystemColor.info);
		textRows.setBounds(176, 181, 60, 25);
		panel.add(textRows);
		textRows.setColumns(10);
		
		JLabel txtNetflix = new JLabel();
		txtNetflix.setHorizontalTextPosition(SwingConstants.CENTER);
		txtNetflix.setHorizontalAlignment(SwingConstants.CENTER);
		txtNetflix.setBorder(null);
		txtNetflix.setBackground(Color.DARK_GRAY);
		txtNetflix.setFont(new Font("Ink Free", Font.BOLD | Font.ITALIC, 55));
		txtNetflix.setForeground(new Color(255, 255, 0));
		txtNetflix.setText("GOLDHUNTER");
		txtNetflix.setBounds(169, 19, 660, 72);
		panel.add(txtNetflix);
		
		JLabel lblNewLabel_1 = new JLabel("Rows :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(SystemColor.activeCaption);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(20, 175, 150, 30);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Columns :");
		lblNewLabel_1_1.setForeground(SystemColor.activeCaption);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setBounds(20, 215, 150, 30);
		panel.add(lblNewLabel_1_1);
		
		Button btnNewButton = new Button("Start The Game");
		btnNewButton.setName("Start");
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnNewButton.setBackground(new Color(255, 204, 0));
		btnNewButton.setForeground(SystemColor.menuText);
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	
		    	getRow = textRows.getText();
		    	getColumns = textColumns.getText();
		    	getNgold = goldRate.getText();
		    	getNsgold = secretGoldRate.getText();
		    	
		          File file = new File("dosya.txt");
		          if (!file.exists()) {
		              try {
						file.createNewFile();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		          }
		          
		          FileWriter fileWriter = null;
				try {
					fileWriter = new FileWriter(file, false);
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
		          BufferedWriter bWriter = new BufferedWriter(fileWriter);
		          try {
					bWriter.write(getRow);
					bWriter.newLine();
					bWriter.write(getColumns);
					bWriter.newLine();
					bWriter.write(getNgold);
					bWriter.newLine();
					bWriter.write(getNsgold);
					

				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
		          try {
					bWriter.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	
				MainFrame mainframe = new MainFrame();
				mainframe.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(400, 413, 192, 52);
		panel.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 163, 292, 2);
		panel.add(separator);
		
		textColumns = new JTextField();
		textColumns.setText("20");
		textColumns.setHorizontalAlignment(SwingConstants.CENTER);
		textColumns.setColumns(10);
		textColumns.setBackground(SystemColor.info);
		textColumns.setBounds(176, 221, 60, 25);
		panel.add(textColumns);
		
		JLabel labelGoldRate = new JLabel("Gold Number :");
		labelGoldRate.setForeground(SystemColor.activeCaption);
		labelGoldRate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelGoldRate.setBackground(Color.WHITE);
		labelGoldRate.setBounds(20, 255, 150, 30);
		panel.add(labelGoldRate);
		
		JLabel labelSecretGold = new JLabel("Secret Gold Number :");
		labelSecretGold.setForeground(SystemColor.activeCaption);
		labelSecretGold.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelSecretGold.setBackground(Color.WHITE);
		labelSecretGold.setBounds(20, 295, 150, 30);
		panel.add(labelSecretGold);
		
		goldRate = new JTextField();
		goldRate.setText("20");
		goldRate.setHorizontalAlignment(SwingConstants.CENTER);
		goldRate.setColumns(10);
		goldRate.setBackground(SystemColor.info);
		goldRate.setBounds(176, 261, 60, 25);
		panel.add(goldRate);
		
		secretGoldRate = new JTextField();
		secretGoldRate.setText("10");
		secretGoldRate.setHorizontalAlignment(SwingConstants.CENTER);
		secretGoldRate.setColumns(10);
		secretGoldRate.setBackground(SystemColor.info);
		secretGoldRate.setBounds(176, 301, 60, 25);
		panel.add(secretGoldRate);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 335, 292, 2);
		panel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(302, 163, 2, 172);
		panel.add(separator_2);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setOrientation(SwingConstants.VERTICAL);
		separator_2_1.setBounds(10, 163, 2, 172);
		panel.add(separator_2_1);
		
		JLabel minerLabel = new JLabel("");
		minerLabel.setIcon(new ImageIcon(Menu.class.getResource("/images/miner.png")));
		minerLabel.setBounds(96, 19, 100, 80);
		panel.add(minerLabel);
		
		JLabel minerLabel_1 = new JLabel("");
		minerLabel_1.setIcon(new ImageIcon(Menu.class.getResource("/images/miner.png")));
		minerLabel_1.setBounds(765, 19, 100, 80);
		panel.add(minerLabel_1);
		
		JLabel lblPlayerSettings = new JLabel("Player Settings");
		lblPlayerSettings.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerSettings.setForeground(SystemColor.info);
		lblPlayerSettings.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPlayerSettings.setBounds(730, 101, 174, 42);
		panel.add(lblPlayerSettings);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(562, 335, 400, 2);
		panel.add(separator_4);
		
		JSeparator separator_2_2 = new JSeparator();
		separator_2_2.setOrientation(SwingConstants.VERTICAL);
		separator_2_2.setBounds(562, 165, 2, 172);
		panel.add(separator_2_2);
		
		JSeparator separator_2_3 = new JSeparator();
		separator_2_3.setOrientation(SwingConstants.VERTICAL);
		separator_2_3.setBounds(962, 165, 2, 172);
		panel.add(separator_2_3);
		
		JLabel lblNewLabel_1_2 = new JLabel("Gold :");
		lblNewLabel_1_2.setForeground(SystemColor.activeCaption);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBackground(Color.WHITE);
		lblNewLabel_1_2.setBounds(574, 175, 162, 30);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Max Move :");
		lblNewLabel_1_3.setForeground(SystemColor.activeCaption);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_3.setBackground(Color.WHITE);
		lblNewLabel_1_3.setBounds(574, 215, 162, 30);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Move Cost :");
		lblNewLabel_1_4.setForeground(SystemColor.activeCaption);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_4.setBackground(Color.WHITE);
		lblNewLabel_1_4.setBounds(574, 255, 162, 30);
		panel.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Target Cost :");
		lblNewLabel_1_5.setForeground(SystemColor.activeCaption);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_5.setBackground(Color.WHITE);
		lblNewLabel_1_5.setBounds(574, 295, 162, 30);
		panel.add(lblNewLabel_1_5);
		
		gold = new JTextField();
		gold.setText("200");
		gold.setHorizontalAlignment(SwingConstants.CENTER);
		gold.setColumns(10);
		gold.setBackground(SystemColor.info);
		gold.setBounds(787, 184, 117, 25);
		panel.add(gold);
		
		maxMove = new JTextField();
		maxMove.setText("3");
		maxMove.setHorizontalAlignment(SwingConstants.CENTER);
		maxMove.setColumns(10);
		maxMove.setBackground(SystemColor.info);
		maxMove.setBounds(787, 224, 117, 25);
		panel.add(maxMove);
		
		moveCost = new JTextField();
		moveCost.setText("5");
		moveCost.setHorizontalAlignment(SwingConstants.CENTER);
		moveCost.setColumns(10);
		moveCost.setBackground(SystemColor.info);
		moveCost.setBounds(787, 264, 117, 25);
		panel.add(moveCost);
		
		targetCost = new JTextField();
		targetCost.setText("10");
		targetCost.setHorizontalAlignment(SwingConstants.CENTER);
		targetCost.setColumns(10);
		targetCost.setBackground(SystemColor.info);
		targetCost.setBounds(787, 304, 117, 25);
		panel.add(targetCost);
		
		JSeparator separator_4_1 = new JSeparator();
		separator_4_1.setBounds(562, 163, 400, 2);
		panel.add(separator_4_1);
		
		JButton btnNewButton_1 = new JButton("Set GamerA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				getGoldA = gold.getText();
		    	getMaxmoveA = maxMove.getText();
		    	getMovecostA = moveCost.getText();
		    	getTargetcostA = targetCost.getText();
		    	  
		    	File fileA = new File("gamerA.txt");
		          if (!fileA.exists()) {
		              try {
						fileA.createNewFile();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		          }
		          
		          FileWriter fileWriterA = null;
				try {
					fileWriterA = new FileWriter(fileA, false);
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
		          BufferedWriter bWriterA = new BufferedWriter(fileWriterA);
		          try {
		        		bWriterA.write(getGoldA);
						bWriterA.newLine();
						bWriterA.write(getMaxmoveA);
						bWriterA.newLine();
						bWriterA.write(getMovecostA);
						bWriterA.newLine();
						bWriterA.write(getTargetcostA);
					

				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
		          try {
					bWriterA.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		btnNewButton_1.setBorder(new LineBorder(new Color(204, 204, 255), 2));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBackground(new Color(204, 255, 204));
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBounds(562, 140, 90, 25);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Set GamerB");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				getGoldB = gold.getText();
		    	getMaxmoveB = maxMove.getText();
		    	getMovecostB = moveCost.getText();
		    	getTargetcostB = targetCost.getText();
		    	  
		    	File fileB = new File("gamerB.txt");
		          if (!fileB.exists()) {
		              try {
						fileB.createNewFile();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		          }
		          
		          FileWriter fileWriterB = null;
				try {
					fileWriterB = new FileWriter(fileB, false);
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
		          BufferedWriter bWriterB = new BufferedWriter(fileWriterB);
		          try {
		        		bWriterB.write(getGoldB);
						bWriterB.newLine();
						bWriterB.write(getMaxmoveB);
						bWriterB.newLine();
						bWriterB.write(getMovecostB);
						bWriterB.newLine();
						bWriterB.write(getTargetcostB);
					

				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
		          try {
					bWriterB.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1_1.setForeground(Color.BLACK);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1_1.setBorder(new LineBorder(new Color(204, 204, 255), 2));
		btnNewButton_1_1.setBackground(new Color(204, 255, 204));
		btnNewButton_1_1.setBounds(662, 140, 90, 25);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Set GamerC");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				getGoldC = gold.getText();
		    	getMaxmoveC = maxMove.getText();
		    	getMovecostC = moveCost.getText();
		    	getTargetcostC = targetCost.getText();
		    	  
		    	File fileC = new File("gamerC.txt");
		          if (!fileC.exists()) {
		              try {
						fileC.createNewFile();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		          }
		          
		          FileWriter fileWriterC = null;
				try {
					fileWriterC = new FileWriter(fileC, false);
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
		          BufferedWriter bWriterC = new BufferedWriter(fileWriterC);
		          try {
		        		bWriterC.write(getGoldC);
						bWriterC.newLine();
						bWriterC.write(getMaxmoveC);
						bWriterC.newLine();
						bWriterC.write(getMovecostC);
						bWriterC.newLine();
						bWriterC.write(getTargetcostC);
					

				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
		          try {
					bWriterC.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1_2.setForeground(Color.BLACK);
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1_2.setBorder(new LineBorder(new Color(204, 204, 255), 2));
		btnNewButton_1_2.setBackground(new Color(204, 255, 204));
		btnNewButton_1_2.setBounds(765, 140, 90, 25);
		panel.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton("Set GamerD");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				getGoldD = gold.getText();
		    	getMaxmoveD = maxMove.getText();
		    	getMovecostD = moveCost.getText();
		    	getTargetcostD = targetCost.getText();
		    	  
		    	File fileD = new File("gamerD.txt");
		          if (!fileD.exists()) {
		              try {
						fileD.createNewFile();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		          }
		          
		          FileWriter fileWriterD = null;
				try {
					fileWriterD = new FileWriter(fileD, false);
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
		          BufferedWriter bWriterD = new BufferedWriter(fileWriterD);
		          try {
		        		bWriterD.write(getGoldD);
						bWriterD.newLine();
						bWriterD.write(getMaxmoveD);
						bWriterD.newLine();
						bWriterD.write(getMovecostD);
						bWriterD.newLine();
						bWriterD.write(getTargetcostD);
					

				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
		          try {
					bWriterD.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1_3.setForeground(Color.BLACK);
		btnNewButton_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1_3.setBorder(new LineBorder(new Color(204, 204, 255), 2));
		btnNewButton_1_3.setBackground(new Color(204, 255, 204));
		btnNewButton_1_3.setBounds(865, 140, 90, 25);
		panel.add(btnNewButton_1_3);
		
		
	}
}