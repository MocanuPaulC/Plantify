package be.kdg.integration.plantifybackend.domain.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "Arduino")
public class ArduinoDao {
    @Id
    @Column(name = "physicalidentifier", nullable = false, updatable = false)
    private int physicalIdentifier;

    @Column(name = "series", updatable = false)
    private String series;

    @Column(name = "ledsetting", nullable = false)
    private boolean ledSetting;

    @Column(name = "redcode", nullable = false)
    private short redCode;

    @Column(name = "greencode", nullable = false)
    private short greenCode;

    @Column(name = "bluecode", nullable = false)
    private short blueCode;

    public ArduinoDao(int physicalIdentifier, String series, boolean ledSetting, short redCode, short greenCode, short blueCode) {
        this.physicalIdentifier = physicalIdentifier;
        this.series = series;
        this.ledSetting = ledSetting;
        this.redCode = redCode;
        this.greenCode = greenCode;
        this.blueCode = blueCode;
    }

    public ArduinoDao() {

    }




    public int getPhysicalIdentifier() {
        return physicalIdentifier;
    }

    public void setPhysicalIdentifier(int physicalIdentifier) {
        this.physicalIdentifier = physicalIdentifier;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public boolean getLedSetting() {
        return ledSetting;
    }

    public void setLedSetting(boolean ledSetting) {
        this.ledSetting = ledSetting;
    }

    public short getRedCode() {
        return redCode;
    }

    public void setRedCode(short redCode) {
        this.redCode = redCode;
    }

    public short getGreenCode() {
        return greenCode;
    }

    public void setGreenCode(short greenCode) {
        this.greenCode = greenCode;
    }

    public short getBlueCode() {
        return blueCode;
    }

    public void setBlueCode(short blueCode) {
        this.blueCode = blueCode;
    }
}
