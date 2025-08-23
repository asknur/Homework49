<#import "layout.ftlh" as main>
<@main.layout>

    <div class="container mt-4">

        <h2 class="text-center mb-4">Главная страница</h2>

        <#-- Если пользователь соискатель -->
        <#if user?? && user.account_type == "applicant">

            <h3 class="mb-4">Доступные вакансии</h3>

            <div class="row">
                <#list vacancylist as vacancy>
                    <div class="col-md-4 mb-4">
                        <div class="card h-100 shadow-sm">
                            <div class="card-body">
                                <h5 class="card-title">${vacancy.name}</h5>
                                <p class="card-text text-muted">${vacancy.description}</p>
                                <p class="mb-2">
                                    <#if vacancy.salary??>
                                        💰 Зарплата: <strong>$${vacancy.salary?string["#,##0.00"]}</strong><br>
                                    </#if>
                                    <#if vacancy.active??>
                                        📌 Статус:
                                        <#if vacancy.active>
                                            <span class="badge bg-success">Активная</span>
                                        <#else>
                                            <span class="badge bg-secondary">Неактивная</span>
                                        </#if><br>
                                    </#if>
                                    <#if vacancy.createdDate??>
                                        📅 Дата публикации:
                                        ${vacancy.createdDate}
                                    </#if>
                                </p>
                                <a href="vacancy/${vacancy.id}" class="btn btn-primary w-100">
                                    Подробнее
                                </a>
                            </div>
                        </div>
                    </div>
                </#list>
            </div>

            <div class="d-flex justify-content-center mt-4">
                <ul class="pagination">
                    <li class="page-item"><a class="page-link" href="/vacancy?page=0&size=3">Previous</a></li>
                    <li class="page-item"><a class="page-link" href="/vacancy?page=1&size=3">1</a></li>
                    <li class="page-item"><a class="page-link" href="/vacancy?page=2&size=3">2</a></li>
                    <li class="page-item"><a class="page-link" href="/vacancy?page=3&size=3">3</a></li>
                    <li class="page-item"><a class="page-link" href="/vacancy?page=4&size=3">4</a></li>
                    <li class="page-item"><a class="page-link" href="/vacancy?page=5&size=3">Next</a></li>
                </ul>
            </div>

        </#if>


        <#-- Если пользователь работодатель -->
        <#if user?? && user.account_type == "employer">

            <h3 class="mb-4">Доступные резюме</h3>

            <div class="row">
                <#list resumelist as resume>
                    <div class="col-md-4 mb-4">
                        <div class="card h-100 shadow-sm">
                            <div class="card-body">
                                <h5 class="card-title">${resume.name}</h5>
                                <p class="mb-2">
                                    💰 Зарплата: <strong>$${resume.salary?string["#,##0.00"]}</strong><br>
                                    📌 Статус:
                                    <#if resume.active?? && resume.active>
                                    <span class="badge bg-success">Активный</span>
                                <#else>
                                    <span class="badge bg-secondary">Неактивный</span>
                                    </#if><br>
                                    <#if resume.createdDate??>
                                        📅 Дата публикации: ${resume.createdDate}
                                    </#if>
                                </p>
                                <a href="resume/${resume.id}" class="btn btn-primary w-100">
                                    Подробнее
                                </a>
                            </div>
                        </div>
                    </div>
                </#list>
            </div>

            <div class="d-flex justify-content-center mt-4">
                <ul class="pagination">
                    <li class="page-item"><a class="page-link" href="/resume?page=0&size=3">Previous</a></li>
                    <li class="page-item"><a class="page-link" href="/resume?page=1&size=3">1</a></li>
                    <li class="page-item"><a class="page-link" href="/resume?page=2&size=3">2</a></li>
                    <li class="page-item"><a class="page-link" href="/resume?page=3&size=3">3</a></li>
                    <li class="page-item"><a class="page-link" href="/resume?page=4&size=3">4</a></li>
                    <li class="page-item"><a class="page-link" href="/resume?page=5&size=3">Next</a></li>
                </ul>
            </div>

        </#if>

    </div>
</@main.layout>
