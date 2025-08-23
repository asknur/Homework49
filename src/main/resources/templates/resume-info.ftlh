<#import "layout.ftlh" as main>
<@main.layout>
    <div class="container mt-4">
        <div class="card shadow-lg p-4">
            <h2 class="mb-3">${resume.name}</h2>
            <p>
                <strong>Категория:</strong> ${resume.name} <br>
                <strong>Зарплата:</strong> $${resume.salary?string["#,##0.00"]} <br>
                <strong>Статус:</strong>
                <#if resume._active>
                    <span class="badge bg-success">Активная</span>
                <#else>
                    <span class="badge bg-secondary">Неактивная</span>
                </#if>
                <br>
            </p>
            <hr>
            <a href="/resume" class="btn btn-outline-primary">Назад к списку вакансий</a>
        </div>
    </div>
</@main.layout>
