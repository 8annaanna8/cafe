import java.time.LocalDate

fun getRubCurrencyEnding(amount: Int): String {
    return when {
        amount % 10 == 1 && amount % 100 != 11 -> "рубль"
        amount % 10 in 2..4 && (amount % 100 < 10 || amount % 100 > 20) -> "рубля"
        else -> "рублей"
    }
}


/*fun getCurrencyDeclensionRuble(amount: Int, currency: String): String {
    val lastDigit = amount % 10
    val lastTwoDigits = amount % 100

    return when(currency) {
        "ru" -> {
            when {
                lastTwoDigits in 11..19 -> "$amount рублей" // Для чисел от 11 до 19
                lastDigit == 1 -> "$amount рубль" // Например, "1 рубль"
                lastDigit in 2..4 -> "$amount рубля" // Например, "2 рубля", "3 рубля", "4 рубля"
                else -> "$amount рублей"
            }
        }

        "usd" -> {
            when {
                lastTwoDigits in 11..19 -> "$amount долларов" // Для чисел от 11 до 19
                lastDigit == 1 -> "$amount доллар" // Например, "1 доллар"
                lastDigit in 2..4 -> "$amount доллара" // Например, "2 доллара", "3 доллара", "4 доллара"
                else -> "$amount долларов" // Например, "5 долларов"
            }

        }

        else -> "Неизвестная валюта"
    }
} */