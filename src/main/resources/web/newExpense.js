callNewExpense = async (reqDate, reqTitle, reqDesc, reqCost) => {
	alert("Getting somewhere...");
	let newExpense = {
		requestDate: reqDate,
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

newExpenseRequest = () => {
	let reqDate = document.getElementById('requestDate').innerHTML;
	let reqTitle = document.getElementById('requestTitle').value;
	let reqDesc = document.getElementById('requestDescription').value;
	let reqCost = document.getElementById('requestCost').value;
	alert('inputting!!!');
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