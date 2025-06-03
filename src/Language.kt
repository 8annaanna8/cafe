enum class Language {
    RUSSIAN,
    ENGLISH,
    GERMAN,
}

fun definitionLanguage(language: Language) {
    when (language) {
        Language.RUSSIAN -> println("русский")
        Language.ENGLISH -> println("english")
        Language.GERMAN -> println("german")
    }
}