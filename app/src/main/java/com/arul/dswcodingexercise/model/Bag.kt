package com.arul.dswcodingexercise.model

data class Bag(
        val products: List<Product>?,
        val promos: List<Promo>?,
        val summary: Summary?
)

data class Product(
        val sku: String,
        val displayName: String,
        val price: String,
        val quantity: Int
)

data class Promo(
        val code: String,
        val description: String,
        val value: String
)

data class Summary(
        val subtotal: String,
        val tax: String,
        val discounts: String,
        val total: String
)
