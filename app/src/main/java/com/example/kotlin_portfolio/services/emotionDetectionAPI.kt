package com.example.kotlin_portfolio.services

import android.content.Context
import android.util.Log
import com.example.kotlin_portfolio.model.EmotionDetectionResponse
import com.google.common.reflect.TypeToken
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.InputStreamReader
import java.lang.reflect.Type

data class ApiKeys(
    @SerializedName("x-rapidapi-key") val apiKey: String,
    @SerializedName("x-rapidapi-host-emotionDetection") val apiHost: String
)

suspend fun fetchEmotionDetection(context: Context): List<EmotionDetectionResponse>? {
    Log.d("API", "Called fetchEmotionDetection function!")

    val client = OkHttpClient()

    // Read the JSON file to get API keys
    val inputStream = context.assets.open("keys/apiKeys.json")
    val reader = InputStreamReader(inputStream)
    val apiKeys = Gson().fromJson(reader, ApiKeys::class.java)
    reader.close()
    Log.d("API", "API KEY = ${apiKeys.apiKey}")
    Log.d("API", "API HOST = ${apiKeys.apiHost}")

    // Prepare the request body
    val mediaType = "application/json".toMediaTypeOrNull()
    val body = "{\"url\":\"https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=668&q=80\"}"
        .toRequestBody(mediaType)

    // Build the request
    val request = Request.Builder()
        .url("https://emotion-detection2.p.rapidapi.com/emotion-detection")
        .post(body)
        .addHeader("x-rapidapi-key", apiKeys.apiKey)
        .addHeader("x-rapidapi-host", apiKeys.apiHost)
        .addHeader("Content-Type", "application/json")
        .build()

    return withContext(Dispatchers.IO) {
        val response = client.newCall(request).execute()
        if (response.isSuccessful) {
            val responseBody = response.body.string()
            Log.d("API", "Response: $responseBody")

            // Define the type for the response
            val listType: Type = object : TypeToken<List<EmotionDetectionResponse>>() {}.type

            // Parse the JSON response to EmotionDetectionResponse
            Gson().fromJson<List<EmotionDetectionResponse>>(responseBody, listType)
        } else {
            val errorBody = response.body.string()
            Log.d("API", "Request failed with status code: ${response.code}")
            Log.d("API", "Error body: $errorBody")
            null
        }
    }
}

