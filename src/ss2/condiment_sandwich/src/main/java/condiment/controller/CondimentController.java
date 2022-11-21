package condiment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class CondimentController {

    @GetMapping
    public String showForm(){

        return "list";
    }

    @PostMapping
    public String condiment(@RequestParam(required = false) String[] condiment, Model model){
        model.addAttribute("condiment",condiment);
        return "list";
    }
}
