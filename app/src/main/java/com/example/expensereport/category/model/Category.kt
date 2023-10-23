package com.example.expensereport.category.model

sealed class Category(){
    data class Food(val title : String = "Food") : Category()
    data class Transport(val title : String = "Transport") : Category()
    data class Gift(val title : String = "Gift") : Category()
    data class Education(val title : String = "Education") : Category()
    data class Health(val title : String = "Health") : Category()
    data class SocialLife(val title : String = "Social Life") : Category()
    data class Other(val title : String = "Other") : Category()
}
