package be.kdg.integration.plantifybackend.domain.gson;

import be.kdg.integration.plantifybackend.domain.Arduino;
import be.kdg.integration.plantifybackend.domain.PlantData;

import be.kdg.integration.plantifybackend.domain.RGBColor;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArduinoMapper implements RowMapper<Arduino> {
    @Override
    public Arduino mapRow(ResultSet rs, int rowNum) throws SQLException {
        Arduino arduino = new Arduino(rs.getString("series"), rs.getInt("physicalIdentifier"));
        arduino.setLedSetting(rs.getBoolean("ledSetting"));
        RGBColor rgbColor = new RGBColor();
        rgbColor.setRed(rs.getShort("redCode"));
        rgbColor.setGreen(rs.getShort("greenCode"));
        rgbColor.setBlue(rs.getShort("blueCode"));
        arduino.setColors(rgbColor);
        return arduino;
    }
}
