package be.kdg.integration.plantifybackend;

import be.kdg.integration.plantifybackend.domain.Arduino;
import be.kdg.integration.plantifybackend.domain.Plant;
import be.kdg.integration.plantifybackend.domain.hibernate.ArduinoDao;
import be.kdg.integration.plantifybackend.presentation.ClientController;
import be.kdg.integration.plantifybackend.presentation.PlantController;
import be.kdg.integration.plantifybackend.repository.ArduinoDaoRepository;
import be.kdg.integration.plantifybackend.service.ArduinoService;
import be.kdg.integration.plantifybackend.service.PlantService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class PlantifybackendApplication{

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(PlantifybackendApplication.class,args);

		// prints current plants in DB
		//context.getBean(PlantService.class).getPlantFromDB();
		//context.getBean(ArduinoService.class).setArduinoList(context.getBean(PlantService.class).readPlants());

		ArduinoDaoRepository arduinoRepository = context.getBean(ArduinoDaoRepository.class);
		arduinoRepository.save(new ArduinoDao(101, "hehexd", true,
				(short)3, (short)4, (short)5));



		// archiving functionality
		ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
		ses.scheduleAtFixedRate(context.getBean(PlantService.class)::updateDBArchive,
				0, 10, TimeUnit.SECONDS);


//
//		Gson gson = new Gson();
//		String json="{\"humidity\":44,\"temperature\":23.3,\"brightness\":19.1395,\"moisture\":2}";
//		Plant.Details details = gson.fromJson(json,Plant.Details.class);
//		System.out.println(details);




	}
}
