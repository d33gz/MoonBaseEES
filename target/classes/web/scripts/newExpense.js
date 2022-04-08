callNewExpense = async (reqDate, reqTitle, reqDesc, reqCost) => {
	let newExpense = {
		reqDate: reqDate,
		reqTitle: reqTitle,
		reqDesc: reqDesc,
		reqCost: reqCost
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

newExpenseRequest = () => {
	let reqDate = document.getElementById('requestDate').innerHTML;
	let reqTitle = document.getElementById('requestTitle').value;
	let reqDesc = document.getElementById('requestDescription').value;
	let reqCost = document.getElementById('requestCost').value;
	callNewExpense(reqDate, reqTitle, reqDesc, reqCost);
};

spaceDate = () => {
	let newExpenseElement = document.getElementById('generatedList-newExpense');
	const date = new Date();
	let currentDay = date.getDay();
	let currentMonth = date.getMonth();
	let spaceYear = date.getFullYear() + 64;
	let spaceDate = `${currentDay}/${currentMonth}/${spaceYear}`;
	let generatedDate = document.createElement('li');
	generatedDate.setAttribute('id', 'requestDate');
	generatedDate.innerHTML = spaceDate;
	newExpenseElement.appendChild(generatedDate);
};