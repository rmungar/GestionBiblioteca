data class DVD(val Titulo: String, val Director: String, val Año:Int){
    init {
        require(Titulo.isNotBlank()) {"El título no puede estar vacío"}
        require(Director.isNotBlank()) {"El director no puede estar vacío"}
        require(Año > 0) {"No tenemos DVDs de antes de Cristo"}
    }
}
