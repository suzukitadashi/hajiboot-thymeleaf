package com.example.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "customers")
data class Customer(@Id @GeneratedValue var id: Int? = null,
					@Column(nullable = false) var firstName: String? = null,
					@Column(nullable = false) var lastName: String? = null,
					@ManyToOne(fetch = FetchTyle.LAZY) @JoinColumn(nullable = true, name = "userid") var user: User? = null) {

}