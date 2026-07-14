package com.alp.memorymatchwear.domain.usecase

import com.alp.memorymatchwear.domain.repository.BestTimeRepository

class GetBestTimeUseCase(private val repository: BestTimeRepository) {
    suspend operator fun invoke(): Long = repository.getBestTime()
}
