package one_to_many_relationship;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "DriverOneToMany")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int experience;

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    private List<Car> cars = new ArrayList<>();

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public void addCar(Car car) {
        car.setDriver(this);
        this.cars.add(car);
    }
}