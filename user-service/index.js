const express = require('express')

const axios = require('axios');
const zipkinInstrumentationAxios = require('zipkin-instrumentation-axios');

const {Tracer, ExplicitContext, BatchRecorder, jsonEncoder} = require('zipkin');
const {HttpLogger} = require('zipkin-transport-http');
const zipkinMiddleware = require('zipkin-instrumentation-express').expressMiddleware;

const ZIPKIN_ENDPOINT = "http://localhost:9411";
const ORDER_SERVICE_ENDPOINT = "http://localhost:8080/";

const tracer = new Tracer({
	ctxImpl: new ExplicitContext(),
	recorder: new BatchRecorder({
		logger: new HttpLogger({
			endpoint: `${ZIPKIN_ENDPOINT}/api/v2/spans`,
			jsonEncoder: jsonEncoder.JSON_V2,
		}),
	}),
	localServiceName: "user-service",
});

const app = express();
app.use(zipkinMiddleware({tracer}));

const zipkinAxios = zipkinInstrumentationAxios(axios, { tracer, serviceName: "axios-client" });

app.get('/', async (req, res) => {
	const result = await zipkinAxios.get(`${ORDER_SERVICE_ENDPOINT}`);
	res.send('[user-service] :: ' + result.data);
});

const server = app.listen(8000, () => {
	console.log('[User-Service] server started');
});
