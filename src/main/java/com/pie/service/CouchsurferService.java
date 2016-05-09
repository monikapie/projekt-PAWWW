package com.pie.service;

import com.pie.dao.CouchsurferDao;
import com.pie.model.Couchsurfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("couchsurferService")
@Transactional
public class CouchsurferService {
    @Autowired
    private CouchsurferDao dao;

    public List<Couchsurfer> findUserCouchsurfers(int id){
        return dao.findUserCouchsurfers(id);
    }

    public void addCouchsurfer(Couchsurfer Couchsurfer, int id){
        dao.addCouchsurfer(Couchsurfer, id);
    }

    public void deleteCouchsurfer(int id){
        dao.deleteCouchsurfer(id);
    }
}
