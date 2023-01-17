package com.elbertribeiro.peopleapi.person

import com.elbertribeiro.peopleapi.phone.PhoneDTO
import io.swagger.annotations.ApiModelProperty
import org.hibernate.validator.constraints.br.CPF
import javax.validation.Valid
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

class PersonDTO(
    @field:ApiModelProperty(
        notes = "Person name",
        example = "joao",
        required = true
    )
    var firstName: @Size(min = 2, max = 100) @NotEmpty String?,
    var lastName: @Size(min = 2, max = 100) @NotEmpty String?,
    var cpf: @CPF @NotEmpty String?,
    var birthDate: @NotEmpty String?,
    phones: List<PhoneDTO>
) {
    @ApiModelProperty(notes = "Person ID", example = "1", required = true)
    var id: Long? = null

    private var phones: @Valid @NotEmpty List<PhoneDTO>

    init {
        this.phones = phones
    }

    fun getPhones(): List<PhoneDTO> {
        return phones
    }

    fun setPhones(phones: List<PhoneDTO>) {
        this.phones = phones
    }
}