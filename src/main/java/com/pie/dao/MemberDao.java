package com.pie.dao;

import com.pie.model.Member;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pie on 5/3/16.
 */
@Repository("memberDao")
public class MemberDao extends AbstractDao<Integer, Member> {

    @SuppressWarnings("unchecked")
    public List<Member> findMembers(int id){
        Criteria criteria = createEntityCriteria().add(Restrictions.eq("user_id", id));
        return (List<Member>) criteria.list();
    }

    public void addMember(Member member, int id){
        String q = "INSERT INTO Member(name, surname, user_id) " +
                "VALUES(:name, :surname, :user_id)";
        getSession().createSQLQuery(q)
                .setParameter("name", member.getName())
                .setParameter("surname", member.getSurname())
                .setParameter("user_id", id)
                .executeUpdate();
    }

    public void deleteMember(int id){
        String q = "DELETE FROM Member WHERE ID = :id";
        getSession().createSQLQuery(q)
                .setParameter("id", id)
                .executeUpdate();
    }
}
