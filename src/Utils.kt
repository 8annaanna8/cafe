fun getRubCurrencyEnding(amount: Int): String {
    return when {
        amount % 10 == 1 && amount % 100 != 11 -> "рубль"
        amount % 10 in 2..4 && (amount % 100 < 10 || amount % 100 > 20) -> "рубля"
        else -> "рублей"
    }
}
