package com.damiandev.microapporders.entity

import org.jetbrains.exposed.sql.Table
import java.math.BigDecimal

data class OrderProduct(val orderId: Long, val productId: Long, val quantity: Long, val price: BigDecimal)

object OrderProducts : Table("OrderProduct") {
    val orderId = long("orderId").references(Orders.id)
    val productId = long("productId")
    val quantity = long("quantity")
    val price = decimal("price", 10, 2)

    override val primaryKey = PrimaryKey(orderId, productId)
}