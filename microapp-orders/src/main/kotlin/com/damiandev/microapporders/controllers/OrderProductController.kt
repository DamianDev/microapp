package com.damiandev.microapporders.controllers

import com.damiandev.microapporders.entity.OrderProduct
import org.springframework.http.ResponseEntity

interface OrderProductController {
    fun addOrderProduct(orderProduct: OrderProduct): ResponseEntity<OrderProduct>
    fun getOrderProductByOrderId(orderId: Long): ResponseEntity<List<OrderProduct>>
    fun deleteByOrderId(orderId: Long)
    fun deleteByOrderIds(orderIds: List<Long>)
    fun getAllOrders(): ResponseEntity<List<OrderProduct>>
}