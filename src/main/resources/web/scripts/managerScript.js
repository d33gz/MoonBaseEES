getAllExpenses = () => {
	fetch('http://localhost:1969/allExpenses')
		.then(response => response.json())
		.then(data => displayExpenses(data))
		.catch(err => alert('Request Failed', err));
		
	displayExpenses = (response) => {
		const expensesSection = document.getElementById('allExpenses');
		let expensesList = document.createElement('ul');
		for (i = 0; i < response.length; i++) {
			let expenseItem = document.createElement('li');
			expenseItem.setAttribute('id', `${response[i].reqId}`);
			expenseItem.innerHTML = response[i].reqStatus + ' ' + response[i].reqTitle + ' ' + response[i].reqDate + '<button type="button" onclick="reviewExpense(this)">Check Expense</button>';
			expensesList.appendChild(expenseItem);
		};
		expensesSection.appendChild(expensesList);
	};
};

reviewExpense = (button) => {
	expenseId = button.parentElement.id;
	setExpenseToReview(expenseId);
};

setExpenseToReview = async (expenseId) => {
	let request = {
		reqId: expenseId
	};
	let response = await fetch('http://localhost:1969/setExpense', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json;charset=utf-8'
		},
		body: JSON.stringify(request)
	});
	let result = await response.text();
	window.location.href = "../pages/reviewExpense.html";
};