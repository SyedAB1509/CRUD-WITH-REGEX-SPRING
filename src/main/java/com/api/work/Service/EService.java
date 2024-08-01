package com.api.work.Service;

import com.api.work.entities.employee;
import com.api.work.entities.employeeDto;

import java.util.List;
import java.util.Optional;

public interface EService {
    public List<employee> getemployee();

    public Optional<employee> getEmp(Long empid);
    public employeeDto addEmp(employeeDto emp);

    public employee updateEmp(employee Emp);

    public void deleteemp(long empid);
}
