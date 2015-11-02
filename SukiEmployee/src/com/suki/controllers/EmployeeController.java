/**
 * 
 */
package com.suki.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.suki.model.Employee;
import com.suki.services.EmployeeService;

/**
 * @author suki
 *
 */
@Controller
public class EmployeeController {

	private EmployeeService employeeService;

	/**
	 * @param employeeService the employeeService to set
	 */
	@Autowired(required=true)
	@Qualifier(value="EmployeeService")
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	/**
	 * 
	 * @param employee
	 * @return
	 */
	@RequestMapping(value= "/employee/new", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("employee") Employee employee){
		
		//If employee is exist, execute update
		if(employee.getId() == 0) {
			this.employeeService.newEmployee(employee); 
		} else {
			this.employeeService.updateEmployee(employee);
		}
		
		return "redirect:/employee";
		
	}

	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/employee/edit/{id}")
	public String updateEmployee(@PathVariable("id") int id, ModelMap model){
	    model.addAttribute("employee", this.employeeService.getEmployee(id));
	    model.addAttribute("employeeList", this.employeeService.employees());
	    return "employee";
	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public String getEmployeeList(ModelMap model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("employeeList", this.employeeService.employees());
		return "employee";
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/employee/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id){
		
        this.employeeService.deleteEmployee(id);
        return "redirect:/employee";
    }
	
}
