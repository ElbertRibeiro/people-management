package com.elbertribeiro.peopleapi.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class PersonNotFoundException(id: Long) : Exception("Person not found with ID $id")