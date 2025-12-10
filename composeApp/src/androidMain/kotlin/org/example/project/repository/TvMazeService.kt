package org.example.project.repository

import org.example.project.model.CastMember
import retrofit2.http.GET
import retrofit2.http.Path

interface TvMazeService {
    @GET("shows/{id}/cast")
    suspend fun getShowCast(@Path("id") showId: Int): List<CastMember>
}
