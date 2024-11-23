package dao.jdbc;

import dao.JednostkaDAO;
import model.Jednostka;
import model.Pracownik;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JednostkaDAOImpl implements JednostkaDAO {
    private final PracownikDAOImpl pracownikDAO;
    private final Connection dbCon;

    public JednostkaDAOImpl(Connection dbCon) {
        this.dbCon = dbCon;
        this.pracownikDAO = new PracownikDAOImpl(dbCon);
    }

    @Override
    public List<Jednostka> getJednostki() {
        List<Jednostka> resp = null;
        try {
            PreparedStatement pstm = dbCon.prepareStatement(
                    "SELECT * FROM Jednostka");
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

    List<Jednostka> listFromResultSet(ResultSet rs) throws SQLException {
        List<Jednostka> p = new ArrayList<>();
        while (rs.next())
            p.add(fromResultSet(rs));
        return p;
    }

    Jednostka fromResultSet(ResultSet rs) throws SQLException {
        Jednostka p = new Jednostka();
        int id = rs.getInt("id");
        p.setId(id);
        p.setNazwa(rs.getString("nazwa"));
        p.setPracownicy(pracownikDAO.getPracownicyByJednostka(id));
        return p;
    }

    @Override
    public List<Jednostka> getJednostkiByNazwa(String nazwa) {
        List<Jednostka> resp = null;
        try {
            PreparedStatement pstm = dbCon.prepareStatement(
                    "SELECT * FROM Jednostka WHERE nazwa like ?");
            pstm.setString(1, "%"+nazwa+"%");
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
    public Jednostka getJednostkaById(int id) {
        Jednostka resp = null;
        try {
            PreparedStatement pstm = dbCon.prepareStatement(
                    "SELECT * FROM Jednostka WHERE id =  ?");
            pstm.setInt(1, id);
            pstm.execute();
            ResultSet rs = pstm.getResultSet();
            if(rs.next())
                resp = fromResultSet(rs);
            rs.close();
            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resp;
    }
}
