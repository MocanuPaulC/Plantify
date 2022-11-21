package be.kdg.integration.plantifybackend.presentation.converter;

import be.kdg.integration.plantifybackend.domain.PlantType;
import org.springframework.core.convert.converter.Converter;


public class StringToPlantTypeConverter implements Converter<String, PlantType> {

    @Override
    public PlantType convert(String source) {
        return PlantType.valueOf(source);
    }
}
