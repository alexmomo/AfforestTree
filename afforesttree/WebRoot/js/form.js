function buttonSubmit(obj){
	obj.disabled = true;
	obj.value = obj.dataset.disableWith;
	return true;
}