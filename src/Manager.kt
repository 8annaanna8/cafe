import java.time.LocalDate

class Manager(
    override val id: Int,
    override val firstName: String,
    override val lastName: String,
    override val middleName: String?,
    override val birthDate: LocalDate,
    override val language: Language, //язык ("ru"/"en")
    override val hireDate: LocalDate, // дата приема на работу
    override val jobTitle: String,
    override val nationality: Nationality,
) : Employee (id, firstName, lastName, middleName, birthDate, language, hireDate, jobTitle, nationality) {
}
