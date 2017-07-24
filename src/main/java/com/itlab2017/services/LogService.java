package com.itlab2017.services;

import com.itlab2017.domain.Log;

import java.util.List;

public interface LogService {

    Iterable<Log> listAllLogs();

    List<Log> getLogsBySensorId(Integer sensorId);

    Log getLogById(Integer id);

    Log saveLog(Log log);
}
