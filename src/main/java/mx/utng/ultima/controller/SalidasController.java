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
import mx.utng.ultima.model.entity.Salidas;
import mx.utng.ultima.model.service.ISalidasService;



@Controller
@SessionAttributes("salidas")
public class SalidasController {
    //Inyectamos una dependencia del servicio
    @Autowired
    private ISalidasService salidasService;

    //Manda llamar este metodo en una peticion GET que contenga como final de la query string "", "/", "/list"
    @GetMapping({"/salidas/list","/salidas","/salidas/"})
    public String list(Model model){
        model.addAttribute("title", "Listado de registro de gastos en salidas");
    model.addAttribute("salidass", salidasService.list());
    return "slist";
    }

    //Peticion que contenga al final de la url /form
    @GetMapping("/salidas/form")
    public String create (Model model){
        model.addAttribute("title", "Formulario de registro de gastos en salidas");
        model.addAttribute("salidas", new Salidas());
        return "sform";
    }

    @GetMapping("/salidas/form/{id}")
    public String update(@PathVariable Long id,Model model){
        Salidas salidas = null;
        if (id>0) {
            salidas = salidasService.getById(id);
        }else{
            return "redirect:slist";
        }

        model.addAttribute("title", "Editar gastos de salidas");
        model.addAttribute("salidas", salidas);
        return "sform";
    }

    @PostMapping ("/salidas/form")
    public String save(@Valid Salidas salidas, BindingResult br, Model model){

        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de gastos en salidas");
            return "sform";
        }

        salidasService.save(salidas);
        return "redirect:/salidas/list";
    }

    @GetMapping("/salidas/delete/{id}")
    public String delete (@PathVariable Long id, Model model){
        if (id>0) {
            salidasService.delete(id);
        }
        return "redirect:/salidas/list";
    }

}



