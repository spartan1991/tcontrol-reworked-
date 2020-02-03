package com.vcprojects.tcontrol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vcprojects.tcontrol.dao.DataDAO;
import com.vcprojects.tcontrol.model.Data;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private DataDAO dataDAO;

    @Override
    @Transactional
    public List < Data > getDatas() {
        return dataDAO.getDatas();
    }

    @Override
    @Transactional
    public void saveData(Data theData) {
        dataDAO.saveData(theData);
    }

    @Override
    @Transactional
    public Data getData(int theId) {
        return dataDAO.getData(theId);
    }

    @Override
    @Transactional
    public void deleteData(int theId) {
        dataDAO.deleteData(theId);
    }
}