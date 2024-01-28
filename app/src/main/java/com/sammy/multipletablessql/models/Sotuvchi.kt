package com.sammy.multipletablessql.models

class Sotuvchi {
    var id:Int?=null
    var name :String? = null
    var phone:String? = null

    constructor(id: Int?, name: String?, phone: String?) {
        this.id = id
        this.name = name
        this.phone = phone
    }

    constructor(name: String?, phone: String?) {
        this.name = name
        this.phone = phone
    }

}