import java.io.File
import kotlin.system.measureTimeMillis
import kotlin.test.assertEquals

abstract class AoCPuzzle {
    private val name = this::class.simpleName!!
    private val day = name.substringAfter("Day").toInt()
    private val input: List<String> by lazy {
        if (!File("resources/$name.txt").exists()) downloadInput(day)
        readInput(name)
    }

    protected open val part1Test = Test()
    protected open val part2Test = Test()

    protected open fun part1(input: List<String>): Number = 0
    protected open fun part2(input: List<String>): Number = 0

    protected fun testPart1() = assertEquals(part1Test.expected, part1(part1Test.input.lines()))
    protected fun testPart2() = assertEquals(part2Test.expected, part2(part2Test.input.lines()))

    protected fun runPart1() = timed { part1(input) }
    protected fun runPart2() = timed { part2(input) }

    protected data class Test(val expected: Number = 0, val input: String = "")
}
