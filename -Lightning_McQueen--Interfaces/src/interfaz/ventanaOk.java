package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JSpinner;

public class ventanaOk extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaOk frame = new ventanaOk();
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
	public ventanaOk() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 458, 607);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("(cargando...)");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Zen Dots", Font.PLAIN, 20));
		lblNewLabel_1.setToolTipText("");
		lblNewLabel_1.setBounds(173, 193, 185, 125);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("BIENVENID@ :))");
		lblNewLabel_1_1.setToolTipText("");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Zen Dots", Font.PLAIN, 32));
		lblNewLabel_1_1.setBounds(98, 139, 320, 125);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 451, 574);
		lblNewLabel.setIcon(new ImageIcon(ventanaOk.class.getResource("/interfaz/imagen/guay.jpg")));
		contentPane.add(lblNewLabel);
		
		
	}
}
