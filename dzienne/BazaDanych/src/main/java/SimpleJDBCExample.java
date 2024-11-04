import java.sql.*;

public class SimpleJDBCExample {
    public static void main(String[] args)
            throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, SQLException {
        String conString = "jdbc:postgresql://localhost:5432/appdb";

        Class.forName("org.postgresql.Driver").newInstance();

        Connection con = DriverManager.getConnection(conString,"dbuser","dbuser");
        Statement stm = con.createStatement();
        stm.execute("SELECT * FROM PRACOWNIK");
        ResultSet rs = stm.getResultSet();
        while (rs.next()){
            System.out.print(rs.getInt(1));
            System.out.print(" ");
            System.out.print(rs.getString("imie"));
            System.out.print(" ");
            System.out.println(rs.getString("nazwisko"));
        }
        rs.close();
        stm.close();
        con.close();
    }
}
