package com.elbertribeiro.peopleapi.person

import com.elbertribeiro.peopleapi.phone.Phone
import java.time.LocalDate
import javax.persistence.*

@Entity
class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @Column(nullable = false)
    var firstName: String? = null

    @Column(nullable = false)
    var lastName: String? = null

    @Column(nullable = false, unique = true)
    var cpf: String? = null
    var birthDate: LocalDate? = null

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE])
    var phones: List<Phone>? = null
}