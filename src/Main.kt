import java.time.LocalDate

fun main() {
    val manager1: Manager = Manager(
        id = 1,
        firstName = "Иван",
        lastName = "Петров",
        middleName = "Иванович",
        birthDate = LocalDate.of(1990, 5, 20),
        language = Language.RUSSIAN, //язык ("ru"/"en")
        hireDate = LocalDate.of(2020, 2, 13),
        jobTitle = "менеджер",
        salary = 10,
        value = 100,
    )

    manager1.greet(manager1.firstName)
    manager1.printPersonalCard()
    println()


    val manager2: Manager = Manager( // переменная класса или экземпляр
        id = 2,
        firstName = "Петр",
        lastName = "Глазов",
        middleName = "Георгиевич",
        birthDate = LocalDate.of(2000, 5, 20),
        language = Language.RUSSIAN, //язык ("ru"/"en")
        hireDate = LocalDate.of(2022, 7, 23),
        jobTitle = "менеджер",
        salary = 20,
        value = 100,
    )

    val chef1: Chef = Chef(
        id = 3,
        firstName = "Antonio",
        lastName = "Faro",
        middleName = null,
        birthDate = LocalDate.of(2011, 5, 20),
        language = Language.ENGLISH, //язык ("ru"/"en")
        hireDate = LocalDate.of(2011, 1, 20), // дата приема на
        jobTitle = "Chef",
        signatureDish = "Pasta with seafood",
        salary = 20,
        value = 100,
    )

    chef1.greet(chef1.firstName)

    chef1.printPersonalCard()
    println()

    val chef2: Chef = Chef(
        id = 5,
        firstName = "Heinrich",
        lastName = "Hertz",
        middleName = "Rudolf",
        birthDate = LocalDate.of(1990,5,15),
        language = Language.GERMAN,
        hireDate = LocalDate.of(2017,5,22),
        jobTitle = "Kochen",
        signatureDish = "Berliner Knöchel",
        salary = 20,
        value = 100,
    )

    chef2.greet(chef2.firstName)
    chef2.printPersonalCard()
}






