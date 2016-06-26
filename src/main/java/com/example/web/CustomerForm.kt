package com.example.web

import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class CustomerForm(@field:NotNull
						@field:Size(min = 1, max = 127) var firstName: String? = null,
						@field:NotNull
						@field:Size(min = 1, max = 127) var lastName: String? = null) {
}