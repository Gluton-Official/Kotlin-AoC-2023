package util

import java.math.BigInteger
import java.security.MessageDigest
import kotlin.time.measureTimedValue

fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray())).toString(16).padStart(32, '0')

fun <T> timed(block: () -> T): T = measureTimedValue(block).run {
    println("${value.toString().padEnd(20)} $duration")
    value
}

fun <T, R> findCycle(data: T, maxIterations: Long, uid: (T) -> R, transform: (T) -> T): LongRange {
    val ids = mutableListOf<R>()
    return 0..0L
}
