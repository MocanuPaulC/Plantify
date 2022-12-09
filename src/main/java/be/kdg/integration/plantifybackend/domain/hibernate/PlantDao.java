package be.kdg.integration.plantifybackend.domain.hibernate;

import be.kdg.integration.plantifybackend.domain.Arduino;
import be.kdg.integration.plantifybackend.domain.PlantType;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "plant")
public class PlantDao {

    public PlantDao(String userEmail, String plantName, PlantType plantType, int physicalIdentifier) {
        this.userEmail = userEmail;
        this.plantName = plantName;
        this.plantType = plantType;
        this.physicalIdentifier = physicalIdentifier;
        this.dateAdded = Timestamp.from(Instant.now());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long plantid;

    @Column(name = "useremail")
    private String userEmail;

    @Column(name = "plantname", updatable = false)
    private String plantName;

    @Column(name = "planttype", updatable = false)
    @Enumerated(EnumType.STRING)
    private PlantType plantType;

    @Column(name = "dateadded", updatable = false)
    private Timestamp dateAdded;


    @Column(name = "arduinophysicalidentifier")
    private int physicalIdentifier;

    public PlantDao() {

    }

    public Timestamp getDateAdded() {
        return dateAdded;
    }

    public PlantType getPlantType() {
        return plantType;
    }

    public String getPlantName() {
        return plantName;
    }

    public Long getPlantId() {
        return plantid;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public int getPhysicalIdentifier() {
        return physicalIdentifier;
    }
}
