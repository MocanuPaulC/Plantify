package be.kdg.integration.plantifybackend.repository;

import be.kdg.integration.plantifybackend.domain.Arduino;
import be.kdg.integration.plantifybackend.domain.Client;
import be.kdg.integration.plantifybackend.domain.Plant;
import be.kdg.integration.plantifybackend.domain.gson.PlantDetailsRowMapper;
import be.kdg.integration.plantifybackend.domain.hibernate.DetailsDao;
import be.kdg.integration.plantifybackend.domain.hibernate.PlantDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Repository
public class PlantRepositoryHibernate implements PlantRepository {
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PlantRepositoryHibernate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private Plant daoToPlant(PlantDao plantDao){
        return new Plant(plantDao.getPlantName(), plantDao.getPlantType(),
                new Arduino("xx", plantDao.getPhysicalIdentifier()),plantDao.getPlantId(), plantDao.getUserEmail());
    }
    @Override
    public List<Plant> getPlants() {
        logger.debug("searching plants");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        List<PlantDao> daoList = em.createQuery("select a from PlantDao a",
                PlantDao.class).getResultList();
        List<Plant> plantList = new ArrayList<>();
        logger.debug("daoList:");
        daoList.forEach(System.out::println);
        daoList.forEach(plantDao -> plantList.add(daoToPlant(plantDao)));
        logger.debug("plantList created");
        em.getTransaction().commit();
        em.close();
//        logger.debug();
        logger.debug("plantList:");
        plantList.forEach(System.out::println);
        return plantList;
    }

    @Override
    public void getPlantsFromDB(){
        /*
        logger.debug("getting plants from database");
        String getPlants = "SELECT plantid,useremail, plantname,planttype, arduinophysicalidentifier, series " +
                "FROM plant " +
                "JOIN arduino a on a.physicalidentifier = plant.arduinophysicalidentifier";
        plantList = jdbcTemplate.query(getPlants, new PlantRowMapper());
        String getDetails = """
                SELECT p.plantid, p.temperature,p.humidity,p.moisture,p.light,p.refreshtime
                FROM details AS p
                INNER JOIN (
                  SELECT plantid, MAX(refreshtime) AS date
                  FROM details
                  GROUP BY plantid
                ) tm ON p.plantid = tm.plantid AND p.refreshtime = tm.date;""" ;
        List<Plant> tempPlantList = jdbcTemplate.query(getDetails,new PlantDetailsRowMapper());
        for (Plant value : tempPlantList) {
            for (Plant plant : plantList) {
                if (plant.getId() == value.getId()) {
                    plant.setDetails(value.getDetails());
                }
            }
        }
        logger.debug(plantList.toString());*/
    }


    @Override
    public Plant savePlant(Plant plant, Client client) {
        logger.debug("saving plant to database");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(new PlantDao(
                client.getEmail(),
                plant.getName(),
                plant.getTypeOfPlant(),
                plant.getArduino().getPhysicalIdentifier()));
        em.getTransaction().commit();
        em.close();
        return plant;
    }


