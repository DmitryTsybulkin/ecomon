package com.itlab2017.services;

import com.itlab2017.domain.Station;

public interface StationService {
    Iterable<Station> listAllStations();

    Station getStationById(Integer id);

    Station saveStation(Station Station);

}
