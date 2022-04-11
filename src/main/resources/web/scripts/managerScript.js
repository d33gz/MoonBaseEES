let url = 'http://localhost:1969/'
getManagerName = () => {
	alert('Fetching the Manager')
	fetch(url + "getName")
		.then(response => response.json())
		.then(data => JSON.stringify(data))
		.then(data => displayName(data))
		.catch(err => alert('Request Failed', err));
		
	displayName = (response) => {
		console.log("now we are getting somewhere " + response);
		alert("Okay we are displaying");

	}
};

getMyEmployees = () => {
	fetch('http://localhost:1969/allEmployees')
		.then(response => response.json())
		.then(data => displayEmployees(data))
		.catch(err => alert('Request Failed', err));
		
	displayEmployees = (response) => {
		const employeeSection = document.getElementById('muhEmployees');
		let list = document.createElement('ul');
		for (i = 0; i < response.length; i++) {
			let item = document.createElement('li');
			item.innerHTML = response[i].empId + "\n" + response[i].empRole + "\n" + response[i].empName + "\n" + response[i].empStation + "\n" + response[i].empStatus;
			list.appendChild(item);
		};
		employeeSection.appendChild(list);
	};
};

loadManagerPage = () => {
	getManagerName();	
	getMyEmployees();
};

