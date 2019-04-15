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

// Complete the aVeryBigSum function below.
function aVeryBigSum(ar) {
	var bigSum = 0;
	// var temp = "";
	for (var i = 0; i < ar.length; i++) {
		// temp = String(ar[i])
		// for (var j = temp.length - 1; j >= 0 ; j--) {
		//     if (i === 0) {
		//         bigSum.push(parseInt(temp.charAt(j)));
		//     } else {
		//         if (bigSum[j] + parseInt(temp.charAt(j)) > 10) {
		//             bigSum[j] = (bigSum[j] + parseInt(temp.charAt(j))) % 10;
		//             if (j === 0) {
		//                 bigSum.unshift(1);
		//             } else {
		//                 bigSum[j - 1] += 1;
		//             }
		//         } else {
		//             bigSum[j] += parseInt(temp.charAt(j));
		//         }
		//     }
		// }
		bigSum += parseInt(ar[i]);
	}
	return bigSum;
}

function main() {
	const ws = fs.createWriteStream(process.env.OUTPUT_PATH);
	
	const arCount = parseInt(readLine(), 10);
	
	const ar = readLine().split(' ').map(arTemp => parseInt(arTemp, 10));
	
	let result = aVeryBigSum(ar);
	
	ws.write(result + "\n");
	
	ws.end();
}
