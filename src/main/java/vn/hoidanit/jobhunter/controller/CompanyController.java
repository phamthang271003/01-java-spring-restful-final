package vn.hoidanit.jobhunter.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vn.hoidanit.jobhunter.domain.Company;
import vn.hoidanit.jobhunter.service.CompanyService;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/companies")
    public ResponseEntity<Company> createNewCompany(@RequestBody Company company) {
        Company newCompany = this.companyService.handleCreateCompany(company);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCompany);
    }
}
