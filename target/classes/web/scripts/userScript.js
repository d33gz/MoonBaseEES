getName = async () => {
	let response = await fetch('http://localhost:1969/getName', {
		method: 'GET',
		headers: {
			'Content-Type': 'application/json;charset=utf-8'
		},
	});
	let result = await response.text();
	let nameElement = document.getElementById('userName');
	nameElement.innerHTML = result;
};