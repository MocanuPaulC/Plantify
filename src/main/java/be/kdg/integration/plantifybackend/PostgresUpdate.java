package be.kdg.integration.plantifybackend;

import be.kdg.integration.plantifybackend.domain.gson.PlantDataRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostgresUpdate {

    JdbcTemplate jdbcTemplate;
    @Autowired
    public PostgresUpdate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate=jdbcTemplate;
    }

    public void update(){
        String pullData = "SELECT * FROM plantCurrentData";
        List<PlantData> plantDataList = jdbcTemplate.query(pullData, new PlantDataRowMapper());
        List<Integer> plantIDList = new ArrayList<>();

        for (PlantData plantData : plantDataList) {
            if(!plantIDList.contains(plantData.getPlantID())){
                plantIDList.add(plantData.getPlantID());
            }
        }

        for (Integer plantID : plantIDList) {
            int temperatureAvg=0;
            int humidityAvg=0;
            int moistureAvg=0;
            int lightAvg=0;
            for (PlantData plantData : plantDataList) {
                if(plantData.getPlantID()==plantID){
                    temperatureAvg+=plantData.getTemperature();
                    humidityAvg+=plantData.getHumidity();
                    moistureAvg+=plantData.getMoisture();
                    lightAvg+=plantData.getLight();
                }
            }
            String postData=String.format("INSERT INTO plantDataArchive " +
                    "(plantID, temperatureAvg, humidityAvg, moistureAvg, lightAvg) " +
                    "VALUES(%d, %d, %d, %d, %d)", plantID, temperatureAvg, humidityAvg, moistureAvg, lightAvg);
            jdbcTemplate.execute(postData);
        }
        String clearTable="DROP TABLE IF EXISTS plantCurrentData; " +
                "CREATE TABLE plantCurrentData( " +
                "ID INT NOT NULL " +
                "   GENERATED ALWAYS AS IDENTITY " +
                "   PRIMARY KEY, " +
                "plantID INT NOT NULL " +
                "   CONSTRAINT fk_plantID REFERENCES currentPlants (plantID) " +
                "       ON DELETE CASCADE, " +
                "temperature NUMERIC(10) NOT NULL, " +
                "humidity NUMERIC(10) NOT NULL, " +
                "moisture NUMERIC(10) NOT NULL, " +
                "light NUMERIC(10) NOT NULL, " +
                "refreshTime TIMESTAMP NOT NULL " +
                "   DEFAULT CURRENT_TIMESTAMP " +
                "); ";
        jdbcTemplate.execute(clearTable);
    }
}
