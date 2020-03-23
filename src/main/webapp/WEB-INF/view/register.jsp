<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <c:set var="title" value="Registration" scope="request"/>
    <jsp:include page="meta.jsp"></jsp:include>
    <body>
        <div class="wrapper">
            <jsp:include page="header.jsp"></jsp:include>

            <div class="content">
                <div class="register-img">
                    <div class="info">
                        <h4>Регистрация</h4>
                        <form class="form" action="${pageContext.request.contextPath}/register" method="post"
                              onsubmit="
                                var password = document.getElementById('password');
                                var rePassword = document.getElementById('passwordRepeat');
                                   if(password.value != rePassword.value) {
                                       password.value = '';
                                       rePassword.value = '';
                                       alert('Пароли не совпадают! Дай себе еще один шанс :)');
                                   }">
                            <div class="form-group">
                                <label for="firstName">Имя</label>
                                <input type="text" name="firstName" id="firstName" placeholder="Введите имя.." required
                                       onkeyup="
                                            var pattern=/['а-яА-ЯёЁa-zA-Z']/;
                                            if(!pattern.test(this.value)) {
                                                this.value=''
                                            }"
                                       title="Имя не должно содержать цифр и спецсимволов"
                                />
                            </div>

                            <div class="form-group">
                                <label for="lastName">Фамилия</label>
                                <input type="text" name="lastName" id="lastName" placeholder="Введите фамилию.." required
                                       onkeyup="
                                            var pattern=/['а-яА-ЯёЁa-zA-Z']/;
                                            if(!pattern.test(this.value)) {
                                                this.value=''
                                            }"
                                       title="Фамилия не должна содержать цифр и спецсимволов"
                                />
                            </div>

                            <div class="form-group">
                                <label for="login">Логин</label>
                                <input type="text" name="login" id="login" minlength="3" maxlength="15"  placeholder="Придумайте логин.." required
                                       title="Логин должен быть длиной от 3 до 15 символов"
                                />
                            </div>

                            <div class="form-group">
                                <label for="password">Пароль</label>
                                <input type="text" name="password" id="password" placeholder="Придумайте пароль.." required/>
                            </div>

                            <div class="form-group">
                                <label for="passwordRepeat">Пароль ещё раз</label>
                                <input type="text" name="passwordRepeat" id="passwordRepeat" placeholder="Повторите пароль.." required/>
                            </div>

                            <div class="register-submit">
                                <input type="submit" value="Зарегистрироваться"/>
                            </div>


                        </form>
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
                    </div>
                </div>
            </div>

            <jsp:include page="footer.jsp"></jsp:include>
        </div>
    </body>
</html>