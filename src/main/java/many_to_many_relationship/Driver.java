package many_to_many_relationship;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int experience;

    @ManyToMany
    @JoinTable(
            name = "driver_car", // name of the join table
            joinColumns = @JoinColumn(name = "driver_id"), // foreign key for Driver
            inverseJoinColumns = @JoinColumn(name = "car_id") // foreign key for Car
    )
    private Set<Car> cars = new HashSet<>();

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

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    public void addCar(Car car) {
        this.cars.add(car);
        car.getDrivers().add(this);
    }
}
