package com.itlab2017.services;


import com.itlab2017.domain.Record;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RecordService {
    Iterable<Record> listAllRecords();

    Record getRecordById(Integer id);

    Record saveRecord(Record Device);
}
