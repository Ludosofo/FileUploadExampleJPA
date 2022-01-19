package com.capgemini.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.entities.Persona;
import com.capgemini.service.IPersonaService;

@Controller
@RequestMapping("/")
public class MainController {
	
	private static final Log LOG = LogFactory.getLog(MainController.class);
	
	@Autowired
	private IPersonaService personaService; // Con autowired se conecta con la capa de servicio
	
	
	// Esto iba a hacerse con model y addAttribute pero lo hago con ModelAndView
	@GetMapping("/index")
	public ModelAndView getIndex(){
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("listaPersonas", personaService.personas());
		mav.addObject("absPath", Paths.get("src//main//resources//static/images").toFile().getAbsolutePath());
		return mav;
	}
	
	@GetMapping("/addPerson")
	public String crearPersona(Model model){
		model.addAttribute("persona", new Persona());
		return "createPersona";
	}
	
	@PostMapping("/savePerson")
	public String savePerson(	@ModelAttribute(name="persona") Persona persona,
								@RequestParam(name="file") MultipartFile file){
		// Si la imagen no esta vacia vamos a guardar el archivo en src/main/resources/static/images
		if(!file.isEmpty()) {
			// Obtenemos la ruta relativa
			// //home//curso//Persona//Recursos
			
			// Path imagesFolder = Paths.get("src//main//resources//static/images");
			
			
			// Convertimos la ruta relativa a absoluta
			// String rutaAbsoluta = imagesFolder.toFile().getAbsolutePath();
			
			
			String rutaAbsoluta = "//home//curso//Persona//Recursos";
			LOG.info("Esto es rutaAbsoluta: "+rutaAbsoluta);
			
			try {
				byte[] bytesImages = file.getBytes();
				// Ruta completa, que incluye el nombre original de la imagen
				// ERROR HABITUAL NO PONER LOS PATH CON "//"
				Path rutaCompleta = Paths.get(rutaAbsoluta +"//"+ file.getOriginalFilename());
				
				Files.write(rutaCompleta, bytesImages);
				
				persona.setFoto(file.getOriginalFilename());

				personaService.savePersona(persona);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		personaService.savePersona(persona);
		return "redirect:/index";
	}
	
	@GetMapping("/getImgByUser/{id}")
	public String getImgByUser(@PathVariable(name="id") String id, Model model) {
		Persona persona = null;
		persona = personaService.getPersona(id);
		model.addAttribute("persona", persona);
		return "detalle";
	}
}
