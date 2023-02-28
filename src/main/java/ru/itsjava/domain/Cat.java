package ru.itsjava.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Cat {
    private final String name;
    private final String color;
    private final boolean isMale;

}
