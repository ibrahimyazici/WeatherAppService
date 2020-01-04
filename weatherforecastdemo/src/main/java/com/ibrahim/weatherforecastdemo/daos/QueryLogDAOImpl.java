package com.ibrahim.weatherforecastdemo.daos;

import com.ibrahim.weatherforecastdemo.models.QueryLog;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class QueryLogDAOImpl implements QueryLogDAO{
    @Autowired
    private EntityManager entityManager;

    @Override
    public QueryLog getQueryLogById(long id) {
        Session currentSession = entityManager.unwrap(Session.class);
        QueryLog queryLog = currentSession.get(QueryLog.class, id);
        return queryLog;
    }

    @Override
    public List<QueryLog> getAllQueryLogs() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<QueryLog> query = currentSession.createQuery("from QueryLog", QueryLog.class);
        List<QueryLog> queryLogs = query.getResultList();
        return queryLogs;
    }

    @Override
    public void save(QueryLog queryLog) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(queryLog);
    }
}
