package com.ibrahim.weatherforecastdemo.services;

import com.ibrahim.weatherforecastdemo.models.QueryLog;

import java.util.List;

public interface QueryLogService {
    QueryLog getQueryLogById(long id);
    List<QueryLog> getAllQueryLogs();
    void save(QueryLog queryLog);
}
