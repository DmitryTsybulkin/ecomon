package com.itlab2017.repositories;

import com.itlab2017.domain.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station, Integer> {
}
