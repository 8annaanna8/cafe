
import resources.StringRes
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

open class Employee(
    open val id: Int,
    open val firstName: String,
    open val lastName: String,
    open val middleName: String? = null,
    open val birthDate: LocalDate,
    open val language: Language, //язык ("ru"/"en")
    open val hireDate: LocalDate, // дата приема на работу
    open val jobTitle: String,
    open val nationality : Nationality,
) {

    private val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
    open fun greet(firstName: String) {
        println("${StringRes.GREETING.getString(language = language)}, $firstName!")
    }

    open fun printPersonalCard() {
        val age = calculateYearsFromStartDate(startDate = birthDate)
        val workYears = calculateYearsFromStartDate(startDate = hireDate)
        val formattedBirthDate = birthDate.format(formatter)
       /* when (language) {
            Language.RUSSIAN -> println(StringRes.YOUR_PERSONAL_CARD.russian)
            Language.ENGLISH -> println(StringRes.YOUR_PERSONAL_CARD.english)
        }*/
        val yourPersonalCard = StringRes.YOUR_PERSONAL_CARD.getString(language = language)
        println(yourPersonalCard)
        val fullName = StringRes.FULL_NAME.getString(language = language)
        println("$fullName $lastName $firstName ${middleName ?: ""}") // знак элвиса, если будет нал, то пусто
        val birthDate = StringRes.BIRTH_DATE.getString(language)
        println("$birthDate $formattedBirthDate")
       /* val ageInLanguage = StringRes.AGE.getString(language)
        val ageInLanguage = StringRes.AGE.getString (language = language).
        println("$ageInLanguage")*/
        val experience = StringRes.EXPERIENCE.getString(language)
        println("$experience ${formatYears(years = workYears)}")
        val profession = StringRes.JOB_TITLE.getString(language)
        println("$profession $jobTitle") // на каком языке должна быть профессия

        val salary = Salary(value = 200, currency = "ru")
            .calculate(workYears = workYears)
        val rubCurrencyEnding = getRubCurrencyEnding(amount = 0)
        println("Зарплата: $salary")
        val nationality = definitionNationality(nationality)
        println("Национальность: $nationality")
    }

/*    private fun definitionOfNationality(nationality: Nationality): String {
        return when(nationality) {
            Nationality.RUSSIAN -> "Русский"
            Nationality.ENGLISH -> "Englishman"
            Nationality.GERMAN -> "German"
        }
    }*/
    private fun calculateYearsFromStartDate(
        startDate: LocalDate, // как узнает дату найма?
        endDate: LocalDate = LocalDate.now() //дефолтное значение
    ): Int {
        val period = Period.between(startDate, endDate)
        val years = period.years
        return years
    }

    private fun formatYears(years: Int): String {
        return when {
            years % 10 == 1 -> "$years год"
            years % 10 in 2..4 -> "$years года"
            else -> "$years лет"
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
