async function callLogin(nameInput, passInput) {
	alert('Now this is podracing!');
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
	alert(result);
	if (result === "Good Good not Bad")
		window.location.href = "./success.html";
};




function validateLogin() {
	let nameInput = document.getElementById('userName').value;
	let passInput = document.getElementById('password').value;
	alert('validating!!!');
	callLogin(nameInput, passInput);
};