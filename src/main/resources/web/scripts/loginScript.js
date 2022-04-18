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
	if (result === "Good")
		window.location.href = "../pages/employeePage.html";
	if (result === "Wow")
		window.location.href = "../pages/managerPage.html";
};

function validateLogin() {
	let nameInput = document.getElementById('userName').value;
	let passInput = document.getElementById('password').value;
	callLogin(nameInput, passInput);
};