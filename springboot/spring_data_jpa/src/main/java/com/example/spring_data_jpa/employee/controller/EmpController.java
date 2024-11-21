package com.example.spring_data_jpa.employee.controller;

import com.example.spring_data_jpa.employee.domain.Employee;
import com.example.spring_data_jpa.employee.service.EmpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emps")
@RequiredArgsConstructor
public class EmpController {
    private final EmpService empService;

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return empService.saveEmp(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return empService.getAllEmp();
    }

    @GetMapping("/{empId}")
    public Employee getEmployee(@PathVariable String empId) {
        return empService.getOneEmp(empId).orElseThrow(() -> new RuntimeException("Employee not found with id " + empId));
    }

    @GetMapping("/name/{empName}")
    public List<Employee> getAllEmpWithEmpName(@PathVariable("empName") String empName) {
        return empService.getAllEmpWithEmpName(empName + "%");
    }

    @PutMapping("/{empId}")
    public Employee updateEmployee(@PathVariable String empId, @RequestBody Employee employee) {
        employee.setEmpId(empId);
        return empService.updateEmp(employee);
    }

    @PatchMapping("/{empId}")
    public Employee patchEmployee(@PathVariable String empId, @RequestBody Employee employee) {
        employee.setEmpId(empId);
        return empService.patchEmp(employee);
    }

    @DeleteMapping("/{empId}")
    public void deleteEmployee(@PathVariable String empId) {
        empService.deleteEmp(empId);
    }
}
