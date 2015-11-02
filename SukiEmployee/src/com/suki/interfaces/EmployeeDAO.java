/**
 * 
 */
package com.suki.interfaces;

import java.util.List;

import com.suki.model.Employee;

/**
 * @author suki
 *
 */
public interface EmployeeDAO {
	public void newEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public List<Employee> employees();
	public Employee getEmployee(int id);
	public void deleteEmployee(int id);
}