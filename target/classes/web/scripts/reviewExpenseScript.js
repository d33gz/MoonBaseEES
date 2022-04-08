/*
commitReview = async (expenseId, expenseStatus) => {
	let expense = {
		
	}
	fetch('http://localhost:1969/commitReview')
		.then(response => response.json())
		.then(data => displayExpenses(data))
		.catch(err => alert('Request Failed', err));
		
		displayExpenses = (response) => {
		console.log(response);
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
};

callLogin = async (nameInput, passInput) => {
	let user = {
		empName: nameInput,
		empPass: passInput
	};
	let response = await fetch('http://localhost:1969/login', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json;charset=utf-8'
		},
		body: JSON.stringify(user)
	});
	let result = await response.text();
	if (result === "Good Good not Bad")
		window.location.href = "../pages/employeePage.html";
	if (result === "Wow quite Impressive")
		window.location.href = "../pages/managerPage.html";
};

function validateLogin() {
	let nameInput = document.getElementById('userName').value;
	let passInput = document.getElementById('password').value;
	callLogin(nameInput, passInput);
};*/