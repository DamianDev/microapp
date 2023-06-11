package com.damiandev.microapporders.controllers.impl

import com.damiandev.microapporders.controllers.OrderProductController
import com.damiandev.microapporders.entity.OrderProduct
import com.damiandev.microapporders.services.OrderProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/orderProduct")
class OrderProductControllerImpl @Autowired constructor(private val orderProductService: OrderProductService): OrderProductController {
    @PostMapping("add")
    override fun addOrderProduct(@RequestBody orderProduct: OrderProduct): ResponseEntity<OrderProduct> {
        return ResponseEntity.ok(orderProductService.addOrderProduct(orderProduct))
    }
    @GetMapping("{orderId}")
    override fun getOrderProductByOrderId(@PathVariable orderId: Long): ResponseEntity<List<OrderProduct>> {
        return ResponseEntity.ok(orderProductService.getOrderProductByOrderId(orderId))
    }
    @DeleteMapping("delete/{orderId}")
    override fun deleteByOrderId(@PathVariable orderId: Long) {
        orderProductService.deleteByOrderId(orderId)
    }
    @DeleteMapping("delete")
    override fun deleteByOrderIds(@RequestParam orderIds: List<Long>) {
        orderProductService.deleteByOrderIds(orderIds)
    }
    @GetMapping("all")
    override fun getAllOrders(): ResponseEntity<List<OrderProduct>> {
        return ResponseEntity.ok(orderProductService.getAllOrderProducts())
    }
}