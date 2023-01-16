package one.digitalinnovation.personapi.person

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v2/people")
class PersonControllerKt(val personService: PersonService) {

    @GetMapping
    fun listAll(): ResponseEntity<List<PersonDTO>>{
        return ResponseEntity.ok(personService.listAll())
    }
}