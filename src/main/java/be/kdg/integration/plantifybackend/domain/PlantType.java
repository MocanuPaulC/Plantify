package be.kdg.integration.plantifybackend.domain;

import java.util.Optional;

public enum PlantType {
    DESERT, WATER, MOUNTAIN, PLAIN;
    public static Optional<PlantType> check(String val) {
        try { return Optional.of(PlantType.valueOf(val)); }
        catch (Exception e) {/* do nothing */}
        return Optional.empty();
    }
}
