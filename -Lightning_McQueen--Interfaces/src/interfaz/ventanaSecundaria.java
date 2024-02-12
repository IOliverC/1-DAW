package interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class ventanaSecundaria extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private metodos usuario=new metodos();

	conexionSQL cc=new conexionSQL();
	Connection con=cc.conexion();
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaSecundaria frame = new ventanaSecundaria();
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
	public ventanaSecundaria() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 458, 607);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JButton btnYaTengoCuenta = new JButton("LOGIN");
		btnYaTengoCuenta.setBounds(162, 269, 129, 23);
		contentPane.add(btnYaTengoCuenta);
		
		JLabel lblNewLabel_1 = new JLabel("LO");
		lblNewLabel_1.setForeground(new Color(89, 89, 89));
		lblNewLabel_1.setFont(new Font("Oswald", Font.PLAIN, 54));
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setBounds(156, 0, 193, 114);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblRegistro = new JLabel("LOGIN");
		btnYaTengoCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(usuario.validarUsuario(textField.getText(), passwordField.getText())==1) {
					JOptionPane.showMessageDialog(btnYaTengoCuenta, "Login existoso", "Todo correcto",
                            JOptionPane.INFORMATION_MESSAGE);
					 ventanaOk frame = new ventanaOk();
					 frame.setVisible(true);
					 btnYaTengoCuenta.setVisible(false);
				}else{
					JOptionPane.showMessageDialog(btnYaTengoCuenta, "Datos incorrectos/incompletos", "Usuario o contraseña erróneos",
                            JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		lblRegistro.setForeground(new Color(202, 0, 0));
		lblRegistro.setFont(new Font("Oswald", Font.PLAIN, 54));
		lblRegistro.setBackground(Color.BLACK);
		lblRegistro.setBounds(156, 0, 193, 114);
		contentPane.add(lblRegistro);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(228, 156, 150, 20);
		contentPane.add(textField);
		
		final JButton btnNewButton = new JButton("REGISTRARSE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaPrincipal frame = new ventanaPrincipal();
                frame.setVisible(true);
                btnNewButton.setVisible(false);
			}
		});
		btnNewButton.setBounds(162, 303, 129, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_1 = new JLabel("Usuario:");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Ubuntu", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(149, 151, 72, 24);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("Contraseña:");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Ubuntu", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(120, 190, 102, 24);
		contentPane.add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(229, 193, 150, 20);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 451, 574);
		lblNewLabel.setIcon(new ImageIcon(ventanaSecundaria.class.getResource("/interfaz/imagen/lighting.jpg")));
		contentPane.add(lblNewLabel);
	}

}
