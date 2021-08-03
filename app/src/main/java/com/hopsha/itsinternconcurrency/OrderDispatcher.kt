package com.hopsha.itsinternconcurrency

import android.util.Log

class OrderDispatcher {

    fun processOrder(order: Order) {
        order.status = Status.IN_PROGRESS
        Thread.sleep(1000)
        Log.d("OrderDispatcher", "Processing order: ${order.name}")
        order.status = Status.DONE
    }
}