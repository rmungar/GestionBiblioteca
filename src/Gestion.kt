class Gestion {
    private var estudiantes = mutableListOf<Usuario>()
    private var profesores = mutableListOf<Usuario>()
    private var visitantes = mutableListOf<Usuario>()
    private val usuarios:List<MutableList<Usuario>> = listOf(estudiantes, profesores, visitantes)
    private var libros = mutableListOf<Multimedia>()
    private var revistas = mutableListOf<Multimedia>()
    private var DVDs = mutableListOf<Multimedia>()
    private val multimedia = listOf(libros,revistas,DVDs)
    private val ocupaciones = mutableListOf<Pair<Usuario,Multimedia>>()
    private fun separador(){
        for (i in 1..5) println()
    }
    //--------------------------------------------------MOSTRAR---------------------------------------------------//
    fun mostrarMenu(){
        println("----MENU----")
        println("1 --AÑADIR USUARIO Y LIBRO")
        println("2 --AÑADIR USUARIO")
        println("3 --AÑADIR LIBRO")
        println("4 --OCUPAR LIBRO")
        println("5 --DESOCUPAR LIBRO")
        println("6 --ELIMINAR USUARIO O LIBRO")
        println("7 --MOSTRAR TODO")
        println("8 --SALIR")
    }
    private fun mostrarTodo(){
        usuarios.forEach { it -> it.forEach { println(it.toString()) } }
        multimedia.forEach { it -> it.forEach { println(it.toString()) } }
        ocupaciones.forEach { println("${it.first.nombre} tiene ${it.second.Titulo}") }
    }
    //--------------------------------------------------OPCIONES--------------------------------------------------//
    private fun opcionesAddUsuario(){
        println("¿Que tipo de usuario eres?")
        println("1 --ESTUDIANTE")
        println("2 --PROFESOR")
        println("3 --VISITANTE")
    }
    private fun opcionesRemoveUsuario(){
        println("¿Que tipo de usuario es?")
        println("1 --ESTUDIANTE")
        println("2 --PROFESOR")
        println("3 --VISITANTE")
    }
    private fun opcionesLibro(){
        println("¿Que tipo de libro es?")
        println("1 --LIBRO")
        println("2 --REVISTA")
        println("3 --DVD")
    }
    private fun opcionesEliminar(){
        println("¿Que quieres eliminar?")
        println("1 --USUARIO")
        println("2 --LIBRO/REVISTA/DVD")
    }
    //--------------------------------------------------FUNCIONES---------------------------------------------------//
    fun seleccionMenu(){
        print("-> ")
        val opcion = readln().toInt()
        when (opcion){
            1 -> {
                nuevoUsuario()
                separador()
                nuevoLibro()
            }
            2 -> nuevoUsuario()
            3 -> nuevoLibro()
            4 -> ocuparLibro()
            5 -> desocuparLibro()
            6 -> eliminar()
            7 -> mostrarTodo()

        }
    }

    private fun nuevoUsuario(){
        print("Ingrese el ID del usuario: ")
        val id = readln()
        print("Ingrese el nombre del usuario: ")
        val nombre = readln()
        separador()
        opcionesAddUsuario()
        val tipo = readln().toInt()
        separador()
        when (tipo){
            1 -> { print("¿Qué carrera estudias? ")
                val carrera = readln().replaceFirstChar { it.uppercase() }
                val usuario = Usuario.Estudiante(id, nombre, carrera)
                estudiantes.add(usuario)
                println("ESTUDIANTE AÑADIDO")
            }
            2 -> { print("¿De que departamento eres? ")
                val departamento = readln().replaceFirstChar { it.uppercase() }
                val profesor = Usuario.Profesor(id, nombre, departamento)
                profesores.add(profesor)
                println("PROFESOR AÑADIDO")
            }
            3 -> {
                val visitante = Usuario.Visitante(id, nombre)
                visitantes.add(visitante)
                println("VISITANTE AÑADIDO")
            }
            else -> println("Opción no válida")
        }
    }
    private fun eliminarUsuario(){
        opcionesRemoveUsuario()
        val opcion = readln().toInt()
        when (opcion){
            1 -> { print("ID del estudiante a eliminar: ")
                val id = readln()
                estudiantes.forEach { if (it.id == id) estudiantes.remove(it) }

            }
            2 -> { print("ID del profesor a eliminar: ")
                val id = readln()
                profesores.forEach { if (it.id == id) profesores.remove(it) }
            }
            3 -> { print("ID del visitante a eliminar ")
                val id = readln()
                visitantes.forEach { if (it.id == id) estudiantes.remove(it) }
            }
            else -> println("Opción no válida")
        }
    }

    private fun nuevoLibro(){
        opcionesLibro()
        val opcion = readln().toInt()
        when (opcion){
            1 -> {
                print("Nombre del libro: ")
                val nombre = readln().replaceFirstChar { it.uppercase() }
                print("Nombre del autor: ")
                val autor = readln().replaceFirstChar { it.uppercase() }
                print("Año de publicación: ")
                val year = readln().toInt()
                val libro = Multimedia.Libro(nombre,autor,year)
                libros.add(libro)
                println("LIBRO AÑADIDO")
            }
            2 -> {
                print("Nombre de la revista: ")
                val nombre = readln().replaceFirstChar { it.uppercase() }
                print("Issue de la revista: ")
                val issue = readln().toInt()
                print("Año de publicación: ")
                val year = readln().toInt()
                val revista = Multimedia.Revista(nombre,issue,year)
                revistas.add(revista)
                println("REVISTA AÑADIDA")
            }
            3 -> {
                print("Nombre del DVD: ")
                val nombre = readln().replaceFirstChar { it.uppercase() }
                print("Nombre del director: ")
                val director = readln().replaceFirstChar { it.uppercase() }
                print("Año de publicación: ")
                val year = readln().toInt()
                val dvd = Multimedia.DVD(nombre,director,year)
                DVDs.add(dvd)
                println("DVD AÑADIDO")
            }
            else -> println("Opción no válida")
        }
    }
    private fun eliminarLibro(){
        opcionesLibro()
        val opcion = readln().toInt()
        when (opcion){
            1 -> { print("Titulo del libro: ")
                val nombre = readln().replaceFirstChar { it.uppercase() }
                libros.forEach { if (it.Titulo == nombre) libros.remove(it) }

            }
            2 -> { print("Título de la revista: ")
                val nombre = readln().replaceFirstChar { it.uppercase() }
                revistas.forEach { if (it.Titulo == nombre) revistas.remove(it) }
            }
            3 -> { print("Título del DVD: ")
                val nombre = readln().replaceFirstChar { it.uppercase() }
                DVDs.forEach { if (it.Titulo == nombre) DVDs.remove(it) }
            }
            else -> println("Opción no válida")
        }
    }

    private fun ocuparLibro() {
        opcionesAddUsuario()
        val tipo = readln().toInt()
        when (tipo) {
            1 -> {
                print("Ingrese el ID del estudiante: ")
                val id = readln()
                val usuario = estudiantes.find { it.id == id }
                if (usuario != null){
                    opcionesLibro()
                    val opcion = readln().toInt()
                    when (opcion) {
                        1 -> {
                            print("Nombre del libro: ")
                            val nombre = readln().replaceFirstChar { it.uppercase() }
                            val libro = libros.find { it.Titulo == nombre }
                            if (libro != null) {
                                ocupaciones.add(Pair(usuario, libro))
                            }

                        }
                        2 -> {
                            print("Nombre de la revista: ")
                            val nombre = readln().replaceFirstChar { it.uppercase() }
                            val revista = revistas.find { it.Titulo == nombre }
                            if (revista != null) {
                                ocupaciones.add(Pair(usuario, revista))
                            }

                        }
                        3 -> {
                            print("Nombre del DVD: ")
                            val nombre = readln().replaceFirstChar { it.uppercase() }
                            val dvd = DVDs.find { it.Titulo == nombre }
                            if (dvd != null) {
                                ocupaciones.add(Pair(usuario, dvd))
                            }

                        }
                    }
                }
            }
            2 -> {
                print("Ingrese el ID del profesor: ")
                val id = readln()
                val usuario = profesores.find { it.id == id }
                if (usuario != null){
                    opcionesLibro()
                    val opcion = readln().toInt()
                    when (opcion) {
                        1 -> {
                            print("Nombre del libro: ")
                            val nombre = readln().replaceFirstChar { it.uppercase() }
                            val libro = libros.find { it.Titulo == nombre }
                            if (libro != null) {
                                ocupaciones.add(Pair(usuario, libro))
                            }

                        }
                        2 -> {
                            print("Nombre de la revista: ")
                            val nombre = readln().replaceFirstChar { it.uppercase() }
                            val revista = revistas.find { it.Titulo == nombre }
                            if (revista != null) {
                                ocupaciones.add(Pair(usuario, revista))
                            }

                        }
                        3 -> {
                            print("Nombre del DVD: ")
                            val nombre = readln().replaceFirstChar { it.uppercase() }
                            val dvd = DVDs.find { it.Titulo == nombre }
                            if (dvd != null) {
                                ocupaciones.add(Pair(usuario, dvd))
                            }

                        }
                    }
                }
            }
            3 -> {
                println("Lo lamento, los invitados no pueden retirar o solicitar libros")
            }

        }
    }
    private fun desocuparLibro(){
        println("Ingrese el nombre del libro o el usuario: ")
        val entrada = readln()
        val liberado = ocupaciones.find { it.first.nombre == entrada || it.second.Titulo == entrada }
        ocupaciones.remove(liberado)
    }
    private fun eliminar(){
        opcionesEliminar()
        print("-> ")
        val opcion = readln().toInt()
        when (opcion){
            1 -> eliminarUsuario()
            2 -> eliminarLibro()
            else -> println("Opción no válida")
        }
    }
}