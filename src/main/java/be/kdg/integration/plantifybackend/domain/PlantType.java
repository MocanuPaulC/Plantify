package be.kdg.integration.plantifybackend.domain;

/**
 * Different types of plants, useful for future AI in determining water usagepublic
 */
public enum PlantType {
    DESERT(20,80,10,10,50,700),
    WATER(20,80,10,10,50,700),
    MOUNTAIN(20,80,10,10,50,700),
    PLAIN(20,80,10,10,50,700);

    private int minMoisture;
    private int maxMoisture;
    private int minHumidity;
    private int minTemp;
    private int maxTemp;
    private int maxBrightness;

    PlantType(int minMoisture, int maxMoisture, int minHumidity, int minTemp, int maxTemp, int maxBrightness) {
        this.minMoisture=minMoisture;
        this.maxMoisture=maxMoisture;
        this.minHumidity=minHumidity;
        this.minTemp=minTemp;
        this.maxTemp=maxTemp;
        this.maxBrightness=maxBrightness;
    }

    public int getMinMoisture() {
        return minMoisture;
    }

    public int getMaxMoisture() {
        return maxMoisture;
    }

    public int getMinHumidity() {
        return minHumidity;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public int getMaxBrightness() {
        return maxBrightness;
    }

    @Override
    public String toString() {
        return String.format("%d %d %d %d %d %d",minMoisture,maxMoisture,minHumidity,minTemp,maxTemp,maxBrightness);
    }


}