package dao.jdbc;

import model.Person;
import model.Position;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO implements dao.PersonDAO {
    {
        try {
            Class.forName("org.postgresql.Driver").newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private String selectAll = "Select s.id as sid, nazwa, p.id as pid, imie, nazwisko from Stanowisko as s, Pracownik as p WHERE p.stanowisko = s.id";
    private String selectById = "Select s.id as sid, nazwa, p.id as pid, imie, nazwisko from Stanowisko as s, Pracownik as p WHERE p.stanowisko = s.id and p.id = ?";
    private String selectByImie = "Select s.id as sid, nazwa, p.id as pid, imie, nazwisko from Stanowisko as s, Pracownik as p WHERE p.stanowisko = s.id and imie LIKE ?";
    private String selectByNazwisko = "Select s.id as sid, nazwa, p.id as pid, imie, nazwisko from Stanowisko as s, Pracownik as p WHERE p.stanowisko = s.id and nazwisko LIKE ?";
    private String maxId = "Select max(id) from Pracownik";
    private String update = "UPDATE Pracownik SET imie = ?, nazwisko =?, stanowisko= ? WHERE id = ?";
    private String insert = "INSERT INTO Pracownik (id, imie, nazwisko, stanowisko) VALUES(?,?,?,?)";
    private String delete = "DELETE FROM Pracownik WHERE id = ?";

    private Connection con = null;
    private PositionDAO positionDAO;

    @Override
    public List<Person> getAllPersons() {
        List<Person> persons = new ArrayList<>();
        try {
            PreparedStatement pstm = con.prepareStatement(selectAll);
            pstm.execute();
            ResultSet rs = pstm.getResultSet();
            while (rs.next())
                persons.add(pracownikFromRS(rs));
            rs.close();
            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return persons;
    }

    Person pracownikFromRS(ResultSet rs) throws SQLException {
        Position pos = positionDAO.positionFromRS(rs);
        Person person = new Person(
                rs.getInt("pid"),
                rs.getString("imie"),
                rs.getString("nazwisko"),
                pos);
        return person;
    }

    @Override
    public List<Person> getPersonsByName(String name) {
        List<Person> persons = new ArrayList<>();
        try {
            PreparedStatement pstm = con.prepareStatement(selectByImie);
            pstm.setString(1,"%"+name+"%");
            pstm.execute();
            ResultSet rs = pstm.getResultSet();
            while (rs.next())
                persons.add(pracownikFromRS(rs));
            rs.close();
            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return persons;
    }

    @Override
    public List<Person> getPersonsBySurname(String surname) {
        List<Person> persons = new ArrayList<>();
        try {
            PreparedStatement pstm = con.prepareStatement(selectByNazwisko);
            pstm.setString(1,"%"+surname+"%");
            pstm.execute();
            ResultSet rs = pstm.getResultSet();
            while (rs.next())
                persons.add(pracownikFromRS(rs));
            rs.close();
            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return persons;
    }

    @Override
    public Person getPerson(int id) {
        Person person = null;
        try {
            PreparedStatement pstm = con.prepareStatement(selectById);
            pstm.setInt(1,id);
            pstm.execute();
            ResultSet rs = pstm.getResultSet();
            while (rs.next())
                person=pracownikFromRS(rs);
            rs.close();
            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return person;
    }

    @Override
    public int update(Person p) {
        int changedRows = 0;
        Position pos = positionDAO.getPosition(p.getPosition().getId());
        if (pos ==null || !pos.equals(p.getPosition())){
            changedRows+=positionDAO.update(p.getPosition());
        }
        try {
            PreparedStatement pstm = con.prepareStatement(update);
            pstm.setString(1, p.getName());
            pstm.setString(2, p.getSurname());
            pstm.setInt(3,p.getPosition().getId());
            pstm.setInt(4,p.getId());
            changedRows += pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return changedRows;
    }

    @Override
    public int insert(Person p) {
        int nextId = -1;
        Position pos = positionDAO.getPosition(p.getPosition().getId());
        if (pos ==null){
            pos = p.getPosition();
            pos.setId(positionDAO.insert(pos));
        }
        try {
            PreparedStatement pstm = con.prepareStatement(maxId);
            ResultSet rs = pstm.getResultSet();
            rs.next();
            nextId = rs.getInt(1)+1;
            p.setId(nextId);
            rs.close();
            pstm.close();
            pstm = con.prepareStatement(insert);
            pstm.setInt(1,p.getId());
            pstm.setString(2, p.getName());
            pstm.setString(3, p.getSurname());
            pstm.setInt(4,p.getPosition().getId());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return nextId;
    }

    @Override
    public int delete(Person p) {
        return deletePerson(p.getId());
    }

    @Override
    public int deletePerson(int id) {
        int changedRows;
        try {
            PreparedStatement pstm = con.prepareStatement(delete);
            pstm.setInt(1,id);
            changedRows = pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return changedRows;
    }

    public void close(){
        try {
            if (!con.isClosed())
                con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
