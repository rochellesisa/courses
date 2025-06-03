package com.course.ro.section5.controller;

import com.course.ro.section5.exception.ValidationException;
import com.course.ro.section5.model.dto.RestResponse;
import com.course.ro.section5.model.entity.Company;
import com.course.ro.section5.service.ICompanyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final ICompanyService companyService;
    private final ObjectMapper objectMapper;

    @Autowired
    public CompanyController(ICompanyService companyService, ObjectMapper objectMapper) {
        this.companyService = companyService;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public ResponseEntity<RestResponse<List<Company>>> getAll(){
        return new ResponseEntity<>(new RestResponse<List<Company>>(HttpStatus.OK, companyService.getAll(), true), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<Company>> getById(@PathVariable("id") Long companyId) {
        Company company = companyService.getById(companyId);
        boolean success = Objects.nonNull(company);
        HttpStatus status = success ? HttpStatus.OK : HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(new RestResponse<>(status, company, success), status);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<RestResponse<List<Company>>> getById(@PathVariable String name) {
        List<Company> feet = companyService.findByName(name);
        boolean success = Objects.nonNull(feet);
        HttpStatus status = success ? HttpStatus.OK : HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(new RestResponse<>(status, feet, success), status);
    }

    @PostMapping
    public ResponseEntity<RestResponse> createCompany(@RequestBody Company company) {
        System.out.println("CREATE: " + company);
        company.setId(null);
        company.setVersion(0);
        return new ResponseEntity<>(new RestResponse<>(HttpStatus.OK,  companyService.create(company), true), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestResponse> updateCompany(@PathVariable Long id, @RequestBody Company company) {
        System.out.println("UPDATE: " + company);
        return new ResponseEntity<>(new RestResponse<>(HttpStatus.OK, companyService.update(company), true), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse> deleteById(@PathVariable("id") Long companyId) {
        System.out.println("Do something");
        companyService.delete(companyId);
        return new ResponseEntity<>(new RestResponse<>(HttpStatus.OK, null, true), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RestResponse> patchCompany(@PathVariable Long id, @RequestBody Map<String, Object> payload) throws ValidationException {
        System.out.println("PATCH");
        if (payload.containsKey("id"))
            throw new ValidationException(("ID not allowed in payload"));

        Company orig = companyService.getById(id);
        Company updated = apply(orig, payload);
        return new ResponseEntity<>(new RestResponse<>(HttpStatus.OK,  companyService.update(updated), true), HttpStatus.OK);
    }

    private Company apply(Company orig, Map<String, Object> payload){
        ObjectNode companyNode = objectMapper.convertValue(orig, ObjectNode.class);
        ObjectNode patchNode = objectMapper.convertValue(payload, ObjectNode.class);

        companyNode.setAll(patchNode);
        return objectMapper.convertValue(companyNode, Company.class);
    }
}
