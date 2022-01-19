package com.capgemini;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Cuando la aplicación arranca hace un recorrido a la estructura dentro dle proyecto y busca, declara uno o más metodos anotados con beans
@Configuration
public class ImagenesConfigurer implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addResourceHandlers(registry);
		
		// addResourceHandler informa de que puede usar todo en la carpeta recursos
		// addResourceLocations informa que son archivos locales no en web
		// INTERESANTE: recursos esta en minus y la ruta en mayusculas inicial ¿porque? Porque el resource Hander es como una variable pero la ruta tiene que ser 100% correcta
		registry.addResourceHandler("/recursos/**").addResourceLocations("file:"+"/home/curso/Persona/Recursos/");
		
		// P: ¿Por que no buscamos con ruta absoluta?
		// R: Porque Spring no tiene la configuración para encontrar esa ruta por defecto
	}
	
}
