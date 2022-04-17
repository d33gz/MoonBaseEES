getUserExpenses = () => {
	fetch('http://localhost:1969/userExpenses')
		.then(response => response.json())
		.then(data => displayExpenses(data))
		.catch(err => alert('Request Failed', err));
		
		displayExpenses = (response) => {
		const expensesSection = document.getElementById('userExpenses');
		let expensesList = document.createElement('ul');
		for (i = 0; i < response.length; i++) {
			let expenseItem = document.createElement('li');
			console.log(response[i]);
			if (response[i].reqStatus = 0) {
				expenseItem.innerHTML = `
					<img src="../images/icons/ToBeDetermined.png"/>
					<span id="inner-text"${response[i].reqDate}: ${response[i].reqTitle}</span>
					<a id="last-row" href="../images/spaceCowboy.png">
						<img src="../images/icons/ViewExpense.png"/>
					</a>
				`
			} else if (response[i].reqStatus = 0) {
				expenseItem.innerHTML = `
					<img src="../images/icons/Approved.png"/>
					<span id="inner-text"${response[i].reqDate}: ${response[i].reqTitle}</span>
					<a id="last-row" href="../images/spaceCowboy.png">
						<img src="../images/icons/ViewExpense.png"/>
					</a>
				`
			} else {
				expenseItem.innerHTML = `
					<img src="../images/icons/Denied.png"/>
					<span id="inner-text"${response[i].reqDate}: ${response[i].reqTitle}</span>
					<a id="last-row" href="../images/spaceCowboy.png">
						<img src="../images/icons/ViewExpense.png"/>
					</a>
				`
			}
			expensesList.appendChild(expenseItem);
		};
		expensesSection.appendChild(expensesList);
	};
};