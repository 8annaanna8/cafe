
import resources.StringRes
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import kotlin.coroutines.cancellation.CancellationException

open class Employee(
    open val id: Int,
    open val firstName: String,
    open val lastName: String,
    open val middleName: String? = null,
    open val birthDate: LocalDate,
    open val language: Language, //язык ("ru"/"en")
    open val hireDate: LocalDate, // дата приема на работу
    open val jobTitle: String,
    open val salary: Int,
    open val value: Int,
) {

    open fun greet(firstName: String) {
        println("${StringRes.GREETING.getString(language = language)}, $firstName!")
    }

    private val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")

    open fun printPersonalCard() {
         //
        val workYears = calculateYearsFromStartDate(startDate = hireDate)
        val formattedBirthDate = birthDate.format(formatter)
       /* when (language) {
            Language.RUSSIAN -> println(StringRes.YOUR_PERSONAL_CARD.russian)
            Language.ENGLISH -> println(StringRes.YOUR_PERSONAL_CARD.english)
        }*/
        val yourPersonalCard = StringRes.YOUR_PERSONAL_CARD.getString(language = language)
        println("$yourPersonalCard:")

        val fullName = StringRes.FULL_NAME.getString(language = language)
        println("$fullName: $lastName $firstName ${middleName ?: ""}") // знак элвиса, если будет нал, то пусто


        val birthDate = StringRes.BIRTH_DATE.getString(language)
        println("$birthDate: $formattedBirthDate")

        val age = calculateYearsFromStartDate(startDate = this.birthDate)
        println("${StringRes.AGE.getString(language)}: ${formatYears(years = age, language = language)}")

        val experience = StringRes.EXPERIENCE.getString(language)
        println("$experience: ${formatYears(
            years = workYears,
            language = language,
        )}")

        val profession = StringRes.JOB_TITLE.getString(language)
        println("$profession: $jobTitle")

        val salary = Salary(value = value, currency = "ru")
            .calculate(workYears = workYears)

        val currency = StringRes.CURRENCY.getString(language)
        println("${StringRes.SALARY.getString(language)}: $salary " +
                formatCurrency(
                    currency = currency,
                    salary = salary,
                    language = language,
                )
        )

    }

    private fun calculateYearsFromStartDate(
        startDate: LocalDate,
        endDate: LocalDate = LocalDate.now() //дефолтное значение
    ): Int {
        val period = Period.between(startDate, endDate)
        val years = period.years
        return years
    }

    private fun formatYears(years: Int, language: Language): String {
        return "$years " + when (language) {
            Language.RUSSIAN ->
                when {
                years % 10 == 1 && years % 100 != 11 -> "год"
                years % 10 in 2..4 && years % 100 !in 12..14 -> "года"
                else -> "лет"
                }
            Language.ENGLISH, Language.GERMAN -> {
                if (years == 1) {
                    StringRes.YEAR.getString(language)
                } else {
                    StringRes.YEARS.getString(language)
                }
            }
        }
    }

    private fun formatCurrency(salary: Int, currency: String, language: Language): String {
        return currency + when (language) {
            Language.RUSSIAN -> getRubCurrencyEnding(amount = salary)
            Language.ENGLISH -> {
                if (salary == 1) {
                    "dollar"
                } else {
                    "dollars"
                }
            }
            Language.GERMAN -> {
                if (salary == 1) {
                    "euro"
                } else {
                    "euros"
                }
            }
        }
    }
}





 /*  private val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")

private fun calculateWorkYears(hireDate: LocalDate = this.hireDate): String {
    val today = LocalDate.now()
    val experience = Period.between(hireDate, today)
    val years = experience.years

    val experienceString = when {
        years % 10 == 1 && years % 100 != 11 -> "$years год"
        years % 10 in 2..4 && (years % 100 < 10 || years % 100 > 20) -> "$years года"
        else -> "$years лет"
    }

    // Форматируем дату найма
    val formattedHireDate = hireDate.format(formatter)

    return "$experienceString, дата найма: $formattedHireDate"
}
*/