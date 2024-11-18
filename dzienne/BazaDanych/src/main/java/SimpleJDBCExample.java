import java.sql.*;

public class SimpleJDBCExample {

    public static void main(String[] args)
            throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, SQLException {
        String conString = "jdbc:postgresql://localhost:5432/appdb";

        Class.forName("org.postgresql.Driver").newInstance();
        //simplequery(conString);;
        showAllPracownicy(conString);

    }

    private static void showAllPracownicy(String conString) throws SQLException {
        Connection con = DriverManager.getConnection(conString,"dbuser","dbuser");
        PreparedStatement pstm = con.prepareStatement(
                "SELECT p.id, imie, nazwisko, nazwa FROM Pracownik as p, Stanowisko as s WHERE p.stanowisko=s.id");
        pstm.execute();
//        ResultSet rs = stm.getResultSet();
        ResultSet rs = pstm.getResultSet();
        while (rs.next()){
            System.out.print("ID:"+rs.getInt(1));
            System.out.print(" imie:"+rs.getString("imie"));
            System.out.println(" stanowisko:"+ rs.getString("nazwa"));
        }
        rs.close();
        pstm.close();
        System.out.println(con.getMetaData().getURL());
        con.close();

    }

    public static void simplequery(String conString) throws SQLException {
        Connection con = DriverManager.getConnection(conString,"dbuser","dbuser");
//        Statement stm = con.createStatement();
//        stm.execute("SELECT * FROM PRACOWNIK");
        PreparedStatement pstm = con.prepareStatement("SELECT * FROM Pracownik WHERE id>?");
        pstm.setInt(1,3);
        System.out.println(pstm);
        pstm.execute();
//        ResultSet rs = stm.getResultSet();
        ResultSet rs = pstm.getResultSet();
        while (rs.next()){
            System.out.print(rs.getInt(1));
            System.out.print(" ");
            System.out.print(rs.getString("imie"));
            System.out.print(" ");
            System.out.println(rs.getString("nazwisko"));
        }
        rs.close();
        pstm.close();
        con.close();
    }
}
