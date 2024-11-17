package dao;

import model.Pracownik;
import model.Stanowisko;

import java.util.List;

public interface PracownikDAO {
    Pracownik getPracownik(int id);
    List<Pracownik> getPracownicy();
    List<Pracownik> getPracownicyByImie(String imie);
    List<Pracownik> getPracownicyByNazwisko(String nazwisko);
    List<Pracownik> getPracownicyByStanowisko(Stanowisko stanowisko);

    List<Pracownik> getPracownicyByJednostka(int id);
}
