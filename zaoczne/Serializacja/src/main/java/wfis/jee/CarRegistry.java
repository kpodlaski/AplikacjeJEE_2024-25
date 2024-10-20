package wfis.jee;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarRegistry {

    public static void main(String[] args) {
        serialize();
        deserialize();
    }

    public static void serialize(){
        Car c = new Car(1,"Volvo",2005, "EL12345");
        List<Car> cars = new ArrayList<>();
        cars.add(c);
        cars.add(new Car(2,"Syrenka",1974,"LWX1234"));
        ObjectMapper om = new ObjectMapper();
        om.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            String json = om.writeValueAsString(c);
            System.out.println(json);
            json = om.writeValueAsString(cars);
            System.out.println(json);
            om.writeValue(new File("cars.json"),cars);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deserialize(){
        ObjectMapper om = new ObjectMapper();
        om.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            List<Car> cars = Arrays.asList(om.readValue(new File("cars.json"),Car[].class));
            for (Car c :cars)
            {
                System.out.println(c.getBrand()+" "+c.getPlate());
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
