
//预约
function appoint() {
    //客户编号
    var cId = $(window.parent.document).find("#cId").val();
    //线索编号
    var clId = $(window.parent.document).find("#clId").val();
    //负责人编号
    var clUId = $(window.parent.document).find("#clUId").val();
    //客户姓名
    var cName = $(window.parent.document).find("[name=cName]")[0].innerText;
    //客户状态
    var cType = $(window.parent.document).find("#cType").text();
    if (cType != "待预约"){
        layer.msg("该客户不可预约！");
    } else {
        //弹出预约页面
        layer.open({
            type: 2, //层类型，iframe
            title: '新增预约客户',
            content: ['/crm/appointmentsave?clId='+clId+'&cName='+cName],
            area: ['450px', '450px'],
            resize: false,
            btn: '确定',
            btn1: function (index, layero) {
                var body = layer.getChildFrame('body', index);
                //获取值
                var aClId = $(body).find("#aClId").val();
                var aTime = $(body).find("#aTime").val();
                var aHId = $(body).find("#aHId").val();
                var atType = $(body).find("#atType").val();
                if (aTime != '') {
                    var load = layer.load();
                    $.post("/crm/appointment/saveAppointment", {uId:uId, uName:uName, aClId:aClId, aTime:aTime,
                            aHId:aHId, atType:atType},
                        function (data) {
                            layer.close(load);
                            if (data.code == 200){
                                layer.msg(data.msg, {time: 500}, function () {
                                    layer.close(index);
                                    goDetail(cId, clId, clUId);
                                });
                            } else {
                                layer.msg(data.msg);
                            }
                        }
                    );
                } else {
                    layer.msg('请输入预约时间');
                }
            },
            cancel: function(index, layero){
                layer.close(index);
            }
        });
    }
}

//成交
function success() {
    //客户编号
    var cId = $(window.parent.document).find("#cId").val();
    //线索编号
    var clId = $(window.parent.document).find("#clId").val();
    //负责人编号
    var clUId = $(window.parent.document).find("#clUId").val();
    //客户姓名
    var cName = $(window.parent.document).find("[name=cName]")[0].innerText;
    //门诊编号
    var hId = $(window.parent.document).find("#hId").val();
    //门诊名称
    var hName = $(window.parent.document).find("#hName").text();
    //报名费
    var clEntryFee = $(window.parent.document).find("#clEntryFee").text();
    //预约编号
    var sAId = $(window.parent.document).find("#sAId").val();
    //客户状态
    var cType = $(window.parent.document).find("#cType").text();
    if (cType == "待分配" || cType == "待联系" || cType == "待预约"){
        layer.msg("该客户尚未分配，请先分配！");
    } else {
        //弹出成交页面
        layer.open({
            type: 2, //层类型，iframe
            title: '新增成交客户',
            content: ['/crm/successsave?cId='+cId+'&clId='+clId+'&sAId='+sAId+
            '&cName='+cName+'&hId='+hId+'&hName='+hName+'&clEntryFee='+clEntryFee],
            area: ['500px', '450px'],
            resize: false,
            btn: '确定',
            btn1: function (index, layero) {
                var body = layer.getChildFrame('body', index);
                //获取值
                var sAId = $(body).find("#sAId").val();
                var sHId = $(body).find("#sHId").val();
                var sMessage = $(body).find("#sMessage").val();
                var isDeduction = "";
                if ($(body).find("[name=clEntryFee]")[1].checked){
                    isDeduction = $(body).find("#isDeduction").val();
                }
                var sSum = $(body).find("#sSum").val();
                var sPaysum = $(body).find("#sPaysum").val();
                var sTime = $(body).find("#sTime").val();
                var sRemark = $(body).find("#sRemark").val();
                if (sSum != '' && sPaysum != '' && sTime != '') {
                    //声明格式是否正确
                    var verify = true;
                    //验证成交金额
                    if(isNaN(sSum) || sSum <= 0){
                        layer.msg("成交金额必须是大于零的数值");
                        verify = false;
                        return;
                    }
                    //验证支付金额
                    if(isNaN(sPaysum) || sPaysum <= 0 || parseFloat(sPaysum) > parseFloat(sSum)){
                        layer.msg("支付金额必须是大于零小于成交金额的数值");
                        verify = false;
                        return;
                    }
                    if(verify) {
                        var load = layer.load();
                        $.post("/crm/success/saveSuccess", {
                                uId: uId,
                                uName:uName,
                                cName:cName,
                                cId: cId,
                                clId: clId,
                                sAId: sAId,
                                sHId: sHId,
                                sMessage: sMessage,
                                isDeduction: isDeduction,
                                sSum: sSum,
                                sPaysum: sPaysum,
                                sTime: sTime,
                                sRemark: sRemark
                            },
                            function (data) {
                                layer.close(load);
                                if (data.code == 200){
                                    layer.msg(data.msg, {time: 500}, function () {
                                        layer.close(index);
                                        goDetail(cId, clId, clUId);
                                    });
                                } else {
                                    layer.msg(data.msg);
                                }
                            }
                        );
                    }
                } else {
                    layer.msg('请填写带星号的必填项');
                }
            },
            cancel: function(index, layero){
                layer.close(index);
            }
        });
    }
}

