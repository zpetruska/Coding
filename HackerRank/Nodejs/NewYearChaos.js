'use strict';
const fs = require('fs');
const _ = require('lodash');
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

// Complete the minimumBribes function below.
function minimumBribes(q) {
	let n = q.length;
	let bribes = 0;
	for (let i = n; i-- > 0;) {
		if (q[i] - (i + 1) > 2) {
			bribes = "Too chaotic";
			break;
		}
		for (let j = q[i] - 2; j < i; j++) {
			if (q[j] > q[i])
				bribes++;
		}
	}
	return bribes;
}

function main() {
	const ws = fs.createWriteStream(process.env.OUTPUT_PATH);
	
	const t = parseInt(readLine(), 10);
	
	for (let tItr = 0; tItr < t; tItr++) {
		const n = parseInt(readLine(), 10);
		
		const q = readLine().split(' ').map(qTemp => parseInt(qTemp, 10));
		
		ws.write(minimumBribes(q) + "\n");
		
	}
	ws.end();
	
}
