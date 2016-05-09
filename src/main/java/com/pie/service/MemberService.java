package com.pie.service;

import com.pie.dao.MemberDao;
import com.pie.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by pie on 5/3/16.
 */
@Transactional
@Service("memberService")
public class MemberService {

    @Autowired
    private MemberDao dao;

    public List<Member> findMembers(int id){
        return dao.findMembers(id);
    }

    public void addMember(Member member, int id){
        dao.addMember(member, id);
    }

    public void deleteMember(int id){
        dao.deleteMember(id);
    }
}
