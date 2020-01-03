package com.demon.dbserver.controller;

import com.demon.dbserver.bean.Change;
import com.demon.dbserver.common.ResultCode;
import com.demon.dbserver.service.ChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/change")
public class ChangeController {

    @Autowired
    private ChangeService changeService;

    @GetMapping("/enterprise_id/{enterpriseId}")
    public List<Change> getChangeByEnterpriseId(@PathVariable Integer enterpriseId) {
        return changeService.getChangeByEnterpriseId(enterpriseId);
    }

    @GetMapping("/enterprise_name/{enterpriseName}")
    public List<Change> getChangeByEnterpriseName(@PathVariable String enterpriseName) {
        return changeService.getChangeByEnterpriseName(enterpriseName);
    }

    @GetMapping("/all")
    public List<Change> getAllChanges() {
        return changeService.getAllChanges();
    }

    @PostMapping("/delete")
    public ResultCode deleteChange(Integer enterpriseInformationChangeId) {
        if(changeService.deleteChange(enterpriseInformationChangeId)) {
            return ResultCode.SUCCESS;
        } else {
            return ResultCode.FAILED;
        }
    }

    @PostMapping("/modify")
    public ResultCode modifyChange(Integer enterpriseInformationChangeId,
                            Integer enterpriseId,
                            String enterpriseName,
                            String informationChangeDate,
                            String informationChangeType,
                            String informationBefore,
                            String informationAfter,
                            String createDate) {
        if (changeService.modifyChange(enterpriseInformationChangeId, enterpriseId, enterpriseName, informationChangeDate, informationChangeType, informationBefore, informationAfter, createDate)) {
            return ResultCode.SUCCESS;
        } else {
            return ResultCode.FAILED;
        }

    }

}
