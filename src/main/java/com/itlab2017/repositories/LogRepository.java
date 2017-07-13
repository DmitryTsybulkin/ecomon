package com.itlab2017.repositories;

import com.itlab2017.domain.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface LogRepository extends JpaRepository<Log,Integer>, JpaSpecificationExecutor<Log> {
}
