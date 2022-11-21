package be.kdg.integration.plantifybackend.domain;

/**
 * RGBColor class for colors and brightness of led strip
 */
public class RGBColor {
    private short red;
    private short blue;
    private short green;
    private short brightness;

    public short getRed() {
        return red;
    }

    public short getBlue() {
        return blue;
    }

    public short getGreen() {
        return green;
    }

    public short getBrightness() {
        return brightness;
    }

    public void setRed(short red) {
        this.red = red;
    }

    public void setBlue(short blue) {
        this.blue = blue;
    }

    public void setGreen(short green) {
        this.green = green;
    }

    public void setBrightness(short brightness) {
        this.brightness = brightness;
    }
}
