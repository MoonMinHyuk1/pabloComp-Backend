package com.pablocomp.pablocompbackend.repository;

import com.pablocomp.pablocompbackend.domain.Member;
import com.pablocomp.pablocompbackend.domain.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberRepository {
    private final EntityManager em;

    @Transactional
    public Member save(Member member) {
        em.persist(member);

        return member;
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public long findBySerialNum(String serialNum, OrderStatus orderStatus) {
        return em.createQuery("select count(m) from Member m where m.serialNum = :serialNum and m.orderStatus = :orderStatus", Long.class)
                .setParameter("serialNum", serialNum)
                .setParameter("orderStatus", orderStatus)
                .getSingleResult();
    }

    @Transactional
    public Optional<Member> findBySerialNumAndTempPw(String serialNum) {
        Member findMember = em.createQuery("select m from Member m where m.serialNum = :serialNum", Member.class)
                .setParameter("serialNum", serialNum)
                .getSingleResult();

        return Optional.ofNullable(findMember);
    }
}


