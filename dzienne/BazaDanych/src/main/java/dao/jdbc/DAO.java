package dao.jdbc;

import dao.PersonDAO;
import dao.PositionDAO;
import model.Person;
import model.Position;
import java.util.List;

public class  DAO implements dao.DAO {
    private PersonDAO personDAO;
    private PositionDAO positionDAO;

    @Override
    public List<Position> getAllPositions() {
        return positionDAO.getAllPositions();
    }

    @Override
    public Position getPosition(int id) {
        return positionDAO.getPosition(id);
    }

    @Override
    public List<Position> getPositionByName(String name) {
        return positionDAO.getPositionByName(name);
    }

    @Override
    public int update(Position p) {
        return positionDAO.update(p);
    }

    @Override
    public int insert(Position p) {
        return positionDAO.insert(p);
    }

    @Override
    public int delete(Position p) {
        return positionDAO.delete(p);
    }

    @Override
    public int deletePosition(int id) {
        return positionDAO.deletePosition(id);
    }

    @Override
    public List<Person> getAllPersons() {
        return personDAO.getAllPersons();
    }

    @Override
    public List<Person> getPersonsByName() {
        return personDAO.getPersonsByName();
    }

    @Override
    public List<Person> getPersonsBySurname() {
        return personDAO.getPersonsBySurname();
    }

    @Override
    public Person getPerson(int id) {
        return personDAO.getPerson(id);
    }

    @Override
    public int update(Person p) {
        return personDAO.update(p);
    }

    @Override
    public int insert(Person p) {
        return personDAO.insert(p);
    }

    @Override
    public int delete(Person p) {
        return personDAO.delete(p);
    }

    @Override
    public int deletePerson(int id) {
        return personDAO.deletePerson(id);
    }

    //    int deletePosition(int id);
//    int deletePerson(int id);

}
