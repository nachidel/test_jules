package com.productionapp.shared.api

import com.productionapp.shared.models.Credentials
import com.productionapp.shared.models.UserSession
// ApiError might be implicitly handled by Ktor's exception system or a wrapper class,
// but it's good to have it in mind for return types if not using exceptions for flow control.

interface AuthApi {
    /**
     * Attempts to log in the user.
     * @return UserSession on success.
     * @throws Exception or a specific typed exception (e.g., containing ApiError) on failure.
     * Ktor client typically throws exceptions for non-2xx responses, which can be caught.
     */
    suspend fun login(credentials: Credentials): UserSession
}
