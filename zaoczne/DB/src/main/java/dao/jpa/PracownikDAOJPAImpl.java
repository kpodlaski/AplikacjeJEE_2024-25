package dao.jpa;

import dao.PracownikDAO;
import model.Pracownik;
import model.Stanowisko;

import java.util.List;

public class PracownikDAOJPAImpl implements PracownikDAO {
    @Override
    public Pracownik getPracownik(int id) {
        return null;
    }

    @Override
    public List<Pracownik> getPracownicy() {
        return null;
    }

    @Override
    public List<Pracownik> getPracownicyByImie(String imie) {
        return null;
    }

    @Override
    public List<Pracownik> getPracownicyByNazwisko(String nazwisko) {
        return null;
    }

    @Override
    public List<Pracownik> getPracownicyByStanowisko(Stanowisko stanowisko) {
        return null;
    }

    @Override
    public List<Pracownik> getPracownicyByJednostka(int id) {
        return null;
    }
}
