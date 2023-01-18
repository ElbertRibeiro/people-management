package com.elbertribeiro.peopleapi.root

import com.elbertribeiro.peopleapi.person.PersonController
import io.swagger.v3.oas.annotations.Operation
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RootController {

    @Operation(summary = "Endpoint of collections", description = "Returns 200 if sucessful")
    @GetMapping
    fun getEntryPointRoot(): ResponseEntity<RootEntryPoint> {
        val rootEntryPoint = RootEntryPoint()
            .add(linkTo(methodOn(PersonController::class.java)
                .listAll())
                .withRel("list-persons"))

        return ResponseEntity.ok(rootEntryPoint)
    }
}
