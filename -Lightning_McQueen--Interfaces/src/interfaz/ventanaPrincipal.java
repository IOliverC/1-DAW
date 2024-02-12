package interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ventanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblRegistro;
	private JLabel lblUsuario;
	private JLabel lblCorreo;
	private JLabel lblContraseña;
	private JLabel lblContra;
	private JTextField txtUsuario;
	private JTextField textCorreo;
	private JPasswordField passwordField;
	private JButton btnYaTengoCuenta;
	private metodos usuario=new metodos();
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaPrincipal frame = new ventanaPrincipal();
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
	public ventanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 458, 607);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(230, 247, 150, 20);
		contentPane.add(passwordField_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(230, 216, 150, 20);
		contentPane.add(passwordField);
		
		final JButton btnRegistrarse = new JButton("REGISTRARSE");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				String icono = "/interfaz/imagen/tic.png";
                ImageIcon tic = new ImageIcon(getClass().getResource(icono));
				if(passwordField.getText().equals(passwordField_1.getText()) && !txtUsuario.getText().isEmpty() && !textCorreo.getText().isEmpty() && !passwordField.getText().isEmpty() && !passwordField_1.getText().isEmpty()&& textCorreo.getText().contains("@") && textCorreo.getText().contains(".")) {
									JOptionPane.showMessageDialog(btnRegistrarse, "Te has registrado", "Todo correcto",
                            JOptionPane.INFORMATION_MESSAGE,tic);
				ventanaSecundaria frame = new ventanaSecundaria();
				usuario.AgregarUsuario(txtUsuario.getText(), passwordField.getText(), textCorreo.getText());
                frame.setVisible(true);
                btnRegistrarse.setVisible(false);
				}else {
					if(!passwordField.getText().equals(passwordField_1.getText())){
						JOptionPane.showMessageDialog(btnRegistrarse,"Comprueba la contraseña","ERROR CONTRASEÑA INCORRECTA", JOptionPane.WARNING_MESSAGE);
				}else if(txtUsuario.getText().isEmpty()) {
						JOptionPane.showMessageDialog(btnRegistrarse,"Usuario no válido/incompleto","ERROR", JOptionPane.WARNING_MESSAGE);
				}else if(textCorreo.getText().isEmpty()){
						JOptionPane.showMessageDialog(btnRegistrarse,"Correo incompleto","ERROR", JOptionPane.WARNING_MESSAGE);
				}else if(!textCorreo.getText().contains("@") && !textCorreo.getText().contains(".")){
                    JOptionPane.showMessageDialog(btnRegistrarse,"Email no válido","ERROR",JOptionPane.WARNING_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(btnRegistrarse,"Contraseña incompleta","ERROR", JOptionPane.WARNING_MESSAGE);
				}
			}
			}
		});
		btnRegistrarse.setBounds(166, 309, 129, 23);
		contentPane.add(btnRegistrarse);
		
		btnYaTengoCuenta = new JButton("LOGIN");
		btnYaTengoCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int respuesta = JOptionPane.showOptionDialog(null,
		                "¿Desea iniciar sesión?",
		                "Inicio de Sesión",
		                JOptionPane.YES_NO_OPTION,
		                JOptionPane.QUESTION_MESSAGE,
		                null,
		                new Object[]{"Sí", "No"},
		                "Sí");
			if (respuesta == JOptionPane.YES_OPTION) {
	            // Acciones para iniciar sesión
	            System.out.println("Iniciando sesión...");
	        } else {
	            // Acciones si no se desea iniciar sesión
	            System.out.println("No se inició sesión.");
	        }
				ventanaSecundaria frame = new ventanaSecundaria();
                frame.setVisible(true);
                btnYaTengoCuenta.setVisible(false);
			}
		});
		btnYaTengoCuenta.setBounds(165, 338, 129, 23);
		contentPane.add(btnYaTengoCuenta);
		
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtUsuario.setBounds(230, 154, 150, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		textCorreo = new JTextField();
		textCorreo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textCorreo.setColumns(10);
		textCorreo.setBounds(230, 184, 150, 20);
		contentPane.add(textCorreo);
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Ubuntu", Font.PLAIN, 18));
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setBounds(156, 149, 72, 24);
		contentPane.add(lblUsuario);
		
		lblCorreo = new JLabel("Correo electrónico :");
		lblCorreo.setForeground(Color.WHITE);
		lblCorreo.setFont(new Font("Ubuntu", Font.PLAIN, 18));
		lblCorreo.setBounds(66, 182, 216, 24);
		contentPane.add(lblCorreo);
		
		lblContraseña = new JLabel("Contraseña:");
		lblContraseña.setForeground(Color.WHITE);
		lblContraseña.setFont(new Font("Ubuntu", Font.PLAIN, 18));
		lblContraseña.setBounds(123, 216, 102, 24);
		contentPane.add(lblContraseña);
		
		lblContra = new JLabel("Repite contraseña:");
		lblContra.setForeground(Color.WHITE);
		lblContra.setFont(new Font("Ubuntu", Font.PLAIN, 18));
		lblContra.setBounds(76, 245, 160, 24);
		contentPane.add(lblContra);
		
		lblNewLabel = new JLabel("REGI");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(new Color(89, 89, 89));
		lblNewLabel.setFont(new Font("Oswald", Font.PLAIN, 54));
		lblNewLabel.setBounds(93, 11, 298, 114);
		contentPane.add(lblNewLabel);
		
		lblRegistro = new JLabel("REGISTRO");
		lblRegistro.setForeground(new Color(202, 0, 0));
		lblRegistro.setFont(new Font("Oswald", Font.PLAIN, 54));
		lblRegistro.setBackground(Color.BLACK);
		lblRegistro.setBounds(93, 11, 298, 114);
		contentPane.add(lblRegistro);
		
		JLabel labelBackGround = new JLabel("");
		labelBackGround.setBounds(0, 0, 451, 574);
		labelBackGround.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/interfaz/imagen/lighting.jpg")));
		contentPane.add(labelBackGround);

	}
}
