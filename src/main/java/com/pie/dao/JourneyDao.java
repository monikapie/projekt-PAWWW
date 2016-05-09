package com.pie.dao;

import com.pie.model.Journey;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pie on 5/3/16.
 */
@Repository("journeyDao")
public class JourneyDao extends AbstractDao<Integer, Journey> {

    @SuppressWarnings("unckecked")
    public List<Journey> findUserJourneys(int id){
        Criteria criteria = createEntityCriteria().add(Restrictions.eq("user_id", id));
        return (List<Journey>) criteria.list();
    }

    public void addJourney(Journey journey, int id){
        String q = "INSERT INTO Journey(name, country, cost, start_date, end_date, user_id) " +
                "VALUES(:name, :country, :cost, :start_date, :end_date, :user_id)";
        getSession().createSQLQuery(q)
                .setParameter("name", journey.getName())
                .setParameter("country", journey.getCountry())
                .setParameter("cost", journey.getCost())
                .setParameter("start_date", journey.getStart_date())
                .setParameter("end_date", journey.getEnd_date())
                .setParameter("user_id", id)
                .executeUpdate();
    }

    public void deleteJourney(int id){
        String q = "DELETE FROM Journey WHERE ID = :id";
        getSession().createSQLQuery(q)
                .setParameter("id", id)
                .executeUpdate();
    }
}
