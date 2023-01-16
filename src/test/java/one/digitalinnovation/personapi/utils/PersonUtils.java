package one.digitalinnovation.personapi.utils;

import one.digitalinnovation.personapi.person.PersonDTO;
import one.digitalinnovation.personapi.person.Person;

import java.time.LocalDate;
import java.util.Collections;

public class PersonUtils {

    private static final String FIRST_NAME = "Rodrigo";
    private static final String LAST_NAME = "Peleias";
    private static final String CPF_NUMBER = "369.333.878-79";
    private static final long PERSON_ID = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(2010, 10, 1);

    public static PersonDTO createFakeDTO() {
        return new PersonDTO(
                FIRST_NAME,
                LAST_NAME,
                CPF_NUMBER,
                "04-04-2010",
                Collections.singletonList(PhoneUtils.createFakeDTO()));
    }

    public static Person createFakeEntity() {
        return new Person(
                PERSON_ID,
                FIRST_NAME,
                LAST_NAME,
                CPF_NUMBER,
                BIRTH_DATE,
                Collections.singletonList(PhoneUtils.createFakeEntity()));
    }
}
