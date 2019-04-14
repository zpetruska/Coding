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

function leftRotation(n, d, a) {
	let left = Array(n);
	for (let i = 0; i < n; i++) {
		left[i] = a[(i + d)%n];
	}
	return left;
}


function main() {
	const ws = fs.createWriteStream(process.env.OUTPUT_PATH);
	
	const nd = readLine().split(' ');
	
	const n = parseInt(nd[0], 10);
	
	const d = parseInt(nd[1], 10);
	
	const a = readLine().split(' ').map(aTemp => parseInt(aTemp, 10));
	
	const res = leftRotation(n, d, a);
	
	ws.write(res.join(' ') + '\n');
	
	ws.end();
}
