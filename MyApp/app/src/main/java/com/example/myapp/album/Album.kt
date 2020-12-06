package com.example.myapp.album

import java.io.Serializable

class Album(var nombre: String, var anio: Int, var imagen: String, var canciones: Int
):Serializable{
    override fun toString(): String {
        return "$nombre $anio"
    }
}