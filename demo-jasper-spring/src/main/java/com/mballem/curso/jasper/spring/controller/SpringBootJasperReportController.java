package com.mballem.curso.jasper.spring.controller;



import com.mballem.curso.jasper.spring.model.Employee;
import com.mballem.curso.jasper.spring.repository.CategoriaRepository;
import com.mballem.curso.jasper.spring.repository.ClienteRepository;
import com.mballem.curso.jasper.spring.repository.EmployeeRepository;
import com.mballem.curso.jasper.spring.service.impl.ReportServiceImpl;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("report")
public class SpringBootJasperReportController {

    @Autowired
    private ClienteRepository cliente;
    @Autowired
    private CategoriaRepository categoria;
    @Autowired
    private EmployeeRepository employeer;
    @Autowired
    private ReportServiceImpl service;

    @GetMapping("/getEmployees")
    public List<Employee> getEmployees(){
        return employeer.findAll();
    }

    @GetMapping("/report/{format}")
    public String generatedReport(@PathVariable String format) throws JRException, FileNotFoundException {
        return service.exportReport(format);

    }


}
