package ir.training.marvelcomics.data.service.repository.api.utils

import ir.training.marvelcomics.data.BuildConfig
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.math.BigInteger
import java.security.MessageDigest
import javax.inject.Inject

class AuthenticateInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original: Request = chain.request()
        val originalHttpUrl: HttpUrl = original.url()

        val currentTimeMillis = System.currentTimeMillis().toString()
        val url: HttpUrl = originalHttpUrl.newBuilder()
            .addQueryParameter("apikey", BuildConfig.API_KEY)
            .addQueryParameter(
                "hash",
                md5(
                    currentTimeMillis + BuildConfig.API_HASH + BuildConfig.API_KEY
                )
            ).addQueryParameter("ts", currentTimeMillis)
            .build()

        // Request customization: add request headers
        val requestBuilder: Request.Builder = original.newBuilder()
            .url(url)

        val request: Request = requestBuilder.build()
        return chain.proceed(request)
    }

    fun md5(input: String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }
}