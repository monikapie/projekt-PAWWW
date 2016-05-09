package com.pie.service;

import com.pie.dao.JourneyDao;
import com.pie.model.Journey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by pie on 5/3/16.
 */
@Service("journeyService")
@Transactional
public class JourneyService {

    @Autowired
    private JourneyDao dao;

    public List<Journey> findUserJourneys(int id){
        return dao.findUserJourneys(id);
    }

    public void addJourney(Journey journey, int id){
        dao.addJourney(journey, id);
    }

    public void deleteJourney(int id){
        dao.deleteJourney(id);
    }
}
