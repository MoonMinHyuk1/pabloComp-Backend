package com.pablocomp.pablocompbackend.service;

import com.pablocomp.pablocompbackend.domain.Member;
import com.pablocomp.pablocompbackend.domain.OrderStatus;
import com.pablocomp.pablocompbackend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public void updateOrderStatus(Member member) {
        member.setOrderStatus(OrderStatus.NONE);
    }
}
