package org.solyton.solawi.bid.module.user.action

import io.ktor.server.response.*
import org.evoleq.math.state.bind
import org.evoleq.math.state.map
import org.evoleq.math.x
import org.evoleq.util.ApiAction
import org.evoleq.util.DbAction
import org.jetbrains.exposed.sql.SizedIterable
import org.jetbrains.exposed.sql.transactions.transaction
import org.solyton.solawi.bid.module.user.data.api.User
import org.solyton.solawi.bid.module.db.schema.User as UserEntity

/**
 * Get all users in the database
 */
// val GetAllUsers =
suspend fun getAllUsers() = DbAction {
    database -> transaction(database) {
        UserEntity.all()
    } x database
 } map { userEntities: SizedIterable<UserEntity> ->
    userEntities.map { userEntity ->
        User(
            userEntity.id.value,
            userEntity.username,
            userEntity.password
        )
    }
 } bind { users -> ApiAction{ call ->
    call.respond(users) x call
} }



