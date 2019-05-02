package com.unitri.table

import com.unitri.gramar.Delimiters
import com.unitri.gramar.Keywords
import com.unitri.gramar.Operators

data class Token(
    val tokenClass: TokenClass,
    val image: String,
    val line: Int?,
    val column: Int?
) {

    enum class TokenClass(val value: String) {

        CLI("Literal inteiro"),
        CLR("Literal real"),
        CLL("Literal lógico"),
        CLS("Constante literal String"),
        DELIMITER("Delimitador"),
        KEYWORD("Palavra reservada"),
        OPERATOR("Operador"),
        ID("Identificador");

        companion object {

            fun getClass(letter: String): TokenClass {
                return when {
                    letter.matches("([0-9]+)".toRegex()) -> CLI
                    letter.matches("([0-9]+.[0-9]+)".toRegex()) -> CLR
                    letter.matches("(vero|falso)".toRegex()) -> CLL
                    letter.matches("\".*\"".toRegex()) -> CLS
                    Delimiters.isDelimiter(letter) -> DELIMITER
                    Keywords.isKeyword(letter) -> KEYWORD
                    Operators.isOperator(letter) -> OPERATOR
                    else -> ID
                }
            }

            fun literalConstants() = listOf(CLI.value, CLR.value, CLL.value, CLS.value, ID.value)
        }
    }

}

