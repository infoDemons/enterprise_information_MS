package com.demon.dbserver.service;

import com.demon.dbserver.bean.Trademark;

import java.util.List;

public interface TrademarkService {

    List<Trademark> getTrademarkByEnterpriseId(Integer enterpriseId);

    List<Trademark> getTrademarkByApplicant(String applicant);

    List<Trademark> getTrademarkByTrademarkName(String trademarkName);

    List<Trademark> getTrademarkByRegistrationNumber(Integer registrationNumber);

    List<Trademark> getAllTrademarks();

    int getMaxTrademarkId();

    boolean addTrademark(Trademark trademark);

    boolean deleteTrademark(Integer trademarkId);

    boolean modifyTrademark(Integer trademarkId, String applicant, String trademarkAddress, String trademarkName, Integer registrationNumber, String classification, String trademarkStatus, String trademarkProcess );

}

