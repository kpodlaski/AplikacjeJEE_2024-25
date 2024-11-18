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

    private String selectAll = "Select id as sid, nazwa from Stanowisko";
    private String selectById = "Select id as sid, nazwa from Stanowisko WHERE id = ?";
    private String selectByName = "Select id as sid, nazwa from Stanowisko WHERE nazwa LIKE ?";
    private String maxId = "Select max(id) from Stanowisko";
    private String update = "UPDATE Stanowisko SET nazwa = ? WHERE id = ?";
    private String insert = "INSERT INTO Stanowisko (id, nazwa) VALUES(?,?)";
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
        int nextId = -1;
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
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return nextId;
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
