import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.InputStreamReader

data class ApiKeys(
    @SerializedName("x-rapidapi-key") val apiKey: String,
    @SerializedName("x-rapidapi-host") val apiHost: String
)

suspend fun fetchAirbnbPrices(context: Context): String? {
    val client = OkHttpClient()

    // Read the JSON file
    val inputStream = context.assets.open("keys/airbnbKey.json")
    val reader = InputStreamReader(inputStream)
    val apiKeys = Gson().fromJson(reader, ApiKeys::class.java)
    withContext(Dispatchers.IO) {
        reader.close()
    }

    val request = Request.Builder()
        .url("https://airbnb19.p.rapidapi.com/api/v1/searchPropertyV2?category=TAB_8225&totalRecords=10&currency=USD&adults=1")
        .get()
        .addHeader("x-rapidapi-key", apiKeys.apiKey)
        .addHeader("x-rapidapi-host", apiKeys.apiHost)
        .build()

    return withContext(Dispatchers.IO) {
        val response: Response = client.newCall(request).execute()

        if (response.isSuccessful) {
            val responseBody = response.body?.string()
            Log.d("API", "Response: $responseBody")
            responseBody
        } else {
            val errorBody = response.body?.string()
            Log.d("API", "Request failed with status code: ${response.code}")
            Log.d("API", "Error body: $errorBody")
            "Request failed with status code: ${response.code}, Error body: $errorBody"
        }
    }
}