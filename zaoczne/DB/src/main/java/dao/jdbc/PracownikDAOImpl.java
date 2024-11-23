package dao.jdbc;

import dao.PracownikDAO;

import model.Pracownik;
import model.Stanowisko;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PracownikDAOImpl implements PracownikDAO {

    private final Connection dbCon;
    private final StanowiskoDAOImpl stanowiskoDAO;

    public PracownikDAOImpl(Connection dbCon) {
        this.dbCon = dbCon;
        this.stanowiskoDAO = new StanowiskoDAOImpl(dbCon);
    }
    @Override
    public Pracownik getPracownik(int id) {
        Pracownik resp = null;
        try {
            PreparedStatement pstm = dbCon.prepareStatement(
                    "SELECT Stanowisko.id as sid, Stanowisko.nazwa as snazwa, Pracownik.id as pid, imie, nazwisko  FROM Pracownik, Stanowisko where Pracownik.id = ?");
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

    Pracownik fromResultSet(ResultSet rs) throws SQLException {
        Pracownik p = new Pracownik();
        p.setId(rs.getInt("pid"));
        p.setImie(rs.getString("imie"));
        p.setNazwisko(rs.getString("nazwisko"));
        p.setStanowisko(stanowiskoDAO.fromResultSet(rs));
        return p;
    }

    List<Pracownik> listFromResultSet(ResultSet rs) throws SQLException {
        List<Pracownik> p = new ArrayList<>();
        while (rs.next())
            p.add(fromResultSet(rs));
        return p;
    }

    @Override
    public List<Pracownik> getPracownicy() {
        List<Pracownik> resp = null;
        try {
            PreparedStatement pstm = dbCon.prepareStatement(
                    "SELECT Stanowisko.id as sid, Stanowisko.nazwa as snazwa, Pracownik.id as pid, imie, nazwisko  FROM Pracownik, Stanowisko WHERE stanowisko.id=pracownik.stanowisko");
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
    public List<Pracownik> getPracownicyByImie(String imie) {
        List<Pracownik> resp = null;
        try {
            PreparedStatement pstm = dbCon.prepareStatement(
                    "SELECT Stanowisko.id as sid, Stanowisko.nazwa as snazwa, Pracownik.id as pid, imie, nazwisko  FROM Pracownik, Stanowisko WHERE imie like ? AND stanowisko.id=pracownik.stanowisko");
            pstm.setString(1,"%"+imie+"%");
            pstm.execute();
            //System.out.println(pstm);
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
    public List<Pracownik> getPracownicyByNazwisko(String nazwisko) {
        List<Pracownik> resp = null;
        try {
            PreparedStatement pstm = dbCon.prepareStatement(
                    "SELECT Stanowisko.id as sid, Stanowisko.nazwa as snazwa, Pracownik.id as pid, imie, nazwisko  FROM Pracownik, Stanowisko WHERE nazwisko like ? AND stanowisko.id=pracownik.stanowisko");
            pstm.setString(1,"%"+nazwisko+"%");
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
    public List<Pracownik> getPracownicyByStanowisko(Stanowisko stanowisko) {
        List<Pracownik> resp = null;
        try {
            PreparedStatement pstm = dbCon.prepareStatement(
                    "SELECT Stanowisko.id as sid, Stanowisko.nazwa as snazwa, Pracownik.id as pid, imie, nazwisko  FROM Pracownik, Stanowisko WHERE snazwa like ? AND stanowisko.id=pracownik.stanowisko");
            pstm.setString(1,"%"+stanowisko.getNazwa()+"%");
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
    public List<Pracownik> getPracownicyByJednostka(int id) {
        List<Pracownik> resp = null;
        try {
            PreparedStatement pstm = dbCon.prepareStatement(
                    "SELECT Stanowisko.id as sid, Stanowisko.nazwa as snazwa, Pracownik.id as pid, imie, nazwisko  FROM Pracownik, Stanowisko, PracJednLnk WHERE stanowisko.id=pracownik.stanowisko AND pracownik.id=id_prac AND id_jedn = ?");
            pstm.setInt(1,id);
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
}
