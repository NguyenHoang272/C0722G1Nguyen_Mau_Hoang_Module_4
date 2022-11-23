package product_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import product_manager.model.Product;
import product_manager.repository.IProductRepository;

@Controller
public class ProductController {
    @Autowired
    private IProductRepository productService;

    @GetMapping("")
    public String showForm(Model model) {
        model.addAttribute("productList", productService.finAll());
        return "product/list";
    }

    @GetMapping("/remove")
    public String removeProduct(int id, RedirectAttributes redirectAttributes) {
        productService.remove(id);
        redirectAttributes.addFlashAttribute("mess","Successful delete!");
        return "redirect:/";
    }

    @GetMapping("/add")
    public String showAdd(Model model){
       model.addAttribute("product",new Product());
       return "/product/add";
    }
    @PostMapping("/add")
       public String add(Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("mess", "Successful add!");
        return "redirect:/";
    }

}
