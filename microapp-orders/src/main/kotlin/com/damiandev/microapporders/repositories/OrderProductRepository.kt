package com.damiandev.microapporders.repositories

import com.damiandev.microapporders.entity.OrderProduct

interface OrderProductRepository {
    fun addOrderProduct(orderProduct: OrderProduct): OrderProduct?
    fun getOrderProduct(orderId: Long): List<OrderProduct>?
    fun deleteByOrderId(orderId: Long)
    fun deleteByOrderIds(orderIds: List<Long>)
    fun getAllOrderProducts(): List<OrderProduct>?
}