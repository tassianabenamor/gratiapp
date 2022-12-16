package br.edu.infnet.gratiapp.repository

import br.edu.infnet.gratiapp.models.Endereco
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

class ApiService () {

    companion object {

        private lateinit var INSTANCE: Retrofit
        private const val BASE_URL = "https://viacep.com.br/"

        private fun getRetrofitInstance(): Retrofit{
            val http = OkHttpClient.Builder()
            if(!::INSTANCE.isInitialized){
                INSTANCE = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(http.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return INSTANCE
        }

        fun createPostService(): PostService {
            return getRetrofitInstance().create(PostService::class.java)
        }
    }
}

interface PostService {
    @GET("ws/{cep}/json/")
    fun getCep(@Path("cep") cep: String):Call<Endereco>
}
