package org.example.project.model

import kotlinx.serialization.Serializable

@Serializable
data class CastMember(
    val person: Person,
    val character: Character
)

@Serializable
data class Person(
    val id: Int,
    val name: String,
    val image: ImageInfo? = null
)

@Serializable
data class Character(
    val id: Int,
    val name: String,
    val image: ImageInfo? = null
)

@Serializable
data class ImageInfo(
    val medium: String,
    val original: String
)