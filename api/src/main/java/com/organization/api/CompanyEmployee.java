package com.organization.api;

import com.organization.CompanyRepository;
import com.organization.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyEmployee {
    @Autowired
    private CompanyRepository companyRepository;

    @PostMapping
    public ResponseEntity create(Company company) {
        companyRepository.save(company);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Company> getAll() {
        return companyRepository.findAll();
    }
}