    public void saveCurrentReadingsToDB(Plant.Details details, int physicalId){
        logger.debug("saving readings to db");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        PlantDao plantDao =
                em.createQuery("select p from PlantDao p where p.physicalIdentifier="+physicalId+"; ",
                        PlantDao.class)
                        .getSingleResult();
        DetailsDao detailsDao = new DetailsDao(plantDao.getPlantId(), details.getTemperature(), details.getHumidity(),
                details.getMoisture(), details.getTemperature());
        em.persist(detailsDao);
        logger.debug("readings saved");
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public int getPhysicalIdentifier(int plantId) {
        logger.debug("getting arduino");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        PlantDao plantDao =  em.find(PlantDao.class, plantId);
        logger.debug("arduino retrieved");
        em.getTransaction().commit();
        em.close();
        return plantDao.getPhysicalIdentifier();
    }

    @Override
    public void deletePlant(int id){
        logger.debug("deleting plant");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        PlantDao plantDao =  em.find(PlantDao.class, id);
        em.remove(plantDao);
        logger.debug("plant deleted");
        em.getTransaction().commit();
        em.close();
    }

    // kept usage of jdbctemplate, might change it later if i wanna torture myself
    @Override
    public void updateDBArchive() {
        logger.debug("Archiving plant details");

        String pullData = "SELECT * FROM details";
        List<Plant> plantList = jdbcTemplate.query(pullData, new PlantDetailsRowMapper());
        String pullplantID = "SELECT DISTINCT plantID FROM details";
        List<Integer> plantIDList = jdbcTemplate.queryForList(pullplantID, Integer.class);

        for (Integer plantID : plantIDList) {
            double temperatureAvg=0;
            double humidityAvg=0;
            double moistureAvg=0;
            double lightAvg=0;
            int counter=0;
            double minimumTemp=0;
            double maximumTemp=0;
            double minimumHumidity=0;
            double maximumHumidity=0;
            double minimumMoisture=0;
            double maximumMoisture=0;
            double minimumLight=0;
            double maximumLight=0;
            for (Plant plant : plantList ) {
                if(plant.getId()==plantID){
                    temperatureAvg+=plant.getDetails().getTemperature();
                    humidityAvg+=plant.getDetails().getHumidity();
                    moistureAvg+=plant.getDetails().getMoisture();
                    lightAvg+=plant.getDetails().getBrightness();

                    if(counter==0){
                        minimumTemp=plant.getDetails().getTemperature();
                        maximumTemp=plant.getDetails().getTemperature();
                        minimumHumidity=plant.getDetails().getHumidity();
                        maximumHumidity=plant.getDetails().getHumidity();
                        minimumMoisture=plant.getDetails().getMoisture();
                        maximumMoisture=plant.getDetails().getMoisture();
                        minimumLight=plant.getDetails().getBrightness();
                        maximumLight=plant.getDetails().getBrightness();
                    }
                    else{
                        if(minimumTemp>plant.getDetails().getTemperature()){
                            minimumTemp=plant.getDetails().getTemperature();
                        }
                        if(maximumTemp<plant.getDetails().getTemperature()){
                            maximumTemp=plant.getDetails().getTemperature();
                        }
                        if(minimumHumidity>plant.getDetails().getHumidity()){
                            minimumHumidity=plant.getDetails().getHumidity();
                        }
                        if(maximumHumidity<plant.getDetails().getHumidity()){
                            maximumHumidity=plant.getDetails().getHumidity();
                        }
                        if(minimumMoisture>plant.getDetails().getMoisture()){
                            minimumMoisture=plant.getDetails().getMoisture();
                        }
                        if(maximumMoisture<plant.getDetails().getMoisture()){
                            maximumMoisture=plant.getDetails().getMoisture();
                        }
                        if(minimumLight>plant.getDetails().getBrightness()){
                            minimumLight=plant.getDetails().getBrightness();
                        }
                        if(maximumLight<plant.getDetails().getBrightness()){
                            maximumLight=plant.getDetails().getBrightness();
                        }
                    }
                    counter++;
                }
            }
            temperatureAvg=temperatureAvg/counter;
            humidityAvg=humidityAvg/counter;
            moistureAvg=moistureAvg/counter;
            lightAvg=lightAvg/counter;

            // in the database INSERT the average gets rounded down
            String postData=String.format(Locale.US ,"INSERT INTO detailsarchive " +
                    "(plantID, temperatureAvg, humidityAvg, moistureAvg, lightAvg, " +
                    "minimumTemperature, maximumTemperature, minimumHumidity, maximumHumidity, " +
                    "minimumMoisture, maximumMoisture, minimumLight, maximumLight, totalRowsArchived) " +
                    "VALUES(%d, %f, %f, %f, %f, " +
                    "%f, %f, %f, %f, %f, %f, %f, %f, %d)",
                    plantID, temperatureAvg, humidityAvg, moistureAvg, lightAvg,
                    minimumTemp, maximumTemp, minimumHumidity, maximumHumidity, minimumMoisture,
                    maximumMoisture, minimumLight, maximumLight, counter);
            jdbcTemplate.execute(postData);
        }
        String clearTable="DROP TABLE IF EXISTS details; " +
                "CREATE TABLE details( " +
                "    ID INT NOT NULL " +
                "        GENERATED ALWAYS AS IDENTITY " +
                "        PRIMARY KEY, " +
                "    plantID INT NOT NULL " +
                "        CONSTRAINT fk_plantID REFERENCES plant (plantID) " +
                "            ON DELETE CASCADE, " +
                "    temperature NUMERIC(10) NOT NULL, " +
                "    humidity NUMERIC(10) NOT NULL, " +
                "    moisture NUMERIC(10) NOT NULL, " +
                "    light NUMERIC(10) NOT NULL, " +
                "    refreshTime TIMESTAMP NOT NULL " +
                "        DEFAULT CURRENT_TIMESTAMP " +
                "); ";
        jdbcTemplate.execute(clearTable);

        logger.debug("archive successful");
    }
}
