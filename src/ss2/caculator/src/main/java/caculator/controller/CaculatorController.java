package caculator.controller;

import caculator.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class CaculatorController {
    @Autowired
    ICalculatorService iCalculatorService;
    @GetMapping
    String showForm() {
        return "calculator";
    }

    @RequestMapping("result")
    public String showResult (@RequestParam(required = false)String operation, double number1, double number2,
                             Model model){
        double result =iCalculatorService.calculate(operation,number1,number2);
        model.addAttribute("number1",number1);
        model.addAttribute("number2",number2);
        model.addAttribute("result",result);

        return "calculator";
    }
}
