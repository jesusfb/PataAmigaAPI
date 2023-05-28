package com.example.kotlindemo.model

import org.springframework.lang.Nullable
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity(name = "users")
data class User (
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0,

    @get: NotBlank
    var name: String = "",

    @get: NotBlank
    var email: String = "",

    @get: NotBlank
    var password: String = "",

    @get: NotBlank
    var birth: String = "",

    @get: NotBlank
    var location: String = "",

    @Column(name = "profile_pic")
    var profilePic: String = "",

    @get: NotBlank
    var banner: String = "",

    @get: NotBlank
    var phone: String = "",

    @Nullable
    var instagram: String? = "",

    @Nullable
    var facebook: String? = "",

    @Nullable
    var whatsapp: String? = "",

) {
    @PrePersist
    @PreUpdate
    fun hashPassword() {
        val encoder = BCryptPasswordEncoder()
        password = encoder.encode(password)
    }
}