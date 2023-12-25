import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ConferenceManagerTest {

    @Test
    void addParticipant_ShouldAddParticipant() {
        ConferenceManager conferenceManager = new ConferenceManager();
        Participant participant = new Participant("Иванов", "Москва", "Компания1");

        conferenceManager.addParticipant(participant);

        assertEquals(1, conferenceManager.getParticipants().size());
        assertTrue(conferenceManager.getParticipants().contains(participant));
    }

    @Test
    void displayAllParticipants_ShouldDisplayAllParticipants() {
        ConferenceManager conferenceManager = new ConferenceManager();
        Participant participant1 = new Participant("Иванов", "Москва", "Компания1");
        Participant participant2 = new Participant("Петров", "Санкт-Петербург", "Компания2");

        conferenceManager.addParticipant(participant1);
        conferenceManager.addParticipant(participant2);

        assertEquals(2, conferenceManager.getParticipants().size());
    }

    @Test
    void displayParticipantsByCity_ShouldDisplayParticipantsInCity() {
        ConferenceManager conferenceManager = new ConferenceManager();
        Participant participant1 = new Participant("Иванов", "Москва", "Компания1");
        Participant participant2 = new Participant("Петров", "Санкт-Петербург", "Компания2");

        conferenceManager.addParticipant(participant1);
        conferenceManager.addParticipant(participant2);

        assertEquals(1, conferenceManager.getParticipantsByCity("Санкт-Петербург").size());
        assertTrue(conferenceManager.getParticipantsByCity("Санкт-Петербург").contains(participant2));
    }

    @Test
    void displayParticipantsByOrganization_ShouldDisplayParticipantsInOrganization() {
        ConferenceManager conferenceManager = new ConferenceManager();
        Participant participant1 = new Participant("Иванов", "Москва", "Компания1");
        Participant participant2 = new Participant("Петров", "Санкт-Петербург", "Компания2");

        conferenceManager.addParticipant(participant1);
        conferenceManager.addParticipant(participant2);

        assertEquals(1, conferenceManager.getParticipantsByOrganization("Компания1").size());
        assertTrue(conferenceManager.getParticipantsByOrganization("Компания1").contains(participant1));
    }

    @Test
    void displayParticipantsByOrganization_ShouldNotDisplayParticipantsFromOtherOrganizations() {
        ConferenceManager conferenceManager = new ConferenceManager();
        Participant participant1 = new Participant("Иванов", "Москва", "Компания1");
        Participant participant2 = new Participant("Петров", "Санкт-Петербург", "Компания2");

        conferenceManager.addParticipant(participant1);
        conferenceManager.addParticipant(participant2);

        assertEquals(0, conferenceManager.getParticipantsByOrganization("Компания3").size());
    }
}