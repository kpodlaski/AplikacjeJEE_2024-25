package dao;

import model.Pracownik;
import model.Stanowisko;

import java.util.List;

public interface PracownikDAO {
    Pracownik getPracownik(int id);
    List<Pracownik> getPracownicy();
    List<Pracownik> getPracownicyByImie();
    List<Pracownik> getPracownicyByNazwisko();
    List<Pracownik> getPracownicyByStanowisko(Stanowisko stanowisko);

}
