package Game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.ComponentOrientation;
import java.awt.Component;

public class MainFrame extends JFrame {
	
	final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";

	final java.util.Random rand = new java.util.Random();

	// consider using a Map<String,Boolean> to say whether the identifier is being used or not 
	final Set<String> identifiers = new HashSet<String>();
	
	public String randomIdentifier() {
	    StringBuilder builder = new StringBuilder();
	    while(builder.toString().length() == 0) {
	        int length = rand.nextInt(5)+5;
	        for(int i = 0; i < length; i++) {
	            builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
	        }
	        if(identifiers.contains(builder.toString())) {
	            builder = new StringBuilder();
	        }
	    }
	    return builder.toString();
	}

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
		setUndecorated(true);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(20, 20, 1, 1));
		
		ArrayList <String> button_Names = new ArrayList<String>();
		
		for(int i = 0; i < 200; i++) {
			
			button_Names.add(randomIdentifier());
			System.out.println("1 " + button_Names.get(i));
			
		}
		
		JButton btnNewButton_1 = new JButton("New button");
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_8 = new JButton("New button");
		contentPane.add(btnNewButton_8);
		
		JButton btnNewButton_4 = new JButton("New button");
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.setHorizontalTextPosition(SwingConstants.LEFT);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("New button");
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("New button");
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton = new JButton("New button");
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_10 = new JButton("New button");
		contentPane.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("New button");
		contentPane.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("New button");
		contentPane.add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("New button");
		contentPane.add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("New button");
		contentPane.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("New button");
		contentPane.add(btnNewButton_15);
		
		JButton btnNewButton_14_1 = new JButton("New button");
		contentPane.add(btnNewButton_14_1);
		
		JButton btnNewButton_14_2 = new JButton("New button");
		contentPane.add(btnNewButton_14_2);
		
		JButton btnNewButton_14_3 = new JButton("New button");
		contentPane.add(btnNewButton_14_3);
		
		JButton btnNewButton_14_4 = new JButton("New button");
		contentPane.add(btnNewButton_14_4);
		
		JButton btnNewButton_14_5 = new JButton("New button");
		contentPane.add(btnNewButton_14_5);
		
		JButton btnNewButton_9 = new JButton("New button");
		contentPane.add(btnNewButton_9);
		
		JButton btnNewButton_14_7 = new JButton("New button");
		contentPane.add(btnNewButton_14_7);
		
		JButton btnNewButton_14_6 = new JButton("New button");
		contentPane.add(btnNewButton_14_6);
		
		JButton btnNewButton_14_9 = new JButton("New button");
		contentPane.add(btnNewButton_14_9);
		
		JButton btnNewButton_14_8 = new JButton("New button");
		contentPane.add(btnNewButton_14_8);
		
		JButton btnNewButton_14_12 = new JButton("New button");
		contentPane.add(btnNewButton_14_12);
		
		JButton btnNewButton_14_11 = new JButton("New button");
		contentPane.add(btnNewButton_14_11);
		
		JButton btnNewButton_14_14 = new JButton("New button");
		contentPane.add(btnNewButton_14_14);
		
		JButton btnNewButton_14_13 = new JButton("New button");
		contentPane.add(btnNewButton_14_13);
		
		JButton btnNewButton_14_15 = new JButton("New button");
		contentPane.add(btnNewButton_14_15);
		
		JButton btnNewButton_14_10 = new JButton("New button");
		contentPane.add(btnNewButton_14_10);
		
		JButton btnNewButton_14_17 = new JButton("New button");
		contentPane.add(btnNewButton_14_17);
		
		JButton btnNewButton_14_16 = new JButton("New button");
		contentPane.add(btnNewButton_14_16);
		
		JButton btnNewButton_14_18 = new JButton("New button");
		contentPane.add(btnNewButton_14_18);
		
		
		
	}

}
