package be.kdg.integration.plantifybackend.service;

import be.kdg.integration.plantifybackend.domain.Arduino;
import be.kdg.integration.plantifybackend.domain.Plant;
import be.kdg.integration.plantifybackend.domain.RGBColor;
import be.kdg.integration.plantifybackend.domain.hibernate.ArduinoDao;
import be.kdg.integration.plantifybackend.repository.ArduinoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * service class for handling arduino information
 */
@Component
public class ArduinoServiceImplementation implements ArduinoService{

    private ArduinoRepository arduinoDaoRepository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private Arduino daoToArduino(ArduinoDao arduinoDao){
        return new Arduino(arduinoDao.getSeries(), arduinoDao.getLedSetting(),
                arduinoDao.getPhysicalIdentifier(), new RGBColor(arduinoDao.getRedCode(), arduinoDao.getBlueCode(),
                arduinoDao.getGreenCode()), arduinoDao.getPhysicalIdentifier());
    }

    @Autowired
    public ArduinoServiceImplementation(ArduinoRepository arduinoRepositoryHibernate) {
        this.arduinoDaoRepository = arduinoRepositoryHibernate;
    }


    @Override
    public List<Arduino> getArduinoList() {
        List<Arduino> arduinoList = new ArrayList<>();
        Iterable<ArduinoDao> arduinoDaoIterable= arduinoDaoRepository.findAll();
        for (ArduinoDao arduinoDao : arduinoDaoIterable) {
            arduinoList.add(daoToArduino(arduinoDao));
        }

        return arduinoList;
    }

    @Override
    public void setLedSetting(int physicalId, boolean base) {
        if(arduinoDaoRepository.findById(physicalId).isPresent()){
            arduinoDaoRepository.findById(physicalId).get().setLedSetting(base);
        }
        else {
            logger.debug(physicalId+" arduino not present");
        }

    }

    /**
     * adds an arduino to teh database
     * @param series type of the arduino
     * @param physicalIdentifier unique ID of the arduino
     * @return function from repository
     */
    @Override
    public Arduino addArduino(String series, int physicalIdentifier) {
        ArduinoDao arduinoDao = new ArduinoDao(physicalIdentifier, series, false, (short)0,(short)0,(short)0);
        arduinoDaoRepository.save(arduinoDao);
        return daoToArduino(arduinoDao);
    }

    /*@Override
    public void setArduinoList(List<Plant> plantList) {
        this.arduinoRepository.setArduinoList(plantList);
    }*/


    @Override
    public void changeColor(int physicalIdentifier, short red, short green, short blue) {
        if(arduinoDaoRepository.findById(physicalIdentifier).isPresent()){
            arduinoDaoRepository.findById(physicalIdentifier).get().setBlueCode(blue);
            arduinoDaoRepository.findById(physicalIdentifier).get().setRedCode(red);
            arduinoDaoRepository.findById(physicalIdentifier).get().setGreenCode(green);
        }
        else {
            logger.debug(physicalIdentifier+" arduino not present");
        }
    }

    /**
     * interacts with the arduino to retrieve information being red
     * @param physicalIdentifier unique ID of the arduino to listen to a specific arduino
     * @return all information retrieved from the arduino in a formatted string
     */
    @Override
    public String postMapping(int physicalIdentifier) {
        logger.debug(physicalIdentifier + " is the physical identifier");
        Arduino arduino = getArduinoList().stream().filter(ar -> ar.getPhysicalIdentifier() == physicalIdentifier).toList().get(0);
        return String.format("P%dL%dC%03d,%03d,%03d",arduino.getPumpInstruction(),arduino.getLedSetting() ? 1 : 0
                ,arduino.getLedColor().getRed(),arduino.getLedColor().getGreen(),arduino.getLedColor().getBlue());
    }

    @Override
    public void removeArduino(int physicalIdentifier){
        if(arduinoDaoRepository.findById(physicalIdentifier).isPresent()){
            arduinoDaoRepository.delete(arduinoDaoRepository.findById(physicalIdentifier).get());
        }
        else {
            logger.debug(physicalIdentifier+" arduino not present");
        }
    }
}
