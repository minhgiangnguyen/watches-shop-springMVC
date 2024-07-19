//Document ready thì show loại sách và số lượng trong giỏ hàng (jquery ajax)
$(function(){
	$.get(path + "/categories", function(data) {
		$('.dropdown-menu').html(data);
	});
	$.get(path + "/countItems", function(data) {
		$('#basket_total').html(data);
	});
});
//hàm xử lý add 1 sách vào giỏ hàng (jquery ajax)
function addBasket(watchId) {
	$.get(path + "/addItem/" + watchId, function(data) {
		$('#basket_total').html(data);
		window.scrollTo({ top: 0, behavior: 'smooth' });
	});
}
//hàm xử lý cập nhật lại số lượng trong giỏ hàng (jquery ajax)
function updateBasket(watchId, value) {
	$.get(path + "/updateBasket/" + watchId + "/" + value, function() {
		window.location.reload();
	});
}
//hàm xử lý xóa 1 sách trong giỏ hàng (jquery ajax)
function removeItem(watchId) {
	if (confirm('You may want to delete?')) {
		$.get(path + "/removeItem/" + watchId, function() {
			window.location.reload();
		});
	}
}