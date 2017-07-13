package com.itlab2017.services;

import com.itlab2017.domain.Station;
import com.itlab2017.repositories.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StationServiceImpl implements StationService {
    private StationRepository StationRepository;

    @Autowired
    public void setStationRepository(StationRepository StationRepository) {
        this.StationRepository = StationRepository;
    }

    @Override
    public Iterable<Station> listAllStations() {
        return StationRepository.findAll();
    }

    @Override
    public Station getStationById(Integer id) {
        return StationRepository.findOne(id);
    }

    @Override
    public Station saveStation(Station Station) {
        return StationRepository.save(Station);
    }
}
