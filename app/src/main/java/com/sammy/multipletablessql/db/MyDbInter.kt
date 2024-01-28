package com.sammy.multipletablessql.db

import com.sammy.multipletablessql.models.Buyurtma
import com.sammy.multipletablessql.models.Sotuvchi
import com.sammy.multipletablessql.models.Xaridor

interface MyDbInter {
    fun addSotuvchi(sotuvchi: Sotuvchi)
    fun getAllSotuvchi():ArrayList<Sotuvchi>

    fun addXarirod(xaridor: Xaridor)
    fun getAllXaridor():ArrayList<Xaridor>

    fun addBuyurtma(buyurtma: Buyurtma)
    fun getAllBuyurtma():ArrayList<Buyurtma>

    fun getSotuvchiById(id:Int):Sotuvchi
    fun getXaridorById(id:Int):Xaridor

}