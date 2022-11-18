package dictionary.controller;

import dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService servicee;

    @GetMapping
    public String showForm(){
        return "list";
    }

    @PostMapping
    public ModelAndView search(Model model, @RequestParam String word){
        model.addAttribute("saveword",word);

        return new ModelAndView("list","vietnamese", servicee.search(word));

    }
}