<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <title>Registration</title>
    <jsp:include page="meta.jsp"></jsp:include>
    <!--<script src="checkRegistration.js"></script>-->
    <!--<link href="https://fonts.googleapis.com/css?family=PT+Sans" rel="stylesheet">-->
</head>
<body>
    <div class="wrapper">
        <jsp:include page="header.jsp"></jsp:include>
        <div class="content">
            <div class="register-img">
                <div class="info">
                    <h2>Регистрация</h2>
                    <form class="form" action="${pageContext.request.contextPath}/register" method="post"
                          onsubmit="
                            var password = document.getElementById('password');
                           var rePassword = document.getElementById('passwordRepeat');
                           if(password.value != rePassword.value) {
                               password.value = '';
                               rePassword.value = '';
                               alert('Пароли не совпадают!')
                           }">
                        <label for="firstName">Имя</label>
                        <input type="text" name="firstName" id="firstName" class="reg" value="" size="20" minlength="1" placeholder="Введите имя.." required
                               title="Имя не должно содержать цифр и спецсимволов"
                               onkeyup="var pattern=/['а-яА-ЯёЁa-zA-Z']/;
                           if(!pattern.test(this.value)) this.value=''"/>
                        <br/>
                        <label for="lastName">Фамилия</label>
                        <input type="text" name="lastName" id="lastName" class="reg" value="" size="20" minlength="1" placeholder="Введите фамилию.." required
                               title="Фамилия не должна содержать цифр и спецсимволов"
                               onkeyup="var pattern=/['а-яА-ЯёЁa-zA-Z']/;
                           if(!pattern.test(this.value)) this.value=''"/>
                        <br/>
                        <label for="login">Логин</label>
                        <input type="text" name="login" id="login" class="reg" value="" size="20" minlength="3" maxlength="15"  placeholder="Придумайте логин.." required
                               title="Логин должен быть длиной от 3 до 15 символов"/>
                        <br/>
                        <label for="password">Пароль</label>
                        <input type="text" name="password" id="password" class="reg" value="" size="10" minlength="1" placeholder="Придумайте пароль.." required
                               title=""/>
                        <br/>
                        <label for="passwordRepeat">Пароль ещё раз</label>
                        <input type="text" name="passwordRepeat" id="passwordRepeat" class="reg" value="" size="10" minlength="1" placeholder="Повторите пароль.." required/>
                        <br/>
                        <%--<label for="score">Очки</label>--%>
                        <%--<input type="text" name="score" id="score" class="reg" value="" size="10" minlength="1" placeholder="" required/>--%>
                        <%--<br/>--%>
                        <%--<div class="passwordCheck">--%>
                        <%--<h3>Пароль должен как минимум:</h3>--%>
                        <%--<p id="letter" class="invalid">иметь один строчный символ</p>--%>
                        <%--<p id="capital" class="invalid">иметь один прописной символ</p>--%>
                        <%--<p id="number" class="invalid">иметь одну цифру</p>--%>
                        <%--<p id="length" class="invalid">состоять из 8 символов</p>--%>
                        <%--</div>--%>
                        <input type="submit"/>
                        <br/>
                        <span>${errorString}</span>
                        <script>
                            window.addEventListener('DOMContentLoaded', function() {
                                var form = document.querySelector('.form'),
                                    pas = form.querySelectorAll('#password, #passwordRepeat');

                                form.addEventListener('submit', function(e) {
                                    var err = !(pas[0].value && (pas[0].value ==  pas[1].value))
                                    pas[1].setAttribute("title", err ? 'err' : '');
                                    err && e.preventDefault();
                                }, false);
                                pas[1].addEventListener('input', function(e) {
                                    var err = !(pas[0].value ==  pas[1].value)
                                    pas[1].setAttribute("title", err ? 'err' : '');
                                }, false);
                            });
                        </script>

                    </form>
                </div>
            </div>
        </div>

        <jsp:include page="footer.jsp"></jsp:include>

    </div>
</body>
</html>