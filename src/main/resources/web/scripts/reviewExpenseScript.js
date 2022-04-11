var responseId;

getExpenseToReview = async () => {
	alert("getting ma expense");
	let response = await fetch('http://localhost:1969/reviewExpense', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json;charset=utf-8'
		},
	});
	let result = await response.json();
	displayExpense(result);
};

validateExpense = () => {
	let approve = document.getElementById("approveRadio");
	let deny = document.getElementById("denyRadio");
	let updateStatus = 0;
	if (approve.checked) {
		updateStatus = approve.value;
		updateExpense(updateStatus);
	} else if (deny.checked) {
		updateStatus = deny.value;
		updateExpense(updateStatus);	
	} else alert("You need to Approve or Deny the request.");
};

updateExpense = async (updateStatus) => {
	let expenseToUpdate = {
		reqId: responseId,
		reqStatus: updateStatus,
	};
	alert("updating ma expense");
	let response = await fetch('http://localhost:1969/updateExpense', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json;charset=utf-8'
		},
		body: JSON.stringify(expenseToUpdate)
	});
	let result = await response.json();
	displayExpense(result);
};

displayExpense = (response) => {
	responseId = response.reqId;
	const expensesSection = document.getElementById('expenseToReview');
	let expenseItem = document.createElement('span');
	if (response.reqStatus == 0) {
		expenseItem.innerHTML = response.reqStatus + ' ' + response.reqTitle + ' ' + response.reqDate + '<br>' +
			`
			<label for="trueRadio">Approve</label><input type="radio" id="approveRadio" name="status" value=1><br>
			<label for="falseRadio">Deny</label><input type="radio" id="denyRadio" name="status" value=-1><br>
			<button type="button" onclick=(validateExpense()) value="Commit your Review">Commit Status</button>
			`;
		expensesSection.appendChild(expenseItem);
	} else if (response.reqStatus == -1 ||response.reqStatus == 1) {
		expenseItem.innerHTML = response.reqStatus + ' ' + response.reqTitle + ' ' + response.reqDate;
		expensesSection.appendChild(expenseItem);
	}
};
