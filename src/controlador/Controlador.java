/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import modelo.Modelo;
import bd.BD;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Matias
 */
public class Controlador {
    
    BD con = new BD();
   
    /*
    public String Suma(Modelo objModelo){
    
        
        int suma = objModelo.getNumeroUno()+ objModelo.getNumeroDos();
        
        String sumaString = String.valueOf(suma);
        
    return sumaString;
    
   
    };

*/
    
    public boolean insertAlumno(Modelo objModelo) {
    
    Connection connect = con.conectar();
    
    try{
    
        Statement s = connect.createStatement();
        
        String consulta = ""; 
        consulta += "INSERT INTO alumno(Nombre,Edad,Curso,Asignatura) values('"+objModelo.getNombre()+"','"+objModelo.getEdad()+"','"+objModelo.getCurso()+"','"+objModelo.getAsignatura()+ "')";
        
        /*PreparedStatement preparedStmt = connect.prepareStatement(consulta);
        preparedStmt.setString (1, "4");
        preparedStmt.setString(2, "Nombre");
        preparedStmt.setString(3, "Edad");
        preparedStmt.setString(4, "Curso");
        preparedStmt.setString(4, "Asignatura");
        preparedStmt.execute();
        */
        s.execute(consulta);
       
        JOptionPane.showMessageDialog(null, "Alumno Registrado con exito!");
        connect.close();
        
  
    } catch (SQLException ex) {
        
            JOptionPane.showMessageDialog(null, "A OCURRIDO UN ERROR AL REGISTRAR UN ALUMNO: !"+ex);
           // System.out.println(ex);
            return false;
        }
    
        return true;
    };
    
    
    /*
    
    public class ModeloClientes {
    
    public ArrayList<Alumnos>
    }
    */
    
    
    public boolean VerAlumnos () {
    Connection connect = con.conectar();
    
     try{
    
        CallableStatement mostrar = connect.prepareCall("{call mostrarAlumno}" );
        
        ResultSet rs = mostrar.executeQuery();
        
      
                
        while(rs.next()){
        
            System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
        }
        
        rs.close();
  
    } catch (SQLException ex) {
        
            
            System.out.println(ex);
            return false;
        }
    
    return true;
    }
    
    

}
