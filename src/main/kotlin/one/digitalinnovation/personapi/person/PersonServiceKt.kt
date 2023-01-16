package one.digitalinnovation.personapi.person

import org.springframework.stereotype.Service

@Service
class PersonServiceKt(val personRepository: PersonRepository) {
    fun listAll(): List<Person> {
        return personRepository.findAll()
    }
}
