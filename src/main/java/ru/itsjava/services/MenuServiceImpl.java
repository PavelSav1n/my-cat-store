package ru.itsjava.services;

import lombok.RequiredArgsConstructor;

import java.util.Scanner;

@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final ClientService clientService;
    private final Scanner scanner;

    @Override
    public void menu() {

        while (true) {
            printMenu();
            System.out.print("Введите номер меню: ");
            int menuNum = scanner.nextInt();

            if (menuNum == 1) {
                clientService.printAllCats();
            } else if (menuNum == 2) {
                clientService.takeCat();
            } else if (menuNum == 3) {
                clientService.putCat();
            } else if (menuNum == 4) {
                clientService.printCatsTaken();
            } else {
                System.out.println("До встречи в нашем котомагазине!");
                break;
            }
        }
    }

    @Override
    public void printMenu() {
        System.out.println();
        System.out.print("Уважаемый посетитель, ");
        clientService.printName();
        System.out.println(", вы можете: \n" +
                "1 -- Ознакомиться с ассортиментом котов " +
                "\n2 -- Взять кота " +
                "\n3 -- Отдать кота " +
                "\n4 -- Посмотреть список ваших котов " +
                "\nДля выхода введите что-то другое...");
    }
}
