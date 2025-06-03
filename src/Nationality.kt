enum class Nationality {
    RUSSIAN,
    ENGLISH,
    GERMAN,
}

fun definitionNationality (nationality: Nationality): String {
    return when (nationality) {
        Nationality.RUSSIAN -> "Русский"
        Nationality.ENGLISH -> "Englishman"
        Nationality.GERMAN -> "German"
    }
}