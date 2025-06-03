class Salary(
    val value: Int, // базовая ставка
    val currency: String, //валюта ("ru"/"usd")
 ) {
    fun calculate(workYears: Int): Int {
        // перемножаем базовую ставку, коэффициент и стаж, получаем сумму премии
        val prize = workYears * 0.1 * value
        val totalSalary = value + workYears * 0.1 * value //a * (5 +10c)
        return (value * (workYears * 0.1 + 1)).toInt()
    } // расписать склонение валют

    fun getRubCurrencyEnding(amount: Int): String {
        return when {
            amount % 10 == 1 && amount % 100 != 11 -> "рубль"
            amount % 10 in 2..4 && (amount % 100 < 10 || amount % 100 > 20) -> "рубля"
            else -> "рублей"
        }
    }
}
