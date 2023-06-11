package com.damiandev.microapporders.controllers.impl

import com.damiandev.microapporders.controllers.OrderInfoController
import com.damiandev.microapporders.entity.Order
import com.damiandev.microapporders.entity.OrderInfo
import com.damiandev.microapporders.entity.OrderProduct
import com.damiandev.microapporders.services.OrderProductService
import com.damiandev.microapporders.services.OrderService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/ordersInfo")
class OrderInfoControllerImpl(val orderService: OrderService, val orderProductService: OrderProductService) : OrderInfoController {
    @PostMapping("add")
    override fun addOrderInfo(orderInfo: OrderInfo): ResponseEntity<OrderInfo> {
        val totalPrice = orderInfo.orderProductList.sumOf { orderProduct -> orderProduct.price }
        val order = Order(null, orderInfo.order.customerId, orderInfo.order.date, totalPrice, orderInfo.order.description)
        val orderSaved = orderService.addOrder(order)
        val orderProductList = ArrayList<OrderProduct>()

        orderInfo.orderProductList.forEach { orderProduct ->
            run {
                val orderProductSaved = orderProductService.addOrderProduct(orderProduct)
                orderProductList.add(orderProductSaved!!)
            }
        }

        return ResponseEntity.ok(OrderInfo(orderSaved!!, orderProductList))
    }

    @GetMapping("{id}")
    override fun getOrderInfoById(@PathVariable id: Long): ResponseEntity<OrderInfo> {
        val order = orderService.getOrderById(id)
        val orderProducts = orderProductService.getOrderProductByOrderId(id)

        return ResponseEntity.ok(OrderInfo(order!!, orderProducts!!))
    }

    @DeleteMapping("delete/{id}")
    override fun deleteById(@PathVariable id: Long) {
        orderService.deleteById(id)
        orderProductService.deleteByOrderId(id)
    }

    @DeleteMapping("delete")
    override fun deleteByIds(@RequestParam ids: List<Long>) {
        orderService.deleteByIds(ids)
        orderProductService.deleteByOrderIds(ids)
    }

    @GetMapping("customer/{customerId}")
    override fun getOrdersInfoByCustomerId(@PathVariable customerId: Long): ResponseEntity<List<OrderInfo>> {
        val orders = orderService.getOrdersByCustomerId(customerId)
        val orderInfoList = ArrayList<OrderInfo>();

        orders.forEach { order: Order -> orderInfoList.add(OrderInfo(order, order.id?.let { orderProductService.getOrderProductByOrderId(it) }!!)) }

        return ResponseEntity.ok(orderInfoList)
    }

    @GetMapping("all")
    override fun getAllOrdersInfo(): ResponseEntity<List<OrderInfo>> {
        val orders = orderService.getAllOrders()
        val orderInfoList = ArrayList<OrderInfo>();

        orders.forEach { order: Order -> orderInfoList.add(OrderInfo(order, order.id?.let { orderProductService.getOrderProductByOrderId(it) }!!)) }

        return ResponseEntity.ok(orderInfoList)
    }
}