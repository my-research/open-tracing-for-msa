const express = require('express')

const {Tracer, ExplicitContext, BatchRecorder, jsonEncoder} = require('zipkin');
const {HttpLogger} = require('zipkin-transport-http');
const zipkinMiddleware = require('zipkin-instrumentation-express').expressMiddleware;

const ZIPKIN_ENDPOINT = "http://localhost:9411";

const tracer = new Tracer({
	ctxImpl: new ExplicitContext(),
	recorder: new BatchRecorder({
		logger: new HttpLogger({
			endpoint: `${ZIPKIN_ENDPOINT}/api/v2/spans`,
			jsonEncoder: jsonEncoder.JSON_V2,
		}),
	}),
	localServiceName: "user-service!",
});

const app = express();
app.use(zipkinMiddleware({tracer}));

app.get('/', (req, res) => {
	res.send('hello zipkin');
});

const server = app.listen(8000, () => {
	console.log('[User-Service] server started');
});
