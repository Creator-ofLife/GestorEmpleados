/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Leona
 */
public class ConexionEmpleadosDB {

    // Configuracion de conexion Usuario y contrasenia.
    private static final String URL = "jdbc:mysql://localhost:3306/empleados"; // Nombre de la base de datos
    private static final String USER = "root"; // Usuario 
    private static final String PASSWORD = ""; // Contrasenia

    /**
     * Establece una conexion con la base de datos.
     *
     * @return Objeto Connection si la conexion es exitosa, o null en caso
     * contrario.
     */
    public static Connection conectar() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexion a la base de datos establecida exitosamente.");

        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos.");

        }
        return conexion;
    }

}
