'use strict';

const fs = require('fs');

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
	inputString += inputStdin;
});

process.stdin.on('end', _ => {
	inputString = inputString.replace(/\s*$/, '')
		.split('\n')
		.map(str => str.replace(/\s*$/, ''));
	
	main();
});

function readLine() {
	return inputString[currentLine++];
}

// Complete the repeatedString function below.
function repeatedString(s, n) {
	let aCount = 0;
	let shortLength = n > s.length ? s.length : n;
	for (let i = 0; i < shortLength; i++) {
		if (s.charAt(i) === 'a') {
			aCount++;
		}
	}
	aCount = aCount * ((n - n % shortLength) / shortLength);
	for (let i = 0; i < n % shortLength; i++) {
		if (s.charAt(i) === 'a') {
			aCount++;
		}
	}
	return aCount;
}

function main() {
	const ws = fs.createWriteStream(process.env.OUTPUT_PATH);
	
	const s = readLine();
	
	const n = parseInt(readLine(), 10);
	
	let result = repeatedString(s, n);
	
	ws.write(result + "\n");
	
	ws.end();
}
