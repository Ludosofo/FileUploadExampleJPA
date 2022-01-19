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
		registry.addResourceHandler("/recursos/**"); // Añadimos acceso a la carpeta recursos
		
		// P: ¿Por que no buscamos con ruta absoluta?
		// R: Porque Spring no tiene la configuración para encontrar esa ruta por defecto
	}
	
}
