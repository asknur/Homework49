<#import "../layout.ftlh" as main>
<@main.layout>
    <div class="d-flex justify-content-center align-items-center" style="min-height: 100vh; background: #f9fafb;">
        <div class="card shadow-lg rounded-4 p-4" style="max-width: 450px; width: 100%; border: none;">
            <div class="card-body py-5 px-md-4">
                <h2 class="fw-bold mb-4 text-center">Вход в аккаунт</h2>
                <p class="text-muted text-center mb-4">Введите данные, чтобы продолжить</p>

                <form id="login-form" action="/login" method="post">
                    <!-- Email input -->
                    <div class="form-outline mb-4">
                        <label class="form-label fw-semibold" for="email">Email</label>
                        <input type="email" id="email" name="username" class="form-control form-control-lg"
                               placeholder="Введите email" required/>
                    </div>

                    <!-- Password input -->
                    <div class="form-outline mb-3">
                        <label class="form-label fw-semibold" for="password">Пароль</label>
                        <input type="password" id="password" name="password" class="form-control form-control-lg"
                               placeholder="Введите пароль" required/>
                    </div>

                    <!-- Доп. опции -->
                    <div class="d-flex justify-content-between align-items-center mb-4">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" id="rememberMe"/>
                            <label class="form-check-label" for="rememberMe">Запомнить меня</label>
                        </div>
                        <a href="/forgot-password" class="small text-decoration-none">Забыли пароль?</a>
                    </div>

                    <!-- Submit button -->
                    <button type="submit"
                            class="btn btn-primary btn-lg w-100 rounded-3 shadow-sm">
                        Войти
                    </button>

                    <!-- Divider -->
                    <div class="text-center mt-4 mb-3">
                        <span class="text-muted">или</span>
                    </div>

                    <!-- Register button -->
                    <a href="/register" class="btn btn-outline-secondary btn-lg w-100 rounded-3">
                        Создать аккаунт
                    </a>
                </form>
            </div>
        </div>
    </div>
</@main.layout>
