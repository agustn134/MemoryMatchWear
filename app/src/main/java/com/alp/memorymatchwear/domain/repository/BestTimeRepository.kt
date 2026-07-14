package com.alp.memorymatchwear.domain.repository

interface BestTimeRepository {
    suspend fun getBestTime(): Long
    suspend fun saveBestTime(seconds: Long)
}
