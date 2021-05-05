package com.test

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.amazonaws.services.lambda.runtime.LambdaLogger
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2HTTPEvent
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2HTTPResponse
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule


class App : RequestHandler<APIGatewayV2HTTPEvent, APIGatewayV2HTTPResponse> {

    private val mapper: ObjectMapper = JsonMapper.builder()
        .addModule(KotlinModule())
        .serializationInclusion(JsonInclude.Include.NON_NULL)
        .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
        .build()
/***Creating simple https service using apigateway with Lambda**********/
    override fun handleRequest(input: APIGatewayV2HTTPEvent?, context: Context?): APIGatewayV2HTTPResponse {
        var log: LambdaLogger = context!!.logger

        input?.let {
            val handlerInput: HandlerInput = HandlerInput();

            handlerInput.argument1 = it.queryStringParameters["argument1"]!!.toInt()
            handlerInput.argument2 = it.queryStringParameters["argument2"]!!.toInt()
            handlerInput.dataType = it.queryStringParameters["dataType"]!!.toString()
            handlerInput.method = OperationType.valueOf(it.queryStringParameters["method"]!!)


            /***this apigate way example for accessing the integers as primary data type*********/
            val response = APIGatewayV2HTTPResponse.builder().withStatusCode(200).withBody(
                mapper.writeValueAsString(
                    HandlerOutput(
                        handlerInput.argument1, handlerInput.argument2,
                        handlerInput.method.applyAsInt(handlerInput.argument1, handlerInput.argument2),
                        handlerInput.method.toString(),
                        "Success", "200"
                    )
                )
            ).build()

            log.log("${handlerInput.method.applyAsInt(handlerInput.argument1, handlerInput.argument2)}")

            return response

        }
        return APIGatewayV2HTTPResponse.builder().withStatusCode(200).build()
    }
}
