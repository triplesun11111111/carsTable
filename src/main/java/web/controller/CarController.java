package web.controller;
import model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController implements CarService {
    @Override
    public Car getCar(List<Car> cars, int id) {
        if (id >= 0 && id < cars.size()) {
            return cars.get(id);
        } else {
            return null;
        }
    }

    @GetMapping(value = "/cars")

    public String showCars(@RequestParam(value = "count", defaultValue = "5") int count, ModelMap model) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1, "BMW", "black"));
        cars.add(new Car(2, "Audi", "white"));
        cars.add(new Car(3, "Honda", "red"));
        cars.add(new Car(4, "Ford", "black"));
        cars.add(new Car(5, "Audi", "green"));

        if (count > 0 && count <= 5) {
            cars = cars.subList(0, count);
        } else if (count > 0 && count > 5) {
            cars = cars;
        }
        model.addAttribute("cars", cars);
        return "cars";
    }
}