//退报名费
function refund() {
    //客户编号
    var cId = $(window.parent.document).find("#cId").val();
    //客户编号
    var cName = $(window.parent.document).find("[name=cName]")[0].innerText;
    //线索编号
    var clId = $(window.parent.document).find("#clId").val();
    //负责人编号
    var clUId = $(window.parent.document).find("#clUId").val();
    //预约编号
    var sAId = $(window.parent.document).find("#sAId").val();
    //报名费
    var clEntryFee = $(window.parent.document).find("#clEntryFee").text();
    if (clEntryFee == "null" || clEntryFee == "" || clEntryFee.indexOf("已抵扣")!=-1 || clEntryFee.indexOf("已退还")!=-1){
        layer.msg("该客户不可退报名费");
    } else {
        layer.confirm('确定退报名费吗？', {icon: 3, title:'提示'}, function(index){
            var load = layer.load();
            $.get("/crm/clue/refundClEntryFee", {uId: uId, uName: uName, cId: cId,
                    cName: cName, clId: clId, sAId: sAId, clEntryFee: clEntryFee},
                function (data) {
                    layer.close(load);
                    if (data.code == 200){
                        layer.msg(data.msg, {time: 500}, function () {
                            layer.close(index);
                            goDetail(cId, clId, clUId);
                        });
                    } else {
                        layer.msg(data.msg);
                    }
                }
            );
        });
    }
}

//表格折叠方法
function collapseTable(options) {
    var trObj = options.elem;
    if (!trObj) return;
    var accordion = options.accordion,
        success = options.success,
        content = options.content || '';
    var tableView = trObj.parents('.layui-table-view'); //当前表格视图
    var id = tableView.attr('lay-id'); //当前表格标识
    var index = trObj.data('index'); //当前行索引
    var leftTr = tableView.find('.layui-table-fixed.layui-table-fixed-l tr[data-index="' + index + '"]'); //左侧当前固定行
    var rightTr = tableView.find('.layui-table-fixed.layui-table-fixed-r tr[data-index="' + index + '"]'); //右侧当前固定行
    var colspan = trObj.find('td').length; //获取合并长度
    var trObjChildren = trObj.next(); //展开行Dom
    var indexChildren = id + '-' + index + '-children'; //展开行索引
    var leftTrChildren = tableView.find('.layui-table-fixed.layui-table-fixed-l tr[data-index="' + indexChildren + '"]'); //左侧展开固定行
    var rightTrChildren = tableView.find('.layui-table-fixed.layui-table-fixed-r tr[data-index="' + indexChildren + '"]'); //右侧展开固定行
    var lw = leftTr.width() + 15; //左宽
    var rw = rightTr.width() + 15; //右宽
    //不存在就创建展开行
    if (trObjChildren.data('index') != indexChildren) {
        //装载HTML元素
        var tr = '<tr data-index="' + indexChildren + '"><td colspan="' + colspan + '"><div style="height: auto;padding-left:' + lw + 'px;padding-right:' + rw + 'px" class="layui-table-cell">' + content + '</div></td></tr>';
        trObjChildren = trObj.after(tr).next().hide(); //隐藏展开行
        var fixTr = '<tr data-index="' + indexChildren + '"></tr>';//固定行
        leftTrChildren = leftTr.after(fixTr).next().hide(); //左固定
        rightTrChildren = rightTr.after(fixTr).next().hide(); //右固定
    }
    //展开|折叠箭头图标
    trObj.find('td[lay-event="collapse"] i.layui-colla-icon').toggleClass("layui-icon-right layui-icon-down");
    //显示|隐藏展开行
    trObjChildren.toggle();
    //开启手风琴折叠和折叠箭头
    if (accordion) {
        trObj.siblings().find('td[lay-event="collapse"] i.layui-colla-icon').removeClass("layui-icon-down").addClass("layui-icon-right");
        trObjChildren.siblings('[data-index$="-children"]').hide(); //展开
        rightTrChildren.siblings('[data-index$="-children"]').hide(); //左固定
        leftTrChildren.siblings('[data-index$="-children"]').hide(); //右固定
    }
    success(trObjChildren, indexChildren); //回调函数
    heightChildren = trObjChildren.height(); //展开高度固定
    rightTrChildren.height(heightChildren + 115).toggle(); //左固定
    leftTrChildren.height(heightChildren + 115).toggle(); //右固定
}

