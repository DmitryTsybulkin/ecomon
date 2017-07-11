package com.itlab2017.services;

import com.itlab2017.domain.Log;
import com.itlab2017.repositories.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordServiceImpl implements RecordService {
    private RecordRepository recordRepository;

    @Autowired
    public void setRecordRepository(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }


    @Override
    public Iterable<Log> listAllRecords() {
        return recordRepository.findAll();
    }

    @Override
    public Log getRecordById(Integer id) {
       return recordRepository.findOne(id);
    }

    @Override
    public Log saveRecord(Log record) {
        return recordRepository.save(record);
    }
}
