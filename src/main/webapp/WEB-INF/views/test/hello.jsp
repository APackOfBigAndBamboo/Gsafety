<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>鼠标移动点击顺序排序</title>
    <script type="text/javascript" src="jquery-1.8.3.js"></script>
    <style type="text/css">
        .tr-hover { background-color: #CCC; }
        .tr-selected { background-color: #666; } .tr-border { border: solid 1px #F00; } </style> </head> <body> <table width="500" border="1" cellpadding="0" cellspacing="0" id="table">
    <thead>
    <tr>
        <th>序号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>网址</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>1</td>
        <td>Lupo</td>
        <td>
            <select name="">
                <option value="1">男</option>
                <option value="0">女</option>
            </select>
        </td>
        <td><input type="text" value="http://bbs.it-home.org" /></td>
    </tr>
    <tr>
        <td>2</td>
        <td>andy</td>
        <td>
            <select name="">
                <option value="1">男</option>
                <option value="0">女</option>
            </select>
        </td>
        <td><input type="text" value="http://bbs.it-home.org"  /></td>
    </tr>
    <tr>
        <td>3</td>
        <td>lilian</td>
        <td>
            <select name="">
                <option value="1">男</option>
                <option value="0">女</option>
            </select>
        </td>
        <td><input type="text" value="http://bbs.it-home.org"  /></td>
    </tr>
    <tr>
        <td>4</td>
        <td>jinker</td>
        <td>
            <select name="">
                <option value="1">男</option>
                <option value="0">女</option>
            </select>
        </td>
        <td><input type="text" value="http://bbs.it-home.org"  /></td>
    </tr>
    </tbody>
</table>
<script type="text/javascript">
    /**
     *表格插件 实现表格的hover效果 点击效果 拖动排序
     *@encode UTF-8
     *@param {boolen} hover     是否打开hover效果 true|false
     *@param {boolen} selected    是否打开selected效果 true|false
     *@param {boolen} rowMove    是否打开移动排序效果 true|false
     *@example:
     $("#table").initTable({
        hover:true,
        selected:false,
        rowDrag:true,
        rowMove:true
    })
     表格需包含thead,tbody2部分

     */
    (function ($) {
        $.fn.extend({
            initTable:function (o) {
                //接受配置参数并设定默认值
                var it = this,
                    hover = o.hover||false,
                    selected = o.selected||false,
                    rowDrag = o.rowDrag||false;
                rowMove =rowDrag?true:(o.rowMove||true),
                    tbody = $(it).children("tbody"),
                    tr = $(it).children("tbody").children("tr");
                //添加事件前先移除对象所有的事件
                it.undelegate();
                //tr的鼠标移动效果
                if (hover) {
                    tbody.delegate("tr", "mouseenter", function () {
                        $(this).addClass("tr-hover");
                    }).delegate("tr", "mouseleave", function () {
                        $(this).removeClass("tr-hover");
                    })
                }
                //tr的选中效果
                if (selected) {
                    tbody.delegate("tr","click",function(e){
                        if(e.target.tagName.toLowerCase()=="td"){
                            tbody.children(".tr-selected").removeClass('tr-selected');
                            $(this).addClass('tr-selected');
                        }
                    })
                }
                //表格行的移动效果
                if(rowMove){
                    var targetEl,mouseDown=false;
                    tbody.delegate("tr", "mousedown", function(e){
                        //只对td对象触发
                        if(e.target.tagName.toLowerCase() === "td"){
                            //按下鼠标时选取行
                            targetEl = this,mouseDown = true; console.log(this);
                            $(this).css("cursor","move");
                            return false;
                        }
                    }).delegate("tr", "mousemove", function(e){
                        //移动鼠标
                        if (mouseDown) {
                            //释放鼠标键时进行插入
                            if (targetEl != this) {
                                if ($(this).index()>$(targetEl).index()){
                                    $($(this)).after(targetEl);
                                } else {
                                    $($(this)).before(targetEl);
                                }
                            }
                        }
                        return false;
                    }).delegate("tr", "mouseup", function (e) {
                        $(tr).css("cursor","default");
                        targetEl = null;
                    })
                    //鼠标离开表格时,释放所有事件
                    it.delegate("tbody", "mouseleave", function (e) {
                        $(tr).css("cursor","default");
                        targetEl = null;
                        mouseDown = false;
                    })
                }
            }
        })
    })(jQuery)
    $("#table").initTable({
        hover:true,
        selected:true,
        rowMove:true
    })
</script>
</body>
</html>