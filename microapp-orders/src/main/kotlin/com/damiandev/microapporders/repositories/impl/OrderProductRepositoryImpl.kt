package com.damiandev.microapporders.repositories.impl

import com.damiandev.microapporders.configuration.DBContext
import com.damiandev.microapporders.entity.OrderProduct
import com.damiandev.microapporders.entity.OrderProducts
import com.damiandev.microapporders.repositories.OrderProductRepository
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.SqlExpressionBuilder.inList
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
class OrderProductRepositoryImpl : OrderProductRepository{
    override fun addOrderProduct(orderProduct: OrderProduct): OrderProduct? {
        val insertStatement = transaction(Database.connect(DBContext.dataSource))
        {
            OrderProducts.insert {
                it[orderId] = orderProduct.orderId
                it[productId] = orderProduct.productId
                it[quantity] = orderProduct.quantity
                it[price] = orderProduct.price
            }
        }
        return insertStatement.resultedValues?.singleOrNull()?.let(::resultRowToOrderProduct)
    }

    override fun getOrderProduct(orderId: Long): List<OrderProduct>? {
        return transaction(Database.connect(DBContext.dataSource)) {
            OrderProducts.select { OrderProducts.orderId eq orderId }
                    .map(::resultRowToOrderProduct)
        }
    }

    override fun deleteByOrderId(orderId: Long) {
        transaction(Database.connect(DBContext.dataSource)) {
            OrderProducts.deleteWhere { OrderProducts.orderId eq orderId }
        }
    }

    override fun deleteByOrderIds(orderIds: List<Long>) {
        transaction(Database.connect(DBContext.dataSource)) {
            OrderProducts.deleteWhere { orderId inList orderIds }
        }
    }

    override fun getAllOrderProducts(): List<OrderProduct>? {
        return transaction(Database.connect(DBContext.dataSource))
        {
            OrderProducts.selectAll().map(::resultRowToOrderProduct)
        }
    }

    private fun resultRowToOrderProduct(row: ResultRow) = OrderProduct(
            orderId = row[OrderProducts.orderId],
            productId = row[OrderProducts.productId],
            quantity = row[OrderProducts.quantity],
            price = row[OrderProducts.price]
    )
}