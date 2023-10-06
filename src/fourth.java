import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class fourth {
    public void lab () {
        System.out.println("===================\n\nFOURTH LAB\n");
        PhoneNetwork phoneBook = new PhoneNetwork();
        phoneBook.addUser(
                new PhoneNetworkUser(
                        "Egorov",
                        "Egor",
                        "Egorovich",
                        "Moscow, s.Mira",
                        "9994563421"
                )
        );
        phoneBook.addUser(
                new PhoneNetworkUser(
                        "Denisov",
                        "Denis",
                        "Denisovich",
                        "Moscow, s.Lomonosova",
                        "9997853121"
                )
        );
        phoneBook.addUser(
                new PhoneNetworkUser(
                        "Denisov",
                        "Egor",
                        "Denisovich",
                        "Moscow, s.Lomonosova",
                        "9997853221"
                )
        );
        phoneBook.printUserList();
        menu(phoneBook);
    }

    public void menu(PhoneNetwork phoneBook) {

        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("Меню работы телефонной сети:\n");
            System.out.println("1. Добавление нового абонента");
            System.out.println("2. Поиск по фамилии");
            System.out.println("3. Поиск по номеру");
            System.out.println("4. Поиск по коду телефона");
            System.out.println("5. Вывод списка в Excel");
            System.out.println("0. Выход");

            System.out.println("\nВыберите пункт:");
            int menuValue = in.nextInt();

            switch (menuValue) {
                case 1:
                    phoneBook.createUser();
                    break;
                case 2:
                    System.out.println("Введите фамилию: ");
                    String surname = in.next();
                    phoneBook.findUserBySurname(surname);
                    break;
                case 3:
                    System.out.println("Введите телефон: ");
                    String phone = in.next();
                    phoneBook.findUserByPhone(phone);
                    break;
                case 4:
                    System.out.println("Введите код телефона");
                    String code = in.next();
                    phoneBook.findUserGroupByCode(code);
                    break;
                case 5:
                    System.out.println("Вы уверены, что хотите записать данные в Excel и закончить работу?\n" +
                            "Введите да, если хотите продолжить:\n");
                    String isExit = in.next();
                    if (Objects.equals(isExit, "да")) {
                        phoneBook.writeToExcel();
                    } else {
                        System.out.println("Выход в меню \n\n");
                    }
                case 0:
                    return;
            }
        }
    }
}

class PhoneNetwork {
    private List<PhoneNetworkUser> usersList = new ArrayList<>();

    public void addUser(PhoneNetworkUser user) {
        usersList.add(user);
    }

    public void writeToExcel() {
        try {
            Workbook phoneNetwork = new HSSFWorkbook();
            FileOutputStream phoneNetworkFile = new FileOutputStream("PhoneNetwork.xls");
            Sheet phoneUsersList = phoneNetwork.createSheet("Список абонентов");

            Row headerRow = phoneUsersList.createRow(0);
            headerRow.createCell(0).setCellValue("Фамилия");
            headerRow.createCell(1).setCellValue("Имя");
            headerRow.createCell(2).setCellValue("Отчество");
            headerRow.createCell(3).setCellValue("Адрес");
            headerRow.createCell(4).setCellValue("Номер телефона");

            Integer i = 1;
            for (PhoneNetworkUser users : this.usersList) {
                Row row = phoneUsersList.createRow(i++);
                row.createCell(0).setCellValue(users.getSurname());
                row.createCell(1).setCellValue(users.getName());
                row.createCell(2).setCellValue(users.getPatronymic());
                row.createCell(3).setCellValue(users.getAddress());
                row.createCell(4).setCellValue(users.getPhoneNumber());
            }

            phoneNetwork.write(phoneNetworkFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createUser() {

        System.out.println("Создание пользователя:\n");
        Scanner in = new Scanner(System.in);
        System.out.println("Введите фамилию:");
        String surname = in.next();
        System.out.println("Введите имя:");
        String name = in.next();
        System.out.println("Введите отчество:");
        String patronymic = in.next();
        System.out.println("Введите адрес:");
        String address = in.next();
        System.out.println("Введите номер телефона:");
        String phoneNumber = in.next();
        usersList.add(
                new PhoneNetworkUser(
                        surname,
                        name,
                        patronymic,
                        address,
                        phoneNumber
                )
        );
    }

    public void printUserList() {
        for (PhoneNetworkUser users: usersList) {
            users.printPerson();
        }
    }

    public void findUserBySurname(String surname) {
        System.out.println("Найденные пользователи:\n");
        for (PhoneNetworkUser users: usersList) {
            if (users.isSurname(surname)) users.printPerson();
        }
    }

    public void findUserByPhone(String phone) {
        System.out.println("Найденные пользователи по телефону:\n");
        for (PhoneNetworkUser users: usersList) {
            if (users.isPhone(phone)) users.printPerson();
        }
    }
    public void findUserGroupByCode(String code) {
        Scanner in = new Scanner(System.in);
        System.out.println("Найденные пользователи по коду телефона:\n");
        for (PhoneNetworkUser users: usersList) {
            if (users.isPhoneGroup(code)) users.printPerson();
        }
    }

    public List<PhoneNetworkUser> getUsersList() {
        return usersList;
    }
}

class PhoneNetworkUser {
    private String surname;
    private String name;
    private String patronymic;
    private String address;
    private String phoneNumber;

    public PhoneNetworkUser(String surname, String name, String patronymic, String address, String phoneNumber) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void printPerson() {
        System.out.println("Фамилия:" + surname);
        System.out.println("Имя:" + name);
        System.out.println("Отчество:" + patronymic);
        System.out.println("Адрес:" + address);
        System.out.println("Номер телефона:" + phoneNumber);
        System.out.println("\n");
    }

    public boolean isSurname(String surname) {
        if(surname.equals(this.surname)) return true;
        else return false;
    }

    public boolean isName(String name) {
        if(name.equals(this.name)) return true;
        else return false;
    }

    public boolean isPhone(String phone) {
        if(phone.equals(this.phoneNumber)) return true;
        else return false;
    }

    public boolean isPhoneGroup(String phoneCode) {
        int compareSum = 0;
        for (int i = 0; i <phoneCode.length(); i++) {
            if(phoneCode.charAt(i) == this.phoneNumber.charAt(i)) {
                compareSum++;
            }
        }
        if (compareSum == 3) return true;
        else return false;
    }
}
