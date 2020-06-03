package ua.dao;

import ua.model.Employee;

public interface EmployeeDao {
	
	public Employee addEmployee(Employee emp);

	public Employee getEmployeeById(int id);
	
	public Employee updateEmployeeById(Employee newEmp, int id);
	
	public void deleteEmployeeById(int id);
}
