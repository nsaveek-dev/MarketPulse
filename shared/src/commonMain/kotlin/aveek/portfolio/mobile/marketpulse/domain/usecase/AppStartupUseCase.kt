package aveek.portfolio.mobile.marketpulse.domain.usecase

import aveek.portfolio.mobile.marketpulse.domain.repository.AppRepository

class AppStartupUseCase ( private val repository: AppRepository) {
    suspend operator fun invoke() {
        repository.fetchUser()
    }
}