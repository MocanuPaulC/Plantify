package be.kdg.integration.plantifybackend.domain.gson;

import be.kdg.integration.plantifybackend.domain.Plant;
import be.kdg.integration.plantifybackend.domain.PlantData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlantDataRowMapper implements RowMapper<Plant> {
    @Override
    public Plant mapRow(ResultSet rs, int rowNum) throws SQLException{
        Plant plant = new Plant();
        Plant.Details plantData = plant.getDetails();
        plant.setId(rs.getInt("plantID"));
        plantData.setTemperature(rs.getInt("temperature"));
        plantData.setHumidity(rs.getInt("humidity"));
        plantData.setMoisture(rs.getInt("moisture"));
        plantData.setBrightness(rs.getInt("light"));
        return plant;
    }
}
