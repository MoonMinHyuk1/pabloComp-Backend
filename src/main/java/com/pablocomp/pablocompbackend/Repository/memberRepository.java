package com.pablocomp.pablocompbackend.Repository;

import com.pablocomp.pablocompbackend.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class memberRepository {
    @Autowired private EntityManager em;

    public Member findByUserType(String userType) {
        return em.createQuery("select m from Member m where m.userType = :userType", Member.class)
                .setParameter("userType", userType)
                .getSingleResult();
    }


}