//详情页面
function goDetail(cId, clId, clUId){

    //显示详情页面
    var detail = $(window.parent.document).find("#detail");
    detail.css('right', '0px');

    //赋值
    $(window.parent.document).find("#cId").val(cId);
    $(window.parent.document).find("#clId").val(clId);
    $(window.parent.document).find("#clUId").val(clUId);

    //根据线索编号查询信息并赋值
    $.get("/crm/customer/detail", {clId:clId}, function (data) {
        //姓名
        var cNameList = $(window.parent.document).find("[name=cName]");
        for(var i = 0; i < cNameList.length; i++){
            cNameList[i].innerText = data.customer.cName;
        }
        //年龄
        var cAgeList = $(window.parent.document).find("[name=cAge]");
        for(var i = 0; i < cAgeList.length; i++){
            cAgeList[i].innerText = data.customer.cAge;
        }
        //电话
        var cTelList = $(window.parent.document).find("[name=cTel]");
        for(var i = 0; i < cTelList.length; i++){
            cTelList[i].innerText = data.customer.cTel;
        }
        //客户状态
        $(window.parent.document).find("#cType").text(data.customer.cType);
        //最近就诊
        $(window.parent.document).find("#hName").text(data.hName);
        //最近就诊时间
        var date = data.date;
        date = date.substring(0, 10);
        $(window.parent.document).find("#date").text(date);
        //微信
        $(window.parent.document).find("#cWx").text(data.customer.cWx);
        //负责人
        $(window.parent.document).find("#principal").text(data.customer.uName);
        //创建时间
        var cTime = data.customer.cTime;
        cTime = cTime.substring(0, 10);
        $(window.parent.document).find("#cTime").text(cTime);
        //修改时间
        var editTime = data.editTime;
        editTime = editTime.substring(0, 10);
        $(window.parent.document).find("#editTime").text(editTime);
        //报名费
        $(window.parent.document).find("#clEntryFee").text(data.customer.clEntryFee);
        //成交金额
        $(window.parent.document).find("#successMoney").text(data.successMoney);
        //已交金额
        $(window.parent.document).find("#payMoney").text(data.payMoney);
        //待交金额
        $(window.parent.document).find("#waitMoney").text(data.waitMoney);
        //抵扣状态
        $(window.parent.document).find("#status").text(data.status);
        //退款金额
        $(window.parent.document).find("#refund").text(data.refund);
        //性别
        $(window.parent.document).find("#cSex").text(data.customer.cSex);
        //来源
        $(window.parent.document).find("#clSource").text(data.customer.clSource);
        //来源
        $(window.parent.document).find("#clEntryFee").text(data.customer.clEntryFee);
        //报名项目
        $(window.parent.document).find("#clProject").text(data.customer.clProject);
        //报名时间
        $(window.parent.document).find("#clPlaceTime").text(data.customer.clPlaceTime);
        //备注
        $(window.parent.document).find("#clRemark").text(data.customer.clRemark);
        //预约编号
        $(window.parent.document).find("#sAId").val(data.sAId);
        //门诊编号
        $(window.parent.document).find("#hId").val(data.hId);
    });

    //预约记录
    $.get("/crm/appointment/queryAToDetail", {clId:clId}, function (data) {
        var html = "";
        $.each(data.data, function (index, item) {
            html += "<li class='layui-timeline-item'>" +
                "<i class='layui-icon layui-timeline-axis'>&#xe63f;</i>" +
                "<div class='layui-timeline-content layui-text'>" +
                "<div class='layui-card' style='background-color: aliceblue;'>" +
                "<div><span style='font-size: 20px;'>"+item.aTime+"【"+item.aType+"】</span></div>" +
                "<div style='margin-top: 5px;'>预约项目："+item.clProject+"</div>" +
                "<div style='margin-top: 5px;'>预约人："+item.uName+"</div>" +
                "<div style='margin-top: 5px;'>预交金额："+item.clEntryFee+"</div>" +
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
    $.get("/crm/operating/queryOpByCId", {cId:cId}, function (data) {
        var html = "";
        $.each(data.data, function (index, item) {
            html += "<li class='layui-timeline-item'>" +
                "<i class='layui-icon layui-timeline-axis'>&#xe63f;</i>" +
                "<div class='layui-timeline-content layui-text'>" +
                "<div class='layui-card' style='background-color: aliceblue;'>" +
                "<div><span style='font-size: 20px;'>"+item.opTime+"</span></div>" +
                "<div style='margin-top: 5px;'>操作用户："+item.uName+"</div>" +
                "<div style='margin-top: 5px;'>操作名称："+item.opName+"</div>" +
                "<div style='margin-top: 5px;'>操作内容："+item.opContent+"</div>" +
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
        ,url: '/crm/success/querySByClId?clId='+clId //访问路径
        ,skin : 'line'
        ,cols: [ //表头
            [
                {width: 10, title: '', align:'center', event: 'collapse',
                    templet: function(data) {
                        return "<div style='position: relative; cursor:pointer;'>" +
                            "<i	style='left: 0px;' lay-tips='展开' class='layui-icon layui-colla-icon layui-icon-right' lay-event='collapse'></i>" +
                            "</div>";
                    }
                }
                ,{field: 'hName', minWidth: 150, title: '成交门诊', align:'center'}
                ,{field: 'sMessage', minWidth: 180, title: '成交信息', align:'center'}
                ,{field: 'sSum', minWidth: 120, title: '成交金额', align:'center'}
                ,{field: 'sPaysum', minWidth: 120, title: '支付金额', align:'center'}
                ,{field: 'sRemark', minWidth: 180, title: '备注', align:'center'}
                ,{field: 'sTime', minWidth: 200, title: '成交时间', align:'center'}
                ,{fixed: 'right', minWidth: 220, title: '操作', align:'center',
                    templet: function(data) {
                        return "<div><a class='layui-btn layui-btn-xs' lay-event='edit'>编辑</a>" +
                                    "<a class='layui-btn layui-btn-warm layui-btn-xs' lay-event='gathering'>收款</a>" +
                                    "<a class='layui-btn layui-btn-danger layui-btn-xs' lay-event='refund'>退款</a>" +
                                    "<a class='layui-btn layui-btn-normal layui-btn-xs' lay-event='success'>成交</a>" +
                                "</div>";
                    }
                }
            ]
        ]
    });

    //监听行工具事件
    table.on('tool(successTab)', function(obj){ // 注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
        var data = obj.data //获得当前行数据
            ,layEvent = obj.event; //获得 lay-event 对应的值
        if (obj.event === 'collapse') {
            var trObj = parent.layui.$(this).parent('tr'); //当前行
            var accordion = true //开启手风琴，那么在进行折叠操作时，始终只会展现当前展开的表格。
            var content = '<table></table>' //内容
            //表格行折叠方法
            collapseTable({
                elem: trObj,
                accordion: accordion,
                content: content,
                success: function(trObjChildren, index) { //成功回调函数
                    //trObjChildren 展开tr层DOM
                    //index 当前层索引
                    trObjChildren.find('table').attr("id", index);
                    parent.table.render({
                        elem: "#" + index
                        ,url: '/crm/payrecord/queryPByPaySId?paySId=' + data.sId
                        ,cols: [
                            [
                                {field: 'payId', minWidth: 120, title: 'ID', sort: true, align:'center'}
                                ,{field: 'cName', minWidth: 120, title: '客户名称', align:'center'}
                                ,{field: 'paySum', minWidth: 120, title: '支付金额', sort: true, align:'center'}
                                ,{field: 'payTime', minWidth: 200, title: '支付时间', sort: true, align:'center'}
                                ,{field: 'payRemark', minWidth: 200, title: '支付备注', align:'center'}
                                ,{field: 'payType', minWidth: 120, title: '支付类型', align:'center'}
                            ]
                        ]
                    });
                },

            });
        } else if (obj.event === 'edit'){
            //弹出编辑页面
            parent.layer.open({
                type: 2, //层类型，iframe
                title: '编辑成交客户',
                content: ['/crm/success/querySBySId?sId='+data.sId+'&cId='+data.cId],
                area: ['450px', '450px'],
                resize: false,
                btn: '确定',
                btn1: function (index, layero) {
                    var body = parent.layer.getChildFrame('body', index);
                    //获取值
                    var sId = $(body).find("#sId").val();
                    var cId = $(body).find("#cId").val();
                    var cName = $(body).find("#cName").val();
                    var sAId = $(body).find("#sAId").val();
                    var sHId = $(body).find("#sHId").val();
                    var sMessage = $(body).find("#sMessage").val();
                    var sSum = $(body).find("#sSum").val();
                    var sTime = $(body).find("#sTime").val();
                    var sRemark = $(body).find("#sRemark").val();
                    if (sSum != '' && sTime != '') {
                        //声明格式是否正确
                        var verify = true;
                        if (isNaN(sSum) || sSum <= 0 || parseFloat(sSum) < parseFloat(data.sPaysum)) {
                            parent.layer.msg("成交金额必须是大于支付金额的数值");
                            verify = false;
                            return;
                        }
                        if (verify) {
                            var load = layer.load();
                            $.post("/crm/success/editSBySId",
                                {
                                    uId: uId, sId:sId, cId:cId, sAId: sAId, sHId: sHId,
                                    sMessage: sMessage, sSum: sSum, sTime:sTime,
                                    sRemark: sRemark, uName: uName, cName: cName
                                },
                                function (data) {
                                    layer.close(load);
                                    if (data.code == 200){
                                        parent.layer.msg(data.msg, {time: 500}, function () {
                                            parent.layer.close(index);
                                            goDetail(cId, clId, clUId);
                                        });
                                    } else {
                                        layer.msg(data.msg);
                                    }
                                }
                            );
                        }
                    } else {
                        parent.layer.msg('请填写带星号的必填项');
                    }
                },
                cancel: function (index, layero) {
                    parent.layer.close(index);
                }
            });
        } else if (obj.event === 'gathering'){
            if (parseFloat(data.sSum) == parseFloat(data.sPaysum)){
                parent.layer.msg('该客户全款已付全款');
            } else {
                //尾款
                var wk = eval(data.sSum + "-" + data.sPaysum);
                wk = wk.toFixed(2);
                console.log("尾款："+wk);
                //弹出收款页面
                parent.layer.open({
                    type: 2, //层类型，iframe
                    title: '收款',
                    content: ['/crm/payrecordsave?sId='+data.sId+'&cId='+data.cId+'&cName='+data.cName+'&wk='+wk],
                    area: ['500px', '500px'],
                    resize: false,
                    btn: '确定',
                    btn1: function (index, layero) {
                        var body = parent.layer.getChildFrame('body', index);
                        //获取值
                        var cId = $(body).find("#cId").val();
                        var cName = $(body).find("#cName").val();
                        var paySId = $(body).find("#paySId").val();
                        var wk = $(body).find("#wk").val();
                        var paySum = $(body).find("#paySum").val();
                        var payRemark = $(body).find("#payRemark").val();
                        var payTypeId = $(body).find("#payTypeId").val();
                        var payTime = $(body).find("#payTime").val();
                        if (paySum != '' && payTime != '') {
                            if (!isNaN(paySum) && paySum >= 0){
                                if (parseFloat(wk) < parseFloat(paySum)){
                                    parent.layer.msg("支付金额不能大于尾款，尾款为"+wk);
                                } else {
                                    var load = parent.layer.load();
                                    $.post("/crm/payrecord/savePayrecord",
                                        {uId: uId, uName: uName, cId: cId, cName: cName, paySId: paySId, paySum: paySum, payRemark:payRemark, payTypeId: payTypeId, payTime:payTime},
                                        function (data) {
                                            parent.layer.close(load);
                                            if (data.code == 200){
                                                parent.layer.msg(data.msg, {time: 500}, function () {
                                                    parent.layer.close(index);
                                                    goDetail(cId, clId, clUId);
                                                });
                                            } else {
                                                layer.msg(data.msg);
                                            }
                                        }
                                    );
                                }
                            } else {
                                parent.layer.msg('支付金额必须是大于等于零的数值');
                            }
                        } else {
                            parent.layer.msg('请填写带星号的必填项');
                        }
                    },
                    cancel: function (index, layero) {
                        parent.layer.close(index);
                    }
                });
            }
        } else if (obj.event === 'refund'){
            //成交金额
            var sSum = data.sSum;
            //支付金额
            var sPaysum = data.sPaysum;
            parent.layer.open({
                type: 2, //层类型，iframe
                title: '退款',
                content: ['/crm/refundMoney?sId='+data.sId+'&cId='+data.cId+
                '&cName='+data.cName+'&sSum='+sSum+'&sPaysum='+sPaysum],
                area: ['500px', '500px'],
                resize: false,
                btn: '确定',
                btn1: function (index, layero) {
                    var body = parent.layer.getChildFrame('body', index);
                    //获取值
                    var cId = $(body).find("#cId").val();
                    var cName = $(body).find("#cName").val();
                    var paySId = $(body).find("#paySId").val();
                    var refundsSum = $(body).find("#refundsSum").val();
                    var refundsPaysum = $(body).find("#refundsPaysum").val();
                    var payTime = $(body).find("#payTime").val();
                    var payRemark = $(body).find("#payRemark").val();
                    var payTypeId = $(body).find("#payTypeId").val();
                    //声明格式是否正确
                    var verify = true;
                    if (refundsSum != '' && refundsPaysum != '' && payTime != '') {
                        //验证成交退款金额
                        if (!isNaN(refundsSum) && refundsSum >= 0) {
                            if (parseFloat(sSum) < parseFloat(refundsSum)) {
                                parent.layer.msg("成交退款金额不能大于成交金额，成交金额为" + sSum);
                                verify = false;
                                return;
                            }
                        } else {
                            parent.layer.msg('成交退款金额必须是大于零的数值');
                            verify = false;
                            return;
                        }
                        //验证支付退款金额
                        if (!isNaN(refundsPaysum) && refundsPaysum >= 0) {
                            if (parseFloat(sPaysum) < parseFloat(refundsPaysum)) {
                                parent.layer.msg("支付退款金额不能大于支付金额，支付金额为" + sPaysum);
                                verify = false;
                                return;
                            }
                        } else {
                            parent.layer.msg('支付退款金额必须是大于等于零的数值');
                            verify = false;
                            return;
                        }
                    } else {
                        parent.layer.msg('请填写带星号的必填项');
                        verify = false;
                        return;
                    }
                    if (verify){
                        var load = parent.layer.load();
                        $.get("/crm/success/refundMoney",
                            {uId: uId, uName: uName, cId: cId, cName: cName, paySId: paySId, sSum:sSum, sPaysum:sPaysum, refundsSum: refundsSum,
                                refundsPaysum:refundsPaysum, payTime:payTime, payRemark:payRemark, payTypeId: payTypeId},
                            function (data) {
                                parent.layer.close(load);
                                if (data.code == 200){
                                    parent.layer.msg(data.msg, {time: 500}, function () {
                                        parent.layer.close(index);
                                        goDetail(cId, clId, clUId);
                                    });
                                } else {
                                    layer.msg(data.msg);
                                }
                            }
                        );
                    }
                },
                cancel: function (index, layero) {
                    parent.layer.close(index);
                }
            });
        } else if(layEvent === 'success'){
            //弹出成交页面
            parent.layer.open({
                type: 2, //层类型，iframe
                title: '新增成交客户',
                content: ['/crm/successsave?cId='+data.cId+'&clId='+data.clId+'&sAId='+data.sAId+
                '&cName='+data.cName+'&hId='+data.hId+'&hName='+data.hName+'&clEntryFee='+data.clEntryFee],
                area: ['500px', '450px'],
                resize: false,
                btn: '确定',
                btn1: function (index, layero) {
                    var body = parent.layer.getChildFrame('body', index);
                    //获取值
                    var cId = $(body).find("#cId").val();
                    var cName = $(body).find("#cName").val();
                    var clId = $(body).find("#clId").val();
                    var sAId = $(body).find("#sAId").val();
                    var sHId = $(body).find("#sHId").val();
                    var sMessage = $(body).find("#sMessage").val();
                    var isDeduction = "";
                    if ($(body).find("[name=clEntryFee]")[1].checked){
                        isDeduction = $(body).find("#isDeduction").val();
                    }
                    var sSum = $(body).find("#sSum").val();
                    var sPaysum = $(body).find("#sPaysum").val();
                    var sTime = $(body).find("#sTime").val();
                    var sRemark = $(body).find("#sRemark").val();
                    if (sSum != '' && sPaysum != '' && sTime != '') {
                        //声明格式是否正确
                        var verify = true;
                        //验证成交金额
                        if(isNaN(sSum) || sSum <= 0){
                            parent.layer.msg("成交金额必须是大于零的数值");
                            verify = false;
                            return;
                        }
                        //验证支付金额
                        if(isNaN(sPaysum) || sPaysum <= 0 || parseFloat(sPaysum) > parseFloat(sSum)){
                            parent.layer.msg("支付金额必须是大于零小于成交金额的数值");
                            verify = false;
                            return;
                        }
                        if(verify) {
                            var load = parent.layer.load();
                            $.post("/crm/success/saveSuccess", {
                                    uId: uId,
                                    uName:uName,
                                    cName:cName,
                                    cId: cId,
                                    clId: clId,
                                    sAId: sAId,
                                    sHId: sHId,
                                    sMessage: sMessage,
                                    isDeduction: isDeduction,
                                    sSum: sSum,
                                    sPaysum: sPaysum,
                                    sTime: sTime,
                                    sRemark: sRemark
                                },
                                function (data) {
                                    parent.layer.close(load);
                                    if (data.code == 200){
                                        parent.layer.msg(data.msg, {time: 500}, function () {
                                            parent.layer.close(index);
                                            goDetail(cId, clId, clUId);
                                        });
                                    } else {
                                        layer.msg(data.msg);
                                    }
                                }
                            );
                        }
                    } else {
                        parent.layer.msg('请填写带星号的必填项');
                    }
                },
                cancel: function(index, layero){
                    parent.layer.close(index);
                }
            });
        }
    });

    //根据客户编号查询所拥有的跟进类型
    $.get("/crm/follow/queryFollowByFClId?clId="+clId, function(obj){
        var html = "";
        for(var i = 0; i < obj.data.length; i++) {
            var year = obj.data[i].fTime.substring(0, 4);
            var month = obj.data[i].fTime.substring(5, 7);
            var day = obj.data[i].fTime.substring(8, 10);
            var date = year+"年"+month+"月"+day+"日";
            html += "<li class='layui-timeline-item'>" +
                        "<i class='layui-icon layui-timeline-axis'>&#xe63f;</i>" +
                        "<div class='layui-timeline-content layui-text'>" +
                            "<h3>"+date+"("+obj.data[i].fType+")</h3>" +
                            "<ul>" +
                                "<li>"+obj.data[i].fContent+"</li>" +
                            "</ul>" +
                        "</div>" +
                    "</li>";
        }
        //赋值
        $(window.parent.document).find("#follow").html(html);
    });

}
