package com.itlab2017.services;

import com.itlab2017.domain.Station;
import com.itlab2017.repositories.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StationServiceImpl implements StationService {
    private StationRepository stationRepository;

    @Autowired
    public void setStationRepository(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @Override
    public Iterable<Station> listAllStations() {
        return stationRepository.findAll();
    }

    @Override
    public Station getStationById(Integer id) {
        return stationRepository.findOne(id);
    }

    @Override
    public Station saveStation(Station Station) {
        return stationRepository.save(Station);
    }
}
