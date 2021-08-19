<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件名转小写、下划线——X_Monster</title>

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
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
        <div id="file_name">
            <!-- 这行是显示服务器返回的提示信息 -->
            <span id="returnMsg"></span>
            <fieldset>
                <legend>文件名转小写、下划线</legend>
                <ul style="list-style-type: none;">
                    <li>请输入文件名：</li>
                    <li>
                        <textarea id="filename" name="filename" rows="10" cols="36" placeholder="请输入文件名..."
                                  required></textarea>
                    </li>
                    <li>
                        允许输入：大小写字母、 “.” 、空格、 “-” 、 “_” <br/>
                        大写字母会转换为小写<br/>
                        空格 或 “-” 会转换为 “_” <br/>
                    </li>
                    <li>
                        <input class="submit" id="submit" type="submit" value="提 交" onclick="submit()">
                    </li>

                </ul>
            </fieldset>
            <span id="returnFileName"></span><br/>
            <hr class="style9">
            <a href="/description_about_file_name_convert_tool/" style="background-color: #292a2d"> 关于本工具的说明（源代码） </a><br/>
            <a href="https://github.com/HonorKnight8/X_Tools_and_Toys" style="background-color: #292a2d"> 本工具源码 </a>
        </div>

    </div>

</div>

</body>

<script>

    function submit() {
        $("#returnFileName").css("color", "red").html("");
        $("#returnMsg").css("color", "red").html("");

        let filename = $("#filename").val();

        $.ajax({
            url: "/tools_and_toys/file_name",
            async: true,
            data: {
                "filename": filename
            },
            type: "POST",
            dataType: "json",
            success: function (data) {
                console.log("发送成功");
                console.log("服务器返回：" + data);

                if (data.flag) {
                    $("#returnFileName").css("color", "royalblue").html(data.returnFileName);
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
