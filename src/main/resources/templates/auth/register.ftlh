<#import "../layout.ftlh" as main>
<@main.layout>
    <div class="d-flex justify-content-center align-items-center" style="min-height: 100vh; background: #f9fafb;">
        <div class="card shadow-lg rounded-4 p-4" style="width: 450px; border: none;">
            <h2 class="text-center mb-4 fw-bold">Регистрация</h2>
            <form method="post" action="/auth/register" enctype="multipart/form-data">

                <div class="mb-3">
                    <label for="email" class="form-label">Email</label>
                    <div class="input-group">
                        <span class="input-group-text"><i class="bi bi-envelope-fill"></i></span>
                        <input type="email" name="email" class="form-control" id="email" placeholder="you@example.com" required>
                    </div>
                </div>

                <div class="mb-3">
                    <label for="phone" class="form-label">Телефон</label>
                    <div class="input-group">
                        <span class="input-group-text"><i class="bi bi-telephone-fill"></i></span>
                        <input type="text" name="phone" class="form-control" id="phone" placeholder="+996 700 123 456" required>
                    </div>
                </div>

                <div class="mb-3">
                    <label for="password" class="form-label">Пароль</label>
                    <div class="input-group">
                        <span class="input-group-text"><i class="bi bi-lock-fill"></i></span>
                        <input type="password" name="password" class="form-control" id="password" placeholder="Введите пароль" required>
                    </div>
                </div>

                <div class="mb-3">
                    <label for="name" class="form-label" id="nameLabel">Имя пользователя</label>
                    <div class="input-group">
                        <span class="input-group-text"><i class="bi bi-person-fill"></i></span>
                        <input type="text" name="name" class="form-control" id="name" placeholder="Введите имя" required>
                    </div>
                </div>

                <div class="mb-3">
                    <label for="photo" class="form-label">Фото профиля (необязательно)</label>
                    <input type="file" class="form-control" id="photo" name="photo" accept="image/*">
                    <div class="form-text">Если фото не загружено, установится изображение по умолчанию.</div>
                </div>

                <div class="mb-3 text-center">
                    <label class="form-label d-block mb-2">Тип аккаунта</label>
                    <div class="btn-group" role="group" aria-label="Выбор роли">
                        <input type="radio" class="btn-check" name="accountType" id="applicant" value="APPLICANT" checked>
                        <label class="btn btn-outline-primary" for="applicant"><i class="bi bi-person-badge-fill"></i> Соискатель</label>

                        <input type="radio" class="btn-check" name="accountType" id="employer" value="EMPLOYER">
                        <label class="btn btn-outline-success" for="employer"><i class="bi bi-building"></i> Компания</label>
                    </div>
                </div>

                <!-- Кнопка -->
                <div class="d-grid mt-4">
                    <button type="submit" class="btn btn-primary btn-lg rounded-3">
                        <i class="bi bi-check-circle-fill"></i> Зарегистрироваться
                    </button>
                </div>
            </form>
        </div>
    </div>
</@main.layout>
