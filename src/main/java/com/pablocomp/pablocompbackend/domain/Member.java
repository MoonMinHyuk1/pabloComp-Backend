package com.pablocomp.pablocompbackend.domain;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity @Getter @Setter
public class Member {
    @Id @GeneratedValue private long Id;
}
