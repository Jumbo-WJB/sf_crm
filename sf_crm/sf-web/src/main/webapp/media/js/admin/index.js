


//jtopo画图
var canvas = document.getElementById('canvas');
var stage = new JTopo.Stage(canvas);
var scene = new JTopo.Scene(stage);

// 方形节点
function newNode(flag,x, y, w, h, text,color,count,rate,fans,source,startContribution,endContribution){
    var node = new JTopo.Node(text);
    node.setLocation(x, y);
    node.setSize(w, h);
    node.textPosition = 'Middle_Center';
    node.borderRadius = 10;
    node.font = '12pt 微软雅黑';
    if (color != null){
        node.fillColor = color;
    }else{
        node.fillColor = '166, 216, 255';
    }
    scene.add(node);

    if (flag){
        var userCount = newText(x+20,y,count+"人",12,'0,0,255',true,source,startContribution,endContribution);
        var percent = newText(x+92,y+5,'占比'+rate,8,'0,0,0');
        var fans = newText(x+20,y+30,'成为粉丝：'+fans+'人',10,'0,0,0');
    }
    return node;
}

// 连线节点
function newLink(nodeA, nodeZ,color){
    var link = new JTopo.Link(nodeA, nodeZ);
    link.lineWidth = 3; // 线宽
    link.arrowsRadius = 15; //箭头大小
    link.bundleOffset = 60; // 折线拐角处的长度
    link.bundleGap = 20; // 线条之间的间隔
    link.textOffsetY = 3; // 文本偏移量（向下3个像素）
    if (color == "color1"){
        link.strokeColor = '247,10,26';
    }else if (color == "color2"){
        link.strokeColor = '242,214,73';
    }; // 线条颜色随机
    scene.add(link);
    return link;
}

//文字节点
function newText(x,y,text,size,color,href,source,startContribution,endContribution){
    //文字节点
    var msgNode;
    this.text = text;
    if (href == true){
        msgNode = new JTopo.LinkNode(this.text);
        msgNode.href = "javascript:freshUrl('/sf-web/knowCustomer/userList?source="+source+"&startContribution="+startContribution+"&endContribution="+endContribution+"')";
    }else{
        msgNode = new JTopo.TextNode(this.text);
    }
    msgNode.zIndex++;
    msgNode.setBound(x,y);
    msgNode.background='255,255,255';
    if (color != null){
        msgNode.fontColor = color;
    }else{
        msgNode.fontColor = '0,0,0';
    }
    msgNode.font = size+'pt 微软雅黑';
    scene.add(msgNode);
}

var node1_1 = newNode(false,45,130,10,10,'','66,73,89');
var node1_2 = newNode(false,1225,130,10,10,'','66,73,89');
var line1 = newLink(node1_2,node1_1,'color1');

var node2_1 = newNode(false,205,90,10,10,'','66,73,89');
var node2_2 = newNode(false,205,700,10,10,'','66,73,89');
var line2 = newLink(node2_2,node2_1,'color2');

xLength = 10;    //x轴位移
yLength = 0;     //y轴位移
var title = newText(105,0,'用户贡献度模型UVM',17,'255,255,255');
var lit_title = newText(185,40,'价值',14,'176,194,58');

if (nameList[0] != undefined){
    var x_title_1 = newText(280+xLength,90,nameList[0],14,'242,214,73');
}
if (nameList[1] != undefined){
    var x_title_2 = newText(485+xLength,90,nameList[1],14,'242,214,73');
}
if (nameList[2] != undefined){
    var x_title_3 = newText(720,90,nameList[2],14,'242,214,73');
}
if (nameList[3] != undefined){
    var x_title_4 = newText(930,90,nameList[3],14,'242,214,73');
}

var y_title_3 = newText(110,200,'V>80',14,'189,204,242');
var y_title_4 = newText(95,350,'60≤V≤80',14,'189,204,242');
var y_title_5 = newText(110,500,'V<60',14,'189,204,242');


//首页添加备注
var descript_1 = newText(450,20,'计算维度:包括购买周期、购买频率、购买金额，其中金额为第一权重等等。',10,'189,204,242');
//var descript_2 = newText(600,20,'品牌粉丝：计算维度包括购买周期、购买频率、购买金额、评价其中周期为第一权重。',10,'189,204,242');
//var descript_3 = newText(600,40,'转化社群：是否为粉丝，互动消息数，互动次数，购买频率、评价数量等等。购买频率为第一权重。',10,'189,204,242');

//异步请求数据
for (var i = 0;i < 3;i++){
    for (var j = 0;j < loop;j++){
        sendAjax(i,j);
    }
}


function sendAjax(i,j){
    $.post(baseUrl+"index/getContributionModel",{source:dataArray[loop*i+j][0],startContribution:dataArray[loop*i+j][1],endContribution:dataArray[loop*i+j][2]},
        function(data){
            if (data != null) {
                var rate = ((data.model.userRate) * 100).toFixed(2) + '%';
                if (data.model.count > 0) {
                    newNode(true,255+220*j+xLength,200+150*i+yLength,170,70,'',null,data.model.userCount,rate,data.model.fansCount,dataArray[loop*i+j][0],dataArray[loop*i+j][1],dataArray[loop*i+j][2]);
                }
            }
        }
    )
}



