package one.digitalinnovation.personapi.utils;

import one.digitalinnovation.personapi.phone.PhoneDTO;
import one.digitalinnovation.personapi.phone.Phone;
import one.digitalinnovation.personapi.phone.PhoneType;

public class PhoneUtils {

    private static final String PHONE_NUMBER = "1199999-9999";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final long PHONE_ID = 1L;

    public static PhoneDTO createFakeDTO() {
        PhoneDTO phoneDTO = new PhoneDTO(PHONE_TYPE, PHONE_NUMBER);
        return phoneDTO;
    }

    public static Phone createFakeEntity() {
        Phone phone = new Phone();
        phone.setId(PHONE_ID);
        phone.setType(PHONE_TYPE);
        phone.setNumber(PHONE_NUMBER);
        return phone;
    }
}
