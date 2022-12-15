package be.kdg.integration.plantifybackend;

import be.kdg.integration.plantifybackend.domain.hibernate.ArduinoDao;
import be.kdg.integration.plantifybackend.repository.ArduinoRepository;
import be.kdg.integration.plantifybackend.repository.ArduinoRepositoryHibernate;
import be.kdg.integration.plantifybackend.service.ArduinoService;
import be.kdg.integration.plantifybackend.service.ArduinoServiceImplementation;
import be.kdg.integration.plantifybackend.service.PlantService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.script.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
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
		//context.getBean(ArduinoService.class).addArduino("xx", 103);


		// archiving functionality
		ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
		ses.scheduleAtFixedRate(context.getBean(PlantService.class)::updateDBArchive,
				0, 20, TimeUnit.HOURS);

		/*try (PythonInterpreter pyInterp = new PythonInterpreter()) {
			StringWriter output = new StringWriter();
			pyInterp.setOut(output);
			String pwd= System.getProperty("user.dir");
			pyInterp.execfile(pwd+"\\src\\main\\resources\\script.py");

			System.out.println(output);
		}*/


//
//		Gson gson = new Gson();
//		String json="{\"humidity\":44,\"temperature\":23.3,\"brightness\":19.1395,\"moisture\":2}";
//		Plant.Details details = gson.fromJson(json,Plant.Details.class);
//		System.out.println(details);




	}
}
