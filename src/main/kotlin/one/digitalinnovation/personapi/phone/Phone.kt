package one.digitalinnovation.personapi.phone

import javax.persistence.*

@Entity
class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var type: PhoneType? = null

    @Column(nullable = false)
    var number: String? = null
}