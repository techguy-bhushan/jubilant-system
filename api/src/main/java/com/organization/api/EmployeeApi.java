package com.organization.api;

import com.organization.CompanyRepository;
import com.organization.EmployeeRepository;
import com.organization.model.Company;
import com.organization.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeApi {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public ResponseEntity create(@RequestBody EmpVO empVO) {
        Company company = companyRepository.findOne(empVO.getCompanyId());
        if (company == null) {
            return ResponseEntity.badRequest().build();
        }
        Employee employee = empVO.getEmployee();
        employee.setCompany(company);
        company.addEmployee(empVO.getEmployee());
        employeeRepository.save(employee);
        companyRepository.save(company);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}
