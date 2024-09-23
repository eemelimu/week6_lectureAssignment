package one_to_one_relationship;

import jakarta.persistence.*;

@Entity(name = "DriverOneToOne")
public class DriverOneToOne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int experience;

    @OneToOne(mappedBy = "driver")
    private CarOneToOne carOneToOne;

    public CarOneToOne getCar() {
        return carOneToOne;
    }

    public void setCar(CarOneToOne carOneToOne) {
        this.carOneToOne = carOneToOne;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

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
}