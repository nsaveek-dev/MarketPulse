package aveek.portfolio.mobile.marketpulse.domain.repository

import aveek.portfolio.mobile.marketpulse.domain.model.User

interface AppRepository {
    fun fetchUser() : User
}