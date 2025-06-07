package resources

import Language

/*enum class StringRes(val russian: String, val english: String) {
    YOUR_PERSONAL_CARD(
        russian = "Ваша персональная карта:",
        english = "Your personal card:",
    ),

} */

/*
enum class StringRes {
    YOUR_PERSONAL_CARD;

    val russian: String
        get() = when (this) {
            YOUR_PERSONAL_CARD -> "Ваша персональная карта:"
        }
    val english: String
        get() = when (this) {
            YOUR_PERSONAL_CARD -> "Your personal card:"
        }
}*/

enum class StringRes {
    GREETING,
    YOUR_PERSONAL_CARD,
    FULL_NAME,
    BIRTH_DATE,
    AGE,
    EXPERIENCE,
    JOB_TITLE,
    SALARY,
    YEAR,
    YEARS,
    CURRENCY,
    SIGNATURE_DISH;


    fun getString(language: Language): String {
        return when (language) {
            Language.RUSSIAN -> russian()
            Language.ENGLISH -> english()
            Language.GERMAN -> german()
        }
    }

    private fun russian(): String {
        return when (this) {
            GREETING -> "Привет"
            YOUR_PERSONAL_CARD -> "Ваша персональная карта"
            FULL_NAME -> "Ф.И.О"
            BIRTH_DATE -> "Дата рождения"
            AGE -> "Полных лет"
            EXPERIENCE -> "Опыт работы"
            JOB_TITLE -> "Профессия"
            SALARY -> "Зарплата"
            YEAR -> "год"
            YEARS -> "лет"
            CURRENCY -> ""
            SIGNATURE_DISH -> "Фирменное блюдо"
        }
    }

    private fun english(): String {
        return when (this) {
            GREETING -> "Hello"
            YOUR_PERSONAL_CARD -> "Your personal card"
            FULL_NAME ->  "Full name"
            BIRTH_DATE -> "Birth date"
            AGE -> "Age"
            EXPERIENCE -> "Experience"
            JOB_TITLE -> "Profession"
            SALARY -> "Salary"
            YEAR -> "year"
            YEARS -> "years"
            CURRENCY -> ""
            SIGNATURE_DISH -> "Signature dish"
        }
    }

    private fun german(): String {
        return when (this) {
            YOUR_PERSONAL_CARD -> "Ihre persönliche Karte"
            GREETING -> "Hallo"
            FULL_NAME -> "Vollständiger Name"
            BIRTH_DATE -> "Geburtsdatum"
            AGE -> "Alter"
            EXPERIENCE -> "Erfahrung"
            JOB_TITLE -> "Beruf"
            SALARY -> "Gehalt"
            YEAR -> "Jahr"
            YEARS -> "Jahre"
            CURRENCY -> ""
            SIGNATURE_DISH -> "Spezialgericht"
        }
    }
}