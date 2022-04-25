const express = require('express')
const app = express();

app.get('/', (req, res) => {
	res.send('hello zipkin');
});

const server = app.listen(8000, () => {
	console.log('server started');
});
