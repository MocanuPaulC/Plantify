package be.kdg.integration.plantifybackend.domain.hibernate;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "arduino")
public class ArduinoDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dummyid;

    @Column(name = "physicalidentifier")
    private int physicalIdentifier;

    @Column(name = "series")
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


    public Long getDummyid() {
        return dummyid;
    }


    public void setDummyid(Long dummyId) {
        this.dummyid = dummyId;
    }

    public boolean isLedSetting() {
        return ledSetting;
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

    @Override
    public String toString() {
        return "ArduinoDao{" +
                "physicalIdentifier=" + physicalIdentifier +
                ", series='" + series + '\'' +
                ", ledSetting=" + ledSetting +
                ", redCode=" + redCode +
                ", greenCode=" + greenCode +
                ", blueCode=" + blueCode +
                '}';
    }
}
