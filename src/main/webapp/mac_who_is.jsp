<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>MAC地址查询——X_Monster</title>

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
          integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
    <link rel="stylesheet" href="css/entire.css">
    <script src="js/jquery-3.6.0.js"></script>

    <!-- Global site tag (gtag.js) - Google Analytics -->
    <script async src="https://www.googletagmanager.com/gtag/js?id=G-W7NHWX0HRN"></script>
    <script>
        window.dataLayer = window.dataLayer || [];

        function gtag() {
            dataLayer.push(arguments);
        }

        gtag('js', new Date());
        gtag('config', 'G-W7NHWX0HRN');
    </script>
</head>
<body style="margin: 0px; padding: 0px;">
<!-- 去除页面与浏览器边框之间的空白 -->
<div id="all" style="padding: 0px;">
    <!-- 页面顶栏 -->
    <div id="topbar">
        <a href="/" title="HelloWorld.Monster"><i class='far fa-edit fa-fw'></i>HelloWorld</a>
        <a href="/posts/" title="全部文章"> 文章 </a>
        <a href="/tags/" title="文章标签"> 标签 </a>
        <a href="/categories/" title="文章分类"> 分类 </a>
        <a href="/labs/" title="学习与实践"><i class='fas fa-flask'></i> Labs </a>
        <a href="/tools/" title="工具与玩具"><i class='fas fa-dice-d20'></i> Tools </a>
        <a href="/about/" title="本站日记"> About </a>
    </div>

    <!-- 页面主体 -->
    <div id="main">

        <!-- file_name -->
        <div id="mac_who_is">
            <!-- 这行是显示服务器返回的提示信息 -->
            <span id="returnMsg"></span>
            <fieldset>
                <legend>查询 MAC 地址所归属的厂商</legend>
                <ul style="list-style-type: none;">
                    <li><span id="updateTime"></span></li>
                    <li><br/></li>
                    <li>本功能支持的 MAC 地址说明：</li>
                    <li>支持的分隔方式有：（以 “-” 作为分隔符示例）</li>
                    <ul style="list-style-type:disc">
                        <li>按字节分隔：xx-xx-xx-xx-xx-xx</li>
                        <li>两字节分隔：xxxx-xxxx-xxxx</li>
                        <li>不&emsp;分&emsp;隔：xxxxxxxxxxxx</li>
                    </ul>
                    <li>支持的分隔符有：</li>
                    <ul style="list-style-type:disc">
                        <li>连字符：“-”</li>
                        <li>冒&emsp;号：“:”</li>
                        <li>点&emsp;号：“.”</li>
                        <li>空&emsp;格：“ ”</li>
                    </ul>
                    <li>也可以只输入前三个字节（输入长度大于等于 3 个字节，至完整长度的 MAC 地址，均能自动识别）</li>
                    <li>要进行批量查询，可以用<span style="background-color: silver;font-weight:900;color:firebrick;">逗号 “,” 分隔</span>)多个 MAC 地址</li>
                    <li><br/></li>
                    <li>请在文本框中输入 MAC 地址：</li>

                    <li>
                        <textarea id="macAddress" name="macAddress" rows="10" cols="36" placeholder="请输入 MAC 地址..."
                                  required></textarea>
                    </li>
                    <li>
                        <input class="submit" id="submit" type="submit" value="提 交" onclick="submit()">
                    </li>

                </ul>
            </fieldset>
            <span id="returnResults"></span><br/>
            <hr class="style9">
            <a href="https://github.com/HonorKnight8/X_Tools_and_Toys" style="background-color: #292a2d"> 本工具源码 </a>
        </div>

    </div>

</div>


</body>

<script>
    /**
     * 页面加载时，获取资料库更新时间
     */
    $(document).ready(function () {
        //console.log("页面加载");
        $.ajax({
            url: "/tools_and_toys/get_oui_update_time",
            async: true,
            type: "POST",
            dataType: "json",
            success: function (data) {
                if (data.flag) {
                    $("#updateTime").css("color", "royalblue").html(data.returnUpdateTime);
                } else {
                    $("#returnMsg").css("color", "red").html(data.returnMsg);
                }
            },
            error: function () {
                console.log("执行失败");
            },
        })
    });

    /**
     * 进行 MAC 地址查询
     */
    function submit() {
        $("#returnResults").css("color", "red").html("");
        $("#returnMsg").css("color", "red").html("");

        let macAddress = $("#macAddress").val();
        let html = "";

        $.ajax({
            url: "/tools_and_toys/mac_who_is",
            async: true,
            data: {
                "macAddress": macAddress
            },
            type: "POST",
            dataType: "json",
            success: function (data) {
                //console.log(data);
                if (data.flag) {
                    let returnJson = eval(data);
                    let returnResults = returnJson['returnResults'];
                    //console.log(returnResults);

                    for (let key in returnResults) {
                        //console.log(key + " " + returnResults[key]);
                        html = html + "MAC 地址：<b>“" + key + "” </b>归属的厂商是：<br/>&emsp;&emsp;" + returnResults[key] + "<br/><br/>";
                    }

                    $("#returnResults").css("color", "royalblue").html(html);
                    // $("#returnResults").html(html);
                } else {
                    $("#returnMsg").css("color", "red").html(data.returnMsg);
                }
            },
            error: function () {
                console.log("执行失败");
            },
        })
    }
</script>
</html>