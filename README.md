> 해당 레포지토리의 소스코드에 대한 설명은 [기술 블로그](https://wonit.tistory.com/623?category=854727) 에 정리되어있습니다.


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
  - User(node) 에서 Order 로 GET 요청을 보낸다
  - Order 에서 Delivery 로 POST 요청을 보낸다
  - Delivery 에서 AWS SQS 로 Message 를 발행한다
  - AWS SQS 에 존재하는 Message 를 Notification 이 소비한다

## user-service

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

## order-service

Spring Boot 로 구성된 서버

> deliver-service 로 HTTP POST 요청을 보낸다

## delivery-service

Srping Boot 로 구성된 서버

- HTTP API 서버
- AWS SQS Message Producer

> order-service 로부터 받은 message 를 notification-queue 로 Message 를 produce 한다

## notification-consumer

Spring Boot 의 AWS SQS Listener 서버

- AWS SQS Message Consumer
  - 커스텀 zipkin reporter 를 이용한다
    - [zipkin-reporter-java-github](https://github.com/openzipkin/zipkin-reporter-java)

> notification-queue 에 남아있는 message 를 consume 한다
