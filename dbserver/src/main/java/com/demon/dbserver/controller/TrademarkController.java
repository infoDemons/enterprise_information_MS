package com.demon.dbserver.controller;

import com.demon.dbserver.bean.Trademark;
import com.demon.dbserver.common.ResultCode;
import com.demon.dbserver.service.TrademarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trademark")
public class TrademarkController {

    @Autowired
    private TrademarkService trademarkService;


    @GetMapping("/enterprise/{enterpriseId}")
    public List<Trademark> getTrademarkByEnterpriseId(@PathVariable Integer enterpriseId) {
        return trademarkService.getTrademarkByEnterpriseId(enterpriseId);
    }

    @GetMapping("/applicant/{applicantName}")
    public List<Trademark> getTrademarkByApplicant(@PathVariable String applicantName) {
        return trademarkService.getTrademarkByApplicant(applicantName);
    }

    @GetMapping("/name/{trademarkName}")
    public List<Trademark> getTrademarkByTrademarkName(@PathVariable String trademarkName) {
        return trademarkService.getTrademarkByTrademarkName(trademarkName);
    }

    @GetMapping("/registration/{registrationNumber}")
    public List<Trademark> getTrademarkByRegistrationNumber(@PathVariable Integer registrationNumber) {
        return trademarkService.getTrademarkByRegistrationNumber(registrationNumber);
    }

    @GetMapping("/all")
    public List<Trademark> getAllTrademarks() {
        return trademarkService.getAllTrademarks();
    }

    @PostMapping("/delete")
    public ResultCode deleteTrademark(Integer trademarkId) {
        if(trademarkService.deleteTrademark(trademarkId)) {
            return ResultCode.SUCCESS;
        } else {
            return ResultCode.FAILED;
        }
    }

    @PostMapping("/modify")
    public ResultCode modifyTrademark(Integer trademarkId,
                                      String applicantName,
                                      String trademarkAddress,
                                      String trademarkName,
                                      Integer registrationNumber,
                                      String classification,
                                      String trademarkStatus,
                                      String trademarkProcess ) {
        if (trademarkService.modifyTrademark(trademarkId, applicantName, trademarkAddress, trademarkName, registrationNumber, classification, trademarkStatus, trademarkProcess)) {
            return ResultCode.SUCCESS;
        } else {
            return ResultCode.FAILED;
        }

    }

}
