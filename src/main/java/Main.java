import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws Exception {

        Connection dbconnection = null;
        Statement statement = null;

        String insertTableSQL = "INSERT INTO PETS" + "(appellation, name, age, colour, owner,id)" + "VALUES" +
                " ('cat', 'Myrka', 10, 'grey', 'Pasha',11)";

        try {

            dbconnection = getDBConnection();
            statement = dbconnection.createStatement();
            statement.executeUpdate(insertTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static Connection getDBConnection() {

        String url = "jdbc:mysql://localhost:3306";
        String username = "root";
        String password = "159753An";
        Connection dbconnection = null;
        Statement statement = null;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();}
        catch (Exception e){
            System.out.println(e);
        }
        try{ dbconnection = DriverManager.getConnection(url, username, password);
            return dbconnection;
            } catch (Exception ex) {
            System.out.println("Connection failed...");

            System.out.println(ex);

        }
        return dbconnection;
    }
}
