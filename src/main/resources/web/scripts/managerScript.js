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
			expenseItem.innerHTML = response[i].reqStatus + ' ' + response[i].reqTitle + " " + response[i].reqDate;
			expensesList.appendChild(expenseItem);
		};
		expensesSection.appendChild(expensesList);
	};
};