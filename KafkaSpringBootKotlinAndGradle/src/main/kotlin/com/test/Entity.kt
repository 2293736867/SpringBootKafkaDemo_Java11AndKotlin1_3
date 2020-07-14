package com.test

class Entity {
    var id: Long = 0
    var name: String = ""
    var num: Int = 0

    constructor()

    constructor(id:Long,name:String,num:Int)
    {
        this.id = id
        this.name = name
        this.num = num
    }
}
