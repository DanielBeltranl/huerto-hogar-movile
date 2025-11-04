package org.example.project.repository

data class Product (

    val id: Int,
    val code: String,
    val name: String,
    val price : Float,
    val description: String,
    val category: String,
    val stock: Int,
    val image: String
)
val productos = mutableListOf(
    Product(
        id = 1,
        code = "FR001",
        name = "Manzanas Fuji",
        price = 1200f,
        description = "Manzanas Fuji crujientes y dulces, cultivadas en el Valle del Maule. Perfectas para meriendas saludables o como ingrediente en postres.",
        category = "Frutas",
        stock = 150,
        image = "https://via.placeholder.com/300?text=Manzana+Fuji"
    ),
    Product(
        id = 2,
        code = "FR002",
        name = "Naranjas Valencia",
        price = 1000f,
        description = "Jugosas y ricas en vitamina C, estas naranjas Valencia son ideales para zumos frescos y refrescantes.",
        category = "Frutas",
        stock = 200,
        image = "https://via.placeholder.com/300?text=Naranja+Valencia"
    ),
    Product(
        id = 3,
        code = "FR003",
        name = "Plátanos Cavendish",
        price = 800f,
        description = "Plátanos maduros y dulces, perfectos para el desayuno o como snack energético.",
        category = "Frutas",
        stock = 250,
        image = "https://via.placeholder.com/300?text=Platano+Cavendish"
    ),
    Product(
        id = 4,
        code = "VR001",
        name = "Zanahorias Orgánicas",
        price = 900f,
        description = "Zanahorias crujientes cultivadas sin pesticidas en la Región de O'Higgins.",
        category = "Verduras",
        stock = 100,
        image = "https://via.placeholder.com/300?text=Zanahoria+Organica"
    ),
    Product(
        id = 5,
        code = "VR002",
        name = "Espinacas Frescas",
        price = 700f,
        description = "Espinacas frescas y nutritivas, perfectas para ensaladas y batidos verdes.",
        category = "Verduras",
        stock = 80,
        image = "https://via.placeholder.com/300?text=Espinaca+Fresca"
    ),
    Product(
        id = 6,
        code = "VR003",
        name = "Pimientos Tricolores",
        price = 1500f,
        description = "Pimientos rojos, amarillos y verdes, ideales para salteados y platos coloridos.",
        category = "Verduras",
        stock = 120,
        image = "https://via.placeholder.com/300?text=Pimientos+Tricolores"
    ),
    Product(
        id = 7,
        code = "PO001",
        name = "Miel Orgánica",
        price = 5000f,
        description = "Miel pura y orgánica producida por apicultores locales.",
        category = "Productos Orgánicos",
        stock = 50,
        image = "https://via.placeholder.com/300?text=Miel+Organica"
    ),
    Product(
        id = 8,
        code = "PO003",
        name = "Quinua Orgánica",
        price = 3500f,
        description = "Quinua orgánica de alta calidad, rica en proteínas y nutrientes esenciales.",
        category = "Productos Orgánicos",
        stock = 60,
        image = "https://via.placeholder.com/300?text=Quinua+Organica"
    ),
    Product(
        id = 9,
        code = "PL001",
        name = "Leche Entera",
        price = 1500f,
        description = "Leche entera fresca y nutritiva, perfecta para toda la familia.",
        category = "Lácteos",
        stock = 200,
        image = "https://via.placeholder.com/300?text=Leche+Entera"
    )
)