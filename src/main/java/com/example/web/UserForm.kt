package com.example.web

import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class UserForm(@field:NotNull
						@field:Size(min = 1, max = 127) var userid: String? = null,
						@field:NotNull
						@field:Size(min = 1, max = 127) var password: String? = null,
						@field:NotNull
						@field:Size(min = 1, max = 127) var username: String? = null) {
}