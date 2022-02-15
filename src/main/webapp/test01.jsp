<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>mytitle</title>
        <script src="js/jquery-3.4.1.js"></script>
        <script>
            $(function (){
                $("#button1").click(function (){
                    $.ajax({
                        contentType:"application/json",
                        url:"test.do",
                        dataType:"json",
                        type:"get",
                        async:true,
                        success:function (data){
                            $("#div1").html("学号："+data.id+" 姓名："+data.name+" 年龄："+data.age)
                        }
                    })
                    //此处不用等待ajax执行完毕才执行，因为ajax设置为异步
                    //分出一个线程执行ajax，主线程继续执行，两个线程相互独立，互不影响
                    alert("12345")
                })
            })
        </script>
    </head>
    <body>
        <div id = 'div1' style="width: 1000px;height: 50px;background-color: aqua">

        </div>
        <br/>
        <div id = 'div2' style="width: 50px;height: 50px;background-color: aqua">

        </div>
        <br/>
        <div id = 'div3' style="width: 50px;height: 50px;background-color: aqua">

        </div>
        <br/>
        <button id = 'button1'>点击</button>
    </body>
</html>
