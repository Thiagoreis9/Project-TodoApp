/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package TodoApp;

import java.sql.Connection;
import util.ConnectionFactory;

/**
 *
 * @author Ryuzaki
 */
public class Main {

    public static void main(String[] args) {
        
        Connection c = ConnectionFactory.getConnection();
        
        ConnectionFactory.closeConnection(c);
        
        

    }

}
