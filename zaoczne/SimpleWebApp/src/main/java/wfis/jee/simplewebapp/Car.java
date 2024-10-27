package wfis.jee.simplewebapp;

public class Car {
    private String brand;
    private int year;

    public Car(){
        brand ="";
    }

    public Car(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    public void copyFrom(Car car){
        this.brand = car.brand;
        this.year = car.year;
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
}
