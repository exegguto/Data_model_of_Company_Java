package com.example.routes

import com.example.data.Company
import com.example.data.customerStorage
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

fun Route.customerRouting() {
    route("/customer") {
        get {
            if (customerStorage.isNotEmpty()) {
                call.respond(Json.encodeToString(customerStorage))
            } else {
                call.respondText("No customers found", status = HttpStatusCode.OK)
            }
        }
        get("{id?}") {
            val id = call.parameters["id"] ?: return@get call.respondText(
                "Missing name",
                status = HttpStatusCode.BadRequest
            )
            val customer =
                customerStorage.find { it.name == id } ?: return@get call.respondText(
                    "No customer with id $id",
                    status = HttpStatusCode.NotFound
                )
            call.respond(Json.encodeToString(customer))
        }
        post {
            val customer = call.receive<Company>()
            customerStorage.add(customer)
            call.respondText("Customer stored correctly", status = HttpStatusCode.Created)

        }
        delete("{id?}") {
            val id = call.parameters["id"] ?: return@delete call.respond(HttpStatusCode.BadRequest)
            if (customerStorage.removeIf { it.name == id }) {
                call.respondText("Customer removed correctly", status = HttpStatusCode.Accepted)
            } else {
                call.respondText("Not Found", status = HttpStatusCode.NotFound)
            }
        }
    }
}
