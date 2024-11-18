package org.solyton.solawi.bid.application.storage.event

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.evoleq.math.*
import org.evoleq.optics.storage.Storage
import org.solyton.solawi.bid.application.data.*

@MathDsl
fun Storage<Application>.onDispatch(configure: suspend Storage<Application>.()->Unit): Storage<Application> {
    CoroutineScope(Job()).launch {configure()}
    return this
}
