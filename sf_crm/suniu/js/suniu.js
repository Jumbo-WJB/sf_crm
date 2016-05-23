$(".register").click(function(){
    layer.alert('联系电话：0571-87139330</br> QQ&nbsp;&nbsp;:&nbsp;&nbsp;2924409341');
    $('.layui-layer-title').html('联系客服');
    return false;
})


var IMYUAN;
IMYUAN || (IMYUAN = {});

(function(a) {

    a.fn.extend({
        returntop: function() {
            if (this[0]) {
                var b = this.click(function() {
                        a("html, body").animate({
                                scrollTop: 0
                            },
                            250)
                    }),
                    c = null;
                a(window).bind("scroll",
                    function() {
                        var d = a(document).scrollTop(),
                            e = a(window).height();
                        0 < d ? b.css("bottom", "200px") : b.css("bottom", "-200px");
                        a.isIE6() && (b.hide(), clearTimeout(c), c = setTimeout(function() {
                                b.show();
                                clearTimeout(c)
                            },
                            1E3), b.css("top", d + e - 125))
                    })
            }
        }

    })
})

(jQuery); (function(a) {
    a("body")('<a class="close" href="javascript:;"></a>');
})

(function() {
    $("#returnTop").returntop();
    $(window).scroll();
});
