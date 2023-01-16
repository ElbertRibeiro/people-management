package one.digitalinnovation.personapi.person

import one.digitalinnovation.personapi.dto.MessageResponseDTO
import one.digitalinnovation.personapi.exception.PersonNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/v2/people")
class PersonController(val personService: PersonService, val personServiceKt: PersonServiceKt) {

    @GetMapping
    fun listAll(): ResponseEntity<List<Person>> {
        return ResponseEntity.ok(personServiceKt.listAll())
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createPerson(@RequestBody personDTO: @Valid PersonDTO): MessageResponseDTO {
        return personService.createPerson(personDTO)
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Throws(PersonNotFoundException::class)
    fun findById(@PathVariable id: Long): PersonDTO {
        return personService.findById(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Throws(PersonNotFoundException::class)
    fun updateById(@PathVariable id: Long, @RequestBody personDTO: @Valid PersonDTO): MessageResponseDTO {
        return personService.updateById(id, personDTO)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Throws(PersonNotFoundException::class)
    fun deleteById(@PathVariable id: Long) {
        personService.delete(id)
    }
}