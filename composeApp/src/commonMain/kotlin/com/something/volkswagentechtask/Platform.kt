package com.something.volkswagentechtask

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform