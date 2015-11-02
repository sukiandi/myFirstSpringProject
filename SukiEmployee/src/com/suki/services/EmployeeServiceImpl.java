/**
 * 
 */
package com.suki.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suki.interfaces.EmployeeDAO;
import com.suki.model.Employee;

/**
 * @author suki
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeDAO employeeDAO;
	
	
	/**
	 * @return the employeeDAO
	 */
	public EmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}

	/**
	 * @param employeeDAO the employeeDAO to set
	 */
	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	@Transactional
	public void newEmployee(Employee employee) {
		// TODO Auto-generated method stub
		this.employeeDAO.newEmployee(employee);
	}

	@Override
	@Transactional
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		this.employeeDAO.updateEmployee(employee);
	}

	@Override
	@Transactional
	public List<Employee> employees() {
		// TODO Auto-generated method stub
		return this.employeeDAO.employees();
	}

	@Override
	@Transactional
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return this.employeeDAO.getEmployee(id);
	}

	@Override
	@Transactional
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		this.employeeDAO.deleteEmployee(id);
	}

}