package dev.vladleesi.yac

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform