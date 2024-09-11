package org.reringuy.kmmproject

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform