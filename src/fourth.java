import java.util.ArrayList;
import java.util.List;

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
        phoneBook.findUserBySurname("Denisov");
        phoneBook.findUserByPhone("9997853121");
    }
}

class PhoneNetwork {
    private List<PhoneNetworkUser> usersList = new ArrayList<>();

    public void addUser(PhoneNetworkUser user) {
        usersList.add(user);
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
        if(surname == this.surname) return true;
        else return false;
    }

    public boolean isPhone(String phone) {
        if(phone == this.phoneNumber) return true;
        else return false;
    }
}
