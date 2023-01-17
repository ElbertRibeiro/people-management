package one.digitalinnovation.personapi.phone

import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

class PhoneDTO(
    @field:Enumerated(EnumType.STRING) var type: PhoneType,
    var number: @Size(min = 13, max = 14) @NotEmpty String
) {
    var id: Long = 0

}