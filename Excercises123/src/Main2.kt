data class Laptop(val brand: String, val ramGB: Int)

fun Int.toLehmanGigabytes(): String {
    return "$this GB (Lehman Standard)"
}

fun main() {
    val laptop1 = Laptop("Lenovo", 16)
    val laptop2 = Laptop("Apple", 8)

    println("${laptop1.brand} RAM: ${laptop1.ramGB.toLehmanGigabytes()}")
    println("${laptop2.brand} RAM: ${laptop2.ramGB.toLehmanGigabytes()}")
}