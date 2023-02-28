package ru.itsjava.services;

import org.junit.jupiter.api.Test;
import ru.itsjava.domain.Cat;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class CatServiceImplTest {

    public static final String DEFAULT_NAME = "Barsik";
    public static final String DEFAULT_COLOR = "white";
    public static final boolean DEFAULT_ISMALE = true;
    public static final String TEST_NAME = "Barsik";
    public static final String INCORRECT_NAME = "NotBarsik";


    @Test
    public void shouldHaveCorrectTakeCatByNameMethod() {
        // Создаём кошачий список
        List<Cat> catList = new ArrayList<>();
        Cat defaultCat = new Cat(DEFAULT_NAME, DEFAULT_COLOR, DEFAULT_ISMALE);
        // Пихаем экземпляр кота в кошачий список
        catList.add(defaultCat);
        // Создаём объект типа CatService и передаём туда наш кошачий список
        CatService catService = new CatServiceImpl(catList);
        // Проверка:
        // 1. Возвращается ли null, если мы указываем имя, которого нет в списке
        // 2. Возвращается ли объект, совпадающий по запрашиваемому имени
        // 3. Возвращается ли null, после того, как мы забрали котика из списка в прошлый вызов метода
        assertAll("CatServiceImpl.takeCatByName()",
                () -> assertEquals(null, catService.takeCatByName(INCORRECT_NAME)),
                () -> assertEquals(defaultCat, catService.takeCatByName(TEST_NAME)),
                () -> assertEquals(null, catService.takeCatByName(TEST_NAME))
        );
    }

    @Test
    public void shouldHaveCorrectHasCatMethod(){
        // Создаём кошачий список
        List<Cat> catList = new ArrayList<>();
        Cat defaultCat = new Cat(DEFAULT_NAME, DEFAULT_COLOR, DEFAULT_ISMALE);
        // Пихаем экземпляр кота в кошачий список
        catList.add(defaultCat);
        // Создаём объект типа CatService и передаём туда наш кошачий список
        CatService catService = new CatServiceImpl(catList);

        // 1. Проверка, есть ли в списке кот с существующем в списке именем.
        // 2. Проверка, есть ли в списке кот с несуществующим в списке именем.
        assertAll("CatServiceImpl.hasCat()",
                () -> assertTrue(catService.hasCat(TEST_NAME)),
                () -> assertFalse(catService.hasCat(INCORRECT_NAME))
        );
    }

}
