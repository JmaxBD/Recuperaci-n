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
import mx.utng.ultima.model.entity.Deseo;
import mx.utng.ultima.model.service.IDeseoService;



@Controller
@SessionAttributes("deseo")
public class DeseoController {
    //Inyectamos una dependencia del servicio
    @Autowired
    private IDeseoService deseoService;

    //Manda llamar este metodo en una peticion GET que contenga como final de la query string "", "/", "/list"
    @GetMapping({"/deseo/list","/deseo","/deseo/"})
    public String list(Model model){
        model.addAttribute("title", "Listado de deseos electrodomesticos");
    model.addAttribute("deseos", deseoService.list());
    return "dlist";
    }

    //Peticion que contenga al final de la url /form
    @GetMapping("/deseo/form")
    public String create (Model model){
        model.addAttribute("title", "Formulario de Deseos electrodomesticos");
        model.addAttribute("deseo", new Deseo());
        return "dform";
    }

    @GetMapping("/deseo/form/{id}")
    public String update(@PathVariable Long id,Model model){
        Deseo deseo = null;
        if (id>0) {
            deseo = deseoService.getById(id);
        }else{
            return "redirect:dlist";
        }

        model.addAttribute("title", "Editar deseos electrodomesticos");
        model.addAttribute("deseo", deseo);
        return "dform";
    }

    @PostMapping ("/deseo/form")
    public String save(@Valid Deseo deseo, BindingResult br, Model model){

        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de deseos electrodomesticos");
            return "dform";
        }

        deseoService.save(deseo);
        return "redirect:/deseo/list";
    }

    @GetMapping("/deseo/delete/{id}")
    public String delete (@PathVariable Long id, Model model){
        if (id>0) {
            deseoService.delete(id);
        }
        return "redirect:/deseo/list";
    }
}



