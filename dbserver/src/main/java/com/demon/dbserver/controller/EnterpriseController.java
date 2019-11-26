package com.demon.dbserver.controller;

import com.demon.dbserver.bean.Enterprise;
import com.demon.dbserver.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    @GetMapping("/{id}")
    public Enterprise getEnterpriseById(@PathVariable Integer id) {
        return enterpriseService.getEnterpriseById(id);
    }
}
