fun routeRequest(path: String, user: String?): String {
    return when (path) {
        "/home" ->
            "Welcome to the Lehman Homepage, ${user ?: "Guest"}!"

        "/grades" ->
            if (user == null)
                "Error: Unauthorized access to grades."
            else
                "Loading grades for $user..."

        else ->
            "404: Path $path not found."
    }
}

fun main() {
    println(routeRequest("/home", "Marcus"))
    println(routeRequest("/home", null))
    println(routeRequest("/grades", null))
    println(routeRequest("/grades", "Marcus"))
    println(routeRequest("/unknown", "Marcus"))
}