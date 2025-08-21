<#import "layout.ftlh" as main>

<@main.layout>
    <div class="container mt-4">
        <div class="card p-4 shadow rounded-4">

            <!-- Заголовок -->
            <h2 class="text-center mb-4 text-danger">
                <#if user.account_type == "APPLICANT">
                    Личный кабинет Соискателя
                <#else>
                    Личный кабинет Работодателя
                </#if>
            </h2>

            <!-- Информация о пользователе -->
            <div class="mb-4">
                <#if user.account_type == "APPLICANT">
                    <p><strong>Имя:</strong> ${user.name}</p>
                    <p><strong>Возраст:</strong> ${user.age!"—"}</p>
                <#else>
                    <p><strong>Компания:</strong> ${user.companyName!"—"}</p>
                </#if>
            </div>

            <!-- Основной контент -->
            <div>
                <#if user.account_type == "APPLICANT">
                    <h5>Резюме:</h5>
                    <#list resumes as resume>
                        <div class="border rounded p-2 mb-2">
                            <p>${resume.name}</p>
                            <p class="text-muted">Обновлено: ${resume.createdDate}</p>
                        </div>
                    </#list>
                <#else>
                    <h5>Созданные вакансии:</h5>
                    <#list vacancies as vacancy>
                        <div class="border rounded p-2 mb-2">
                            <p>${vacancy.name}</p>
                            <p class="text-muted">Обновлено: ${vacancy.createdDate}</p>
                        </div>
                    </#list>
                </#if>
            </div>
        </div>
    </div>
</@main.layout>
