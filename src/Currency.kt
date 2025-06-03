enum class Currency {
    RUBLE,
    DOLLAR,
}

fun definitionCurrency(currency: Currency) {
    when (currency) {
        Currency.RUBLE -> println("рубли")
        Currency.DOLLAR -> println("dollar")
    }
}
