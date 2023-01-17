package com.elbertribeiro.peopleapi.status

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/status")
class StatusController {
    @GetMapping
    fun getStatus(): ResponseEntity<String> {
        return ResponseEntity("Ok", HttpStatus.OK)
    }
}