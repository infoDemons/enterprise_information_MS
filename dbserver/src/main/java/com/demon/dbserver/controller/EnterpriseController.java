package com.demon.dbserver.controller;

import com.demon.dbserver.bean.Enterprise;
import com.demon.dbserver.common.ResultCode;
import com.demon.dbserver.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/advanced")
    public List<Enterprise> getEnterpriseByAdvancedSearch(Integer enterpriseId, String enterpriseName,
                                                          String industry, String form) {
        return enterpriseService.getEnterpriseByAdvancedSearch(enterpriseId, enterpriseName, industry, form);
    }

    @PostMapping("/delete")
    public ResultCode deleteEnterpriseById(Integer enterpriseId) {
        if (enterpriseService.deleteEnterpriseById(enterpriseId)) {
            return ResultCode.SUCCESS;
        } else {
            return ResultCode.FAILED;
        }
    }

    @PostMapping("/update")
    public ResultCode updateEnterprise(Enterprise enterprise) {
        if (enterpriseService.updateEnterprise(enterprise)) {
            return ResultCode.SUCCESS;
        } else {
            return ResultCode.FAILED;
        }
    }
}
