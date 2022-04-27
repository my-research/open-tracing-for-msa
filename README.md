# Open Tracing In Msa

**Zipkin** 을 활용하여 **Polygrat 한 마이크로서비스 환경**에 대한 분산 추적을 PoC 한다.

## Microservices

- **user-service** : express.js
- **order-service** : springboot
- **delivery-service** : springboot
- **notification-queue** : AWS SQS
- **tracer** : Zipkin (docker, openzipkin/zipkin)

# 호출 Flow

- User -> Order -> Delivery -> Notification Queue

# user-service

Node Express Server

### npm dependencies

```bash
npm install --save express
npm install --save axios

npm install --save zipkin
npm install --save zipkin-context-cls
npm install --save zipkin-instrumentation-express
npm install --save zipkin-instrumentation-fetch
npm install --save zipkin-transport-http
```

### node-zipkin references

- [tracing-express-service](https://medium.com/trabe/tracing-express-services-with-zipkin-js-6e5c5680467e)

# order-service

Spring Boot 로 구성된 서버

> deliver-service 로 HTTP POST 요청을 보낸다

# delivery-service

Srping Boot 로 구성된 서버

- HTTP API 서버
- Message Producer

> order-service 로부터 받은 message 를 notification-queue 로 Message 를 produce 한다

# notification-consumer

AWS SQS Listener

- Message Consumer

> notification-queue 에 남아있는 message 를 consume 한다
