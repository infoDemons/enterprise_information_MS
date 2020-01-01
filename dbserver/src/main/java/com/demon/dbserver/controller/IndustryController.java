package com.demon.dbserver.controller;

import com.demon.dbserver.bean.Industry;
import com.demon.dbserver.service.IndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/industry")
public class IndustryController {

    @Autowired
    private IndustryService industryService;

    @GetMapping("/all")
    public List<Industry> getAllEnterprises() {
        return industryService.getAllIndustries();
    }

}
