/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.vista;

import controlador.GestorEmpleados;
import java.util.Scanner;

/**
 *
 * @author Leona
 */
public class Vista {

    public static void main(String[] args) {

        GestorEmpleados gestor = new GestorEmpleados();
        Scanner scanner = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("\nMenu Principal");
            System.out.println("1. Registrar Empleado");
            System.out.println("2. Listar Empleados");
            System.out.println("3. Actualizar Empleado");
            System.out.println("4. Eliminar Empleado");
            System.out.println("5. Buscar Empleados por Cargo");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer para la siguiente entrada.

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Limpiar despues de leer un entero
                    System.out.print("Ingrese Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese Apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Ingrese Cargo (recursos humanos, sistemas, soporte a clientes): ");
                    String cargo = scanner.nextLine();
                    System.out.print("Ingrese Salario: ");
                    String salario = scanner.nextLine();
                    System.out.print("Ingrese Fecha de Inicio (YYYY-MM-DD): ");
                    String inicio = scanner.nextLine();
                    gestor.registrarEmpleado(id, nombre, apellido, cargo, salario, inicio);
                    break;
                case 2:
                    gestor.listarEmpleados();
                    break;
                case 3:
                    System.out.print("Ingrese ID del empleado a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    scanner.nextLine(); // Limpiar despues de leer datos enteros.
                    System.out.print("Ingrese Nombre: ");
                    String nombreActualizar = scanner.nextLine();
                    System.out.print("Ingrese Apellido: ");
                    String apellidoActualizar = scanner.nextLine();
                    System.out.print("Ingrese Cargo (recursos humanos, sistemas, soporte a clientes): ");
                    String cargoActualizar = scanner.nextLine();
                    System.out.print("Ingrese Salario: ");
                    String salarioActualizar = scanner.nextLine();
                    System.out.print("Ingrese Fecha de Inicio (YYYY-MM-DD): ");
                    String inicioActualizar = scanner.nextLine();
                    gestor.actualizarEmpleado(idActualizar, nombreActualizar, apellidoActualizar, cargoActualizar, salarioActualizar, inicioActualizar);
                    break;
                case 4:
                    System.out.print("Ingrese ID del empleado a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    gestor.eliminarEmpleado(idEliminar);
                    break;
                case 5:
                    System.out.print("Ingrese el cargo a buscar: ");
                    String cargoBuscar = scanner.nextLine();
                    gestor.buscarEmpleadosPorCargo(cargoBuscar);
                    break;
                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
            }
        } while (opcion != 6);

        scanner.close();
    }

}
