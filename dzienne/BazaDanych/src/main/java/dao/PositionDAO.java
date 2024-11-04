package dao;

import javax.swing.text.Position;
import java.util.List;

public interface PositionDAO {
    List<Position> getAll();
    Position get(int id);
    List<Position> getPositionByName(String name);
    int update(Position p);
    int insert(Position p);
    int delete(Position p);
    int delete(int id);

}
