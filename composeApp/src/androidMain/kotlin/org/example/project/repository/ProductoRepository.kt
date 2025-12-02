package org.example.project.repository

import org.example.project.model.Producto

class ProductoRepository {

    suspend fun getListaProductos(): Result<List<Producto>?>{
        return try{
            val response = RetrofitInstance.api.getProductos()

            if(response.isSuccessful && response.body() != null){
                Result.success(response.body()!!)
            }else{
                Result.failure(Exception("Error: ${response.code()} - ${response.message()}"))
            }
        }catch (e: Exception){
            Result.failure(e)
        }
    }

    suspend fun getProducto(id: String): Result<Producto>{
        return try{
            val response = RetrofitInstance.api.getProductoById(id)

            if(response.isSuccessful && response.body() != null){
                Result.success(response.body()!!)
            }else{
                Result.failure(Exception("Error: ${response.code()} - ${response.message()}"))
            }
        }catch(e: Exception){
            Result.failure(e)
        }
    }
}