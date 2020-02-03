package com.vcprojects.tcontrol.service;

import java.util.List;

import com.vcprojects.tcontrol.model.Data;

public interface DataService {

    public List < Data > getDatas();

    public void saveData(Data theData);

    public Data getData(int theId);

    public void deleteData(int theId);

}