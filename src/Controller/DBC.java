/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author Máni
 */
public class DBC {
    //N: UserAllPrint():
    //F: gagnagrunnur TPData er til en ótengdur
    //E: búið er að tengjast TPData gagnagrunni og Prenta út öll gögn úr honum
    public static void UserAllPrint() 
    {
        Connection conn = null;
        try {
            // Tenging við DB
            String url = "jdbc:sqlite:src/Data/TPData.db";
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
            String name = rs.getString("Name");
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
    //N: findUserId(uName);
    //F: gagnagrunnur TPData er til en ótengdur, uName er strengur
    //E: búið er að tengjast TPData gagnagrunni og finna Id sem tengist nöfnum
    //   sem inniheldur strenginn uName og prenta þau út.
    public static void FindUserId(String uName) 
    {
        Connection conn = null;
        try {
            // Tenging við DB
            String url = "jdbc:sqlite:src/Data/TPData.db";
            // Tenging komið á
            conn = DriverManager.getConnection(url);
            //Command insert
            Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            String SQL = "SELECT * FROM Users WHERE Name LIKE '%"+ uName+"%'";
            //Hvert results fara
            ResultSet rs = stmt.executeQuery( SQL );
            
            //Prentar út gögnin línu fyrir línu
            while(rs.next())
            {
            //rs.next();
            int id_col =rs.getInt("Id");
            String name = rs.getString("Name");
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
    //N: CindUserId(uName);
    //F: gagnagrunnur TPData er til en ótengdur, uName er strengur
    //E: búið er að skila Id sem samsvarar User sem inniheldur strenginn uName
    public static int CatchUserId(String uName) 
    {
        int foundId = 0;
        Connection conn = null;
        try {
            // Tenging við DB
            String url = "jdbc:sqlite:src/Data/TPData.db";
            // Tenging komið á
            conn = DriverManager.getConnection(url);
            //Command insert
            Statement stmt = conn.createStatement();
            String SQL = "SELECT * FROM Users WHERE Users.Users LIKE '%"+ uName+"%'";
            //Hvert results fara
            ResultSet rs = stmt.executeQuery( SQL );
            int id_col = rs.getInt("Id");
            foundId = id_col;
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
        return foundId;
    }
    
    /**N:UserInsert(uName,sex,address,email,phone,nationality
     * F:TPData gagnagrunnur er til
     * E:Búið er að bæta við gögnum í Users töfluna í TPData gagnagrunninum
     */
      public static void UserInsert(String uName, String sex,
              String address, String email, String phone, String nationality) 
    {
        int foundId = 0;
        Connection conn = null;
        try {
            // Tenging við DB
            String url = "jdbc:sqlite:src/Data/TPData.db";
            // Tenging komið á
            conn = DriverManager.getConnection(url);
            //Command insert
            Statement stmt = conn.createStatement();
            String SQL = "Insert into Users values(null,'"+uName+"','"+sex+"','"+address+"','"+email+"',"
                    + "'"+phone+"','"+nationality+"','default')";
            //Hvert results fara
            stmt.executeUpdate(SQL);
            stmt.close();
            conn.commit();
            conn.close();
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
 
    /**N:UserInsert(uName,sex,address,email,phone,nationality
     * F:TPData gagnagrunnur er til
     * E:Búið er að bæta við gögnum í Users töfluna í TPData gagnagrunninum
     */
    public static void BookingInsert(int userId, int refId, String bookingRefId, int catId)
    {
        Connection conn = null;
        try {
            // Tenging við DB
            String url = "jdbc:sqlite:TPData.db";
            // Tenging komið á
            conn = DriverManager.getConnection(url);
            //Command insert
            Statement stmt = conn.createStatement();
            String SQL = "Insert into Booking values(null,'"+userId+"', '"+refId+"','"+bookingRefId+"','"+catId+"')";
            //Hvert results fara
            stmt.executeUpdate(SQL);
            stmt.close();
            conn.commit();
            conn.close();
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
}
