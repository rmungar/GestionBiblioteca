import kotlin.random.Random

/**
 * Clase sellada que contiene como propiedades:
 * @property id -> String que identifica a un usuario
 * @property nombre -> String del nombre del usuario
 */

sealed class Usuario(val nombre:String) {
    companion object{
        var ids = mutableListOf<Int>()
        val id: Int = generarId()
        fun generarId(): Int{
            while (true) {
                val id = Random.nextInt(1,9999)
                if (!ids.contains(id)) {
                    ids.add(id)
                    return id
                }
            }
        }
    }

    /**
     * Clase que contiene como propiedades heredadas de Usuario:
     * @property id -> String que identifica a un usuario
     * @property nombre -> String del nombre del usuario
     * Y propiedad propia:
     * @property carrera -> String que representa los estudios del usuario
     */
    class Estudiante(nombre: String, private val carrera: String): Usuario(nombre){
        init {
            require(nombre.isNotBlank()) {"El nombre no puede ser un campo vacío"}
            nombre.lowercase().replaceFirstChar { it.uppercase() }
            require(carrera.isNotBlank()) {"La carrera no puede estar vacía"}
        }
        val id = generarId()
        override fun toString(): String {
            return "Estudiante: $nombre con ID: $id estudiando: $carrera"
        }
    }

    /**
     * Clase que contiene como propiedades heredadas de Usuario:
     * @property id -> String que identifica a un usuario
     * @property nombre -> String del nombre del usuario
     * Y propiedad propia:
     * @property departamento -> String que representa el área de trabajo del usuario
     */
    class Profesor(nombre: String, private val departamento: String): Usuario(nombre){
        init {
            require(nombre.isNotBlank()) {"El nombre no puede ser un campo vacío"}
            nombre.lowercase().replaceFirstChar { it.uppercase() }
            require(departamento.isNotBlank()) {"El campo departamento no puede estar vacío"}
        }
        val id = generarId()
        override fun toString(): String {
            return "Profesor: $nombre con ID: $id del departamento: $departamento"
        }
    }

    /**
     * Clase que contiene como propiedades heredadas de Usuario:
     * @property id -> String que identifica a un usuario
     * @property nombre -> String del nombre del usuario
     */
    class Visitante(nombre: String): Usuario(nombre){
        init {
            require(nombre.isNotBlank()) {"El nombre no puede ser un campo vacío"}
            nombre.lowercase().replaceFirstChar { it.uppercase() }
        }
        val id = generarId()
        override fun toString(): String {
            return "Visitante: $nombre con ID: $id"
        }
    }
}

