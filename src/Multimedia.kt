/**
 * Clase sellada que contiene como propiedades:
 * @property Titulo-> String que identifica a un objeto multimedia
 */
sealed class Multimedia(open val Titulo: String) {
    /**
     * Clase que contiene como propiedad heredada de Multimedia:
     * @property Titulo -> String que identifica a un libro
     * Y propiedades propias:
     * @property Autor -> String del nombre del escritor del libro
     * @property Año -> Entero que representa la fecha de publicación
     */
    data class Libro(override val Titulo:String, val Autor:String, val Año: Int): Multimedia(Titulo){
        init {
            require(Titulo.isNotBlank()) {"El título no puede estar vacío"}
            require(Autor.isNotBlank()) {"El autor no puede estar vacío"}
            require(Año> 0) {"No tenemos libros de antes de Cristo"}
        }
        override fun toString(): String {
            return "Libro: $Titulo, de $Autor publicado en el año: $Año"
        }
    }

    /**
     * Clase que contiene como propiedad heredada de Multimedia:
     * @property Titulo -> String que identifica a un DVD
     * Y propiedades propias:
     * @property Director -> String del nombre del director del DVD
     * @property Año -> Entero que representa la fecha de publicación del DVD
     */
    data class DVD(override val Titulo: String, val Director: String, val Año:Int): Multimedia(Titulo){
        init {
            require(Titulo.isNotBlank()) {"El título no puede estar vacío"}
            require(Director.isNotBlank()) {"El director no puede estar vacío"}
            require(Año > 0) {"No tenemos DVDs de antes de Cristo"}
        }
        override fun toString(): String {
            return "DVD: $Titulo, de $Director publicado en el año: $Año"
        }
    }

    /**
     * Clase que contiene como propiedad heredada de Multimedia:
     * @property Titulo -> String que identifica a una revista
     * Y propiedades propias:
     * @property Issue -> Entero que representa el issue de la revista
     * @property Año -> Entero que representa la fecha de publicación de la revista
     */
    data class Revista(override val Titulo: String, val Issue: Int, val Año:Int): Multimedia(Titulo){
        init {
            require(Titulo.isNotBlank()) {"El título no puede estar vacío"}
            require(Issue > 0) {"El año no puede ser menor a 0"}
            require(Año > 0) {"No tenemos revistas de antes de Cristo"}
        }
        override fun toString(): String {
            return "Resvista: $Titulo, con issue: $Issue publicado en el año: $Año"
        }
    }
}