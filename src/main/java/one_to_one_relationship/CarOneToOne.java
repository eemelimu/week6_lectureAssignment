package one_to_one_relationship;

import jakarta.persistence.*;

@Entity(name = "CarOneToOne")
public class CarOneToOne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;

    @OneToOne
    @JoinColumn(name = "driver_id")
    private DriverOneToOne driverOneToOne;

    public DriverOneToOne getDriver() {
        return driverOneToOne;
    }

    public void setDriver(DriverOneToOne driverOneToOne) {
        this.driverOneToOne = driverOneToOne;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}