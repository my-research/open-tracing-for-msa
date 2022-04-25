const {Tracer, ExplicitContext, BatchRecorder, jsonEncoder} = require('zipkin');
const {HttpLogger} = require('zipkin-transport-http');

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

export default tracer;