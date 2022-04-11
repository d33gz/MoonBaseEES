let url = 'http://localhost:1969/'
getMyManager = () => {
	alert('Fetching the Manager')
	fetch(url + "manager")
		.then(response => response.json())
		.then(data => JSON.stringify(data))
		.then(data => {return data})
		.catch(err => alert('Request Failed', err));
};

getMyExpenses = () => {
	alert('Fetching the Expenses');
	fetch(url + "allExpenses")
		.then(response => response.json())
		.then(data => JSON.stringify(data))
		.then(data => {return data})
		.catch(err => alert('Request Failed', err));
};

loadEmployeePage = () => {
	let employeeName = getMyEmployee();
	let expenseList = getMyExpenses();
	let employeeElement = document.getElementById('employeeName');
	employeeElement.innerHTML = employeeName;
	console.log(expenseList);
	
	const expensesSection = document.getElementById('muhExpenses');
		let expenseList = document.createElement('ul');
		for (i = 0; i < response.length; i++) {
			let item = document.createElement('li');
			expenseItem.innerHTML = expenseList[i].empId + '\n' + response[i].empRole + '\n' + response[i].empName + "\n" + response[i].empStation + "\n" + response[i].empStatus;
			expenseList.appendChild(expenseItem);
		};
		expensesSection.appendChild(expenseList);
};