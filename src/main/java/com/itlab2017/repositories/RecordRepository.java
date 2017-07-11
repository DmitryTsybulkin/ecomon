package com.itlab2017.repositories;

import com.itlab2017.domain.Log;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RecordRepository extends JpaRepository<Log,Integer> {
}
