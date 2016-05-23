// JavaScript Document

( function (L , root ) {

    //'use strict';

    var _site= 'http://market.cmbchina.com/ccard/weixin/news/zjy/1.html',
        apiUrl = _site+'index.php/api/',
        jumpUrl = _site+'wechat/',

        $c = L.$.$c,
        $id =L.$.$id,
        $class =L.$.$class,
        tool = L.tool,
        yz = L.yz,
        fx = L.fx,


        _default_url = _site,
        _default_url2 = window.location.href,
        _default_img = 'http://market.cmbchina.com/ccard/weixin/news/zjy/img/logo1.gif',
        _default_title ='招商银行信用卡',
        _default_desc = '国内领先的信用卡品牌。秒查账单 额度 积分，每一笔消费提醒。',
        _default_desc2 = '国内领先的信用卡品牌。秒查账单 额度 积分，每一笔消费提醒。',
        wxReady = false;

    document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
        wxReady = true ;
        newShare( _default_url , _default_img ,_default_title , _default_desc  )
        WeixinJSBridge.call('showToolbar');
        WeixinJSBridge.call('showOptionMenu');

    });


    function newShare(url , img ,title , desc  ) {
        WeixinJSBridge.on('menu:share:appmessage',
            function(argv) {
                WeixinJSBridge.invoke('sendAppMessage', {
                    'title': title,
                    'link': url,
                    'desc': desc,
                    'img_url': img
                })
            });
        WeixinJSBridge.on('menu:share:timeline',
            function(argv) {
                WeixinJSBridge.invoke('shareTimeline', {
                    'title': desc,
                    'link': url,
                    'desc': desc,
                    'img_url': img
                })
            })
    };
    function share (url , img ,title , desc  )  {
        if ( wxReady ) {
            newShare(url , img ,title , desc  ) ;
        }	else {
            document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
                wxReady = true ;
                newShare(url , img ,title , desc  ) ;
            });
        }
    } ;

    var app= {};

    var x = $class ('x');
    for ( var i= 0; i < x.length ; i++ ) {
        x [i].onclick = function () { fx.fadeOut (this.parentNode);} ;
    }

    var questIndex = 1,
        fillterIndex=1,
        defaultValue = null,
        isVisted = !1;

    app = {
        showPage :　function ( hide , show , callback ) {
        tool.hide (hide);
        fx.fadeIn (show,function () { callback && callback (); });
    } ,

    checkLogin :　function ( callback ) {
        tool.getData ( {
            url :  apiUrl + 'get_user_info',
            succ : function ( a ) {
                if ( a.errorcode != 0 )
                    window.location.href = jumpUrl ;
                callback &&callback　( a.data );

            }
        } );
    } ,

    index : function () {
        var aDots = $c('dot').children,
            pages =	$class('liuliang_pages'),
            slider = new fx.slide ( L );
        if(pages.length==1){
            $('.dot').css("display","none");
            return;
        }
        if(pages.length==2){
            $('.dot>span').eq(2).css("display","none");
        }
        slider.extend ({7 : {
            up : {out : 'pt-page-rotateFoldTop' , in : 'pt-page-moveFromBottomFade' } ,
            down : {out : 'pt-page-rotateFoldBottom' , in : 'pt-page-moveFromTopFade' } ,
            left : {out : 'pt-page-rotateFoldLeft' , in : 'pt-page-moveFromRightFade' } ,
            right : { out : 'pt-page-rotateFoldRight' , in : 'pt-page-moveFromLeftFade' }
        }});
        slider.setDirection ('h');
        slider.setAnimation (7);
        slider.animationCallback = function ( index ) {
            for ( var i= 0 ; i< aDots.length; i++ ) {aDots[i].className='';}
            aDots[index].className ='hover';
        } ;
        slider.init ($c('index_scroll') ,pages);

        setInterval ( function () {
            slider.showNext (1);
        } , 3000 );
        new Hammer ( pages [0] , { preventDefault: false }).on('tap' , function () {jumpLink('');} );
        new Hammer ( pages[1] , { preventDefault: false }).on('tap' , function () {jumpLink('');} );
        new Hammer ( pages[2] , { preventDefault: true }).on('tap' , function () {jumpLink('');} );
        $c('tc_checkbox').onclick = function () {
            if ( tool.hasClass(this.parentNode ,'hover')){
                tool.removeClass(this.parentNode,'hover');
            }else {tool.addClass(this.parentNode,'hover');}
        };
        function jumpLink ( str ) {
            if (!tool.hasClass( $c('tiaokuan'),'hover' ))
            {
                alert('请同意并遵守活动服务条款');
                return;
            }
            window.location.href = str;
        }

    } ,
    poster : function () {

        this.checkLogin ();

        isVisted = window.localStorage.getItem('visted');

        if ( !isVisted ) {
            tool.show($id('ts'));
            window.localStorage.setItem('visted' ,'vist');
        }

        var myTransform =null,
            cachePosition = null,
            btnMain = $id ('btnmain'),
            text_main=$id('text_main'),
            backBtn  = $c('head_l'),
            topcenter  = $c('head_c'),
            topright  = $c('head_r'),
            upload_page = $class ('upload_page'),
            step = 1,
            _= this,

            textData = [
                { btnText : '确认照片' , desc : '从手机相册挑选一张你帅气的跑步照', topcenter : '上传帅气跑步照片' } , //1
                { btnText : '确认照片' , desc : '缩放或移动照片，将它调整至最佳位置 ', topcenter : '编辑你的帅气跑步照片' } , //2
                { btnText : '确认照片' , desc : '请把照片移到你喜欢的位置', topcenter : '选择你喜欢的问题'} , //3
                { btnText : '继续下一步' , desc : '填写你自己的答案', topcenter : '编辑属于你的对话' } , //4
                { btnText : '' , desc : '', topcenter : '为机智的回答配个颜色' }, //5
                { btnText : '跳过这步' , desc : '让海报更好玩一点，点击上传个头像。', topcenter : '上传头像' }, //6
                { btnText : '完成了' , desc : '', topcenter : '做个海报' } , // 7
                { btnText : '来个微信表情' , desc : '海报做好了,快来做你自己的微信表情！', topcenter : '做个海报' } // 8
            ];

        function doStep ( ) {
            step ++ ;
            btnMain.innerHTML = textData [step-1].btnText;
            text_main.innerHTML =textData [step-1].desc;
            topcenter.innerHTML = textData [step-1].topcenter;
        } ;

        backBtn.onclick = function (){window.location.href = 'index.html';}

        function doUpload ( ) {
            var up = new _liuLiang.uploadPic (
                'fileupload',
                function ( data , canvas ) {
                    _.showPage ( upload_page [0] ,upload_page [1] );
                    doStep (  ) ; //2
                    tool.show ($c('stepbtn1')) ;

                    var img = new Image ();
                    img.onload = function () {
                        upload_page [1].appendChild (img);
                        myTransform = new L.makeTransFormImage ( {
                            controy : $id('controy'),
                            img : img ,
                            warp : upload_page [1]  ,
                            useCanvas : !1 ,
                            min :　.5 ,
                            max : 2
                    });
                    myTransform.start();
                    fx.fadeOut($id('loadingpop'));
                }
            img.src = data;
        },
        { width:640 , errorType : function () { } }

    ).init ();
    };
    doUpload ( ) ;

    function posfa_warp ( data ) {
        $c ( 'fa_warp2').style[tool.prefixedSupport ('transform')]	=
            'translate3d('+(data.x-11)+'px,'+(data.y-8)+'px,0px)';
        cachePosition = data;
    }

    $id('fileupload').addEventListener ('change',function () {
        tool.show ($id('loadingpop'));
    } ,false);
    $id('fileupload2').addEventListener ('change',function () {
        tool.show ($id('loadingpop'));
    } ,false);

    btnMain.addEventListener ('click', function () {

        switch ( step ) {
            case 2 :
                _.showPage ( $c('step1') ,$c('step2'));
                doStep (  ) ; // 3
                break ;
            case 4 :

                if ( !$c('fa_main_input').value ) {alert ('答案文字不能为空'); return ;}
                defaultValue =  $c('fa_main_input').value;
                tool.getData ( {
                    url : apiUrl + 'create_text',
                    data : {
                        word : $c('fa_main_input').value ,
                        color : fillterIndex
                    },
                    succ : function ( a ) {

                        //确认文字
                        _.showPage ( $c('warp1') ,$c('warp2') );
                        tool.hide ( $c ( 'arrow2' ));
                        tool.hide ( $c ( 'fa_main_text' ));
                        _.showPage ( $c('fa_main2') ,$c('fa_main') );
                        $c ( 'fa_main').src = a.data.gif_url ;

                        var Transform = new L.makeTransFormImage ( {
                            managerType : 'img',
                            img : $c ('fa_main') ,
                            warp : upload_page [1]  ,
                            useCanvas : !1 ,
                            limit : !0 ,
                            supportTransform : !1,
                            autoCenter: !1,
                            startX :180 ,
                            startY : 10 ,
                            onStart : function ( data ) {
                                tool.show ( $c ( 'fa_warp2' ));
                                posfa_warp ( data ) ;
                            } ,
                            onMoving : function ( data ) {
                                posfa_warp ( data );
                            }
                        });
                        Transform.start();
                        doStep () ;//5  调整文字位置

                    }
                });

                break ;

            case 6 :
                doStep () ; // 7
                tool.show ($id('controy2'));
                tool.show ( $c ( 'arrow2' ));
                _.showPage ( $c('thumb_uploadbox') ,$c('fq_thumb_main') );
                break ;

            case 7 :
                tool.show ($id('loadingpop'));

                doStep () ; // 8 完成了
                tool.hide ($c('head'));

                tool.show ( $c ( 'arrow2' ));
                $c('btn3').style.width = '295px';

                tool.hide ($c('blank'));

                var c = document.createElement('canvas') ;
                var ctx = c.getContext ('2d');
                c.width =  upload_page [1].offsetWidth ;
                c.height = upload_page [1].offsetHeight ;
                ctx.fillStyle ='#ccc';
                ctx.fillRect (0,0,c.width,c.height);
                ctx.drawImage ( myTransform.toCanvas () , 0 , 0 );
                ctx.drawImage ( $c('uploadbtn_2') ,  23 , 23, 50 ,50 );
                ctx.drawImage ( $c('fq_main') ,  $c('fq_main').offsetLeft , $c('fq_main').offsetTop ,340 ,340/438*122 );
                ctx.drawImage ( $c('fa_main') , cachePosition.x , $c('fa_main').parentNode.offsetTop+cachePosition.y  );
                ctx.drawImage ( $c('filter_logo') ,  $c('filter_logo').offsetLeft , $c('filter_logo').offsetTop );
                upload_page [1].innerHTML = '<img src="'+c.toDataURL('image/jpeg')+'" />';

                tool.getData ( {
                    url : 	apiUrl + 'upload_img',
                    type : 'POST',
                    dataType : 'json',
                    data : { img_data : c.toDataURL('image/jpeg')} ,
                    succ : function ( a ) {
                        var DATA = a ;
                        if ( DATA.errorcode*1 == 0 ) {
                            tool.getData ( {
                                url : 	apiUrl + 'save_work',
                                dataType : 'jsonp',
                                data : {
                                    url : DATA.data.img_url,
                                    question : questIndex,
                                    type :　'img' ,
                                word :  defaultValue ,
                                color : fillterIndex
                        },
                        succ : function ( b ){

                            if ( b.errorcode*1 == 0 || b.data.ret*1 ==1 ) {
                                fx.fadeOut ($id('loadingpop'));

                                setTimeout ( function () {fx.fadeIn ($id('sharepop'));} ,3000);
                                share (_site +'shareback.html?id='+ b.data.work_id+'&type=img' ,DATA.data.img_url ,_default_title ,_default_desc );
                            }
                        }
                    } );
        }
    }
} );

tool.show ($c('warp3'));
break ;
case 8 :
window.location.href = '2.html';
break;
};

},false);


var aTalk = $c('talk').children ;
for ( var i=0; i<aTalk.length; i++ ) {
    aTalk [i].index = i;
    aTalk [i].onclick = function () {
        questIndex = this.index + 1;
        $c ('fq_main').src = this.getElementsByClassName ('q_mian')[0].children[0].src;
        $c('fa_main_input').value = this.getAttribute ('data-text');
        _.showPage ( $c('step2') ,$c('step1') );
        $c('fa_main_input').removeAttribute ('disabled');
        _.showPage ( $c('test5') ,$c('filter_box') );

        if ( !isVisted ) { tool.show ($id('quan'));}
        tool.hide ($id('controy'));
        doStep (  ) ; // 4
        tool.hide ( $c ( 'arrow2' ));

    }
};
var  warps_filter = $class ( 'warps_filter' );
for ( var i=0; i<warps_filter.length; i++ ) {
    warps_filter [i].index = i;
    warps_filter [i].onclick = function () {
        var _this = this ;
        warps_filter [fillterIndex-1].className ='warps_filter';
        fillterIndex  = this.index + 1 ;
        warps_filter [fillterIndex-1].className ='warps_filter hover';
        if ( !_this.dataurl ) {
            tool.show ($id('loadingpop'));
            tool.getData ( {
                url : apiUrl + 'create_text',
                data : {
                    word : $c('fa_main_input').value ,
                    color : fillterIndex
                },
                succ : function ( data ) {
                    $c ( 'fa_main').src = data.data.gif_url ;
                    fx.fadeOut ($id('loadingpop'));
                    _this.dataurl = data.data.gif_url ;
                }
            });
        } else {
            $c ( 'fa_main').src = _this.dataurl ;
        }

    }
}


$c('ok').onclick = function () {
    doStep () ; // 6  打钩完成
    tool.hide ( $c ( 'fa_warp2' ));
    _.showPage ( $c('warp2') ,$c('warp1') );
    _.showPage ( $c('fq_thumb_main') ,$c('thumb_uploadbox') );
    tool.show ($id('controy2'));
    var u =new L.uploadPic (
        'fileupload2',
        function ( data , canvas ) {
            var img = new Image ();
            img.onload = function () {
                step = 6;
                doStep () ; // 7  完成了
                tool.show ( $c ( 'arrow2' ));
                $c('uploadbtn_2').src = img.src ;
                //tool.show ($c('fq_thumb_main'));
                //	_.showPage ( $c('thumb_uploadbox') ,$c('fq_thumb_main') );

                fx.fadeOut($id('loadingpop'));
            }
            img.src = data;
        },
        { width:52, errorType : function () { } }

    ).init ();

}


} ,

sticker  : function () {

    var isVistedSticker = window.localStorage.getItem('isvistedsticker');

    if ( !isVistedSticker ) { tool.show ($id('ts_animation'));
        window.localStorage.setItem('isvistedsticker','vist');
    }

    this.checkLogin ( function ( data ) {
        $id ('q_thumb_main2').src = $c('finalythumb_main').src = data.avatar;
        //$id ('answer_name_1').innerHTML = data.nick_name;
    } );

    var steps = $class ('step'),
        aLis =$c('talk').children,
        _= this ;


    $c('head_l').onclick = function () {window.location.href='index.html';}
    for( var i=0; i <aLis.length; i++)　{
        aLis [i].index = i;
        aLis [i].onclick = function () {
            questIndex = this.index + 1;
            fillterIndex = this.getAttribute('data-fillter');
            if ( !isVistedSticker ) { tool.show ($id('ts_animation2'));}
            $c('fa_main_input2').value = this.getAttribute ( 'data-text' );
            $c('fq_main').src ='images/qs'+questIndex+'.png';
            $id('bubble_main_1').src = 'images/answerbg_talk'+fillterIndex+'.png';
            _.showPage ( steps [0] , steps [1]  );
            $c('head_c').innerHTML= '来段更机智的回答';
        }
    }


    $c( 'btn3' ).onclick =function () {
        if ( !$c('fa_main_input2').value ) {alert ('答案文字不能为空'); return ;}
        defaultValue = $c('fa_main_input2').value;
        tool.show ($id('loadingpop'));
        tool.getData ( {
            url : apiUrl + 'create_gif',
            data : {
                word : defaultValue  ,
                color : fillterIndex
            },
            succ : function ( a ) {
                var oImg = new Image ();
                oImg .src = a.data.gif_url;
                oImg.onload = function () {
                    tool.getData ({
                        url : 	apiUrl + 'save_work',
                        data : {
                            url : oImg.src,
                            question : questIndex,
                            type :　'gif' ,
                        word :  defaultValue ,
                        color : fillterIndex
                },
                    succ : function ( b ){
                    if ( b.errorcode*1 == 0 || b.data.ret*1 ==1 ) {
                        share (_site +'shareback.html?id='+ b.data.work_id+'&type=gif&fillter='+questIndex ,oImg.src ,_default_title ,_default_desc2 );
                    }
                }
            });
        $c('head_c').innerHTML= '分享动画';
        $c ('final_gif').src = oImg.src;
        tool.show ( $id ('sharepop_animation'));
        _.showPage ( steps [1] , steps [2]  );
        fx.fadeOut ($id('loadingpop'));

        $c('xxx').addEventListener (L.event.eventEnd , function () { $c ('final_gif').src = ''; $c ('final_gif').src = oImg.src;} , false);
    }
}
} );
}

},

shareback : function () {
    var type = tool.getQueryString ('type'),
        id  = tool.getQueryString ('id');

    if ( !type || !id )window.location.href ='index.html';

    tool.getData ({
        url : 	apiUrl + 'get_work',
        data : { work_id : id } ,
        succ: function ( a ) {
            var oImg = new Image ();
            oImg.src = a.data.url;
            oImg.onload = function (){
                if (type === 'img') {
                    $id('text_main').innerHTML ='';
                    $c('btn3').href = '2.html';
                    tool.show ($c('page1'));
                    $c('page1_img').src	 = oImg.src;
                    tool.hide($c('page22'));
                } else{
                    $id('text_main').innerHTML ='';
                    $c('btn3').href = '2.html';
                    tool.show ($c('page22'));
                    $c('bubble_main').src =  oImg.src;
                    $c('q_mian_bubble').src = 'images/qs'+a.data.question+'.png';
                    $c('q_thumb_main2').src =  a.data.avatar;
                    tool.hide($c('page1'));
                }
                fx.fadeOut ($id('loadingpop2'));
            }
        }
    });

}
};

return root.app = app;

}) ( _liuLiang , window );

