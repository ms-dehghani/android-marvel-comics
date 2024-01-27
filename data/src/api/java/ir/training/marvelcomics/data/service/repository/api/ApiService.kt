package ir.training.marvelcomics.data.service.repository.api

import ir.training.marvelcomics.data.service.dto.api.base.BaseResponse
import ir.training.marvelcomics.data.service.dto.api.comic.ComicResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/v1/public/comics/{id}")
    suspend fun getComicById(
        @Path("id") id: Int,
    ): BaseResponse<ComicResponse?>

    @GET("/v1/public/comics?limit={limit}}&offset={offset}")
    suspend fun getComicList(
        @Path("limit") limit: Int,
        @Path("offset") offset: Int,
    ): BaseResponse<ComicResponse>

}