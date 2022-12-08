package com.case_study.controller;

import com.case_study.model.CustomerType;
import com.case_study.service.customer.ICustomerService;
import com.case_study.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;
    @GetMapping
public ModelAndView customerList(@RequestParam (value = "nameSearch", defaultValue ="" ) String nameSearch,
                                 @RequestParam(value = "email",defaultValue =""  ) String email,
                                 @RequestParam(value = "customerType",defaultValue ="") String customerType,
                                 @PageableDefault(value = 5) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("customer/list");
        modelAndView.addObject("customers", customerService.search(nameSearch, email, customerType, pageable));
        modelAndView.addObject("email",email);
        modelAndView.addObject("customerType", customerType);
        modelAndView.addObject("nameSearch",nameSearch);
        return modelAndView;
    }

    @ModelAttribute("customerTypes")
    public List<CustomerType> getListCustomerTypes() {
        return customerTypeService.findAllCustomerType();
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam int id, RedirectAttributes redirectAttributes) {
        customerService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Delete customer successfully!");
        return "redirect:/customers";
    }
}
