getMyEmployees = () => {
	alert('Fetching the Employees');
	const getUrl = 'http://localhost:1969/allEmployees';
	fetch(getUrl)
		.then(response => response.json())
		.then(json => displayEmployees(json))
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