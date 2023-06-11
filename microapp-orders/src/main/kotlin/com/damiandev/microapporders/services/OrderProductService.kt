package com.damiandev.microapporders.services

import com.damiandev.microapporders.entity.OrderProduct

interface OrderProductService {
    fun addOrderProduct(orderProduct: OrderProduct): OrderProduct?
    fun getOrderProductByOrderId(orderId: Long): List<OrderProduct>?
    fun deleteByOrderId(orderId: Long)
    fun deleteByOrderIds(orderIds: List<Long>)
    fun getAllOrderProducts(): List<OrderProduct>?
}