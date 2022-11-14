package be.kdg.integration.plantifybackend;

import be.kdg.integration.plantifybackend.domain.Plant;
import be.kdg.integration.plantifybackend.presentation.View;
import be.kdg.integration.plantifybackend.service.PlantService;
import com.google.gson.Gson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PlantifybackendApplication{

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(PlantifybackendApplication.class,args);
 ;
		context.getBean(PlantService.class).getPlantFromDB();
//
//		Gson gson = new Gson();
//		String json="{\"humidity\":44,\"temperature\":23.3,\"brightness\":19.1395,\"moisture\":2}";
//		Plant.Details details = gson.fromJson(json,Plant.Details.class);
//		System.out.println(details);




	}
}
