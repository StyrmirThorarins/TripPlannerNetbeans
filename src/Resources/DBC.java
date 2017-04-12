/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database_console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author Agust Th
 */
public class DBC {

    //tengir forrit við gagnagrunninn TPData
    //F: gagnagrunnur TPData er til en ótengdur
    //E: búið er að tengjast TPData gagnagrunni og Prenta út öll gögn úr honum
    public static void UserAllPrint() {
        Connection conn = null;
        try {
            // Tenging við DB
            String url = "jdbc:sqlite:TPData.db";
            // Tenging komið á
            conn = DriverManager.getConnection(url);
            //Command insert
            Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            String SQL = "SELECT * FROM Users";
            //Hvert results fara
            ResultSet rs = stmt.executeQuery( SQL );
            
            //Prentar út gögnin línu fyrir línu
            while(rs.next())
            {
            //rs.next();
            int id_col =rs.getInt("Id");
            String name = rs.getString("Users");
            int image = rs.getInt("ImageId");
            
            String p = id_col + " " + name + " " + image;
            System.out.println(p);
            }
            //System.out.println("Tenging hefur verið gerð við Sqlite.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    /*
    //Notkun: SelectAllABC(a,b,c);
    //Fyrir: Engin gögn úr töflu a eru valin
    //Eftir: Gögn úr töflu a þar sem b = c eru valin
    public static void SelectAllABC(String a,String b,String c) {
        Connection conn = null;
        try {
            // Tenging við DB
            String url = "jdbc:sqlite:TPData.db";
            // Tenging komið á
            conn = DriverManager.getConnection(url);
            //Command insert
            Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            String SQL = "SELECT * FROM " + a + "WHERE "+ b+ " = " + c;
            //Hvert results fara
            ResultSet rs = stmt.executeQuery( SQL );
            //System.out.println("Tenging hefur verið gerð við Sqlite.");
            while(rs.next())
            {
            //rs.next();
            int id_col =rs.getInt("Id");
            String name = rs.getString("Users");
            int image = rs.getInt("ImageId");
            
            String p = id_col + " " + name + " " + image;
            System.out.println(p);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
    }
    */
    
    //main til að prufa
    public static void main(String[] args) 
    {
        
        //UserAllPrint();
        UserAllPrint();
    }
}