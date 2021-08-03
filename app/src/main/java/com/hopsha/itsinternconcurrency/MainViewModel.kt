package com.hopsha.itsinternconcurrency

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.runBlocking

class MainViewModel : ViewModel() {

    private val factory = OrderFactory()
    private val dispatcher = OrderDispatcher()
    private val orders: MutableList<Order> = mutableListOf()

    private val internalState = MutableSharedFlow<State>()
    val state: Flow<State>
        get() = internalState


    fun postOrder() {
        triggerStateUpdate()
    }

    private fun triggerStateUpdate() = runBlocking {
        internalState.emit(State(orders))
    }

    data class State(
        val orders: List<Order>
    )
}