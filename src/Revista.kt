data class Revista(val Titulo: String, val Issue: Int, val Año:Int){
    init {
        require(Titulo.isNotBlank()) {"El título no puede estar vacío"}
        require(Issue > 0) {"El año no puede ser menor a 0"}
        require(Año > 0) {"No tenemos revistas de antes de Cristo"}
    }
}
