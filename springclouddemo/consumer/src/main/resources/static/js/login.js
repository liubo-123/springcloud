function login() {
			   var username = document.getElementsByName("username")[0].value;
                               //var password =hex_md5(document.getElementsByName("password")[0].value);
                               var password =document.getElementsByName("password")[0].value;

                               //alert(username)
                               //alert(password)
               				   if (username == "") {
                                   alert("请输入用户名！");
                                   return;
                               }
                               if (password == "") {
                                   alert("请输入密码！");
                                   return;
                               }

                               //alert(123)
                               $.ajax({
                                   url: "http://localhost:2224/login",
               					   data:{"username":username,"password":password},
                                   type: "post",
                                   dataType: "json",
                                   success: function (result) {
                                        var data =  JSON.stringify(result)
                                        var res = JSON.parse(data)

                                       if(res.status=="0"){
                                           alert(res.msg)
                                           window.location.href="http://localhost:2224/index"

               						}else{
                                           alert(res.msg)
               						}
                                   },
                                   error:function(result){
                                       var data =  JSON.stringify(result)
                                       alert(data)
                                       alert("请求失败！！！")
                                   }
                               })
                           }