package be.kdg.integration.plantifybackend.domain.gson;

import be.kdg.integration.plantifybackend.domain.Arduino;
import be.kdg.integration.plantifybackend.domain.Plant;
import be.kdg.integration.plantifybackend.domain.PlantType;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

public class PlantRowMapper implements RowMapper<Plant> {

    @Override
    public Plant mapRow(ResultSet rs, int rowNum) throws SQLException {

        Plant plant = new Plant();
        plant.setId(rs.getInt("plantid"));
        plant.setName(rs.getString("plantname"));
        plant.setTypeOfPlant(PlantType.valueOf(rs.getString("planttype").toUpperCase(Locale.ROOT)));


        //hardcoded cuz we only have one arduino
        plant.setArduino(new Arduino(0,"1"));


        return plant;

    }

}
