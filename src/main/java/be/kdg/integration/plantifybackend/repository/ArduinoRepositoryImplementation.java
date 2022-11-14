package be.kdg.integration.plantifybackend.repository;

import be.kdg.integration.plantifybackend.domain.Arduino;
import be.kdg.integration.plantifybackend.domain.Plant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ArduinoRepositoryImplementation implements ArduinoRepository{
    @Autowired
    public ArduinoRepositoryImplementation() {
        arduinoList=new ArrayList<>();
    }
    @Autowired
    JdbcTemplate jdbcTemplate;
    List<Arduino> arduinoList;


    @Override
    public Arduino saveArduino(Arduino arduino) {
//        String saveSql =
//                String.format("INSERT INTO currentplants (plantname,dateadded,planttype) " +
//                        "VALUES ('%s',CURRENT_TIMESTAMP,'%s')", plant.getName(), plant.getTypeOfPlant());
//        jdbcTemplate.execute(saveSql);
        arduino.setId(arduinoList.stream().mapToInt(Arduino::getId).max().orElse(0) + 1);
        arduinoList.add(arduino);
        return arduino;
    }
}
