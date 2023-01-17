package one.digitalinnovation.personapi.person

import one.digitalinnovation.personapi.dto.MessageResponseDTO
import one.digitalinnovation.personapi.exception.PersonNotFoundException
import org.modelmapper.ModelMapper
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class PersonService(val personRepository: PersonRepository) {
    fun listAll(id: Long?, pageable: Pageable): Page<Person> {
        id ?.let { return personRepository.findAllById(id, pageable) }
        return personRepository.findAll(pageable)
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
        return createMessageResponse(personRepository.save(ModelMapper().map(personDTO, Person::class.java))
            .id, "Updated person with ID ")
    }

    private fun createMessageResponse(id: Long, message: String): MessageResponseDTO {
        val messageResponseDTO = MessageResponseDTO()
        messageResponseDTO.message = message + id
        return messageResponseDTO
    }

    @Throws(PersonNotFoundException::class)
    fun verifyIfExists(id: Long): Person? {
        return personRepository.findById(id).orElseThrow {
            PersonNotFoundException(
                id
            )
        }
    }
}
