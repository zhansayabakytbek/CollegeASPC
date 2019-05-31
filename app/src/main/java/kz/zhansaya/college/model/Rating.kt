package kz.zhansaya.college.model

data class Rating(val name: String, val rating: Float , val group: String) {
    constructor() :this("",0f,"")
}