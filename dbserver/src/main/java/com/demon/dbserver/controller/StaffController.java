package com.demon.dbserver.controller;

import com.demon.dbserver.bean.Staff;
import com.demon.dbserver.common.ResultCode;
import com.demon.dbserver.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/delete")
    public ResultCode deleteStaff(Integer enterpriseId, String staffName, String position) {
        if (staffService.deleteStaff(enterpriseId, staffName, position)) {
            return ResultCode.SUCCESS;
        } else {
            return ResultCode.FAILED;
        }
    }

    @PostMapping("/modify")
    public ResultCode modifyStaff(Integer originalEnterpriseId, String originalStaffName, String originalPosition,
                                  String staffName, Integer owningEnterpriseNumber, String position) {
        if (staffService.modifyStaff(originalEnterpriseId, originalStaffName, originalPosition,
                                     staffName, owningEnterpriseNumber, position)) {
            return ResultCode.SUCCESS;
        } else {
            return ResultCode.FAILED;
        }
    }
}