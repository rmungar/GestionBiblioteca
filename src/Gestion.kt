/**
 * La clase Gestion cuenta con 8 propiedades, ninguna de ellas en un constructor primario.
 * @property estudiantes -> Lista mutable de Usuarios Estudiantes
 * @property profesores -> Lista mutable de Usuarios Profesores
 * @property visitantes -> Lista mutable de Usuarios Visitantes
 * @property usuarios -> Lista inmutable que contiene las 3 anteriores
 * @property libros -> Lista mutable de Multimedia Libros
 * @property revistas -> Lista mutable de Multimedia Revistas
 * @property DVDs -> Lista mutable de Multimedia DVD
 * @property multimedia -> Lista inmutable que contiene las 3 anteriores
 * @property ocupaciones -> Lista mutable con todos los libros ocupados y sus respectivos usuarios
 */
class Gestion {
    private var estudiantes = mutableListOf<Usuario.Estudiante>()
    private var profesores = mutableListOf<Usuario.Profesor>()
    private var visitantes = mutableListOf<Usuario.Visitante>()
    private val usuarios:List<MutableList<Usuario>> = listOf(estudiantes, profesores, visitantes)
    private var libros = mutableListOf<Multimedia>()
    private var revistas = mutableListOf<Multimedia>()
    private var DVDs = mutableListOf<Multimedia>()
    private val multimedia = listOf(libros,revistas,DVDs)
    private val ocupaciones = mutableListOf<Pair<Usuario,Multimedia>>()

    /**
     * Imprime un espacio de longuitud personalizable.
     */
    private fun separador(){
        for (i in 1..5) println()
    }
    //--------------------------------------------------MOSTRAR---------------------------------------------------//
    /**
     * Imprime un menú visual de la gestión.
     */
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
    /**
     * Imprime toda la información posible.
     */
    private fun mostrarTodo(){
        usuarios.forEach { it -> it.forEach { println(it.toString()) } }
        multimedia.forEach { it -> it.forEach { println(it.toString()) } }
        ocupaciones.forEach { println("${it.first.nombre} tiene ${it.second.Titulo}") }
    }
    //--------------------------------------------------OPCIONES--------------------------------------------------//
    /**
     * Imprime un menú visual con las opciones disponibles.
     */
    private fun opcionesAddUsuario(){
        println("¿Que tipo de usuario eres?")
        println("1 --ESTUDIANTE")
        println("2 --PROFESOR")
        println("3 --VISITANTE")
    }
    /**
     * Imprime un menú visual con las opciones disponibles.
     */
    private fun opcionesRemoveUsuario(){
        println("¿Que tipo de usuario es?")
        println("1 --ESTUDIANTE")
        println("2 --PROFESOR")
        println("3 --VISITANTE")
    }
    /**
     * Imprime un menú visual con las opciones disponibles.
     */
    private fun opcionesLibro(){
        println("¿Que tipo de libro es?")
        println("1 --LIBRO")
        println("2 --REVISTA")
        println("3 --DVD")
    }
    /**
     * Imprime un menú visual con las opciones disponibles.
     */
    private fun opcionesEliminar(){
        println("¿Que quieres eliminar?")
        println("1 --USUARIO")
        println("2 --LIBRO/REVISTA/DVD")
    }
    //--------------------------------------------------FUNCIONES---------------------------------------------------//
    /**
     * Recoge una entrada y ejecuta una función dependiendo de dicha entrada.
     */
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
    /**
     * Pide al usuario varias entradas, las recoge y genera una instancia de un objeto Usuario acorde a las entradas del usuario
     * y las agrega a la lista correspondiente.
     */
    private fun nuevoUsuario(){
        print("Ingrese el nombre del usuario: ")
        val nombre = readln()
        separador()
        opcionesAddUsuario()
        val tipo = readln().toInt()
        separador()
        when (tipo){
            1 -> { print("¿Qué carrera estudias? ")
                val carrera = readln().replaceFirstChar { it.uppercase() }
                val usuario = Usuario.Estudiante(nombre, carrera)
                estudiantes.add(usuario)
                println("ESTUDIANTE AÑADIDO")
            }
            2 -> { print("¿De que departamento eres? ")
                val departamento = readln().replaceFirstChar { it.uppercase() }
                val profesor = Usuario.Profesor(nombre, departamento)
                profesores.add(profesor)
                println("PROFESOR AÑADIDO")
            }
            3 -> {
                val visitante = Usuario.Visitante(nombre)
                visitantes.add(visitante)
                println("VISITANTE AÑADIDO")
            }
            else -> println("Opción no válida")
        }
    }

