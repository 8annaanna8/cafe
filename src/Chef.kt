import java.time.LocalDate

open class Chef(
    override val id: Int,
    override val firstName: String,
    override val lastName: String,
    override val middleName: String? = null,
    override val birthDate: LocalDate,
    override val language: Language, //язык ("ru"/"en")
    override val hireDate: LocalDate, // дата приема на работу
    override val jobTitle: String, // фирменное блюдо (опционально)
    override val nationality: Nationality,
    val signatureDish: String? = null,
) : Employee(id, firstName, lastName, middleName, birthDate, language, hireDate, jobTitle, nationality,) {
    override fun printPersonalCard() {
        super.printPersonalCard()
        println("Фирменное блюдо $signatureDish")
    }
}
