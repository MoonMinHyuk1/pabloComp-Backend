package com.pablocomp.pablocompbackend.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long Id;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private String serialNum;

    private String tempPw;

    public Member(OrderStatus orderStatus, String serialNum, String tempPw) {
        this.orderStatus = orderStatus;
        this.serialNum = serialNum;
        this.tempPw = tempPw;
    }
}
