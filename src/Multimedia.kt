sealed class Multimedia(open val Titulo: String) {
    data class Libro(override val Titulo:String, val Autor:String, val Año: Int): Multimedia(Titulo){
        init {
            require(Titulo.isNotBlank()) {"El título no puede estar vacío"}
            require(Autor.isNotBlank()) {"El autor no puede estar vacío"}
            require(Año> 0) {"No tenemos libros de antes de Cristo"}
        }
        override fun toString(): String {
            return "Libro: $Titulo, de $Autor publicado en $Año"
        }
    }
    data class DVD(override val Titulo: String, val Director: String, val Año:Int): Multimedia(Titulo){
        init {
            require(Titulo.isNotBlank()) {"El título no puede estar vacío"}
            require(Director.isNotBlank()) {"El director no puede estar vacío"}
            require(Año > 0) {"No tenemos DVDs de antes de Cristo"}
        }
        override fun toString(): String {
            return "DVD: $Titulo, de $Director publicado en $Año"
        }
    }
    data class Revista(override val Titulo: String, val Issue: Int, val Año:Int): Multimedia(Titulo){
        init {
            require(Titulo.isNotBlank()) {"El título no puede estar vacío"}
            require(Issue > 0) {"El año no puede ser menor a 0"}
            require(Año > 0) {"No tenemos revistas de antes de Cristo"}
        }
        override fun toString(): String {
            return "Resvista: $Titulo, con issue: $Issue publicado en $Año"
        }
    }
}