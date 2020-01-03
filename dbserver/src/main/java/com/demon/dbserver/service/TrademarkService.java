package com.demon.dbserver.service;

import com.demon.dbserver.bean.Trademark;

import java.util.List;

public interface TrademarkService {

    List<Trademark> getTrademarkByEnterpriseId(Integer enterpriseId);

    List<Trademark> getTrademarkByApplicant(String applicantName);

    List<Trademark> getTrademarkByTrademarkName(String trademarkName);

    List<Trademark> getTrademarkByRegistrationNumber(Integer registrationNumber);

    List<Trademark> getAllTrademarks();

    boolean deleteTrademark(Integer trademarkId);

    boolean modifyTrademark(Integer trademarkId, String applicantName, String trademarkAddress, String trademarkName, Integer registrationNumber, String classification, String trademarkStatus, String trademarkProcess );

}

