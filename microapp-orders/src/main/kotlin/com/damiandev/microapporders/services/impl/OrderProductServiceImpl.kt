package com.damiandev.microapporders.services.impl

import com.damiandev.microapporders.entity.OrderProduct
import com.damiandev.microapporders.repositories.OrderProductRepository
import com.damiandev.microapporders.services.OrderProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OrderProductServiceImpl @Autowired constructor(private val orderProductRepository: OrderProductRepository): OrderProductService {
    override fun addOrderProduct(orderProduct: OrderProduct): OrderProduct? {
        return orderProductRepository.addOrderProduct(orderProduct)
    }

    override fun getOrderProductByOrderId(orderId: Long): List<OrderProduct>? {
        return orderProductRepository.getOrderProduct(orderId)
    }

    override fun deleteByOrderId(orderId: Long) {
        orderProductRepository.deleteByOrderId(orderId)
    }

    override fun deleteByOrderIds(orderIds: List<Long>) {
        orderProductRepository.deleteByOrderIds(orderIds)
    }

    override fun getAllOrderProducts(): List<OrderProduct>? {
        return orderProductRepository.getAllOrderProducts()
    }
}