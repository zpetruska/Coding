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

process.stdin.on('end', function() {
	inputString = inputString.replace(/\s*$/, '')
		.split('\n')
		.map(str => str.replace(/\s*$/, ''));
	
	main();
});

function readLine() {
	return inputString[currentLine++];
}

// Complete the minimumSwaps function below.
function minimumSwaps(arr) {
	let swap = 0;
	for (let i = 0; i < arr.length; i++) {
		const temp = arr[i];
		if (temp !== i + 1) {
			arr[i] = arr[temp-1];
			arr[temp - 1] = temp;
			swap++;
			i--;
		}
	}
	return swap;
}

function main() {
	const ws = fs.createWriteStream(process.env.OUTPUT_PATH);
	
	const n = parseInt(readLine(), 10);
	
	const arr = readLine().split(' ').map(arrTemp => parseInt(arrTemp, 10));
	
	const res = minimumSwaps(arr);
	
	ws.write(res + '\n');
	
	ws.end();
}
