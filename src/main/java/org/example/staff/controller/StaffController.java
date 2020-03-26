package org.example.staff.controller;

import org.example.staff.model.Employee;
import org.example.staff.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StaffController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String listStaff(Model model) {
        Page<Employee> employees = employeeRepository.findAll(PageRequest.of(0, 10).first());
        model.addAttribute("employees", employees.getContent());
        return "index.html";
    }

    @PostMapping("/filter")
    public String listStaff(@RequestParam(value = "nameFilter") String nameFilter, Model model) {
        Page<Employee> employees = employeeRepository.filterByLastName(nameFilter, PageRequest.of(0, 10).first());
        model.addAttribute("employees", employees.getContent());
        return "index.html";
    }
}
