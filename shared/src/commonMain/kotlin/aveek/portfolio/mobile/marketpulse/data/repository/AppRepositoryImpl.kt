package aveek.portfolio.mobile.marketpulse.data.repository

import aveek.portfolio.mobile.marketpulse.domain.model.User
import aveek.portfolio.mobile.marketpulse.domain.repository.AppRepository

class AppRepositoryImpl : AppRepository {
    override fun fetchUser(): User {
        return User("Aveek")
    }
}