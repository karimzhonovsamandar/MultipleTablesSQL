package com.sammy.multipletablessql.models

class Xaridor {
    var id:Int? = null
    var name:String? =null
    var phone:String? =null
    var address:String? =null

    constructor(id: Int?, name: String?, phone: String?, address: String?) {
        this.id = id
        this.name = name
        this.phone = phone
        this.address = address
    }

    constructor(name: String?, phone: String?, address: String?) {
        this.name = name
        this.phone = phone
        this.address = address
    }


}