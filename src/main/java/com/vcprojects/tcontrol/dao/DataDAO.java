package com.vcprojects.tcontrol.dao;

import java.util.List;

import com.vcprojects.tcontrol.model.Data;

public interface DataDAO {

    public List < Data > getDatas();

    public void saveData(Data theProduct);

    public Data getData(int theId);

    public void deleteData(int theId);
}