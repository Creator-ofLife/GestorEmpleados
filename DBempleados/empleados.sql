-- Creo la base de datos
CREATE DATABASE empleados;

-- Uso la base de datos
USE empleados;

-- Creo la tabla
CREATE TABLE empleados (
    id INT AUTO_INCREMENT PRIMARY KEY,  -- Identificador unico para cada empleado
    nombre VARCHAR(50) NOT NULL,        -- Nombre del empleado
    apellido VARCHAR(50) NOT NULL,      -- Apellido del empleado
    cargo ENUM('recursos humanos', 'sistemas', 'soporte a clientes') NOT NULL,  -- Cargo limitado a opciones validas
    salario DECIMAL(10, 2) NOT NULL,    -- Salario del empleado, con dos decimales
    inicio DATE NOT NULL                -- Fecha de inicio en formato YYYY-MM-DD
);

truncate table empleados;

select * from empleados;