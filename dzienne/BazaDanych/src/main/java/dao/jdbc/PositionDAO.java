package dao.jdbc;

import model.Position;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionDAO implements dao.PositionDAO{



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

    private Connection con = null;
    PositionDAO(Connection con) throws SQLException {
        this.con = con;
    }

    private String selectAll = "SELECT id as sid, nazwa FROM Stanowisko";
    private String selectById = "SELECT id as sid, nazwa FROM Stanowisko WHERE id = ?";
    private String selectByName = "SELECT id as sid, nazwa FROM Stanowisko WHERE nazwa LIKE ?";
    private String maxId = "SELECT max(id) FROM Stanowisko";
    private String update = "UPDATE Stanowisko SET nazwa = ? WHERE id = ?";
    private String insert = "INSERT INTO Stanowisko (nazwa) VALUES(?)";
    private String delete = "DELETE FROM Stanowisko WHERE id = ?";

    @Override
    public List<Position> getAllPositions() {
        List<Position> positions = new ArrayList<>();
        try {
            PreparedStatement pstm = con.prepareStatement(selectAll);
            pstm.execute();
            ResultSet rs = pstm.getResultSet();
            while (rs.next())
                positions.add(positionFromRS(rs));
            rs.close();
            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return positions;
    }

    Position positionFromRS(ResultSet rs) throws SQLException {
        return new Position(rs.getInt("sid"), rs.getString("nazwa"));
    }

    @Override
    public Position getPosition(int id) {
        Position position = null;
        try {
            PreparedStatement pstm = con.prepareStatement(selectById);
            pstm.setInt(1,id);
            pstm.execute();
            ResultSet rs = pstm.getResultSet();
            while (rs.next())
                position = positionFromRS(rs);
            rs.close();
            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return position;
    }

    @Override
    public List<Position> getPositionByName(String name) {
        List<Position> positions = new ArrayList<>();
        try {
            PreparedStatement pstm = con.prepareStatement(selectByName);
            pstm.setString(1, "%"+name+"%");
            pstm.execute();
            ResultSet rs = pstm.getResultSet();
            while (rs.next())
                positions.add(positionFromRS(rs));
            rs.close();
            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return positions;
    }

    @Override
    public int update(Position p) {
        int changedRows;
        try {
            PreparedStatement pstm = con.prepareStatement(update);
            pstm.setString(1, p.getName());
            pstm.setInt(2,p.getId());
            changedRows = pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return changedRows;
    }

    @Override
    public int insert(Position p) {
        try {
            PreparedStatement pstm = con.prepareStatement(insert);
            pstm.setString(1, p.getName());
            pstm.executeUpdate();
            ResultSet generatedKeys = pstm.getGeneratedKeys();
            if (generatedKeys.next()) {
                    p.setId(generatedKeys.getInt(1));
            }
            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return p.getId();
    }

    @Override
    public int delete(Position p) {
        return deletePosition(p.getId());
    }

    @Override
    public int deletePosition(int id) {
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
