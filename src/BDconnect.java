import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BDconnect {

    Connection connect = null;
    Statement state = null;

    String request;

    static boolean conectado = false;

    BDconnect() {
        iniciarBD();
    }

    public void iniciarBD() {
        // Conección a la base de datos
        try {
            connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BDproyecto", "postgres", "123");
            connect.setAutoCommit(false);
            state = connect.createStatement();
            System.out.println("Se ha establecido la conección con la BD");
            conectado = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos " + e.getMessage(),
                    "Error en Base de Datos", 1);
        }
    }

    public boolean validar(String id, String password) {

        request = "SELECT * FROM trabajadores WHERE cedula = '" + id + "' AND password = '" + password + "';";

        try {
            ResultSet result = state.executeQuery(request);

            if (result.next()) {
                System.out.println("La contraseña coincide con la ID en la tabla.");

                return true;
            } else {
                System.out.println("La contraseña no coincide con la ID en la tabla.");

                return false;
            }

        } catch (SQLException e) {
            System.out.println("Error!" + e.getMessage());

            return false;
        }

    }

    public String getNombre(String id) {

        String nombre = "";

        request = "SELECT * FROM trabajadores WHERE cedula = '" + id + "';";
        try {
            ResultSet result = state.executeQuery(request);
            if (result.next()) {
                nombre = result.getString("nombre");

                result.close();
                return nombre;
            } else {
                result.close();
                return "";
            }

        } catch (SQLException e) {
            System.out.println("Error!" + e.getMessage());
            return "";
        }
    }

    public void cerrar() {
        try {
            state.close();
            connect.close();
            conectado = false;
            System.out.println("He cerrado la BD");
        } catch (SQLException e) {
            System.out.println("Error al cerrar la BD " + e.getMessage());
        }

    }

    public JScrollPane consultarTodo() {
        // CONSULTAR REGISTROS
        request = "SELECT id, nombre, inventario, precio, importacion FROM productos;";
        try {
            ResultSet result = state.executeQuery(request);
            DefaultTableModel template = new DefaultTableModel();
            template.addColumn("id");
            template.addColumn("nombre");
            template.addColumn("inventario");
            template.addColumn("precio");
            template.addColumn("importacion");

            while (result.next()) {
                Object row[] = new Object[template.getColumnCount()];
                for (int i = 0; i < row.length; i++) {
                    row[i] = result.getObject(i + 1);
                }
                template.addRow(row);
            }

            JTable table = new JTable(template);
            table.setBackground(Color.orange);
            JScrollPane scroll = new JScrollPane(table);

            return scroll;

        } catch (SQLException e) {
            System.out.println("Error!" + e.getMessage());
            return null;
        }

    }

    public JScrollPane consultarPorID(int id) {
        request = "SELECT id, nombre, inventario, precio, importacion FROM productos WHERE id = " + id + ";";
        try {
            ResultSet result = state.executeQuery(request);
            DefaultTableModel template = new DefaultTableModel();
            template.addColumn("id");
            template.addColumn("nombre");
            template.addColumn("inventario");
            template.addColumn("precio");
            template.addColumn("importacion");

            while (result.next()) {
                Object row[] = new Object[template.getColumnCount()];
                for (int i = 0; i < row.length; i++) {
                    row[i] = result.getObject(i + 1);
                }
                template.addRow(row);
            }

            JTable table = new JTable(template);
            table.setBackground(Color.orange);
            JScrollPane scroll = new JScrollPane(table);

            return scroll;

        } catch (SQLException e) {
            System.out.println("Error!" + e.getMessage());
            return null;
        }
    }

    public void modificarProducto(String id, String nombre, String existencias, String precio, String importacion) {

        try {
            if (validarProducto(id)) {

                request = "UPDATE productos SET nombre='" + nombre + "', inventario='" + existencias + "', precio='"
                        + precio + "', importacion='" + importacion + "' WHERE id= " + id + " ;";
                state.executeUpdate(request);
                connect.commit();
                JOptionPane.showMessageDialog(null, "Se ha modificado el producto con id " + id + " correctamente",
                        "Realizado", 1);

            } else {

                JOptionPane.showMessageDialog(null, "No se ha podido encontrar un producto con id " + id,
                        "No encontrado", 2);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Por favor digite datos válidos en las casillas", "ERROR", 0);
        }
    }

    public boolean validarProducto(String id) {

        request = "SELECT * FROM productos WHERE id = '" + id + "';";

        try {
            ResultSet result = state.executeQuery(request);

            if (result.next()) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Error!" + e.getMessage());
            return false;
        }

    }

    public void eliminar (int quien){ 
        try {
           iniciarBD(); 
           request = "DELETE FROM productos WHERE (id = '"+quien+"')";
           state.executeUpdate(request);
           System.out.println("Eliminado");
           connect.commit();
           state.close();
           connect.close();
           JOptionPane.showMessageDialog(null, "Se ha eliminado con exito el producto " + quien, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
           
       } catch (Exception e) {
           System.err.println(e.getClass().getName() + " " + e.getMessage());
           System.out.println("algo va mal xd");
       }
   }

   public void insertar(int id, String nom, String inven, int precio, String impor){ 
    try {
       iniciarBD(); 
       request = "INSERT INTO productos (id,nombre,inventario,precio,importacion) VALUES ('"+id+"','"+nom+"' ,'"+inven+"', '"+precio+"','"+impor+"')";
       state.executeUpdate(request);
       System.out.println("Creado");
       connect.commit();
       state.close();
       connect.close();
       JOptionPane.showMessageDialog(null, "Se ha registrado con exito", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
       
   } catch (Exception e) {
       System.err.println(e.getClass().getName() + " " + e.getMessage());
       System.out.println("Algo va mal xd");
   }
}


}
