package one.digitalinnovation.personapi.person;

import one.digitalinnovation.personapi.dto.MessageResponseDTO;
import one.digitalinnovation.personapi.exception.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
public class PersonService {

    private final PersonServiceKt personServiceKt;
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository, PersonServiceKt personServiceKt) {
        this.personRepository = personRepository;
        this.personServiceKt = personServiceKt;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = new ModelMapper().map(personDTO, Person.class);
        return createMessageResponse(personRepository.save(personToSave).getId(), "Created person with ID ");
    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        personServiceKt.verifyIfExists(id);
        Person updatedPerson = personRepository.save(new ModelMapper().map(personDTO, Person.class));
        return createMessageResponse(updatedPerson.getId(), "Updated person with ID ");
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        MessageResponseDTO messageResponseDTO = new MessageResponseDTO();
        messageResponseDTO.setMessage(message + id);
        return messageResponseDTO;
    }
}
