Arithmatic Calculation with AWS APIGATEWAY EVENT TRIGGERING - Additional

This is adding a simple arithmatic operation based on INT Data type as primary.

This needs to be import as gradle project in inteliji or any and then it works as expected below.
Build project and package as jar

```
gradle shadowJar
```

Login with Aws as

```
aada login -n -p env
```

Created Lambda function & Available in AWS

```
aws lambda --profile env --region eu-west-1 create-function --function-name  ApiCalculation --zip-file fileb://ApiGateway-Kotlin-all.jar --handler com.test.App --runtime java11 --role arn:aws:iam::XXXXXXXXXX:role/service-role/lambda-basic-execution --memory 1024

```

Adding Event Trigger for APIGATEWAY 

Choose lambda function and add trigger then choose APIGATEWAY.

Create api ->http api ->secuirty as open then ADD
XXXX should be replacing after deployed lambda then manually created apigateway and its reference id.

Request as hitting in browser
```
https://XXXXXXXX.execute-api.eu-west-1.amazonaws.com/default/ApiCalculation?argument1=22&argument2=2&method=ADD&dataType=Int
```
Response in browser as :
```
{"argument1":22,"argument2":2,"result":24,"method":"ADD","message":"Success","statusCode":"200"}
```

POSTMAN TOOL

Hit the same url and add the query params for response.

Terminal With AWS CLi Credentials(optional)

XXXX should be replacing after deployed lambda then manually created apigateway and its reference id.
```
curl -X GET "https://XXXXX.execute-api.eu-west-1.amazonaws.com/default/ApiCalculation?number1=22&number2=2&method=ADD&dataType=Int"
```
```
{ "argument1":22,"argument2":2,"result":24,"method":"ADD","message":"Success","statusCode":"200"} 
```