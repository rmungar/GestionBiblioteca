data class Libro(val Titulo:String, val Autor:String, val Publicacion: Int){
    init {
        require(Titulo.isNotBlank()) {"El título no puede estar vacío"}
        require(Autor.isNotBlank()) {"El autor no puede estar vacío"}
        require(Publicacion > 0) {"No tenemos libros de antes de Cristo"}
    }
}
