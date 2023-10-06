import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class fourthTests {

    private PhoneNetwork phoneBook = new PhoneNetwork();

    @Test
    public void testUserAdd(){
        assertEquals(0, this.phoneBook.getUsersList().size());
        PhoneNetworkUser testUser = new PhoneNetworkUser(
                "Alexandrov",
                "Alexander",
                "Alexandrovich",
                "Novosibyrsk",
                "9501231234"
        );
        phoneBook.addUser(testUser);
        assertEquals(1, this.phoneBook.getUsersList().size());
        assertTrue(this.phoneBook.getUsersList().contains(testUser));
    }

    @Test
    public void testIsName() {
        PhoneNetworkUser testUser = new PhoneNetworkUser(
                "Alexandrov",
                "Alexander",
                "Alexandrovich",
                "Novosibyrsk",
                "9501231234"
        );
        assertTrue(testUser.isName("Alexander"));
    }
    
    @Test
    public void testIsSurname() {
        PhoneNetworkUser testUser = new PhoneNetworkUser(
                "Alexandrov",
                "Alexander",
                "Alexandrovich",
                "Novosibyrsk",
                "9501231234"
        );
        assertTrue(testUser.isSurname("Alexandrov"));
    }

    @Test
    public void testIsPhone() {
        PhoneNetworkUser testUser = new PhoneNetworkUser(
                "Alexandrov",
                "Alexander",
                "Alexandrovich",
                "Novosibyrsk",
                "9501231234"
        );
        assertTrue(testUser.isPhone("9501231234"));
        assertFalse(testUser.isPhone("9999999999"));
    }

    @Test
    public void testUserGroup(){
        PhoneNetworkUser testUser = new PhoneNetworkUser(
                "Alexandrov",
                "Alexander",
                "Alexandrovich",
                "Novosibyrsk",
                "9501231234"
        );
        assertTrue(testUser.isPhoneGroup("950"));
        assertFalse(testUser.isPhoneGroup("999"));
    }
}
