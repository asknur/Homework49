<#import "layout.ftlh" as main>
<@main.layout>
    <div class="container mt-4">
        <div class="card shadow-lg p-4">
            <h2 class="mb-3">${vacancy.name}</h2>
            <p class="text-muted">${vacancy.description}</p>
            <p>
                <strong>Категория:</strong> ${vacancy.name} <br>
                <strong>Зарплата:</strong> $${vacancy.salary?string["#,##0.00"]} <br>
                <strong>Опыт:</strong> от ${vacancy.exp_from} до ${vacancy.exp_to} лет <br>
                <strong>Статус:</strong>
                <#if vacancy._active>
                    <span class="badge bg-success">Активная</span>
                <#else>
                    <span class="badge bg-secondary">Неактивная</span>
                </#if>
                <br>
                <strong>Дата публикации:</strong> ${vacancy.created_date} <br>
                <strong>Последнее обновление:</strong> ${vacancy.updated_time}
            </p>
            <hr>
            <a href="/vacancy" class="btn btn-outline-primary">Назад к списку вакансий</a>
        </div>
    </div>
</@main.layout>
