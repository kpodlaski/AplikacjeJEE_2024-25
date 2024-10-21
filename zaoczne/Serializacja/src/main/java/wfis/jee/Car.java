package wfis.jee;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {
    private int ID;
    @JsonProperty("marka")
    private String brand;
    private int year;
    private String plate;

    public Car(){}

    public Car(int ID, String brand, int year, String plate) {
        this.ID = ID;
        this.brand = brand;
        this.year = year;
        this.plate = plate;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }
}
