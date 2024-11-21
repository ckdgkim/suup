package com.example.spring_data_jpa.employee.service;

import com.example.spring_data_jpa.employee.domain.Employee;
import com.example.spring_data_jpa.employee.repository.EmpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Transactional
public class EmpService {
    private final EmpRepository empRepository;

    @Transactional(readOnly = true)
    public Optional<Employee> getOneEmp(String empId) {
        return empRepository.findById(empId);
    }

    @Transactional(readOnly = true)
    public List<Employee> getAllEmp() {
        return empRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Employee> getAllEmpWithEmpName(String empName) {
        return empRepository.findByEmpNameLike(empName);
    }

    public Employee saveEmp(Employee emp) {
        return empRepository.save(emp);
    }

    public Employee updateEmp(Employee emp) {
        return empRepository.findById(emp.getEmpId())
                .map(existingEmp -> {
                    existingEmp.setEmpName(emp.getEmpName());   // 필드 업데이트
                    existingEmp.setDeptId(emp.getDeptId());
                    existingEmp.setSalary(emp.getSalary());
                    return empRepository.save(existingEmp);
                }).orElseThrow(() -> new RuntimeException("Employee not found with id " + emp.getEmpId()));
    }

    public Employee patchEmp(Employee emp) {
        return empRepository.findById(emp.getEmpId())
                .map(existingEmp -> {
                    // 특정 필드만 수정
                    if (emp.getEmpName() != null) {
                        existingEmp.setEmpName(emp.getEmpName());
                    }
                    if (emp.getDeptId() != 0) {
                        existingEmp.setDeptId(emp.getDeptId());
                    }
                    if (emp.getSalary() != 0) {
                        existingEmp.setSalary(emp.getSalary());
                    }
                    return empRepository.save(existingEmp);
                }).orElseThrow(() -> new RuntimeException("Employee not found with id " + emp.getEmpId()));
    }

    public void deleteEmp(String empId) {
        empRepository.findById(empId)
                .ifPresentOrElse(
                        empRepository::delete,
                        () -> { throw new RuntimeException("Employee not found with id " + empId); }
                );
    }
}
