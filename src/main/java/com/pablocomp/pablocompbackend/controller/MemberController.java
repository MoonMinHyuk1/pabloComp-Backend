package com.pablocomp.pablocompbackend.controller;

import com.pablocomp.pablocompbackend.domain.Member;
import com.pablocomp.pablocompbackend.domain.OrderStatus;
import com.pablocomp.pablocompbackend.repository.MemberRepository;
import com.pablocomp.pablocompbackend.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberRepository memberRepository;
    private final MemberService memberService;

    @PostConstruct
    public void initPost() {
        for(int i = 1; i <= 10; i++) {
            Member member = new Member(OrderStatus.ORDER, "123456abc" + i, "abc" + i);
            memberRepository.save(member);
        }
    }

    @GetMapping("/init")
    @ResponseBody
    public List<Member> initGet() {
        List<Member> memberList = memberRepository.findAll();

        return memberList;
    }

    @PostMapping("/member/serialNum")
    @ResponseBody
    public String findMemberBySerialNumPost(@RequestParam("serialNum") String serialNum) {
        Optional<Member> findMember = memberRepository.findBySerialNum(serialNum, OrderStatus.ORDER);

        if(findMember.isEmpty()) {
            return "NO";
        } else {
            return "YES";
        }
    }

    @PostMapping("/member/tempPw")
    @ResponseBody
    public String findMemberByTempPwPost(@RequestParam("serialNum") String serialNum, @RequestParam("tempPw") String tempPw) {
        Optional<Member> findMember = memberRepository.findBySerialNumAndTempPw(serialNum, tempPw);

        if(findMember.isEmpty()) {
            return "NO";
        } else {
            Member member = findMember.get();
            memberService.updateOrderStatus(member);

            return "YES";
        }
    }
}
