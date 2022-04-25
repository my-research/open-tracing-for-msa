# Open Tracing In Msa

마이크로서비스에서 분산 추적 환경에 대한 PoC

## Microservices

- **user-service** : express.js
- **order-service** : springboot
- **delivery-service** : springboot
- **Delivery-Queue** : AWS SQS
- **Tracer** : Zipkin (docker, openzipkin/zipkin)

# 호출 Flow

- User -> Order -> Delivery -> Delivery Queue

## User-Service

Node Express Server

### npm dependencies

```bash
npm install --save express
npm install --save node-fetch
npm install --save zipkin
npm install --save zipkin-context-cls
npm install --save zipkin-instrumentation-express
npm install --save zipkin-instrumentation-fetch
npm install --save zipkin-transport-http
```
