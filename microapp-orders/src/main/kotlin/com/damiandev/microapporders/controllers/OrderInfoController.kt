package com.damiandev.microapporders.controllers

import com.damiandev.microapporders.entity.OrderInfo
import org.springframework.http.ResponseEntity

interface OrderInfoController {
    fun addOrderInfo(orderInfo: OrderInfo): ResponseEntity<OrderInfo>
    fun getOrderInfoById(id: Long): ResponseEntity<OrderInfo>
    fun deleteById(id: Long)
    fun deleteByIds(ids: List<Long>)
    fun getOrdersInfoByCustomerId(customerId: Long): ResponseEntity<List<OrderInfo>>
    fun getAllOrdersInfo(): ResponseEntity<List<OrderInfo>>
}