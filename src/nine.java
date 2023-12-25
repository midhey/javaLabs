import java.util.*;

public class nine {
    public void lab () {
        System.out.println("NINE LAB\n\n=================");
        ConferenceApp.menu();
    }
}

class Participant {
    private String lastName;
    private String city;
    private String organization;

    public Participant(String lastName, String city, String organization) {
        this.lastName = lastName;
        this.city = city;
        this.organization = organization;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }

    public String getOrganization() {
        return organization;
    }

    @Override
    public String toString() {
        return "Фамилия: " + lastName + ", Город: " + city + ", Организация: " + organization;
    }
}

class ConferenceManager {
    private List<Participant> participants = new ArrayList<>();

    public void addParticipant(Participant participant) {
        participants.add(participant);
        participants.sort(Comparator.comparing(Participant::getLastName));
    }

    public void displayAllParticipants() {
        for (Participant participant : participants) {
            System.out.println(participant);
        }
    }

    public void displayParticipantsByCity(String city) {
        for (Participant participant : participants) {
            if (participant.getCity().equalsIgnoreCase(city)) {
                System.out.println(participant);
            }
        }
    }

    public void displayParticipantsByOrganization(String organization) {
        for (Participant participant : participants) {
            if (participant.getOrganization().equalsIgnoreCase(organization)) {
                System.out.println(participant);
            }
        }
    }

    // Добавленные методы для использования в тестах
    public List<Participant> getParticipants() {
        return participants;
    }

    public List<Participant> getParticipantsByCity(String city) {
        List<Participant> result = new ArrayList<>();
        for (Participant participant : participants) {
            if (participant.getCity().equalsIgnoreCase(city)) {
                result.add(participant);
            }
        }
        return result;
    }

    public List<Participant> getParticipantsByOrganization(String organization) {
        List<Participant> result = new ArrayList<>();
        for (Participant participant : participants) {
            if (participant.getOrganization().equalsIgnoreCase(organization)) {
                result.add(participant);
            }
        }
        return result;
    }
}

class ConferenceApp {
    public static void menu() {
        ConferenceManager conferenceManager = new ConferenceManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить участника");
            System.out.println("2. Вывести всех участников");
            System.out.println("3. Вывести участников из определенного города");
            System.out.println("4. Вывести участников из определенной организации");
            System.out.println("5. Выйти");

            System.out.print("Выберите пункт меню: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Введите фамилию участника: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Введите город участника: ");
                    String city = scanner.nextLine();
                    System.out.print("Введите организацию участника: ");
                    String organization = scanner.nextLine();

                    Participant newParticipant = new Participant(lastName, city, organization);
                    conferenceManager.addParticipant(newParticipant);
                    System.out.println("Участник добавлен успешно!");
                    break;

                case 2:
                    System.out.println("\nВсе участники конференции:");
                    conferenceManager.displayAllParticipants();
                    break;

                case 3:
                    System.out.print("Введите город для поиска участников: ");
                    String searchCity = scanner.nextLine();
                    System.out.println("\nУчастники из города " + searchCity + ":");
                    conferenceManager.displayParticipantsByCity(searchCity);
                    break;

                case 4:
                    System.out.print("Введите организацию для поиска участников: ");
                    String searchOrganization = scanner.nextLine();
                    System.out.println("\nУчастники из организации " + searchOrganization + ":");
                    conferenceManager.displayParticipantsByOrganization(searchOrganization);
                    break;

                case 5:
                    System.out.println("Программа завершена.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Неверный выбор. Пожалуйста, выберите существующий пункт меню.");
                    break;
            }
        }
    }
}