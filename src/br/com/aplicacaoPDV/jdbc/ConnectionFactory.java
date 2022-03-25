/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.aplicacaoPDV.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Lustosas
 */
public class ConnectionFactory {
//private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    
    public Connection getConnection(){
        
        try {
                       return DriverManager.getConnection("jdbc:mysql://localhost:3306/bdvendas?useTimezone=true&serverTimezone=UTC", "teste", "123" );
                               
            
        } catch (Exception erro) {
            throw new RuntimeException(erro);
        }
        
    }

    
}
