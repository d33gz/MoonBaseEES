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
			if (response[i].reqStatus === 0) {
				expenseItem.innerHTML = `
					<img src="../images/icons/ToBeDetermined.png"/>
					<span id="inner-text">${response[i].reqDate}: ${response[i].reqTitle}</span>
					<button id="last-row" onclick="reviewExpense(this)">
						<img src="../images/icons/ViewExpense.png"/>
					</button>
				`
			} else if (response[i].reqStatus === 1) {
				expenseItem.innerHTML = `
					<img src="../images/icons/Approved.png"/>
					<span id="inner-text">${response[i].reqDate}: ${response[i].reqTitle}</span>
					<button id="last-row" onclick="reviewExpense(this)">
						<img src="../images/icons/ViewExpense.png"/>
					</button>
				`
			} else {
				expenseItem.innerHTML = `
					<img src="../images/icons/Denied.png"/>
					<span id="inner-text">${response[i].reqDate}: ${response[i].reqTitle}</span>
					<button id="last-row" onclick="reviewExpense(this)">
						<img src="../images/icons/ViewExpense.png"/>
					</button>
				`
			}
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
	await fetch('http://localhost:1969/setExpense', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json;charset=utf-8'
		},
		body: JSON.stringify(request)
	});
	window.location.href = "../pages/reviewExpense.html";
};