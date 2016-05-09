package com.pie.dao;

import com.pie.model.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by pie on 4/26/16.
 */

@Repository("userDao")
public class UserDao extends AbstractDao<Integer, User>{

    public User findById(int id){
        return getByKey(id);
    }

    public void saveUser(User user){
        persist(user);
    }

    @SuppressWarnings("unchecked")
    public List<User> findAllUsers(){
        Criteria criteria = createEntityCriteria();
        return (List<User>) criteria.list();
    }

    public int getUserCount(){
        Query query = getSession().getNamedQuery("userCount");
        return Integer.parseInt(query.uniqueResult().toString());
    }

    public boolean validateUser(String login, String password)
    throws NoSuchAlgorithmException {
        String q = "SELECT login FROM User u WHERE u.login = :log AND u.password = :pwd";

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte byteData[] = md.digest();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        password = sb.toString();

        List result = getSession().createSQLQuery(q)
                .setParameter("log", login).setParameter("pwd", password).list();
        return !result.isEmpty();
    }

    public boolean isUsernameUnique(String username) {
        String q = "SELECT login FROM User u WHERE u.login = :log";
        List result = getSession().createSQLQuery(q)
                .setParameter("log", username).list();
        return !result.isEmpty();
    }

    public void addUser(User user){
        String q = "INSERT INTO User(login, password) VALUES(:log, MD5(:pwd))";
        getSession().createSQLQuery(q)
                .setParameter("log", user.getLogin())
                .setParameter("pwd", user.getPassword()).executeUpdate();
    }

    public int findUserByLogin(String username){
        String q = "SELECT ID FROM User WHERE login = :login";
        String result = getSession().createSQLQuery(q)
                .setParameter("login", username).uniqueResult().toString();
        return Integer.parseInt(result);
    }
}
