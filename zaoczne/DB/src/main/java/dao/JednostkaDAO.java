package dao;

import model.Jednostka;
import java.util.List;

public interface JednostkaDAO {
    List<Jednostka> getJednostki();
    List<Jednostka> getJednostkiByNazwa(String nazwa);
    Jednostka getJednostkaById(int id);
}
