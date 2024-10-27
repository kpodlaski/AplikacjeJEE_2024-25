package wfis.jee.simplewebapp;

import java.util.ArrayList;
import java.util.List;

public class CarRepo {

    private List<Car> cars = new ArrayList<>();

    public CarRepo(){
        cars.add(new Car("Syrenka",1981));
        cars.add(new Car("Trabant",1975));
        cars.add(new Car("Polonez",1995));
        cars.add(new Car("Polonez",1993));
    }
    public List<Car> getAll(){
        return cars;
    }
    public List<Car> getCarsByBrand(String brand){
        List<Car> tempCars = new ArrayList<>();
        for (Car c : cars){
            if(c.getBrand().toLowerCase().equals(brand.toLowerCase())){
                tempCars.add(c);
            }
        }
        return tempCars;
    }
    //Add Methods for all possible get queries
    public boolean addCar(Car car){
        return cars.add(car);
    }
    //Add Methods for update, detete  queries
}
