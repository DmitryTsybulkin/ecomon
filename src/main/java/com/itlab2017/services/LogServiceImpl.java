package com.itlab2017.services;

import com.itlab2017.domain.Log;
import com.itlab2017.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    private LogRepository logRepository;

    @Autowired
    public void setLogRepository(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public List<Log> getLogsBySensorId(Integer sensorId) {
        return logRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("sensor_id"),sensorId);
        });
    }

    @Override
    public Iterable<Log> listAllLogs() {
        return logRepository.findAll();
    }

    @Override
    public Log getLogById(Integer id) {
       return logRepository.findOne(id);
    }

    @Override
    public Log saveLog(Log record) {
        return logRepository.save(record);
    }
}