    /**
     * Pide al usuario una entrada, la recoge y elimina la instancia del objeto Usuario cuyo parámetro coincida con la entrada.
     */
    private fun eliminarUsuario(){
        opcionesRemoveUsuario()
        val opcion = readln().toInt()
        when (opcion){
            1 -> { print("ID del estudiante a eliminar: ")
                val id = readln().toInt()
                estudiantes.forEach { if (it.id == id) estudiantes.remove(it) }
            }
            2 -> { print("ID del profesor a eliminar: ")
                val id = readln().toInt()
                profesores.forEach { if (it.id == id) profesores.remove(it) }
            }
            3 -> { print("ID del visitante a eliminar ")
                val id = readln().toInt()
                visitantes.forEach { if (it.id == id) visitantes.remove(it) }
            }
            else -> println("Opción no válida")
        }
    }

    /**
     * Pide al usuario varias entradas, las recoge y genera una instancia de un objeto Multimedia acorde a las entradas del usuario
     * y las agrega a la lista correspondiente.
     */
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

    /**
     * Pide al usuario una entrada, la recoge y elimina la instancia del objeto Multimedia cuyo parámetro coincida con la entrada.
     */
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

    /**
     * Pide al usuario una entrada para el nombre del usuario y el tipo de usuario. En función de esta última entrada
     * pedirá una entrada para el objeto Multimedia y la agregará a la lista de ocupaciones si es posible.
     */
    private fun ocuparLibro() {
        opcionesAddUsuario()
        val tipo = readln().toInt()
        when (tipo) {
            1 -> {
                print("Ingrese el ID del estudiante: ")
                val id = readln().toInt()
                val usuario = estudiantes.find { it.id == id }
                if (usuario != null){
                    opcionesLibro()
                    val opcion = readln().toInt()
                    when (opcion) {
                        1 -> {
                            print("Nombre del libro: ")
                            val nombre = readln().replaceFirstChar { it.uppercase() }
                            val libro = libros.find { it.Titulo == nombre }
                            if (libro != null ) {
                                if (!ocupaciones.contains(Pair(usuario, libro))) {
                                    ocupaciones.add(Pair(usuario, libro))
                                }
                                else{
                                    println("Este elemento multimedia ya esta ocupado")
                                }
                            }

                        }
                        2 -> {
                            print("Nombre de la revista: ")
                            val nombre = readln().replaceFirstChar { it.uppercase() }
                            val revista = revistas.find { it.Titulo == nombre }
                            if (revista != null) {
                                if (!ocupaciones.contains(Pair(usuario, revista))) {
                                    ocupaciones.add(Pair(usuario, revista))
                                }
                                else{
                                    println("Este elemento multimedia ya esta ocupado")
                                }
                            }

                        }
                        3 -> {
                            print("Nombre del DVD: ")
                            val nombre = readln().replaceFirstChar { it.uppercase() }
                            val dvd = DVDs.find { it.Titulo == nombre }
                            if (dvd != null) {
                                if (!ocupaciones.contains(Pair(usuario, dvd))) {
                                    ocupaciones.add(Pair(usuario, dvd))
                                }
                                else{
                                    println("Este elemento multimedia ya esta ocupado")
                                }
                            }

                        }
                    }
                }
            }
            2 -> {
                print("Ingrese el ID del profesor: ")
                val id = readln().toInt()
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
                                if (!ocupaciones.contains(Pair(usuario, libro))) {
                                    ocupaciones.add(Pair(usuario, libro))
                                }
                                else{
                                    println("Este elemento multimedia ya esta ocupado")
                                }
                            }

                        }
                        2 -> {
                            print("Nombre de la revista: ")
                            val nombre = readln().replaceFirstChar { it.uppercase() }
                            val revista = revistas.find { it.Titulo == nombre }
                            if (revista != null) {
                                if (!ocupaciones.contains(Pair(usuario, revista))) {
                                    ocupaciones.add(Pair(usuario, revista))
                                }
                                else{
                                    println("Este elemento multimedia ya esta ocupado")
                                }
                            }

                        }
                        3 -> {
                            print("Nombre del DVD: ")
                            val nombre = readln().replaceFirstChar { it.uppercase() }
                            val dvd = DVDs.find { it.Titulo == nombre }
                            if (dvd != null) {
                                if (!ocupaciones.contains(Pair(usuario, dvd))) {
                                    ocupaciones.add(Pair(usuario, dvd))
                                }
                                else{
                                    println("Este elemento multimedia ya esta ocupado")
                                }
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

    /**
     * Recoge 1 entrada que puede ser el nombre del libro o el nombre del usuario y elimina la ocupación del libro.
     */
    private fun desocuparLibro(){
        println("Ingrese el nombre del libro o el usuario: ")
        val entrada = readln()
        val liberado = ocupaciones.find { it.first.nombre == entrada || it.second.Titulo == entrada }
        ocupaciones.remove(liberado)
    }

    /**
     * Permite eliminar cualquier libro o cualquier usuario si este existe dentro de la lista usuarios o multimedia, si no es posible
     * imprime un mensaje.
     */
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