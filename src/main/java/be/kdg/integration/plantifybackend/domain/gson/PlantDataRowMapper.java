package be.kdg.integration.plantifybackend.domain.gson;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlantDataRowMapper implements RowMapper<PlantData> {
    @Override
    public PlantData mapRow(ResultSet rs, int rowNum) throws SQLException{
        PlantData plantData = new PlantData();
        plantData.addPlantID(rs.getInt("plantID"));
        plantData.addTemperature(rs.getInt("temperature"));
        plantData.addHumidity(rs.getInt("humidity"));
        plantData.addMoisture(rs.getInt("moisture"));
        plantData.addLight(rs.getInt("light"));
        return plantData;
    }
}
