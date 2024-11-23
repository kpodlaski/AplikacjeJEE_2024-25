package dao.jdbc;

import dao.StawiskoDAO;
import model.Stanowisko;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StanowiskoDAOImpl implements StawiskoDAO {
    private final Connection dbCon;

    public StanowiskoDAOImpl(Connection dbCon) {
        this.dbCon = dbCon;
    }

    @Override
    public List<Stanowisko> getStanowiska() {
        List<Stanowisko> resp = null;
        try {
            PreparedStatement pstm = dbCon.prepareStatement(
                    "SELECT id as sid, nazwa as snazwa FROM Stanowisko ");
            pstm.execute();
            ResultSet rs = pstm.getResultSet();
            resp = listFromResultSet(rs);
            rs.close();
            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resp;
    }



    @Override
    public List<Stanowisko> getStanowiskaByNazwa(String nazwa) {
        List<Stanowisko> resp = null;
        try {
            PreparedStatement pstm = dbCon.prepareStatement(
                    "SELECT id as sid, nazwa as snazwa FROM Stanowisko where nazwa LIKE ?");
            pstm.setString(1,"%"+nazwa+"%");
            pstm.execute();
            ResultSet rs = pstm.getResultSet();
            resp = listFromResultSet(rs);
            rs.close();
            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resp;
    }

    @Override
    public Stanowisko getStanowisko(int id) {
        Stanowisko resp = null;
        try {
            PreparedStatement pstm = dbCon.prepareStatement(
                    "SELECT id as sid, nazwa as snazwa FROM Stanowisko where id = ?");
            pstm.setInt(1,id);
            pstm.execute();
            ResultSet rs = pstm.getResultSet();
            if (rs.next()) {
                resp = fromResultSet(rs);
            }
            rs.close();
            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resp;
    }

    List<Stanowisko> listFromResultSet(ResultSet resultSet) throws SQLException {
        List<Stanowisko> result =  new ArrayList<>();
        while(resultSet.next()){
            result.add(fromResultSet(resultSet));
        }
        return result;
    }

     Stanowisko fromResultSet(ResultSet resultSet) throws SQLException {
        Stanowisko st = new Stanowisko();
        st.setId(resultSet.getInt("sid"));
        st.setNazwa(resultSet.getString("snazwa"));
        return st;
    }
}
