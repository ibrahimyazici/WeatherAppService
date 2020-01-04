package com.ibrahim.weatherforecastdemo.daos;

import com.ibrahim.weatherforecastdemo.models.QueryLog;

import java.util.List;

public interface QueryLogDAO {
    QueryLog getQueryLogById(long id);
    List<QueryLog> getAllQueryLogs();
    void save(QueryLog queryLog);
}
