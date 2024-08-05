package com.example.kotlin_portfolio.model

import com.google.gson.annotations.SerializedName

data class EmotionDetectionResponse(
    @SerializedName("probability") val probability: Double,
    @SerializedName("rectangle") val rectangle: Rectangle,
    @SerializedName("emotion") val emotion: Emotion
)

data class Rectangle(
    @SerializedName("left") val left: Double,
    @SerializedName("top") val top: Double,
    @SerializedName("right") val right: Double,
    @SerializedName("bottom") val bottom: Double
)

data class Emotion(
    @SerializedName("value") val value: String,
    @SerializedName("probability") val probability: Double,
    @SerializedName("sentiments") val sentiments: Sentiments
)

data class Sentiments(
    @SerializedName("angry") val angry: Double,
    @SerializedName("disgust") val disgust: Double,
    @SerializedName("fear") val fear: Double,
    @SerializedName("happy") val happy: Double,
    @SerializedName("sad") val sad: Double,
    @SerializedName("surprise") val surprise: Double,
    @SerializedName("neutral") val neutral: Double
)
