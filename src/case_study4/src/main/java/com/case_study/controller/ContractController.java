package com.case_study.controller;

import com.case_study.dto.ContractDTO;
import com.case_study.model.*;
import com.case_study.service.customer.IContractService;
import com.case_study.service.customer.ICustomerService;
import com.case_study.service.customer.IEmployeeService;
import com.case_study.service.customer.IFacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.function.Function;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    IContractService contractService;

    @Autowired
    IFacilityService facilityService;

    @Autowired
    IEmployeeService employeeService;

    @Autowired
    ICustomerService customerService;

    @ModelAttribute("attachFacilityList")
    public List<AttachFacility> getListAttachFacility() {
        return contractService.getAttachFacilities();
    }
    @ModelAttribute("contractDetailList")
    public List<ContractDetail> getListContractDetail() {
        return contractService.getListContractDetail();
    }

    @ModelAttribute("facilityList")
    public List<Facility> getListFacility() {
        return facilityService.findAll();
    }

    @ModelAttribute("employeeList")
    public List<Employee> getListEmployee() {
        return employeeService.getListEmployee();
    }

    @ModelAttribute("customerList")
    public List<Customer> getListCustomer() {
        return customerService.findAll();
    }

    @GetMapping("")
    public String showList(Model model, @PageableDefault(value =5 )Pageable pageable){
        Page<Contract> contractPage = contractService.findAll(pageable);

        Page<ContractDTO> contractDTOPage = contractPage.map(new Function<Contract, ContractDTO>() {
            @Override
            public ContractDTO apply(Contract contract) {
                ContractDTO contractDTO = new ContractDTO();
                BeanUtils.copyProperties(contract, contractDTO);
                contractDTO.getTotalCost();
                return contractDTO;
            }

        });

        model.addAttribute("contractList", contractDTOPage);
        return "contract/list";
    }
}
