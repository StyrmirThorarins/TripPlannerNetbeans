/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;

/**
 *
 * @author Máni
 */
public class DBC {
    
    //return connection connection to database
    public static Connection dbConnect(){
        Connection conn = null;
        //attempt local DB connection
        try {            
            String url = "jdbc:sqlite:src/Data/TPData.db";            
            conn = DriverManager.getConnection(url);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());            
        }
        
        return conn;
        
    }
    
    //disconnect database connection
    public static void dbDisconnect(Connection conn){
        try {
            if (conn != null) {
                conn.close();
            }
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }        
    }
    
    public static void dbInsert(Connection conn, String sqlString){
        try {
            Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            stmt.executeUpdate(sqlString);
            stmt.close();
        
            conn.commit();
            conn.close();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ResultSet dbQuery(Connection conn, String sqlString){               
        try{
            Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery( sqlString );
            return rs;
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
            
        return null;
    }
  
    //N: GetUserId(uName);
    //F: gagnagrunnur TPData er til en ótengdur, uName er strengur
    //E: búið er að skila Id sem samsvarar User sem inniheldur strenginn uName
    public static int GetUserId(String uName) 
    {
        
        Connection con = dbConnect();
        String sqlStr = "SELECT * FROM Users WHERE Users.Name LIKE '%"+ uName+"%'";
        ResultSet rs = dbQuery(con, sqlStr);
        
        int userId = 0;
        try{
            userId = rs.getInt("Id"); 
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        dbDisconnect(con);
        
        return userId;        
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
                    + "'"+phone+"','"+nationality+"','0')";
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
    
       
    
    /*  N: CheckLoginC(name, email)
        F: TPData gagnagrunnur er til, user er strengur og email er strengur
        E: Id gögn sem tilheyra notanda name/email eru fundinn 
    */
    public static int CheckLoginC(String name, String email)
    {
        int id = 0;
        
        Connection conn = dbConnect();
        String SQL = "select * from Users where Name ='"+ name +"' and Email = '"+ email +"'";
        ResultSet rs = dbQuery(conn, SQL);
        
        try {
            
            
            id =rs.getInt("Id");
            String name1 = rs.getString("Name");
            String email1 = rs.getString("Email");
            
            dbDisconnect(conn);
            return id;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            return id;
    }

    public static Model.User SetUser (int id)
    {
        Connection conn = dbConnect();
        String SQL = "select * from Users where Id ='"+ id +"'";
        ResultSet rs = dbQuery(conn, SQL);
        Model.User user = new Model.User();
        try{   
            user.setId(rs.getInt("Id"));
            user.setName(rs.getString("Name"));
            user.setSex(rs.getString("Sex").charAt(0));
            user.setAddress(rs.getString("Address"));
            user.setEmail(rs.getString("Email"));
            user.setPhone(rs.getString("Phone"));
            user.setNationality(rs.getString("Nationality"));
            
            System.out.println(user.getId());
            System.out.println(user.getName());
            System.out.println(user.getAddress());
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        dbDisconnect(conn);     
        
        return user;
    }
     
         //hér á að vera list<>
    public static int getMaxRef ()
    {
        Connection conn = dbConnect(); 
        int bookingRefId = 0;
        String SQL = "select MAX(BookingRefId) from Booking";
        ResultSet rs = dbQuery(conn, SQL);
        try{
        bookingRefId = rs.getInt("BookingRefId");
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        dbDisconnect(conn);
        return bookingRefId;
}
}
