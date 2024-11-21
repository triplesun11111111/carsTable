package web.controller;
import model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

import java.util.List;

@Controller
public class CarController {
    private final CarService carService;
    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }
    @GetMapping(value = "/cars")

    public String showCars(@RequestParam(value = "count", defaultValue = "5") int count, ModelMap model) {
        List<Car> cars = carService.returnCars();
        if (count > 0 && count <= 5) {
            cars = cars.subList(0, count);
        } else if (count > 5) {
            cars = cars;
        }
        model.addAttribute("cars", cars);
        return "cars";
    }
}
