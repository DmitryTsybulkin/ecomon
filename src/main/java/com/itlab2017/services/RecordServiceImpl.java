package com.itlab2017.services;

import com.itlab2017.domain.Record;
import com.itlab2017.repositories.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public class RecordServiceImpl implements RecordService {
    private RecordRepository recordRepository;

    @Autowired
    public void setRecordRepository(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }


    @Override
    public Iterable<Record> listAllRecords() {
        return recordRepository.findAll();
    }

    @Override
    public Record getRecordById(Integer id) {
        return recordRepository.findOne(id);
    }

    @Override
    public Record saveRecord(Record record) {
        return recordRepository.save(record);
    }
}
