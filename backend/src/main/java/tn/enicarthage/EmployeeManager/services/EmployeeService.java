package tn.enicarthage.EmployeeManager.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.enicarthage.EmployeeManager.exception.UserNotFoundExeption;
import tn.enicarthage.EmployeeManager.model.Employee;
import tn.enicarthage.EmployeeManager.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private final  EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public Employee addEmployee(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepository.save(employee);
	}
	
	public List<Employee> findAllEmployee(){
		return employeeRepository.findAll();
	}
	
	public Employee updateEmployee(Employee employee){
		return employeeRepository.save(employee);
	}

	public Employee findEmployeeById(Long id) {
		return employeeRepository.findEmployeeById(id)
				.orElseThrow(()-> new UserNotFoundExeption("User by id" + id +" was not found"));
	}
	@Transactional
	public void deleteEmployee(Long id){
		employeeRepository.deleteEmployeeById(id);
    }
	
}
