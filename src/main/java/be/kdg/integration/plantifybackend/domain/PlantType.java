package be.kdg.integration.plantifybackend.domain;

/**
 * Different types of plants, useful for future AI in determining water usagepublic
 */
public enum PlantType {
    HERBS(20,40,50,15,21,700),
    SHRUBS(21,40,60,21,24,700),
    TREES(21,40,40,20,38,700),
    CLIMBERS(60,80,40,20,38,700),
    CREEPERS(21,40,50,21,27,700);

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