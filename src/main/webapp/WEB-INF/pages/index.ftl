<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script src="/js/lib/mootools-core-1.4.5.js"></script>
</head>
<body>
    <form method="post" action="/spring-mvc-demo/register">
        <input type="text" name="name" placeholder="name" />
        <input type="text" name="age"  placeholder="age" />
        <input type="password" name="password"  placeholder="password" />
        <input type="submit" name="提交" />
    </form>

    <div>Upload Single File Request</div>
    <div>
        <form method="post" action="/spring-mvc-demo/addShopWithPic" enctype="multipart/form-data">
            <input type="text" name="shopname" placeholder="shopname" /><br>
            <input type="text" name="name"  placeholder="name1" /><br>
            <input type="file" name="file"  placeholder="file1" /><br>
            <input type="submit" name="提交" /><br>
        </form>
    </div>

    <div>Upload Multiple File Request</div>
    <div>
        <form method="post" action="/spring-mvc-demo/addShopWithPics" enctype="multipart/form-data">
            <input type="text" name="shopname" placeholder="shopname" /><br>
            <input type="text" name="name"  placeholder="name1" /><br>
            <input type="file" name="file"  placeholder="file1" /><br>
            <input type="text" name="name"  placeholder="name2" /><br>
            <input type="file" name="file"  placeholder="file2" /><br>
            <input type="submit" name="提交" /><br>
        </form>
    </div>
</body>
<script src="/js/hello.js"></script>
</html>