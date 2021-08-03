package com.hopsha.itsinternconcurrency

import java.io.Serializable

data class Order(
    val name: String,
    var status: Status
) : Serializable