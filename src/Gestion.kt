class Gestion {
    fun separador(){
        for (i in 1..5) println()
    }
    fun mostrarMenu(){
        println("----MENU----")
        println("1 --AÑADIR USUARIO Y LIBRO")
        println("2 --AÑADIR USUARIO")
        println("3 --AÑADIR LIBRO")
        println("4 --ELIMINAR USUARIO Y LIBRO")
        println("5 --SALIR")
    }
    fun opcionesUsuario(){
        println("¿Que tipo de usuario eres?")
        println("1 --ESTUDIANTE")
        println("2 --PROFESOR")
        println("3 --VISITANTE")
    }
    fun nuevoUsuario(){
        print("Ingrese el ID del usuario: ")
        val id = readln()
        print("Ingrese el nombre del usuario: ")
        val nombre = readln()
        separador()
        opcionesUsuario()
        val tipo = readln().toInt()
        separador()
        when (tipo){
            1 -> { print("¿Qué carrera estudias? ")
                val carrera = readln()
                val usuario = Usuario.Estudiante(id, nombre, carrera)
            }
            2 -> { print("¿De que departamento eres? ")
                val departamento = readln()
                val usuario = Usuario.Estudiante(id, nombre, departamento)
            }
            3 -> { print("¿Qué carrera estudias? ")
                val carrera = readln()
                val usuario = Usuario.Estudiante(id, nombre, carrera)
            }
        }
    }
}