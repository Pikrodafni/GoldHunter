package Game;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
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
		System.out.println("Kaça kaçlýk tahta olsun");
		int tahtax=600;
		int tahtay=600;
		int tahta =20;
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, tahtax, tahtay);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		int artis1=tahtax/tahta;
		int artis2=tahtay/tahta;
		int koordinatx=0,koordinaty=0;
		int i=0,j=0;
		int [] koordinatlarx = new int[tahta];
		int [] koordinatlary = new int[tahta];
		
		for(i=0;i<tahta;i++) {
			
			for(j=0;j<tahta;j++) {
				koordinatx=i*artis1;
				koordinaty=j*artis2;
				koordinatlarx[i]=koordinatx;
				koordinatlary[j]=koordinaty;
			JPanel panel = new JPanel();
			panel.setBounds(koordinatx, koordinaty, artis1, artis2);
			panel.setBorder(new LineBorder(new Color(192, 192, 192), 1));
			contentPane.add(panel);
			panel.setBackground(Color.CYAN);
			
			JLabel dimg = new JLabel("");
			dimg.setHorizontalAlignment(SwingConstants.CENTER);
			dimg.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gold.jpg")).getImage().getScaledInstance(artis1-5, artis2-10, Image.SCALE_SMOOTH)));
			panel.add(dimg);
			
			
			}
		}
		for(i=0;i<tahta;i++) {
			
			for(j=0;j<tahta;j++) {
				System.out.println("koordinatx:"+koordinatlarx[i]+"koordinaty:"+koordinatlary[j]);
			}
			}
		
		
		
	}
}