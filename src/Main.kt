fun main() {
    try {
        val gestor = Gestion()
        while (true) {
            gestor.mostrarMenu()
            gestor.seleccionMenu()
            println("¿Deseas continuar? (s/n) -> ")
            if (readln() == "n"){
                println("CERRANDO...")
                break
            }
        }
    } catch (e:Exception) {
        println(e.message)
    }
}