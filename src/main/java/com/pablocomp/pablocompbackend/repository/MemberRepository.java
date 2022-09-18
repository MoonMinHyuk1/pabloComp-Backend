package com.pablocomp.pablocompbackend.repository;

import com.pablocomp.pablocompbackend.domain.Member;
import com.pablocomp.pablocompbackend.domain.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberRepository {
    private final EntityManager em;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Member save(Member member) {
        em.persist(member);

        return member;
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public Optional<Member> findBySerialNum(String serialNum, OrderStatus orderStatus) {
        Member findMember = em.createQuery("select m from Member m where m.serialNum = :serialNum and m.orderStatus = :orderStatus", Member.class)
                .setParameter("serialNum", passwordEncoder.encode(serialNum))
                .setParameter("orderStatus", orderStatus)
                .getSingleResult();

        return Optional.ofNullable(findMember);
    }

    @Transactional
    public Optional<Member> findBySerialNumAndTempPw(String serialNum, String tempPw) {
        Member findMember = em.createQuery("select m from Member m where m.serialNum = :serialNum and m.tempPw = :tempPw", Member.class)
                .setParameter("serialNum", passwordEncoder.encode(serialNum))
                .setParameter("tempPw", passwordEncoder.encode(tempPw))
                .getSingleResult();

        return Optional.ofNullable(findMember);
    }
}


