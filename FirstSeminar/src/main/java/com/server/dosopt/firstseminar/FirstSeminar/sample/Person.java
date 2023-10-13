package com.server.dosopt.firstseminar.FirstSeminar.sample;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Person {
    private String LastName;
    private String FirstName;

    @Builder
    public Person(String lastName, String firstName) {
        LastName = lastName;
        FirstName = firstName;
    }
}
