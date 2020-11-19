//详情页面
function goDetail(cId, clId, clUId){

    //显示详情页面
    var detail = $(window.parent.document).find("#detail");
    detail.css('right', '0px');

    //赋值
    $(window.parent.document).find("#cId").value=cId;
    $(window.parent.document).find("#clId").value=clId;
    $(window.parent.document).find("#clUId").value=clUId;

    //根据客户编号查询信息并赋值
    $.get("/customer/detail", {clId:clId}, function (data) {
        $(window.parent.document).find("#img").attr("src", "/images/boy.png");
        //上次门诊
        $(window.parent.document).find("#hName").text(data.hName);
        //给基本信息赋值
        var cNameList = $(window.parent.document).find('[name=cName]');
        for(var i = 0; i < cNameList.length; i++){
            cNameList[i].innerText = data.customer.cName;
        }
        var cAgeList = $(window.parent.document).find('[name=cAge]');
        for(var i = 0; i < cAgeList.length; i++){
            cAgeList[i].innerText = data.customer.cAge;
        }
        var cTelList = $(window.parent.document).find('[name=cTel]');
        for(var i = 0; i < cTelList.length; i++){
            cTelList[i].innerText = data.customer.cTel;
        }
        var clEarnestList = $(window.parent.document).find('[name=clEarnest]');
        for(var i = 0; i < clEarnestList.length; i++){
            clEarnestList[i].innerText = data.customer.clEarnest;
        }
        //成交金额
        $(window.parent.document).find("#successMoney").text(data.successMoney);
        //已交金额
        $(window.parent.document).find("#payMoney").text(data.payMoney);
        //待交金额
        $(window.parent.document).find("#waitMoney").text(data.waitMoney);
        //创建时间
        $(window.parent.document).find("#cTime").text(data.customer.cTime);
        //修改时间
        $(window.parent.document).find("#editTime").text(data.updateTime);
        //负责人
        $(window.parent.document).find("#principal").text(data.customer.uName);
        //性别
        $(window.parent.document).find("#cSex").text(data.customer.cSex);
        //来源
        $(window.parent.document).find("#clSource").text(data.customer.clSource);
        //报名项目
        $(window.parent.document).find("#clProject").text(data.customer.clProject);
        //报名时间
        $(window.parent.document).find("#clPlaceTime").text(data.customer.clPlaceTime);
    });

    //预约记录
    $.get("/appointment/queryAToDetail", {clId:clId}, function (data) {
        var html = "";
        $.each(data.data, function (index, item) {
            html += "<li class='layui-timeline-item'>" +
                "<i class='layui-icon layui-timeline-axis'>&#xe63f;</i>" +
                "<div class='layui-timeline-content layui-text'>" +
                "<div class='layui-card' style='background-color: aliceblue;'>" +
                "<div><span style='font-size: 20px;'>"+item.aTime+"【"+item.aType+"】</span></div>" +
                "<div style='margin-top: 5px;'>预约项目："+item.clProject+"</div>" +
                "<div style='margin-top: 5px;'>预约人："+item.uName+"</div>" +
                "<div style='margin-top: 5px;'>预交金额："+item.clEarnest+"</div>" +
                "<div style='margin-top: 5px;'>" +
                "<div style='text-align: left'>预约门诊："+item.hName+"</div>" +
                "<div style='text-align: right'>创建时间："+item.aCreateTime+"</div>" +
                "</div"+
                "</div>" +
                "</div>" +
                "</li>";
        });
        $(window.parent.document).find("#appoint").html(html);
    });

    //操作记录
    $.get("/operating/queryOpByCId", {cId:cId}, function (data) {
        var html = "";
        $.each(data.data, function (index, item) {
            html += "<li class='layui-timeline-item'>" +
                "<i class='layui-icon layui-timeline-axis'>&#xe63f;</i>" +
                "<div class='layui-timeline-content layui-text'>" +
                "<div class='layui-card' style='background-color: aliceblue;'>" +
                "<div><span style='font-size: 20px;'>"+item.opTime+"</span></div>" +
                "<div style='margin-top: 5px;'>操作用户："+item.uName+"</div>" +
                "<div style='margin-top: 5px;'>操作名称："+item.opName+"</div>" +
                "</div>" +
                "</div>" +
                "</li>";
        });
        $(window.parent.document).find("#operating").html(html);
    });

    //成交记录
    var elem = $(window.parent.document).find("#successTab");
    table.render({
        elem: elem
        ,url: '/success/querySByClId?clId='+clId //访问路径
        ,height: '180px'
        ,page: true //开启分页
        ,limit: 2 //每页显示条数
        ,limits: [2] //自定义可选每页显示条数
        ,cols: [
            [
                {field: 'sId', title: 'ID', minWidth: 120, sort: true}
                ,{field: 'cName', title: '客户名称', minWidth: 120}
                ,{field: 'cTel', title: '电话', minWidth: 120}
                ,{field: 'hName', title: '成交门诊', minWidth: 150}
                ,{field: 'sMessage', title: '成交信息', minWidth: 150}
                ,{field: 'sSum', title: '成交金额', minWidth: 120, sort: true}
                ,{field: 'sPaysum', title: '已交金额', minWidth: 120, sort: true}
                ,{field: 'sRemark', title: '成交备注', minWidth: 250}
                ,{field: 'sTime', title: '成交时间', minWidth: 200}
            ]
        ]
    });

    //根据客户编号查询所拥有的跟进类型
    $.get("/follow/queryFollowByFClId?clId="+clId, function(obj){
        var html = "";
        for(var i = 0; i < obj.length; i++) {
            var year = obj[i].time.substring(0, 4);
            var month = obj[i].time.substring(5, 7);
            var day = obj[i].time.substring(8, 10);
            var date = year+"年"+month+"月"+day+"日";
            html += "<li class='layui-timeline-item'>" +
                "<i class='layui-icon layui-timeline-axis'>&#xe63f;</i>" +
                "<div class='layui-timeline-content layui-text'>" +
                "<h3>"+date+"("+obj[i].type+")</h3>" +
                "<ul>";
            for(var j = 0; j < obj[i].followList.length; j++){
                html += "<li>"+obj[i].followList[j]+"</li>";
            }
            html += "</ul>" +
                "</div>" +
                "</li>";
        }
        //赋值
        $(window.parent.document).find("#follow").html(html);
    });

}
