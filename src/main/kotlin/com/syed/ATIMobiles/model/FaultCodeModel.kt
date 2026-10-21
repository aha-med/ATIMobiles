package com.syed.ATIMobiles.model

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

data class FaultCodeModel(
    @field:NotBlank(message = "id required")
    @field:NotEmpty(message = "id must")
    @field:Size(max = 2, message = "id must not exceed 2 characters")
    val id : String = "",
    val code : String = "",
    val name : String = ""
)
