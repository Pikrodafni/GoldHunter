package Game;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JTextField textRows;
	private JTextField textColumns;
	private JTextField goldRate;
	private JTextField secretGoldRate;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;


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
		
		JLabel labelGoldRate = new JLabel("Gold Rate :");
		labelGoldRate.setForeground(SystemColor.activeCaption);
		labelGoldRate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelGoldRate.setBackground(Color.WHITE);
		labelGoldRate.setBounds(20, 255, 150, 30);
		panel.add(labelGoldRate);
		
		JLabel labelSecretGold = new JLabel("Secret Gold Rate :");
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
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(672, 163, 292, 2);
		panel.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(672, 335, 292, 2);
		panel.add(separator_4);
		
		JSeparator separator_2_2 = new JSeparator();
		separator_2_2.setOrientation(SwingConstants.VERTICAL);
		separator_2_2.setBounds(672, 165, 2, 172);
		panel.add(separator_2_2);
		
		JSeparator separator_2_3 = new JSeparator();
		separator_2_3.setOrientation(SwingConstants.VERTICAL);
		separator_2_3.setBounds(962, 165, 2, 172);
		panel.add(separator_2_3);
		
		JLabel lblNewLabel_1_2 = new JLabel("Gold :");
		lblNewLabel_1_2.setForeground(SystemColor.activeCaption);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBackground(Color.WHITE);
		lblNewLabel_1_2.setBounds(682, 175, 150, 30);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Max Move :");
		lblNewLabel_1_3.setForeground(SystemColor.activeCaption);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_3.setBackground(Color.WHITE);
		lblNewLabel_1_3.setBounds(684, 215, 150, 30);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Move Cost :");
		lblNewLabel_1_4.setForeground(SystemColor.activeCaption);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_4.setBackground(Color.WHITE);
		lblNewLabel_1_4.setBounds(684, 255, 150, 30);
		panel.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Target Cost :");
		lblNewLabel_1_5.setForeground(SystemColor.activeCaption);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_5.setBackground(Color.WHITE);
		lblNewLabel_1_5.setBounds(684, 295, 150, 30);
		panel.add(lblNewLabel_1_5);
		
		textField = new JTextField();
		textField.setText("200");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		textField.setBackground(SystemColor.info);
		textField.setBounds(844, 184, 60, 25);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText("3");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		textField_1.setBackground(SystemColor.info);
		textField_1.setBounds(844, 224, 60, 25);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("5");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setColumns(10);
		textField_2.setBackground(SystemColor.info);
		textField_2.setBounds(844, 264, 60, 25);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("10");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setColumns(10);
		textField_3.setBackground(SystemColor.info);
		textField_3.setBounds(844, 304, 60, 25);
		panel.add(textField_3);
		
		JButton btnNewButton_1 = new JButton("GamerA");
		btnNewButton_1.setBorder(new LineBorder(new Color(204, 204, 255), 2));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBackground(new Color(204, 255, 204));
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBounds(672, 144, 65, 21);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("GamerB");
		btnNewButton_1_1.setForeground(Color.BLACK);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1_1.setBorder(new LineBorder(new Color(204, 204, 255), 2));
		btnNewButton_1_1.setBackground(new Color(255, 204, 255));
		btnNewButton_1_1.setBounds(742, 144, 65, 21);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("GamerC");
		btnNewButton_1_2.setForeground(Color.BLACK);
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1_2.setBorder(new LineBorder(new Color(204, 204, 255), 2));
		btnNewButton_1_2.setBackground(new Color(204, 255, 255));
		btnNewButton_1_2.setBounds(812, 144, 65, 21);
		panel.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton("GamerD");
		btnNewButton_1_3.setForeground(Color.BLACK);
		btnNewButton_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1_3.setBorder(new LineBorder(new Color(204, 204, 255), 2));
		btnNewButton_1_3.setBackground(new Color(255, 255, 204));
		btnNewButton_1_3.setBounds(882, 144, 65, 21);
		panel.add(btnNewButton_1_3);
		
	}
}