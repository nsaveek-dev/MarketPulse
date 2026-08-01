package aveek.portfolio.mobile.marketpulse

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform