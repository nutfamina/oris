document.addEventListener('DOMContentLoaded', function(){
	const addButton = document.getElementById('addCommentBtn');
	const commentInput = document.getElementById('newComment');
	const commentsContainer = document.getElementById('commentsContainer');

function addComment(){
	const text = commentInput.value.trim();
	if (text===''){
		alert('Пожалуйста введите текст комментария')
	 return ;
	}

	const commentDiv = document.createElement('div');
	commentDiv.className = 'comment';
	commentDiv.textContent = text;

	commentsContainer.appendChild(commentDiv);

	commentInput.value = '';
}

	addButton.addEventListener('click',addComment);


});