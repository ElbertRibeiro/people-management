package one.digitalinnovation.personapi.person

import one.digitalinnovation.personapi.dto.MessageResponseDTO
import one.digitalinnovation.personapi.exception.PersonNotFoundException
import org.modelmapper.ModelMapper
import org.springframework.stereotype.Service

@Service
class PersonService(val personRepository: PersonRepository) {
    fun listAll(): List<Person> {
        return personRepository.findAll()
    }

    @Throws(PersonNotFoundException::class)
    fun findById(id: Long): PersonDTO {
        return ModelMapper().map(verifyIfExists(id), PersonDTO::class.java)
    }

    @Throws(PersonNotFoundException::class)
    fun delete(id: Long) {
        verifyIfExists(id)
        personRepository.deleteById(id)
    }

    fun createPerson(personDTO: PersonDTO): MessageResponseDTO? {
        val personToSave = ModelMapper().map(personDTO, Person::class.java)
        return createMessageResponse(personRepository.save(personToSave).id, "Created person with ID ")
    }

    @Throws(PersonNotFoundException::class)
    fun updateById(id: Long, personDTO: PersonDTO): MessageResponseDTO {
        verifyIfExists(id)
        val updatedPerson = personRepository.save(ModelMapper().map(personDTO, Person::class.java))
        return createMessageResponse(updatedPerson.id, "Updated person with ID ")
    }

    private fun createMessageResponse(id: Long, message: String): MessageResponseDTO {
        val messageResponseDTO = MessageResponseDTO()
        messageResponseDTO.message = message + id
        return messageResponseDTO
    }

    @Throws(PersonNotFoundException::class)
    fun verifyIfExists(id: Long): Person? {
        return personRepository.findById(id).orElseThrow { PersonNotFoundException(id) }
    }
}
