import resources.StringRes
import java.time.LocalDate

open class Chef(
    override val id: Int,
    override val firstName: String,
    override val lastName: String,
    override val middleName: String? = null,
    override val birthDate: LocalDate,
    override val language: Language, //язык ("ru"/"en")
    override val hireDate: LocalDate, // дата приема на работу
    override val jobTitle: String,
    override val salary: Int,
    override val value: Int,
    val signatureDish: String? = null, // фирменное блюдо (опционально)
) : Employee(
    id,
    firstName,
    lastName,
    middleName,
    birthDate,
    language,
    hireDate,
    jobTitle,
    salary,
    value,
    ) {

    override fun printPersonalCard() {
        super.printPersonalCard()
        val dish = StringRes.SIGNATURE_DISH.getString(language)
        println("$dish: ${signatureDish ?: ""}")

    }
}
