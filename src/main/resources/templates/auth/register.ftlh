<#import "../layout.ftlh" as main>
<@main.layout>
        <h1 class="mt-4">Регистрация</h1>
        <form method="post" action="/register">
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" name="email" class="form-control" id="email" required>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Пароль</label>
                <input type="password" name="password" class="form-control" id="password" required>
            </div>
            <div class="mb-3">
                <label for="name" class="form-label">Имя</label>
                <input type="text" name="name" class="form-control" id="name" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Тип аккаунта</label><br>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="accountType" value="APPLICANT" id="applicant">
                    <label class="form-check-label" for="applicant">Соискатель</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="accountType" value="EMPLOYER" id="employer">
                    <label class="form-check-label" for="employer">Работодатель</label>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Зарегистрироваться</button>
        </form>
</@main.layout>