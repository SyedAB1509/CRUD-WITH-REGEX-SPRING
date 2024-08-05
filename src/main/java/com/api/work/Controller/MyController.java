package com.api.work.Controller;

import com.api.work.Service.EService;
import com.api.work.Service.employeeservice;
import com.api.work.entities.employee;
import com.api.work.entities.employeeDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class MyController {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return ResponseEntity.badRequest().body(errors);
    }


    @Autowired
    private EService service;

    @GetMapping("home")
    public String home() {
        return "Hello Everyone";
    }

    @GetMapping("change")
    public String change() {
        return "New Change";
    }

    @GetMapping("employees")
    public List<employee> getwork() {
        return this.service.getemployee();
    }

    @GetMapping("employees/{empid}")
    public Optional<employee> getEmp(@PathVariable String empid) {
        return this.service.getEmp(Long.parseLong(empid));
    }

    @PostMapping("employees")
    public employeeDto newEmp(@Valid @RequestBody employeeDto Emp) {
        return service.addEmp(Emp);

       // return this.service.addEmp(employee);
    }

    @PutMapping("employees/{Emp}")
    public employee updateEmp(@Valid @RequestBody employee Emp) {
        return this.service.updateEmp(Emp);
    }

    @DeleteMapping("employees/{empid}")
    public ResponseEntity<HttpStatus> deleteemp(@PathVariable String empid) {
        try {
            this.service.deleteemp(Long.parseLong(empid));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
