package ir.training.marvelcomics.data.service.dto.api.base

class BaseResponse<T>(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    val data: DataResponse<T>,
    val status: String
)