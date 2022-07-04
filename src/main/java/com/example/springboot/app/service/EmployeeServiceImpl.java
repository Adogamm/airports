package com.example.springboot.app.service;
import com.example.springboot.app.exception.ResourceNotFoundException;
import com.example.springboot.app.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.example.springboot.app.repository.EmployeeRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Optional<Employee> employeeDb = this.employeeRepository.findById(employee.getId());

        if (employeeDb.isPresent()){
            Employee employeeUpdate = employeeDb.get();
            employeeUpdate.setId(employee.getId());
            employeeUpdate.setSurname(employee.getSurname());
            employeeUpdate.setFirstname(employee.getFirstname());
            employeeRepository.save(employeeUpdate);
            return employeeUpdate;
        }else {
            throw new ResourceNotFoundException("Record not found with id : " + employee.getId());
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long employeeId) {
        Optional<Employee> employeeDB = this.employeeRepository.findById(employeeId);

        if (employeeDB.isPresent()) {
            return employeeDB.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + employeeId);
        }
    }

    @Override
    public void deleteEmployee(long employeeId) {
        Optional<Employee> employeeDB = this.employeeRepository.findById(employeeId);

        if (employeeDB.isPresent()) {
            this.employeeRepository.delete(employeeDB.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + employeeId);
        }
    }
}
