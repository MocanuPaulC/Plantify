package be.kdg.integration.plantifybackend.domain.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "details")
public class DetailsDao {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private int id;
    @Column(name = "plantid", nullable = false, updatable = false)
    private int plantId;
    @Column(name = "temperature", nullable = false, updatable = false)
    private double temperature;
    @Column(name = "humidity", nullable = false, updatable = false)
    private double humidity;
    @Column(name = "moisture", nullable = false, updatable = false)
    private double moisture;
    @Column(name = "light", nullable = false, updatable = false)
    private double light;
    @Column(name = "refreshTime", updatable = false)
    private Timestamp refreshTime;

    public Timestamp getRefreshTime() {
        return refreshTime;
    }

    public double getLight() {
        return light;
    }

    public double getMoisture() {
        return moisture;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getTemperature() {
        return temperature;
    }

    public int getPlantId() {
        return plantId;
    }

    public int getId() {
        return id;
    }

}
