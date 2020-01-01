package com.demon.dbserver.controller;

import com.demon.dbserver.bean.Enterprise;
import com.demon.dbserver.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    @GetMapping("/id/{id}")
    public Enterprise getEnterpriseById(@PathVariable Integer id) {
        return enterpriseService.getEnterpriseById(id);
    }

    @GetMapping("/name/{name}")
    public List<Enterprise> getEnterpriseByName(@PathVariable String name) {
        return enterpriseService.getEnterpriseByName(name);
    }

    @GetMapping("/page/{num}")
    public List<Enterprise> getEnterprisesByPage(@PathVariable Integer num) {
        return enterpriseService.getEnterprisesByPage(num);
    }

    @GetMapping("/all")
    public List<Enterprise> getAllEnterprises() {
        return enterpriseService.getAllEnterprises();
    }

    @GetMapping("/name/es/{name}")
    public List<Enterprise> getEnterpriseByNameLike(@PathVariable String name) {
        return enterpriseService.getEnterpriseByNameLike(name);
    }

    @GetMapping("/form/all")
    public List<String> getAllFormOfBusinessEnterprise() {
        return enterpriseService.getAllFormOfBusinessEnterprise();
    }
}
