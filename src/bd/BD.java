/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bd;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Matias
 */
public class BD {
    Connection conectar = null;

    //Para configurar la conexion, se debe cambiar el usuario root y la contraseña del equipo local donde esté instalada la bd
    public Connection conectar(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba","root","");

            System.out.println("Conexion Realizada");
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        return conectar;
    }
    
}
