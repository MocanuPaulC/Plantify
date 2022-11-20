package be.kdg.integration.plantifybackend;

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
 ;
		context.getBean(PlantService.class).getPlantFromDB();



		/*
		|||| THIS WORKS BUT NEEDS SpringJdbcConfig.class TO FUNCTION,
		AUTOWIRING DOES NOT WORK ON A CLASS THAT IS NOT PART OF THE MVP MODEL
		CHANGE THE VALUES IN SpringJdbcConfig.class TO MAKE IT WORK LOCALLY||||
		PostgresUpdate postgresUpdate = new PostgresUpdate();
		ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
		ses.scheduleAtFixedRate(postgresUpdate::update, 0, 6, TimeUnit.HOURS);*/


//
//		Gson gson = new Gson();
//		String json="{\"humidity\":44,\"temperature\":23.3,\"brightness\":19.1395,\"moisture\":2}";
//		Plant.Details details = gson.fromJson(json,Plant.Details.class);
//		System.out.println(details);




	}
}
