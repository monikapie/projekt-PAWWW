package com.pie.dao;

import com.pie.model.Transport;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("transportDao")
public class TransportDao extends AbstractDao<Integer, Transport> {

    @SuppressWarnings("unchecked")
    public List<Transport> findUserTransports(int id){
        Criteria criteria = createEntityCriteria().add(Restrictions.eq("user_id", id));
        return (List<Transport>) criteria.list();
    }

    public void addTransport(Transport transport, int id){
        String q = "INSERT INTO Transport(name, type, member_id, cost, purchase_date, user_id) " +
                "VALUES(:name, :type, :member_id, :cost, :purchase_date, :user_id)";
        getSession().createSQLQuery(q)
                .setParameter("name", transport.getName())
                .setParameter("type", transport.getType())
                .setParameter("member_id", transport.getMember_id())
                .setParameter("cost", transport.getCost())
                .setParameter("purchase_date", transport.getPurchase_date())
                .setParameter("user_id", id)
                .executeUpdate();
    }

    public void deleteTransport(int id){
        String q = "DELETE FROM Transport WHERE ID = :id";
        getSession().createSQLQuery(q)
                .setParameter("id", id)
                .executeUpdate();
    }
}
