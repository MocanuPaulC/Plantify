package be.kdg.integration.plantifybackend;

import be.kdg.integration.plantifybackend.presentation.View;
import be.kdg.integration.plantifybackend.service.PlantService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PlantifybackendApplication{

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(PlantifybackendApplication.class,args);
		context.getBean(PlantService.class).getPlantFromDB();
		context.getBean(PlantService.class).refreshPlantData();




	}
}
