/**
 * 
 */
package com.suki.interfaces;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.suki.model.Employee;

/**
 * @author suki
 *
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void newEmployee(Employee employee) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(employee);
		System.out.println("Employee added Successfully!");
	}

	@Override
	public void updateEmployee(Employee employee) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(employee);
		System.out.println("Employee updated successfully!");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> employees() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Employee> employeeList = session.createQuery("FROM Employee").list();
	
		return employeeList;
	}

	@Override
	public Employee getEmployee(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Employee employee = (Employee) session.load(Employee.class, new Integer(id));
		System.out.println("Get Employee Detail: " + id);
		
		return employee;
	}

	@Override
	public void deleteEmployee(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Employee employee = (Employee) session.load(Employee.class, new Integer(id));
		if(employee != null){
			session.delete(employee);
		}
		System.out.println("Employee deleted successfully: " + id);
	}
}
