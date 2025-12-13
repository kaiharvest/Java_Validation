package indradwiprabowo.validation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ContainerDataTest extends AbstractValidatorTest {

    @Test
    void testContainerData() {
        Person person = new Person();
        person.setFirstName("indra");
        person.setLastName("dwi");
        person.setAddress(new Address());

        person.getAddress().setCity("semarang");
        person.getAddress().setCountry("indonesia");
        person.getAddress().setStreet("bla bla bla");

        person.setHobbies(new ArrayList<>());
        person.getHobbies().add("");
        person.getHobbies().add("  ");
        person.getHobbies().add("gaming");

        validate(person);
    }

}
