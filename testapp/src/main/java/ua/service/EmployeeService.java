package ua.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ua.dao.EmployeeDao;
import ua.model.Employee;
import ua.repository.EmployeeRepository;

@Service

public class EmployeeService implements EmployeeDao {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee updateEmployeeById(Employee newEmp, int id) {
		Employee empToEdit = employeeRepository.getEmployeeById(id);
		empToEdit.setName(newEmp.getName());
		empToEdit.setPosition(newEmp.getPosition());
		empToEdit.setSalary(newEmp.getSalary());
		return employeeRepository.save(empToEdit);
	}

	@Override
	public Employee addEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}

	@Override
	public Employee getEmployeeById(int id) {
		return employeeRepository.getEmployeeById(id);
	}

	@Override
	public void deleteEmployeeById(int id) {
		Employee employeeToDelete = employeeRepository.getEmployeeById(id);
		employeeRepository.delete(employeeToDelete);

	}

}
