import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;

 public class ConnectionTest
{
    public static void main (String[] args)
    {
        System.out.println("\n\n***** MySQL JDBC Connection To GATHER DBase Tester *****");
        Connection conn = null;

        try
        {
            Class.forName ("com.mysql.cj.jdbc.Driver").newInstance ();
            String userName = "user";
            String password = "password";
            String url = "jdbc:mysql://localhost:3306/db";
            conn = DriverManager.getConnection (url, userName, password);
            System.out.println ("\nDatabase Connection Established...");

        }
        catch (Exception ex)
        {
            System.err.println ("Cannot connect to database server");

        }

        finally
        {
            if (conn != null)
            {
                try
                {
                    System.out.println("\nNow Lets terminate the Connection...");

                    conn.close ();
                    System.out.println ("\nDatabase connection terminated...");

                    System.out.println("\n***** Everything works fine... *****");
                }
                catch (Exception ex)
                {
                    System.out.println ("Error in connection termination!");
                }
            }
        }
    }
}
