package com.ibrahim.weatherforecastdemo.controllers;

import com.ibrahim.weatherforecastdemo.models.QueryLog;
import com.ibrahim.weatherforecastdemo.services.QueryLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/reports")
public class ReportController {
    @Autowired
    private QueryLogService queryLogService;

    @GetMapping("/logs")
    public List<QueryLog> get(){
        return queryLogService.getAllQueryLogs();
    }

    @GetMapping("/logs/{id}")
    public QueryLog get(@RequestParam long id) {
        QueryLog queryLog = queryLogService.getQueryLogById(id);
        if(queryLog == null) {
            throw new RuntimeException("No logs with given id found");
        }
        return queryLog;
    }

    @PostMapping("/logs")
    public QueryLog save(@RequestBody QueryLog queryLog) {
        queryLogService.save(queryLog);
        return queryLog;
    }
}
