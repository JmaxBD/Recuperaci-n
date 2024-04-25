package mx.utng.ultima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import jakarta.validation.Valid;
import mx.utng.ultima.model.entity.Actividad;
import mx.utng.ultima.model.service.IActividadService;



@Controller
@SessionAttributes("actividad")
public class ActividadController {
    //Inyectamos una dependencia del servicio
    @Autowired
    private IActividadService actividadService;

    //Manda llamar este metodo en una peticion GET que contenga como final de la query string "", "/", "/list"
    @GetMapping({"/actividad/list","/actividad","/actividad/"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Registro de actividades curriculares");
    model.addAttribute("actividades", actividadService.list());
    return "alist";
    }

    //Peticion que contenga al final de la url /form
    @GetMapping("/actividad/form")
    public String create (Model model){
        model.addAttribute("title", "Formulario de registro de actividades");
        model.addAttribute("actividad", new Actividad());
        return "aform";
    }

    @GetMapping("/actividad/form/{id}")
    public String update(@PathVariable Long id,Model model){
        Actividad actividad = null;
        if (id>0) {
            actividad = actividadService.getById(id);
        }else{
            return "redirect:alist";
        }

        model.addAttribute("title", "Editar regitro de actividades");
        model.addAttribute("actividad", actividad);
        return "aform";
    }

    @PostMapping ("/actividad/form")
    public String save(@Valid Actividad actividad, BindingResult br, Model model){

        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de registro de actividades");
            return "aform";
        }

        actividadService.save(actividad);
        return "redirect:/actividad/list";
    }

    @GetMapping("/actividad/delete/{id}")
    public String delete (@PathVariable Long id, Model model){
        if (id>0) {
            actividadService.delete(id);
        }
        return "redirect:/actividad/list";
    }

}



