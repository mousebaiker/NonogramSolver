package test

import Nonogram.Nonogram
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.WordSpec

class NonogramTests : WordSpec({
    "Nonogram" should {
        "be valid if empty" {
            val nono = Nonogram(height = 0, width = 0)
            nono.isValid() shouldBe true
        }

        "be valid if generated without lines" {
            val nono = Nonogram(height = 5, width = 3)
            nono.isValid() shouldBe true
        }

        "be valid if lines are valid" {
            val horizontalLines : Array<List<Int>> = arrayOf(
                listOf(1),
                listOf(1, 1),
                listOf(2)
            )
            val verticalLines : Array<List<Int>> = arrayOf(
                listOf(3),
                listOf(2)
            )
            val nono = Nonogram(horizontalLines, verticalLines)
            nono.isValid() shouldBe true
        }

        "be invalid if lines contain numbers exceeding field size" {
            val horizontalLines : Array<List<Int>> = arrayOf(
                listOf(3),
                listOf(1, 1),
                listOf(2)
            )
            val verticalLines : Array<List<Int>> = arrayOf(
                listOf(4),
                listOf(2)
            )
            val nono = Nonogram(horizontalLines, verticalLines)
            nono.isValid() shouldBe false
        }

        "be invalid if lines contain negative numbers" {
            val horizontalLines : Array<List<Int>> = arrayOf(
                listOf(-1)
            )
            val verticalLines : Array<List<Int>> = arrayOf(
                listOf(-3),
                listOf(0)
            )
            val nono = Nonogram(horizontalLines, verticalLines)
            nono.isValid() shouldBe false
        }
    }
})
