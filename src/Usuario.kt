sealed class Usuario(val id: String, val nombre:String) {
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

