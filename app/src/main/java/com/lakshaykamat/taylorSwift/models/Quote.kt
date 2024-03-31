package com.lakshaykamat.taylorSwift.models

data class Quote(
    private val quote: String,
    private val album: String,
    private val song: String,
){
    fun text():String{return quote}
    fun getSongName():String{return song}
    fun getAlbumName():String{return album}
}
