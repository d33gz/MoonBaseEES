async function callNewExpense(reqTitle, reqDesc, reqCost) {
	let newExpense = {
		requestTitle: reqTitle,
		requestDescription: reqDesc,
		requestCost: reqCost
	};
	let response = await fetch('http://localhost:1969/newExpense', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json;charset=utf-8'
		},
		body: JSON.stringify(newExpense)
	});
	let result = await response.text();
	alert(result);
};




function newExpenseLogin() {
	let reqTitle = document.getElementById('requestTitle').value;
	let reqDesc = document.getElementById('requestDescription').value;
	let reqCost = document.getElementById('requestCost').value;
	alert('inputting!!!');
	callNewExpense(reqTitle, reqDesc, reqCost);
};