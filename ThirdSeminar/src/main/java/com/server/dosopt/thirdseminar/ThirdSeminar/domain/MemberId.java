package com.server.dosopt.thirdseminar.ThirdSeminar.domain;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Embeddable
@EqualsAndHashCode
public class MemberId implements Serializable {
    private String memberId;
}
