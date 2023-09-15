public class second {
    public void lab2() {
        System.out.println("\n========================\n\nSECOND LAB\n");
        Person egor = new Person();
        egor.printPerson();
        Person kirill = new Person("Kirill");
        kirill.printPerson();
        Person denis = new Person(10);
        denis.printPerson();
        Person tanya = new Person(false);
        tanya.printPerson();
        Person visokiyAnton = new Person(192.5f);
        visokiyAnton.printPerson();
    }
}

class Person {
    String firstName;
    String lastName;
    int age;
    boolean gender;
    float height;

    public Person() {
        this.firstName = "Ivan";
        this.lastName = "Ivanov";
        this.age = 19;
        this.gender = true;
        this.height = 170;
    }

    Person(String firstName) {
        this.firstName = firstName;
    }

    Person(int age) {
        this.age = age;
    }

    Person(boolean gender) {
        this.gender = gender;
    }

    Person(float height) {
        this.height = height;
    }

    public void printPerson(){
        System.out.println(this.firstName);
        System.out.println(this.lastName);
        System.out.println(this.age);
        System.out.println(this.gender);
        System.out.println(this.height+"\n");
    }
}
