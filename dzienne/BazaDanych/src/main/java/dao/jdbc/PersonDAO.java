package dao.jdbc;

import model.Person;

import java.util.List;

public class PersonDAO implements dao.PersonDAO {
    @Override
    public List<Person> getAllPersons() {
        return null;
    }

    @Override
    public List<Person> getPersonsByName() {
        return null;
    }

    @Override
    public List<Person> getPersonsBySurname() {
        return null;
    }

    @Override
    public Person getPerson(int id) {
        return null;
    }

    @Override
    public int update(Person p) {
        return 0;
    }

    @Override
    public int insert(Person p) {
        return 0;
    }

    @Override
    public int delete(Person p) {
        return 0;
    }

    @Override
    public int deletePerson(int id) {
        return 0;
    }
}
