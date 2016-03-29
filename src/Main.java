import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by ROSA on 3/28/16.
 */
public class Main {

    static final String JDBC_DRIVER_USE = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/TEXTDATA";
    static final String USERNAME = "username";
    static final String PASSWORD = "password";
    String message = "hello there";



    public static void main(String args[]){
        printer();
        mysqlInsert();
    }

    public static void printer(){
        System.out.println("Hello");
    }
    public static void mysqlInsert(){
        Connection conn = null;
        Statement stmt = null;
        try{
            //Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            System.out.println("Connected database successfully...");

            //Execute a query
            System.out.println("Inserting records into the table...");
            stmt = conn.createStatement();

            String sql = null;

            //Create DB:
/*            sql = "CREATE DATABASE TEXTDATA";
            stmt.executeUpdate(sql);*/

/*            //Create Table:
            sql = "CREATE TABLE TEXT_DATA_TABLE " + "(TEXT BLOB(1000))";
            stmt.executeUpdate(sql);*/

            //add record

            sql = "INSERT INTO TEXT_DATA_TABLE " +  "VALUES ('hello adam')";
            stmt.executeUpdate(sql);




            System.out.println("Database.");

        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}
