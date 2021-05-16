$(document).ready(function(e){
    $(".gap").each(function(){
        var gapw=$(this).parent("a").width()-
        $(this).siblings("span.name").width()-
        $(this).siblings("span.author").width()-22;
        $(this).width(gapw);
    });
    //初始化
    $(".type-div .type-item").eq(0).show().siblings().hide();
    var ppdiv=$(".type-div .type-item").eq(0);
    ppdiv.find(".scroll-box").eq(0).show().siblings().hide();
    var pdiv=ppdiv.children(".scroll-per").children(".scroll-box").eq(0);
    pdiv.find(".swiper-container-scroll").eq(0).show().siblings().hide();
    //end

    $(".type-ul li").click(function(){
    	var index=$(this).index();
        $(this).addClass("on").siblings().removeClass("on");
        $(".type-div .type-item").eq(index).show().siblings().hide();
        var ppdiv=$(".type-div .type-item").eq(index);
        ppdiv.find(".scroll-box").eq(0).show().siblings().hide();
        var pdiv=ppdiv.children(".scroll-per").children(".scroll-box").eq(0);
        pdiv.find(".swiper-container-scroll").eq(0).show().siblings().hide();
    });

    $(".scroll-type ul li").click(function(){
    	var index=$(this).index();
        $(this).addClass("on").siblings().removeClass("on");
        $(this).parents(".scroll-type").siblings(".scroll-content").children(".swiper-container-scroll").eq(index).show().siblings().hide();
    });

    $(".type-item .swiper-slide").click(function(){
    	var index=$(this).index();
    	$(this).addClass("swiper-slide-active").siblings().removeClass("swiper-slide-active");
        var obj=$(this).parents(".type-item").children(".scroll-per").children(".scroll-box").eq(index);
    	obj.show().siblings().hide();
        obj.find(".swiper-container-scroll").eq(0).show().siblings().hide();
    });
});