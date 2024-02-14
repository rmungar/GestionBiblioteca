sealed class Usuario(val id: String, val nombre:String) {
    class Estudiante(id: String, nombre: String, val carrera: String): Usuario(id,nombre){
        init {
            require(id.isNotBlank()) {"El ID es obligatorio"}
            require(nombre.isNotBlank()) {"El nombre no puede ser un campo vacío"}
            require(carrera.isNotBlank()) {"La carrera no puede estar vacía"}
        }
    }
    class Profesor(id: String, nombre: String, val departamento: String): Usuario(id, nombre){
        init {
            require(id.isNotBlank()) {"El ID es obligatorio"}
            require(nombre.isNotBlank()) {"El nombre no puede ser un campo vacío"}
            require(departamento.isNotBlank()) {"El campo departamento no puede estar vacío"}
        }
    }
    class Visitante(id: String, nombre: String): Usuario(id,nombre){
        init {
            require(id.isNotBlank()) {"El ID es obligatorio"}
            require(nombre.isNotBlank()) {"El nombre no puede ser un campo vacío"}
        }
    }
}

