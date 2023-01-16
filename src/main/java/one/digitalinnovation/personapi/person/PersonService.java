package one.digitalinnovation.personapi.person;

import one.digitalinnovation.personapi.dto.MessageResponseDTO;
import one.digitalinnovation.personapi.exception.PersonNotFoundException;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = new ModelMapper().map(personDTO, Person.class);
        return createMessageResponse(personRepository.save(personToSave).getId(), "Created person with ID ");
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        return new ModelMapper().map(verifyIfExists(id), PersonDTO.class);
    }

    public void delete(Long id) throws PersonNotFoundException {
        verifyIfExists(id);
        personRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(id);
        Person updatedPerson = personRepository.save(new ModelMapper().map(personDTO, Person.class));
        return createMessageResponse(updatedPerson.getId(), "Updated person with ID ");
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        MessageResponseDTO messageResponseDTO = new MessageResponseDTO();
        messageResponseDTO.setMessage(message + id);
        return messageResponseDTO;
    }
}
