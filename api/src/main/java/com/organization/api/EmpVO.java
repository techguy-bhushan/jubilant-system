package com.organization.api;

import com.organization.model.Employee;

import java.io.Serializable;

public class EmpVO implements Serializable{
    private Long id;
    private String name;
    private String email;
    private String orgId;
    private Long companyId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public Employee getEmployee() {
        Employee employee = new Employee();
        employee.setId(this.id);
        employee.setEmail(email);
        employee.setOrgId(orgId);
        employee.setName(name);
        return employee;
    }
}
