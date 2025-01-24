/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Leona
 */
public class GestorEmpleados {

    private List<Empleado> empleados;

    public GestorEmpleados() {
        empleados = new ArrayList<>();
    }

    //Metodo para registrar un empleado.
    public void registrarEmpleado(int id, String nombre, String apellido, String cargo, String salario, String inicio) {
        if (cargo.equals("recursos humanos") || cargo.equals("sistemas") || cargo.equals("soporte a clientes")) {
            Empleado empleado = new Empleado(id, nombre, apellido, cargo, salario, inicio);
            empleados.add(empleado);
            System.out.println("Empleado registrado con exito.");

            // Guardar en la base de datos
            try (Connection connection = ConexionEmpleadosDB.conectar(); PreparedStatement statement = connection.prepareStatement("INSERT INTO empleados (id, nombre, apellido, cargo, salario, inicio) VALUES (?, ?, ?, ?, ?, ?)")) {
                if (connection != null) {
                    statement.setInt(1, id);
                    statement.setString(2, nombre);
                    statement.setString(3, apellido);
                    statement.setString(4, cargo);
                    statement.setString(5, salario);
                    statement.setString(6, inicio);
                    statement.executeUpdate();
                    System.out.println("Empleado registrado en la base de datos con exito.");
                }
            } catch (SQLException e) {
                System.out.println("Error al registrar el empleado en la base de datos: " + e.getMessage());
            }
        } else {
            System.out.println("Cargo invalido. Debe ser 'recursos humanos', 'sistemas' o 'soporte a clientes'.");
        }
    }

    // Metodo para listar todos los empleados
    public void listarEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            for (Empleado empleado : empleados) {
                System.out.println(empleado);
            }
        }
    }

    // Metodo para actualizar la informacion de un empleado
    public void actualizarEmpleado(int id, String nombre, String apellido, String cargo, String salario, String inicio) {
        for (Empleado empleado : empleados) {
            if (empleado.getId() == id) {
                empleado.setNombre(nombre);
                empleado.setApellido(apellido);
                empleado.setCargo(cargo);
                empleado.setSalario(salario);
                empleado.setInicio(inicio);
                System.out.println("Empleado actualizado con exito.");

                // Actualizar en la base de datos
                try (Connection connection = ConexionEmpleadosDB.conectar(); PreparedStatement statement = connection.prepareStatement("UPDATE empleados SET nombre = ?, apellido = ?, cargo = ?, salario = ?, inicio = ? WHERE id = ?")) {
                    if (connection != null) {
                        statement.setString(1, nombre);
                        statement.setString(2, apellido);
                        statement.setString(3, cargo);
                        statement.setString(4, salario);
                        statement.setString(5, inicio);
                        statement.setInt(6, id);
                        statement.executeUpdate();
                        System.out.println("Empleado actualizado en la base de datos con exito.");
                    }
                } catch (SQLException e) {
                    System.out.println("Error al actualizar el empleado en la base de datos: " + e.getMessage());
                }
                return;
            }
        }
        System.out.println("Empleado no encontrado.");
    }

    // Metodo para eliminar un empleado
    public void eliminarEmpleado(int id) {
        for (Empleado empleado : empleados) {
            if (empleado.getId() == id) {
                empleados.remove(empleado);
                System.out.println("Empleado eliminado con exito.");

                // Eliminar de la base de datos
                try (Connection connection = ConexionEmpleadosDB.conectar(); PreparedStatement statement = connection.prepareStatement("DELETE FROM empleados WHERE id = ?")) {
                    if (connection != null) {
                        statement.setInt(1, id);
                        statement.executeUpdate();
                        System.out.println("Empleado eliminado de la base de datos con exito.");
                    }
                } catch (SQLException e) {
                    System.out.println("Error al eliminar el empleado de la base de datos: " + e.getMessage());
                }
                return;
            }
        }
        System.out.println("Empleado no encontrado.");
    }

    // Metodo para buscar empleados por cargo
    public void buscarEmpleadosPorCargo(String cargo) {
        boolean encontrado = false;
        for (Empleado empleado : empleados) {
            if (empleado.getCargo().equalsIgnoreCase(cargo)) {
                System.out.println(empleado);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron empleados con el cargo: " + cargo);
        }
    }

}
