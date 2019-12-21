package com.demon.dbserver.controller;

import com.demon.dbserver.bean.Staff;
import com.demon.dbserver.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping("/name/{name}")
    public List<Staff> getStaffByName(@PathVariable String name) {
        return staffService.getStaffByName(name);
    }

    @GetMapping("/enterprise/{name}")
    public List<Staff> getStaffByEnterprise(@PathVariable String name) {
        return staffService.getStaffByEnterprise(name);
    }
}