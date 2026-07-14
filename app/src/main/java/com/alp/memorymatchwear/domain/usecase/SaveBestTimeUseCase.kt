package com.alp.memorymatchwear.domain.usecase

import com.alp.memorymatchwear.domain.repository.BestTimeRepository

class SaveBestTimeUseCase(private val repository: BestTimeRepository) {
    suspend operator fun invoke(seconds: Long) = repository.saveBestTime(seconds)
}
