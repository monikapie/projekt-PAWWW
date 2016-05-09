package com.pie.service;

import com.pie.dao.TransportDao;
import com.pie.model.Transport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("transportService")
@Transactional
public class TransportService {
    @Autowired
    private TransportDao dao;

    public List<Transport> findUserTransports(int id){
        return dao.findUserTransports(id);
    }

    public void addTransport(Transport transport, int id){
        dao.addTransport(transport, id);
    }

    public void deleteTransport(int id){
        dao.deleteTransport(id);
    }
}
