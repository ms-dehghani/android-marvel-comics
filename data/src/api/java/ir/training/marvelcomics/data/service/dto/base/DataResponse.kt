package ir.training.marvelcomics.data.service.dto.base

class DataResponse <T>(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<T>,
    val total: Int
)