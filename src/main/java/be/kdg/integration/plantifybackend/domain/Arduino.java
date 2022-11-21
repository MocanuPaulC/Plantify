package be.kdg.integration.plantifybackend.domain;


public class Arduino {
    private String series;

    public void setSeries(String series) {
        this.series = series;
    }

// False means base setting and true means color is selected by user

    @Override
    public String toString() {
        return "Arduino{" +
                ", physicalIdentifier=" + physicalIdentifier +
                '}';
    }


    public Arduino() {
    }

    private boolean ledSetting=false;
    private short pumpInstruction;
    private int physicalIdentifier;
    private RGBColor ledColor= new RGBColor();
    private int id;

    public int getPhysicalIdentifier() {
        return physicalIdentifier;
    }

    public void setPhysicalIdentifier(int physicalIdentifier) {
        this.physicalIdentifier = physicalIdentifier;
    }

    public Arduino(String series, int physicalIdentifier) {
        this.series=series;
        this.physicalIdentifier=physicalIdentifier;
    }
    public void setColors(RGBColor color){
        // to change values with parameter
        ledColor.setBlue(color.getBlue());
        ledColor.setGreen(color.getGreen());
        ledColor.setRed(color.getRed());

    }


    public void setBrightness(short brightness){
        ledColor.setBrightness(brightness);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLedSetting(boolean setting){
        this.ledSetting=setting;
    }

    public String getSeries() {
        return series;
    }

    public boolean getLedSetting() {
        return ledSetting;
    }

    public short getPumpInstruction() {
        return pumpInstruction;
    }

    public void setPumpInstruction(short pumpInstruction) {
        this.pumpInstruction = pumpInstruction;
    }

    public RGBColor getLedColor() {
        return ledColor;
    }


}
