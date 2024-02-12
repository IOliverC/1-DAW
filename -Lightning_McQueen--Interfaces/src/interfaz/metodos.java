package interfaz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;


public class metodos {
	
	
	private conexionSQL conexion = new conexionSQL();
	private Connection cn = null;
	private Statement stm = null;
	private ResultSet rs = null;
	
	public void AgregarUsuario(String usuario, String pass, String email) {
	
		try {
			cn = conexion.conexion();
			PreparedStatement stm2 = cn.prepareStatement("INSERT INTO usuarios(Usuario,pass,Email) VALUES (?,?,?)");
			stm2.setString(1 , usuario);
			stm2.setString(2 , pass);
			stm2.setString(3, email);
			
			stm2.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if (rs!= null) {
					rs.close();
				}
				
				if (stm != null) {
					stm.close();
				}
				
				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
public int validarUsuario(String usuario, String pass) {
	
	int resultado = 0;
    try {
    	cn = conexion.conexion();
        PreparedStatement stm = cn.prepareStatement("SELECT * FROM usuarios WHERE USUARIO = ? AND pass= ? ");
        stm.setString(1, usuario);
        stm.setString(2, pass);

        rs = stm.executeQuery();
        if(rs.next()) {
            resultado =1;
        }

    } catch (SQLException e) {
        e.printStackTrace();

    } finally {
        try {
            if (rs != null) {
                rs.close();
            }

            if (stm != null) {
                stm.close();
            }

            if (cn != null) {
                cn.close();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
    return resultado;
	}
public void modificar(String pass, String email, String usuario) {
	try {
		cn = conexion.conexion();
		PreparedStatement stm2 = cn.prepareStatement(" UPDATE usuarios SET Contraseña = ?, Email = ?  WHERE Usuario = ? ");
		stm2.setString(1, pass);
		stm2.setString(2, email);
		stm2.setString(3, usuario);

		stm2.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
		
	} finally {
		try {
			if (rs!= null) {
				rs.close();
			}
			
			if (stm != null) {
				stm.close();
			}
			
			if (cn != null) {
				cn.close();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
}
public void eliminarUsuario(String usuario) {
	try {
		cn = conexion.conexion();
		PreparedStatement stm2 = cn.prepareStatement("DELETE FROM usuarios WHERE Usuario = ?");
		stm2.setString(1, usuario);
		stm2.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
		
	} finally {
		try {
			if (rs!= null) {
				rs.close();
			}
			
			if (stm != null) {
				stm.close();
			}
			
			if (cn != null) {
				cn.close();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
}
public DefaultTableModel rellenarTabla() {
	String[] columnas = {"id", "usuario", "pass","email"};
	DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
	try {
		String consulta = "SELECT id, usuario, pass, email FROM usuarios";
		cn = conexion.conexion();
		PreparedStatement stm2 = cn.prepareStatement(consulta);
		rs =stm2.executeQuery(consulta);
		modelo.addRow(columnas);
		while (rs.next()) {
		    int id = rs.getInt("id");
		    String usuario = rs.getString("usuario");
		    String pass = rs.getString("pass");
		    String email = rs.getString("email");
		    Object[] fila = {id, usuario, pass,email};
		    
		    modelo.addRow(fila);
		}
		
		
	} catch (SQLException e) {
		e.printStackTrace();
		
	} finally {
		try {
			if (rs!= null) {
				rs.close();
			}
			
			if (stm != null) {
				stm.close();
			}
			
			if (cn != null) {
				cn.close();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	return modelo;
}
}
