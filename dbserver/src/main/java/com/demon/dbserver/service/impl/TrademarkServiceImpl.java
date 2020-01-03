package com.demon.dbserver.service.impl;


import com.demon.dbserver.bean.Trademark;
import com.demon.dbserver.dao.TrademarkDao;
import com.demon.dbserver.service.TrademarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TrademarkServiceImpl implements TrademarkService {

    @Autowired
    private TrademarkDao trademarkDao;

    @Override
    public List<Trademark> getTrademarkByEnterpriseId(Integer enterpriseId) {
        return trademarkDao.getTrademarkByEnterpriseId(enterpriseId);
    }

    @Override
    public List<Trademark> getTrademarkByApplicant(String applicantName) {
        return trademarkDao.getTrademarkByApplicant(applicantName);
    }

    @Override
    public List<Trademark> getTrademarkByTrademarkName(String trademarkName) {
        return trademarkDao.getTrademarkByTrademarkName(trademarkName);
    }

    @Override
    public List<Trademark> getTrademarkByRegistrationNumber(Integer registrationNumber) {
        return trademarkDao.getTrademarkByRegistrationNumber(registrationNumber);
    }

    @Override
    public List<Trademark> getAllTrademarks() { return trademarkDao.getAllTrademarks(); }

    @Override
    public boolean deleteTrademark(Integer trademarkId) {
        try {
            trademarkDao.deleteTrademark(trademarkId);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean modifyTrademark(Integer trademarkId, String applicantName, String trademarkAddress, String trademarkName, Integer registrationNumber, String classification, String trademarkStatus, String trademarkProcess ) {
        try {
            trademarkDao.modifyTrademark(trademarkId, applicantName, trademarkAddress, trademarkName, registrationNumber, classification, trademarkStatus, trademarkProcess );
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }
}
