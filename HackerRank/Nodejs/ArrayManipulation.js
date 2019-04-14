'use strict';

const fs = require('fs');
const _ = require('lodash');

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
	console.log("line:", inputStdin);
	
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

// Complete the arrayManipulation function below.
function arrayManipulation(n, queries) {
	let nray = _.fill(Array(n), 0);
	let max = 0;
	let temp = 0;
	for (let i = 0; i < queries.length; i++) {
		nray[queries[i][0] - 1] += queries[i][2];
		if (queries[i][1] != n) {
			nray[queries[i][1]] -= queries[i][2];
		}
	}
	for (let j = 0; j < n; j++) {
		temp += nray[j];
		if (temp > max) {
			max = temp;
		}
	}
	return max;
}

function main() {
	const ws = fs.createWriteStream(process.env.OUTPUT_PATH);
	const nm = readLine().split(' ');
	
	const n = parseInt(nm[0], 10);
	
	const m = parseInt(nm[1], 10);
	
	let queries = Array(m);
	
	for (let i = 0; i < m; i++) {
		queries[i] = readLine().split(' ').map(queriesTemp => parseInt(queriesTemp, 10));
	}
	
	let result = arrayManipulation(n, queries);
	
	ws.write(result + "\n");
	
	ws.end();
}
