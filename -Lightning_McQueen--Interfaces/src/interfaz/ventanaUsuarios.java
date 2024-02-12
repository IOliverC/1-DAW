package interfaz;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class ventanaUsuarios extends JFrame {
	private metodos usuario=new metodos();
	
	public ventanaUsuarios() {
		setResizable(false);
		setMinimumSize(new Dimension(717, 461));
		getContentPane().setBackground(new Color(0, 0, 0));
		getContentPane().setLayout(null);
		
		final JButton btnYaTengoCuenta = new JButton("Login");
		btnYaTengoCuenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventanaSecundaria frame = new ventanaSecundaria();
                frame.setVisible(true);
                btnYaTengoCuenta.setVisible(false);
			}
		});
		btnYaTengoCuenta.setBounds(440, 388, 150, 23);
		getContentPane().add(btnYaTengoCuenta);
		
		final JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventanaPrincipal frame = new ventanaPrincipal();
                frame.setVisible(true);
                btnRegistrarse.setVisible(false);
			}
		});
		btnRegistrarse.setBounds(440, 355, 150, 23);
		getContentPane().add(btnRegistrarse);
		
		textField = new JTextField();
		textField.setBounds(46, 89, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Usuario");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(64, 72, 55, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Contraseña");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(166, 72, 80, 14);
		getContentPane().add(lblNewLabel_2_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(160, 89, 86, 20);
		getContentPane().add(passwordField);
		
		table_1 = new JTable();
		table_1.setForeground(new Color(255, 255, 255));
		table_1.setBackground(new Color(0, 0, 0));
		table_1.setModel(usuario.rellenarTabla());
		table_1.setBounds(316, 74, 373, 274);
		getContentPane().add(table_1);
		
		final JButton btnEliminarUsuario = new JButton("Eliminar Usuario");
		btnEliminarUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(usuario.validarUsuario(textField.getText(), passwordField.getText())==1) {
					usuario.eliminarUsuario(textField.getText());
					JOptionPane.showMessageDialog(btnEliminarUsuario, "Se ha eliminado el usuario con éxito", "Todo correcto",
                            JOptionPane.INFORMATION_MESSAGE);
					table_1.setModel(usuario.rellenarTabla());	
			}else {
				JOptionPane.showMessageDialog(btnEliminarUsuario, "Usuario no registrado o Datos incorrectos", "No.",
                        JOptionPane.INFORMATION_MESSAGE);
			}	
			}
		});
		btnEliminarUsuario.setBounds(77, 167, 150, 23);
		getContentPane().add(btnEliminarUsuario);
		
		final JButton btnNewButton = new JButton("Comprobar Usuario");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(usuario.validarUsuario(textField.getText(), passwordField.getText())==1) {
					JOptionPane.showMessageDialog(btnNewButton, "Datos comprobados con éxito", "Todo correcto",
                            JOptionPane.INFORMATION_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(btnNewButton, "Usuario no registrado o Datos incorrectos", "No.",
                        JOptionPane.INFORMATION_MESSAGE);
			}
			}	
		});
		btnNewButton.setBounds(77, 133, 150, 23);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ventanaUsuarios.class.getResource("/interfaz/imagen/tabla.png")));
		lblNewLabel.setBounds(0, 89, 699, 421);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("¿Necesitas alguna modificación?");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(20, 11, 297, 64);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Lista de usuarios ");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(425, 11, 140, 83);
		getContentPane().add(lblNewLabel_1_1);
	}

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaUsuarios frame = new ventanaUsuarios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	conexionSQL cc=new conexionSQL();
	Connection con=cc.conexion();
	
	private final JTable table = new JTable();
	private JTable table_1;
	private JTextField textField;
	private JPasswordField passwordField;
	

	/**
	 * Create the frame.
	 */
	
	public void ventanaUsuarios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		table.setBounds(10, 11, 414, 239);
		contentPane.add(table);
	}
}
