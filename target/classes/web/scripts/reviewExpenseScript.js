getExpenseToReview = async () => {
	alert("getting ma expenses");
	let response = await fetch('http://localhost:1969/reviewExpense', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json;charset=utf-8'
		},
	});
	let result = await response.json();
	displayExpense(result);
};

displayExpense = (response) => {
	const expensesSection = document.getElementById('expenseToReview');
	let expenseItem = document.createElement('span');
	expenseItem.innerHTML = response.reqStatus + ' ' + response.reqTitle + ' ' + response.reqDate + 
		'<label for="trueRadio">True</label><input type="radio" id="trueRadio" name="trueRadio" value="true"><br>'+
		'<label for="falseRadio">False</label><input type="radio" id="falseRadio" name="falseRadio" value="False">';
	expensesSection.appendChild(expenseItem);
};
