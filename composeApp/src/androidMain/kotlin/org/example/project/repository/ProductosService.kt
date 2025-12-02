package org.example.project.repository

import org.example.project.model.Producto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductosService {

    @GET("productos/listar")
    suspend fun getProductos(): Response<List<Producto>>

    @GET("productos/buscar/{id}")
    suspend fun getProductoById(
        @Path("id") id: String
    ): Response<Producto>
}