package com.alp.memorymatchwear.data.repository

import com.alp.memorymatchwear.data.datasource.BestTimeDataSource
import com.alp.memorymatchwear.domain.repository.BestTimeRepository

class BestTimeRepositoryImpl(private val ds: BestTimeDataSource) : BestTimeRepository {
    override suspend fun getBestTime() = ds.getBestTime()
    override suspend fun saveBestTime(s: Long) = ds.saveBestTime(s)
}
