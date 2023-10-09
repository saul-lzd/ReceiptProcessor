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

> _docker run_ command will create a container named "myContainer"

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
- Endpointd provided to visualize all resources created
- Method: GET
- Response: List of receipts







