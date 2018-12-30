<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta charset="UTF-8">
    <title>管理中心</title>
</head>
<body style="margin: 0 auto">
<canvas id='d1' width="600" height="700" style="left: 500px; border:dashed 2px #ccc;position:absolute;z-index:-2;filter: alpha(opacity:50);opacity: 0.5"></canvas>
<script>

    var drawtree = function (ctx, startx, starty, length, angle, depth, branchWidth) {
            var rand = Math.random,
                    n_length, n_angle, n_depth, maxbranch = 4,
                    endx, endy, maxangle = 2 * Math.PI / 4;
            var subbranch;
            ctx.beginPath();
            ctx.moveTo(startx, starty);
            endx = startx + length * Math.cos(angle);
            endy = starty + length * Math.sin(angle);
            ctx.lineCap = 'round';
            ctx.lineWidth = branchWidth;
            ctx.lineTo(endx, endy);
            if (depth <= 2) {
                //树的枝干
                ctx.strokeStyle = 'rgb(0,' + (((rand() * 64) + 128) >> 0) + ',0)';
            }
            else {
                //树的叶子
                ctx.strokeStyle = 'rgb(0,' + (((rand() * 64) + 64) >> 0) + ',50,25)';
            }
            ctx.stroke();
            n_depth = depth - 1;
            //判断树是否结束
            if (!n_depth) {
                return;
            }
            subbranch = (rand() * (maxbranch - 1)) + 1;
            branchWidth *= 0.5;
            for (var i = 0; i < subbranch; i++) {
                n_angle = angle + rand() * maxangle - maxangle * 0.5;
                n_length = length * (0.5 + rand() * 0.5);
                setTimeout(function () {
                    drawtree(ctx, endx, endy, n_length, n_angle, n_depth, branchWidth);
                    return;
                }, 500)
            }
        };

        var canvas1 = document.getElementById('d1');
        var context = canvas1.getContext('2d');
        //初始化的树
        drawtree(context, 300, 700, 200, -Math.PI / 2, 12, 12);
        //context.fill();
        //document.getElementById('YST').style.backgroundImage = 'url("' + context.canvas.toDataURL() + '")';

</script>

<div id="YST" style="width:600px; height:700px;border:dashed 2px #ccc;text-align: center;left: 500px;position:absolute">
    <h2><a href="adminUser">用户管理</a><br><br>
<a href="getMyOrder">订单管理</a><br><br><a href="admin_jingdian.jsp">发布景点</a><br><br>
<a href="admin_jiudian.jsp">发布酒店</a><br><br><a href="admin_meishi.jsp">发布美食</a><br>
<br><hr></h2>
    <h2 style="color: red;">管理员须知</h2>
    <p align="center" style="color: red;font-size: 20px">关于管理，有几点注意事项，想到了随时更新： <br>
1、不要清理[已注销]的小组成员和长期无人回复的水贴，将其留到小组扩容时有用； <br>
2、删贴请尽可能详细注明删除理由，以方便出现投诉时倒查并提示被删帖的组员注意； <br>
3、对于提意见或质问删帖原因的帖子，建议管理员可私下豆油进行沟通，耐心解释。尽量不要在组内公开的吵架。对于无理取闹、胡搅蛮缠的组员可将其直接永久封禁； <br>
4、请各位管理员不要擅自修改“小组介绍”下的内容； <br>
5、请暂勿进行小组删帖指引（下表）规定内容以外的操作。 </p>
</div>
</body>

</html>
