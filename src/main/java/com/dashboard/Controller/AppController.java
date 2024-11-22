package com.dashboard.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dashboard.Entities.ContenidoEntidad;
import com.dashboard.Services.ContenidoServicio;

import jakarta.validation.Valid;

@Controller
public class AppController {
	
	private final ContenidoServicio contenidoServicio;
	
	
	public AppController(ContenidoServicio contenidoServicio) {
		this.contenidoServicio = contenidoServicio;
	}
	
//	@GetMapping("/")
//	public String App(Model modelo) {
//		System.out.println("Inicio COMPLETADO!"); 
//		modelo.addAttribute("title", "Login");
//		modelo.addAttribute("Usuario", "");
//		return "login_app";
//	}
//	
   
//    @PostMapping("/login")
//    public ModelAndView log(Model model) {
//		
//    	System.out.println("Login COMPLETADO!"); 
//        return new ModelAndView("redirect:/inicio");
//    }
//    
    @GetMapping("/inicio")
    public String inicio(Model model) {
    	System.out.println("Inicio COMPLETADO!");
    	model.addAttribute("title", "Inicio");
    	//model.addAttribute("Usuario", "Rafael Caballero");

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
    	return "contenidos";
    }
    
    @GetMapping("/destacados")
	public String Destacados(Model model) {
    	List<ContenidoEntidad> content = contenidoServicio.allContenido();
    	model.addAttribute("titulo", "Contenido Destacado");
    	model.addAttribute("contenidos", content);
    	return "destacados";
	}
    
    @GetMapping("/noticias")
    public String obtenerNoticias(Model model) {
    	List<ContenidoEntidad> content = contenidoServicio.allContenido();
    	model.addAttribute("titulo", "Noticias");
    	model.addAttribute("contenidos", content);
    	return "noticias";
    }
    
    @GetMapping("/eventos")
    public String eventos(Model model) {
    	List<ContenidoEntidad> eventos = contenidoServicio.allContenido();
    	model.addAttribute("contenidos", eventos);
    	return "eventos";
    }
    
    @GetMapping("/junta")
    public String junta(Model model) {
    	List<ContenidoEntidad> content = contenidoServicio.allContenido();
    	model.addAttribute("titulo", "Junta Directiva");
    	model.addAttribute("contenidos", content);
    	return "junta";
    }
    
    @GetMapping("/beneficios")
	public String Beneficios(Model model) {
    	List<ContenidoEntidad> content = contenidoServicio.allContenido();
    	model.addAttribute("titulo", "Beneficios");
    	model.addAttribute("contenidos", content);
		return "beneficios";
	}
    
    @GetMapping("/sobre")
    public String sobreNosotros(Model model) {
    	List<ContenidoEntidad> sobreNosotros = contenidoServicio.allContenido();
    	model.addAttribute("contenidos", sobreNosotros);
    	return "sobre";
    }
    
}
