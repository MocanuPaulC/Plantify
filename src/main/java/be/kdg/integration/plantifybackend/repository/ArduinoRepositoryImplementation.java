package be.kdg.integration.plantifybackend.repository;

import be.kdg.integration.plantifybackend.domain.Arduino;
import be.kdg.integration.plantifybackend.domain.Plant;
import be.kdg.integration.plantifybackend.domain.RGBColor;
import be.kdg.integration.plantifybackend.domain.hibernate.ArduinoDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Repository
public class ArduinoRepositoryImplementation implements ArduinoRepository{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public ArduinoRepositoryImplementation(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        arduinoList=new ArrayList<>();
    }

    @Override
    public void setArduinoList(List<Plant> plantList) {
        logger.debug("Setting arduino list using plant list");
        for (Plant plant : plantList) {
            arduinoList.add(plant.getArduino());
        }
    }

    JdbcTemplate jdbcTemplate;
    List<Arduino> arduinoList;

    @Override
    public void setLedSetting(int physicalId, boolean base) {
        logger.debug("setting leds");
        arduinoList.stream().filter(arduino -> arduino.getPhysicalIdentifier()==physicalId).toList().get(0).setLedSetting(base);
    }

    @Override
    public void changeColor(int physicalId, RGBColor color) {
        logger.debug("Setting color of "+physicalId +" to " + color);
        arduinoList.stream().filter(arduino -> arduino.getPhysicalIdentifier()==physicalId).toList().get(0).setColors(color);
    }

    @Override
    public Arduino saveArduino(Arduino arduino) {
        logger.debug("saving arduino to database");
        String saveSql =
                String.format("INSERT INTO arduino (physicalIdentifier, series, ledSetting, redCode, greenCode, blueCode) " +
                        "VALUES ('%d', '%s', '%b', '%d', '%d', '%d')",
                        arduino.getPhysicalIdentifier(), arduino.getSeries(), arduino.getLedSetting(),
                        arduino.getLedColor().getRed(), arduino.getLedColor().getGreen(), arduino.getLedColor().getBlue());
        jdbcTemplate.execute(saveSql);
        arduino.setId(arduinoList.stream().mapToInt(Arduino::getId).max().orElse(0) + 1);
        arduinoList.add(arduino);
        logger.debug("added arduino to database and to arduinolist");
        return arduino;
    }

    @Override
    public List<Arduino> arduinoList() {
        return arduinoList;
    }

    @Override
    public void deleteArduino(int physicalId){
        String deleteArduino= "DELETE FROM arduino WHERE physicalIdentifier="+physicalId+"; ";
        logger.debug("removing arduino from database and arduino list");
        arduinoList.remove(arduinoList.stream()
                .filter(arduino -> arduino.getPhysicalIdentifier() == physicalId).toList().get(0));
        jdbcTemplate.execute(deleteArduino);
        logger.debug("deletion successful");
    }
}

