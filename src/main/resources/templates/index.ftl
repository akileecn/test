<html>
<head>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
</head>
<body>
hello world
<script>
    $.ajax({
        url:"https://app.vdongchina.com/wyl/hello",
        type:"POST",
        success:function(data){
            console.log(data)
        }
    })
</script>
</body>
</html>
