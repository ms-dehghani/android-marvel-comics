package ir.training.marvelcomics.data.service.repo.api

import ir.training.marvelcomics.data.service.dto.base.BaseResponse
import ir.training.marvelcomics.data.service.dto.comic.ComicResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/v1/public/comics/{id}")
    suspend fun getComicById(
        @Path("id") id: Int,
    ): BaseResponse<ComicResponse?>

}