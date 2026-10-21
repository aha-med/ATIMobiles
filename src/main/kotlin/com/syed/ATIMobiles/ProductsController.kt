package com.syed.ATIMobiles

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/Products")
class ProductsController {

    val products : MutableList<Product> = mutableListOf()

    @GetMapping
    fun getMobileCovers() = products

 



}