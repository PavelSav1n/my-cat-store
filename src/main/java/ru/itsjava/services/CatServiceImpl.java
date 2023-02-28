package ru.itsjava.services;

import lombok.RequiredArgsConstructor;
import ru.itsjava.domain.Cat;

import java.util.List;

@RequiredArgsConstructor
public class CatServiceImpl implements CatService {

    private final List<Cat> allCatsFromStore;

    @Override
    public Cat takeCatByName(String name) {
        Cat resCat = null;

        for (Cat elemCat : allCatsFromStore) {
            if (elemCat.getName().equals(name)) {
                resCat = elemCat;
            }
            if (resCat != null) {
                allCatsFromStore.remove(resCat);
                return resCat;
            }
        }
        return null;
    }

    @Override
    public void putCat(Cat cat) {
        allCatsFromStore.add(cat);
    }

    @Override
    public boolean hasCat(String name) {
        for (Cat elemCat : allCatsFromStore) {
            if (elemCat.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void printCats() {
        System.out.println("В нашем магазине " + allCatsFromStore.size() + " котиков!");
        for (Cat elemCat : allCatsFromStore) {
            if (elemCat.isMale()) {
                System.out.println("Котик: \"" + elemCat.getName() + "\" цвет: " + elemCat.getColor());
            } else {
                System.out.println("Коська: \"" + elemCat.getName() + "\" цвет: " + elemCat.getColor());
            }
        }
    }
}
