package service;

import model.Car;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CarServiceImpl  implements CarService {

    @Override
    public Car getCar(List<Car> cars, int id) {
        return cars.stream()
                .filter(car -> car.getId() == id)
                .findAny()
                .orElse(null);
    }
}
