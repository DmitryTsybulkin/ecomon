package com.itlab2017.repositories;

import com.itlab2017.domain.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface RecordRepository extends JpaRepository<Record,Integer> {
}
