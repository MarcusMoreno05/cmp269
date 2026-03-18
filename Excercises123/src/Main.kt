//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val studentName: String = "Marcus"
    val middleName: String? = null

    val displayMiddle = middleName ?: "No Middle Name"
    println("Welcome, $studentName $displayMiddle!")
}