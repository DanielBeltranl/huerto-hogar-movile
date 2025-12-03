package org.example.project.model

data class Producto(
    val id_fruta: String,
    val nombre: String,
    val precio: Double,
    val categoria : String,
    val stock: Int,
    val descripcion : String
)