package ru.itsjava.services;

import ru.itsjava.domain.Cat;
import ru.itsjava.domain.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StoreServiceImpl implements StoreService {
    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ваше имя: ");
        String clientName = scanner.next();
        System.out.println();

        Client client = new Client(clientName, new ArrayList<>());

        // Создаём список котов магазина и заполняем список котами:
        List<Cat> catListStore = new ArrayList<>();
        catListStore.add(new Cat("Барсик", "белый", true));
        catListStore.add(new Cat("Маруся", "серый", false));
        catListStore.add(new Cat("Муська", "чёрно-белый", false));
        catListStore.add(new Cat("Василий_Блаженный", "чёрный", true));
        catListStore.add(new Cat("Лапка", "чёрный", false));
        catListStore.add(new Cat("Снежок", "белый", true));

        CatService catService = new CatServiceImpl(catListStore);

        // Создаём список котов у клиента
        List<Cat> catListClient = new ArrayList<>();

        ClientService clientService = new ClientServiceImpl(client, scanner, catService, catListClient);

        MenuService menuService = new MenuServiceImpl(clientService, scanner);

        menuService.menu();

    }
}
