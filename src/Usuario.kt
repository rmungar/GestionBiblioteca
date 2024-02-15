/**
 * Clase sellada que contiene como propiedades:
 * @property id -> String que identifica a un usuario
 * @property nombre -> String del nombre del usuario
 */

sealed class Usuario(val id: String, val nombre:String) {

    /**
     * Clase que contiene como propiedades heredadas de Usuario:
     * @property id -> String que identifica a un usuario
     * @property nombre -> String del nombre del usuario
     * Y propiedad propia:
     * @property carrera -> String que representa los estudios del usuario
     */
    class Estudiante(id: String, nombre: String, private val carrera: String): Usuario(id,nombre){
        init {
            require(id.isNotBlank()) {"El ID es obligatorio"}
            require(nombre.isNotBlank()) {"El nombre no puede ser un campo vacío"}
            require(carrera.isNotBlank()) {"La carrera no puede estar vacía"}
        }

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
    class Profesor(id: String, nombre: String, private val departamento: String): Usuario(id, nombre){
        init {
            require(id.isNotBlank()) {"El ID es obligatorio"}
            require(nombre.isNotBlank()) {"El nombre no puede ser un campo vacío"}
            require(departamento.isNotBlank()) {"El campo departamento no puede estar vacío"}
        }
        override fun toString(): String {
            return "Profesor: $nombre con ID: $id del departamento: $departamento"
        }
    }

    /**
     * Clase que contiene como propiedades heredadas de Usuario:
     * @property id -> String que identifica a un usuario
     * @property nombre -> String del nombre del usuario
     */
    class Visitante(id: String, nombre: String): Usuario(id,nombre){
        init {
            require(id.isNotBlank()) {"El ID es obligatorio"}
            require(nombre.isNotBlank()) {"El nombre no puede ser un campo vacío"}
        }
        override fun toString(): String {
            return "Visitante: $nombre con ID: $id"
        }
    }
}

