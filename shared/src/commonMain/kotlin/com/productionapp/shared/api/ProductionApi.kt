package com.productionapp.shared.api

import com.productionapp.shared.models.ProductionOrder
// ApiError might be implicitly handled by Ktor's exception system or a wrapper class,
// but it's good to have it in mind for return types if not using exceptions for flow control.

interface ProductionApi {
    /**
     * Fetches the list of production orders.
     * @return A list of ProductionOrder.
     * @throws Exception or a specific typed exception (e.g., containing ApiError) on failure.
     * Ktor client typically throws exceptions for non-2xx responses, which can be caught.
     */
    suspend fun getProductionOrders(): List<ProductionOrder>

    /**
     * Signals the start of a production order and potentially the end of a previous one.
     * @param ofNumber The OF number of the order being started.
     * @param machineName The machine where the order is being started.
     * @param previousOfNumber Optionally, the OF number of the previous order on this machine, to be closed.
     * @throws Exception or a specific typed exception (e.g., containing ApiError) on failure.
     * Ktor client typically throws exceptions for non-2xx responses, which can be caught.
     * The return type is Unit, indicating no specific data is returned on success,
     * but an exception will be thrown for failures.
     */
    suspend fun startOrder(ofNumber: String, machineName: String, previousOfNumber: String?): Unit
}
