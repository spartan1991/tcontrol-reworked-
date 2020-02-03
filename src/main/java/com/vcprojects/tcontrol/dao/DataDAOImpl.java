package com.vcprojects.tcontrol.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vcprojects.tcontrol.model.Data;

@Repository
public class DataDAOImpl implements DataDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List < Data > getDatas() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery < Data > cq = cb.createQuery(Data.class);
        Root < Data > root = cq.from(Data.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void deleteData(int id) {
        Session session = sessionFactory.getCurrentSession();
        Data data = session.byId(Data.class).load(id);
        session.delete(data);
    }

    @Override
    public void saveData(Data theData) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theData);
    }

    @Override
    public Data getData(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Data theData = currentSession.get(Data.class, theId);
        return theData;
    }
}