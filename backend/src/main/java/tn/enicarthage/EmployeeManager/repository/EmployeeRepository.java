package tn.enicarthage.EmployeeManager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.enicarthage.EmployeeManager.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

	void deleteEmployeeById(Long id);
	
	Optional<Employee> findEmployeeById(Long id);
	
	
}
