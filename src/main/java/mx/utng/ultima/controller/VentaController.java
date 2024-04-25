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
import mx.utng.ultima.model.entity.Venta;
import mx.utng.ultima.model.service.IVentaService;



@Controller
@SessionAttributes("venta")
public class VentaController {
    //Inyectamos una dependencia del servicio
    @Autowired
    private IVentaService ventaService;

    //Manda llamar este metodo en una peticion GET que contenga como final de la query string "", "/", "/list"
    @GetMapping({"/venta/list","/venta","/venta/"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Ventas");
    model.addAttribute("ventas", ventaService.list());
    return "vlist";
    }

    //Peticion que contenga al final de la url /form
    @GetMapping("/venta/form")
    public String create (Model model){
        model.addAttribute("title", "Formulario de Ventas");
        model.addAttribute("venta", new Venta());
        return "vform";
    }

    @GetMapping("/venta/form/{id}")
    public String update(@PathVariable Long id,Model model){
        Venta venta = null;
        if (id>0) {
            venta = ventaService.getById(id);
        }else{
            return "redirect:vlist";
        }

        model.addAttribute("title", "Editar Ventas");
        model.addAttribute("venta", venta);
        return "vform";
    }

    @PostMapping ("/venta/form")
    public String save(@Valid Venta venta, BindingResult br, Model model){

        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Ventas");
            return "vform";
        }

        ventaService.save(venta);
        return "redirect:/venta/list";
    }

    @GetMapping("/venta/delete/{id}")
    public String delete (@PathVariable Long id, Model model){
        if (id>0) {
            ventaService.delete(id);
        }
        return "redirect:/venta/list";
    }

}



