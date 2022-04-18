package com.example.demo.helper

class JSONFormatter<T>{
    fun response(status: Int, message: String, data: Iterable<T>?) : JSONResponse<T> {
        return JSONResponse(
            status = status,
            message = message,
            data = data
        )
    }
}

data class JSONResponse<T>(
    var status : Int? = null,
    var message: String? = null,
    var data: Iterable<T>? = null
)