package com.pie.dao;

import com.pie.model.Couchsurfer;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pie on 5/3/16.
 */
@Repository("couchsurferDao")
public class CouchsurferDao extends AbstractDao<Integer, Couchsurfer> {

    @SuppressWarnings("unchecked")
    public List<Couchsurfer> findUserCouchsurfers(int id){
        Criteria criteria = createEntityCriteria().add(Restrictions.eq("user_id", id));
        return (List<Couchsurfer>) criteria.list();
    }

    public void addCouchsurfer(Couchsurfer couchsurfer, int id){
        String q = "INSERT INTO Couchsurfer(name, surname, address, arrival_date, departure_date, user_id) " +
                "VALUES(:name, :surname, :address, :arrival_date, :departure_date, :user_id)";
        getSession().createSQLQuery(q)
                .setParameter("name", couchsurfer.getName())
                .setParameter("surname", couchsurfer.getSurname())
                .setParameter("address", couchsurfer.getAddress())
                .setParameter("arrival_date", couchsurfer.getArrival_date())
                .setParameter("departure_date", couchsurfer.getDeparture_date())
                .setParameter("user_id", id)
                .executeUpdate();
    }

    public void deleteCouchsurfer(int id){
        String q = "DELETE FROM Couchsurfer WHERE ID = :id";
        getSession().createSQLQuery(q)
                .setParameter("id", id)
                .executeUpdate();
    }
}
