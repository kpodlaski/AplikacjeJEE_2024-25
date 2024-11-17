import dao.StawiskoDAO;
import dao.jdbc.StanowiskoDAOImpl;
import model.Stanowisko;

import java.sql.*;

public class JDBCIntro {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class.forName("org.postgresql.Driver").newInstance();

        Connection dbCon = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/appdb",
                "dbuser",
                "dbuser");
        //simpleDBQuery(dbCon);
        preparedStatementDBQuery(dbCon);
        daoTest(dbCon);
        dbCon.close();
    }

    private static void daoTest(Connection dbCon) {
        StawiskoDAO stanowiskoDAO = new StanowiskoDAOImpl();
        Stanowisko st = stanowiskoDAO.getStanowisko(2);

    }

    private static void preparedStatementDBQuery(Connection dbCon) throws SQLException {
        PreparedStatement pstm =
                dbCon.prepareStatement(
                "SELECT * FROM Pracownik, Stanowisko WHERE Pracownik.id > ? AND Stanowisko.id=Pracownik.stanowisko");
        String minid = "3";
        pstm.setInt(1,Integer.parseInt(minid) );
        pstm.execute();
        ResultSet rs = pstm.getResultSet();
        while(rs.next()){
            System.out.print(rs.getInt(1));
            System.out.print(" ");
            //System.out.print(rs.getInt("id"));
            System.out.print(rs.getString("imie"));
            System.out.print(" ");
            System.out.println(rs.getString("nazwa"));
        }
        rs.close();
        pstm.close();
    }

    private static void simpleDBQuery(Connection dbCon) throws SQLException {
        Statement stm = dbCon.createStatement();
        stm.execute("SELECT * FROM Pracownik WHERE imie like '%a%'");
        String minid = "3";

        stm.execute("SELECT * FROM Pracownik WHERE id > "+minid);

        ResultSet rs = stm.getResultSet();
        while(rs.next()){
            System.out.print(rs.getInt(1));
            //System.out.print(rs.getInt("id"));
            System.out.println(rs.getString("imie"));
        }
        rs.close();
        stm.close();
    }
}
