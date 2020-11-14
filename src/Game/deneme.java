package Game;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Label;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;

public class deneme extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deneme frame = new deneme();
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
	public deneme() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 436, 253);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel dimg = new JLabel("5");
		dimg.setBackground(Color.DARK_GRAY);
		dimg.setForeground(Color.DARK_GRAY);
		dimg.setHorizontalAlignment(SwingConstants.CENTER);
		dimg.setBounds(30, 30, 66, 66);
		panel.add(dimg);
		
		Board GameBoard = new Board();
		System.out.println("Gameboard :"+GameBoard.getGold_Number());
		GameBoard.setGold_Number(30);
		System.out.println("Gameboard :"+GameBoard.getGold_Number());
		
	}
}
