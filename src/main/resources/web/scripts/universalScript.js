logout = async () => {
	alert('logging out...')
	const getUrl = 'http://localhost:1969/logout';
	fetch(getUrl)
		.then(alert('You have logged out.'))
		.catch(alert('An Error occured with logging out.', err))
};
