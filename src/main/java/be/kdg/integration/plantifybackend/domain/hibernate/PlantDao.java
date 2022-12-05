package be.kdg.integration.plantifybackend.domain.hibernate;

import be.kdg.integration.plantifybackend.domain.PlantType;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.sql.Timestamp;

@Entity
@Table(name = "plant")
public class PlantDao {
    @Id
    @Column(name = "plantId", nullable = false, updatable = false)
    private int plantId;

    @ManyToOne
    @JoinColumn(name = "userEmail", updatable = false)
    private ClientDao client;

    @Column(name = "plantName", updatable = false)
    private String plantName;

    @Column(name = "plantType", updatable = false)
    @Enumerated(EnumType.STRING)
    private PlantType plantType;

    @Column(name = "dateAdded", updatable = false)
    private Timestamp dateAdded;

    @OneToOne
    @JoinColumn(name = "arduinoPhysicalIdentifier", updatable = false)
    private ArduinoDao arduino;

    public Timestamp getDateAdded() {
        return dateAdded;
    }

    public PlantType getPlantType() {
        return plantType;
    }

    public String getPlantName() {
        return plantName;
    }

    public int getPlantId() {
        return plantId;
    }
}
