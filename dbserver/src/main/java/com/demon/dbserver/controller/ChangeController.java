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

    @GetMapping("/change/{enterpriseId}")
    public List<Change> getChangeByEnterpriseId(@PathVariable Integer enterpriseId) {
        return changeService.getChangeByEnterpriseId(enterpriseId);
    }

    @GetMapping("/change/{enterpriseName}")
    public List<Change> getChangeByEnterpriseName(@PathVariable String enterpriseName) {
        return changeService.getChangeByEnterpriseName(enterpriseName);
    }

    @GetMapping("/change/{changeType}")
    public List<Change> getChangeByChangeType(@PathVariable String changeType) {
        return changeService.getChangeByChangeType(changeType);
    }

    @GetMapping("/all")
    public List<Change> getAllChanges() {
        return changeService.getAllChanges();
    }

    @PostMapping("/delete")
    public ResultCode deleteChange(Integer changeId) {
        if(changeService.deleteChange(changeId)) {
            return ResultCode.SUCCESS;
        } else {
            return ResultCode.FAILED;
        }
    }

    @PostMapping("/modify")
    public ResultCode modifyChange(Integer changeId,
                            Integer enterpriseId,
                            String enterpriseName,
                            String changeDate,
                            String changeType,
                            String informationBefore,
                            String informationAfter,
                            String createDate) {
        if (changeService.modifyChange(changeId, enterpriseId, enterpriseName, changeDate, changeType, informationBefore, informationAfter, createDate)) {
            return ResultCode.SUCCESS;
        } else {
            return ResultCode.FAILED;
        }

    }

}
