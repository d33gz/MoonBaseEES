var responseId;

getExpenseToReview = async () => {
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
		alert("Request Approved!");
		updateStatus = approve.value;
		updateExpense(updateStatus);
	} else if (deny.checked) {
		alert("Request Denied!");
		updateStatus = deny.value;
		updateExpense(updateStatus);	
	} else alert("You need to Approve or Deny the request.");
};

updateExpense = async (updateStatus) => {
	let expenseToUpdate = {
		reqId: responseId,
		reqStatus: updateStatus,
	};
	let response = await fetch('http://localhost:1969/updateExpense', {
		method: 'PUT',
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
	console.log("What we got " + response);
	console.log("What we got Title " + response.reqTitle);
	console.log("What we got Date " + response.reqDate);
	console.log("What we got Cost " + response.reqCost);
	console.log("What we got Desc " + response.reqDesc);
	const expenseSection = document.getElementById('request-box');
	if (response.reqStatus == 0) {
		expenseSection.innerHTML = `
			<ul><li>${response.reqDate}</li</ul>
          	<form id="review-request-form" onsubmit="goodRequest()">
				<div id="form-column-left">
		        	<label for="requestTitle">Request Title</label><br>
		        	<input id="requestTitle" name="requestTitle" type="text" size="35" value="${response.reqTitle}" disabled/><br>
		        	<label for="requestCost">Moon Token Cost</label><br>
		        	<input id="requestCost" name="requestCost" type="number" value="${response.reqCost}" disabled/><br><br>
		        	<label for="trueRadio">Approve</label><input type="radio" id="approveRadio" name="status" value=1>
			    	<label for="falseRadio">Deny</label><input type="radio" id="denyRadio" name="status" value=-1><br>
			    	<button type="submit" onclick=(validateExpense()) value="Commit your Review">Commit Status</button>
		        </div>
		        <div id="form-column-right">
		        	<label for="requestDescription">Request Description</label><br>
		        	<textarea id="requestDescription" name="requestDescription" type="textarea" rows="10" cols="40" disabled>${response.reqDesc}</textarea><br>
		    	</div>
			</form>
		`
	} else if (response.reqStatus == -1 ||response.reqStatus == 1) {
		expenseSection.innerHTML = `
			<ul><li>${response.reqDate}</li</ul>
          	<form id="review-request-form" onsubmit="goodRequest()">
				<div id="form-column-left">
		        	<label for="requestTitle">Request Title</label><br>
		        	<input id="requestTitle" name="requestTitle" type="text" size="35" value="${response.reqTitle}" disabled/><br>
		        	<label for="requestCost">Moon Token Cost</label><br>
		        	<input id="requestCost" name="requestCost" type="number" value="${response.reqCost}" disabled/><br><br>
		        </div>
		        <div id="form-column-right">
		        	<label for="requestDescription">Request Description</label><br>
		        	<textarea id="requestDescription" name="requestDescription" type="textarea" rows="10" cols="40" disabled>${response.reqDesc}</textarea><br>
		    	</div>
			</form>
		`
	}
};
