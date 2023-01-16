package one.digitalinnovation.personapi.person

import one.digitalinnovation.personapi.exception.PersonNotFoundException
import org.modelmapper.ModelMapper
import org.springframework.stereotype.Service

@Service
class PersonServiceKt(val personRepository: PersonRepository) {
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

    @Throws(PersonNotFoundException::class)
    fun verifyIfExists(id: Long): Person? {
        return personRepository.findById(id).orElseThrow { PersonNotFoundException(id) }
    }
}
