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

// Complete the sockMerchant function below.
function sockMerchant(n, ar) {
	let pairs = 0;
	let socks = {};
	for (let i = 0; i < n; i++) {
		if (socks[ar[i]] === undefined) {
			socks[ar[i]] = 0;
		}
		socks[ar[i]]++;
	}
	for (const color in socks) {
		let value = socks[color];
		if (value > 1) {
			pairs += (value - value%2) / 2;
		}
	}
	return pairs;
}

function main() {
	const ws = fs.createWriteStream(process.env.OUTPUT_PATH);
	
	const n = parseInt(readLine(), 10);
	
	const ar = readLine().split(' ').map(arTemp => parseInt(arTemp, 10));
	
	let result = sockMerchant(n, ar);
	
	ws.write(result + "\n");
	
	ws.end();
}
