package com.smm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.smm.model.Employee;
import com.smm.model.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String getEmployees(Model model){
		List employeeList = employeeService.getEmployees();
		model.addAttribute("employeeList", employeeList);
		return "welcome";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addEmployee(Model model) {
        model.addAttribute("empAttr", new Employee());
        return "form";
    }
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("empAttr") Employee employee) {
		if(employee.getId() != null && !employee.getId().trim().equals("")) {
            employeeService.editEmployee(employee);
        } else {
            employeeService.addEmployee(employee);
        }
        return "redirect:list";
    }
	
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editUser(@RequestParam(value="id", required=true) String id, Model model) {
        
        model.addAttribute("empAttr", employeeService.findEmployeeId(id));     
        return "form";
    }
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value="id", required=true) String id, Model model) {
        employeeService.deleteEmployee(id);
        return "redirect:list";
    }
}
