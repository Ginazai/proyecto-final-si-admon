package com.dashboard.Controller;

import java.util.List;

import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dashboard.Entities.ContenidoEntidad;
import com.dashboard.Services.ContenidoServicio;
import com.dashboard.Services.UserService;

import jakarta.validation.Valid;

@Controller
public class AppController {
	
	private final ContenidoServicio contenidoServicio;
	//private final UserService userService;	
	
	public AppController(ContenidoServicio contenidoServicio, UserService userService) {
		this.contenidoServicio = contenidoServicio;
		//this.userService = userService;
	}
	    
    @GetMapping("/inicio")
    public String inicio(Model model, Authentication authentication) {
    	model.addAttribute("title", "Inicio");
    	model.addAttribute("Usuario", authentication.getName());
        return "html/inicio";
    }
    
    /***************************************************
    **********************ACCIONES**********************
     ***************************************************/
    
    @PostMapping("/crear")
    public String crear(@ModelAttribute @Valid ContenidoEntidad contenido) {
    	if (contenido.getCategoria() != null) {
    		contenidoServicio.saveContenido(contenido);
    		return "redirect:/contenidos";
    	} else {return "redirect:/contenidos";}
    }
    
    @PostMapping("/editar/{id}")
    public String actualizar(@PathVariable Long id, @ModelAttribute ContenidoEntidad contenido) {
    	contenidoServicio.editarContenido(id, contenido);
    	return "redirect:/contenidos";
    }
    
    @GetMapping("/borrar/{id}")
    public String borrar(@PathVariable Long id) {
    	contenidoServicio.deleteContenido(id);
    	return "redirect:/contenidos";
    }
    
    /***************************************************
    **********************SECCIONES**********************
     ***************************************************/
    
    @GetMapping("/contenidos")
    public String contenidos(Model model) {
    	List<ContenidoEntidad> contenidos = contenidoServicio.allContenido();
    	model.addAttribute("titulo", "Secciones de la IEEE");
    	model.addAttribute("contenidos", contenidos);
    	return "html/contenidos";
    }
    
    @GetMapping("/destacados")
	public String Destacados(Model model) {
    	List<ContenidoEntidad> content = contenidoServicio.allContenido();
    	model.addAttribute("titulo", "Contenido Destacado");
    	model.addAttribute("contenidos", content);
    	return "html/destacados";
	}
    
    @GetMapping("/noticias")
    public String obtenerNoticias(Model model) {
    	List<ContenidoEntidad> content = contenidoServicio.allContenido();
    	model.addAttribute("titulo", "Noticias");
    	model.addAttribute("contenidos", content);
    	return "html/noticias";
    }
    
    @GetMapping("/eventos")
    public String eventos(Model model) {
    	List<ContenidoEntidad> eventos = contenidoServicio.allContenido();
    	model.addAttribute("contenidos", eventos);
    	return "html/eventos";
    }
    
    @GetMapping("/junta")
    public String junta(Model model) {
    	List<ContenidoEntidad> content = contenidoServicio.allContenido();
    	model.addAttribute("titulo", "Junta Directiva");
    	model.addAttribute("contenidos", content);
    	return "html/junta";
    }
    
    @GetMapping("/beneficios")
	public String Beneficios(Model model) {
    	List<ContenidoEntidad> content = contenidoServicio.allContenido();
    	model.addAttribute("titulo", "Beneficios");
    	model.addAttribute("contenidos", content);
		return "html/beneficios";
	}
    
    @GetMapping("/sobre")
    public String sobreNosotros(Model model) {
    	List<ContenidoEntidad> sobreNosotros = contenidoServicio.allContenido();
    	model.addAttribute("contenidos", sobreNosotros);
    	return "html/sobre";
    }
    
}
