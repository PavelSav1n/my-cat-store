package ru.itsjava.services;

import lombok.RequiredArgsConstructor;
import ru.itsjava.domain.Cat;
import ru.itsjava.domain.Client;

import java.util.List;
import java.util.Scanner;

@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final Client client;
    private final Scanner scanner;
    private final CatService catService;
    private final List<Cat> catsTaken;

    @Override
    public void takeCat() {
        System.out.print("Введите имя кота, которого будете брать:");
        String catNameToTake = scanner.next();
        if (catService.hasCat(catNameToTake)) {
            System.out.println();
            System.out.println("Ловим кота...");
            Cat cat = catService.takeCatByName(catNameToTake);
            catsTaken.add(cat);
            System.out.println("Отлов кота завершён. Получите первого попавшегося по кличке:" + catNameToTake);
            System.out.println("Теперь у вас " + catsTaken.size() + " котов!");
        } else {
            System.out.println("Не смогли поймать кота с именем \"" + catNameToTake + "\". Попробуйте выбрать другого.");
        }
    }

    @Override
    public void putCat() {
        System.out.println("Вы кладёте кота в коробку с котами...");
        System.out.print("Введите имя кота: ");
        String catName = scanner.next();
        System.out.print("Введите цвет кота: ");
        String catColor = scanner.next();
        System.out.print("Введите true, если это кот или false, если кошка: ");
        Boolean catGender = scanner.nextBoolean();
        System.out.println();
        Cat cat = new Cat(catName, catColor, catGender);
        catService.putCat(cat);
    }

    @Override
    public void printAllCats() {
        catService.printCats();
    }

    @Override
    public void printCatsTaken() {
        System.out.println("У вас " + catsTaken.size() + " котиков!");
        for (Cat elemCat : catsTaken) {
            if (elemCat.isMale()) {
                System.out.println("Котик: \"" + elemCat.getName() + "\" цвет: " + elemCat.getColor());
            } else {
                System.out.println("Коська: \"" + elemCat.getName() + "\" цвет: " + elemCat.getColor());
            }
        }
    }


    @Override
    public void printName() {
        System.out.print(client.getName());
    }
}
