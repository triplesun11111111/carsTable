package web.service;

import model.Car;

import java.util.List;
public interface CarService {
    public Car getCar(List<Car> cars, int id);
    public List<Car> returnCars();
}
