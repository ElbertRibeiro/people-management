package one.digitalinnovation.personapi.person

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<Person, Long?> {
    override fun findAll(pageable: Pageable): Page<Person>
    fun findAllById(idPerson: Long, pageable:Pageable): Page<Person>
}