package com.elbertribeiro.peopleapi.person

import com.elbertribeiro.peopleapi.message.MessageResponseDTO
import com.elbertribeiro.peopleapi.exception.PersonNotFoundException
import io.swagger.v3.oas.annotations.Operation
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/v2/people")
class PersonController(val personService: PersonService) {

    @Operation(summary = "Endpoint to list for persons with Pageable", description = "Returns 200 if sucessful")
    @GetMapping
    fun listAllWithPageable(@RequestParam(required = false) idPerson: Long?,@RequestParam(required = false) pageable: Pageable): ResponseEntity<Page<Person>> {
        return ResponseEntity.ok(personService.listAllWithPageable(idPerson, pageable))
    }
    @Operation(summary = "Endpoint to list", description = "Returns 200 if sucessful")
    @GetMapping("/list")
    fun listAll(): ResponseEntity<List<Person>> {
        return ResponseEntity.ok(personService.listAll())
    }

    @PostMapping
    fun createPerson(@RequestBody personDTO: @Valid PersonDTO): ResponseEntity<MessageResponseDTO> {
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.createPerson(personDTO))
    }

    @PutMapping("/{id}")
    @Throws(PersonNotFoundException::class)
    fun updateById(@PathVariable id: Long, @RequestBody personDTO: @Valid PersonDTO): ResponseEntity<MessageResponseDTO> {
        return ResponseEntity.ok(personService.updateById(id, personDTO))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Throws(PersonNotFoundException::class)
    fun deleteById(@PathVariable id: Long) {
        personService.delete(id)
    }
}