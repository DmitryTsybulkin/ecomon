package com.itlab2017.repositories;

import com.itlab2017.domain.Record;
import org.springframework.data.repository.CrudRepository;

public interface RecordRepository extends CrudRepository<Record, Integer> {
}
