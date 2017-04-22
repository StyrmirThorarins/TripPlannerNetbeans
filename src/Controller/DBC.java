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
    
    //return Connection class connection to database
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
    
    //generic call to inserting data into the connected database with a sql string
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

    //generic function for running a sql query on a db connected with Connection clas
    //using the passed sql string
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
    
    //N: UserAllPrint():
    //F: gagnagrunnur TPData er til en ótengdur
    //E: búið er að tengjast TPData gagnagrunni og Prenta út öll gögn úr honum
    public static void userAllPrint() 
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
    public static void findUserId(String uName) 
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
    
    
    //N: GetUserId(uName);
    //F: gagnagrunnur TPData er til en ótengdur, uName er strengur
    //E: búið er að skila Id sem samsvarar User sem inniheldur strenginn uName
    public static int getUserId(String uName) 
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
    public static void userInsert(String uName, String sex,
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
    public static void bookingInsert(int userId, int refId, String bookingRefId, int catId)
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
    
       
    
    /*  N: CheckLoginCredentials(name, email)
        F: TPData gagnagrunnur er til, user er strengur og email er strengur
        E: Id gögn sem tilheyra notanda name/email eru fundinn 
    */
    public static int checkLoginCredentials(String name, String email)
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
    
    //NOT IMPLEMENTED
    //should return a basket with the purchases made by the user for a certain reference id (a given cluster of orders)
    public void getPurchasesByld(int RefId)
    {
        Connection conn = dbConnect();
        
        String SQL;
        
        dbDisconnect(conn); 
    }
    
    
    //NOT IMPLEMENTED
    //should return a basket with the purchases made by the user
    public void getUserPurchases (int id)
    {
        Connection conn = dbConnect();        
        String SQL = "select BookingRefId from Booking where UserId = '"+ id +"'";
        ResultSet rs = dbQuery(conn, SQL);
        DefaultListModel ref = new DefaultListModel();
        try{   
            while (rs.next()) {
                int bookingRefId = rs.getInt("BookingRefId");
                ref.addElement(bookingRefId);
                //jList1.setModel(ref);
            }
            
        } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        dbDisconnect(conn);
        
}
    
    //returns a Model.User from the database by the users Id
    public static Model.User getUserById (int id)
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
     
    
    //returns the highest booking reference number from the database
    public static int getMaxReference ()
    {
        Connection conn = dbConnect(); 
        int bookingRefId = 0;
        String SQL = "select MAX(RefId) from Booking";
        ResultSet rs = dbQuery(conn, SQL);
        try{
        bookingRefId = rs.getInt("MAX(RefId)");
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        dbDisconnect(conn);
        return bookingRefId;
    }
}
