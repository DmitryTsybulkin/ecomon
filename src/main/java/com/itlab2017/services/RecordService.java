package com.itlab2017.services;


import com.itlab2017.domain.Log;

public interface RecordService {
    Iterable<Log> listAllRecords();

    Log getRecordById(Integer id);

    Log saveRecord(Log Device);
}
