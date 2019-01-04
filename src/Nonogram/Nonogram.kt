package Nonogram

class Nonogram(var height : Int, var width : Int) {
    var horizontalLines : Array<List<Int>> = Array(height) {listOf<Int>()}
    var verticalLines : Array<List<Int>> = Array(width) {listOf<Int>()}
    var field : Array<IntArray> = Array(height) { IntArray(width) {0} }

    constructor(horizontalLines : Array<List<Int>>, verticalLines : Array<List<Int>>) :
            this(horizontalLines.size, verticalLines.size) {
        this.horizontalLines = horizontalLines.copyOf()
        this.verticalLines = verticalLines.copyOf()
    }

    fun isValid() : Boolean {
        val isHorizontalValid: Boolean = horizontalLines.all { it.sum() <= width && it.all { elem -> elem > 0 } }
        val isVerticalValid: Boolean = verticalLines.all { it.sum()  <=  height  && it.all { elem -> elem > 0} }
        return isHorizontalValid && isVerticalValid
    }

    fun isRowSolved() {}
}