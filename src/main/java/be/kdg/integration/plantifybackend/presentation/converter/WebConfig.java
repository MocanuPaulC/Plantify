package be.kdg.integration.plantifybackend.presentation.converter;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebConfig for adding converters to the FormatterRegistry
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry){
        registry.addConverter(new StringToPlantTypeConverter());
    }
}
