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
	getExpenseToReview(expenseId);
};

getExpenseToReview = async (expenseId) => {
	alert("getting ma expense");
	let request = {
		reqId: expenseId
	};
	let response = await fetch('http://localhost:1969/reviewExpense', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json;charset=utf-8'
		},
		body: JSON.stringify(request)
	});
	let result = await response.json();
	console.log("here it is " + result);
	
	let managerContent = document.getElementById('managerPage');
	managerContent.innerHTML = "";
	managerContent.innerHTML = ` 
		<h1>Time to review a Request...</h1> 
		<div id="expenseToReview"></div>
		<form onsubmit="commitReview()">
			<input type="submit" value="Commit your Review"/>
		</form>
		<a href="./managerPage.html"><button type="button">Back</button></a>
		<iframe name="response-frame"
        style="width:20%;height:5%;border:2px solid black;"></iframe>`;
	setTimeout(displayExpense(result), 50000);
};

displayExpense = (response) => {
	console.log("okay let's set this thing up" + response);
	const expensesSection = document.getElementById('expenseToReview');
	let reviewExpense = document.createElement('ul');
	for (i = 0; i < response.length; i++) {
		let expenseItem = document.createElement('li');
		expenseItem.innerHTML = response[i].reqStatus + ' ' + response[i].reqTitle + ' ' + response[i].reqDate + 
			'<label for="trueRadio">True</label><input type="radio" id="trueRadio" name="trueRadio" value="true"><br>'+
			'<label for="falseRadio">False</label><input type="falseRadio" id="falseRadio" name="falseRadio" value="False">';
		reviewExpense.appendChild(expenseItem);
	};
	expensesSection.appendChild(reviewExpense);
};