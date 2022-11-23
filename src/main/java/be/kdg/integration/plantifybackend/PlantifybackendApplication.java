package be.kdg.integration.plantifybackend;

import be.kdg.integration.plantifybackend.repository.PlantRepositoryImplementation;
import be.kdg.integration.plantifybackend.service.ArduinoService;
import be.kdg.integration.plantifybackend.service.PlantService;
import be.kdg.integration.plantifybackend.service.PlantServiceImplementation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class PlantifybackendApplication{

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(PlantifybackendApplication.class,args);

		// prints current plants in DB
		context.getBean(PlantService.class).getPlantFromDB();
		context.getBean(ArduinoService.class).getArduinoList(context.getBean(PlantService.class).readPlants());

		// archiving functionality
		ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
		ses.scheduleAtFixedRate(context.getBean(PlantService.class)::updateDBArchive,
				30, 30, TimeUnit.MINUTES);


//
//		Gson gson = new Gson();
//		String json="{\"humidity\":44,\"temperature\":23.3,\"brightness\":19.1395,\"moisture\":2}";
//		Plant.Details details = gson.fromJson(json,Plant.Details.class);
//		System.out.println(details);




	}
}
