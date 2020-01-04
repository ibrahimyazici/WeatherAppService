package com.ibrahim.weatherforecastdemo.services;

import com.ibrahim.weatherforecastdemo.daos.QueryLogDAO;
import com.ibrahim.weatherforecastdemo.models.QueryLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QueryLogServiceImpl implements QueryLogService {

    @Autowired
    private QueryLogDAO queryLogDAO;

    @Transactional
    @Override
    public QueryLog getQueryLogById(long id) {
        return queryLogDAO.getQueryLogById(id);
    }

    @Transactional
    @Override
    public List<QueryLog> getAllQueryLogs() {
        return queryLogDAO.getAllQueryLogs();
    }

    @Transactional
    @Override
    public void save(QueryLog queryLog) {
        queryLogDAO.save(queryLog);
    }
}
