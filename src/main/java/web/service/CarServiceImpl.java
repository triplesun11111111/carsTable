package web.service;

import model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CarServiceImpl implements CarService {
    private List<Car> cars = new ArrayList<>();

    public CarServiceImpl() {
        cars.add(new Car(1, "BMW", "black"));
        cars.add(new Car(2, "Audi", "white"));
        cars.add(new Car(3, "Honda", "red"));
        cars.add(new Car(4, "Ford", "black"));
        cars.add(new Car(5, "Audi", "green"));
    }

    @Override
    public Car getCar(List<Car> cars, int id) {
        return cars.stream()
                .filter(car -> car.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Car> returnCars() {
        return cars;
    }
}
