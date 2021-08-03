package com.hopsha.itsinternconcurrency

class OrderFactory {

    private var counter = 0

    fun create(): Order {
        val name = "Order ${++counter}"
        return Order(name, Status.QUEUED)
    }
}