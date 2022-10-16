package be.kdg.integration.plantifybackend;

import be.kdg.integration.plantifybackend.presentation.View;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PlantifybackendApplication{

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(PlantifybackendApplication.class,args);


		System.out.println("woks");
		View view = context.getBean(View.class);
		view.refreshPlantDetails();
		view.showMenu();
		

	}
}
