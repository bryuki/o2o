/**
 *
 */
$(function() {
    var initUrl = '/o2o/shop/getshopinitinfo';
    var registerShopUrl = 'o2o/shopadmin/registershop';
    function getShopInitInfo() {
        $.getJSON(initUrl, function(data) {
            if (data.success) {
                var tempHtml = '';
                var tempAreaHtml = '';
                data.shopCategoryList.map(function(item, index) {
                    tempHtml += '<option data-id="' + item.shopCategoryId + '">'
                    + item.shopCategoryName + '</option>';
                });
                data.areaList.map(function(item, index) {
                    tempAreaHtml += '<option data-id="' + item.areaId + '">'
                    + item.areaName + '</option>';
                });
                $('#shop-category').html(tempHtml);
                $('#area').html(tempAreaHtml);
            }
        });
        $('#submit').click(function() {
            var shop = {};
            shop.shopName  = $('#shop-name').val();
            shop.shopAddr = $('#shop-addr').varl();
            shop.phone = $('shop-phone').val();
            shop.shopDesc = $('shop-desc').varl();
            shop.shopCategory = {
                shopCategoryId : $('#shop-category').find('option').not(function() {
                    return !this.selected;
                }).data('id')
            };
            shop.area = {
                areaId: $('#area').find('option').not(function() {
                    return !this.selected;
                }).data('id')
            };
            var shopImg = $('#shop')
        }
    }
})
