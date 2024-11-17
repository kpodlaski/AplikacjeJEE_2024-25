package dao;

import model.Stanowisko;

import java.util.List;

public interface StawiskoDAO {
    List<Stanowisko> getStanowiska();
    List<Stanowisko> getStanowiskaByNazwa(String nazwa);
    Stanowisko getStanowisko(int id);
}
