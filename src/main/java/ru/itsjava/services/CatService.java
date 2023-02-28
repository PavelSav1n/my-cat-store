package ru.itsjava.services;

import ru.itsjava.domain.Cat;

public interface CatService {
    Cat takeCatByName(String name);

    void putCat(Cat cat);

    boolean hasCat(String name);

    void printCats();
}
