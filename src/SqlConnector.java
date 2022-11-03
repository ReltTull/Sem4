import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnector
{
    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/tickets)", "root", "slash1702"))
        {
            System.out.println("Yep"); 
        }
        catch (Exception ex)
        {
            System.out.println("Conncetion failed");
            System.out.println(ex);
        }

    }
}
