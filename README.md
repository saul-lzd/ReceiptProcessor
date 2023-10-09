# ReceiptProcessor
Receipt Processor - Java API

## Run with Spring
```
$ ./mvnw clean compile package
$ ./mvnw spring-boot:run
```

## Run with Docker
```
$ docker pull saullzd/myapp:1
$ docker run -d -p 8080:8080 --name myContainer saullzd/myapp:1
```
> the docker image for this project is already uploaded to Docker hub. https://hub.docker.com/r/saullzd/myapp

## Endpoints

http://localhost:8080/
- A message is displayed to notify app is running
- Method: GET

http://localhost:8080/receipts/process
- Create a new "receipt" resource
- Method: POST
- Response example: {id: 8981d6b8-aa0f-48df-a74e-0ea07b19deac}


http://localhost:8080/receipts/{id}/points
- Compute the "awarded points" for the given {id} according to the provided rules
- Method: GET
- Response example {points : 109}

http://localhost:8080/receipts
- Method: GET
- Response: List of receipts
> _**Endpoint not requested but provided in order to visualize the resources that are being created**_

## Execute endpoints with CURL

**Validate application is running**
```
curl --request GET http://localhost:8080/
```

**Get points for the given {id}**
```
curl --request GET http://localhost:8080/receipts/{id}/points
```

**Get all receipts**
```
curl --request GET http://localhost:8080/receipts
```

**Create a new receipt**
```
curl --header "Content-Type:application/json" --data '{json_entity}' --request POST http://localhost:8080/receipts/process
```







