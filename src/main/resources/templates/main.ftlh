<#import "layout.ftlh" as main>
<@main.layout>

    <h2 class="mb-4">Главная страница</h2>

<#-- Если пользователь соискатель, показываем вакансии -->
    <#if user?? && user.account_type == "applicant">
        <ul class="pagination">
            <li class="page-item"><a class="page-link" href="/vacancy?page=0&size=3">Previous</a></li>
            <li class="page-item"><a class="page-link" href="/vacancy?page=1&size=3">1</a></li>
            <li class="page-item"><a class="page-link" href="/vacancy?page=2&size=3">2</a></li>
            <li class="page-item"><a class="page-link" href="/vacancy?page=3&size=3">3</a></li>
            <li class="page-item"><a class="page-link" href="/vacancy?page=4&size=3">4</a></li>
            <li class="page-item"><a class="page-link" href="/vacancy?page=5&size=3">Next</a></li>
        </ul>

        <div class="row">
            <#list vacancylist as vacancy>
                <div class="col-md-4 mb-3">
                    <div class="card p-3">
                        <h5>${vacancy.name}</h5>
                        <p>${vacancy.description}</p>
                        <a href="/vacancies/${vacancy.id}" class="btn btn-primary">Подробнее</a>
                    </div>
                </div>
            </#list>
        </div>
    </#if>

<#-- Если работодатель, показываем резюме -->
    <#if user?? && user.account_type == "employer">
        <ul class="pagination">
            <li class="page-item"><a class="page-link" href="/resume?page=0&size=3">Previous</a></li>
            <li class="page-item"><a class="page-link" href="/resume?page=1&size=3">1</a></li>
            <li class="page-item"><a class="page-link" href="/resume?page=2&size=3">2</a></li>
            <li class="page-item"><a class="page-link" href="/resume?page=3&size=3">3</a></li>
            <li class="page-item"><a class="page-link" href="/resume?page=4&size=3">4</a></li>
            <li class="page-item"><a class="page-link" href="/resume?page=5&size=3">Next</a></li>
        </ul>

        <div class="row">
            <#list resumelist as resume>
                <div class="col-md-4 mb-3">
                    <div class="card p-3">
                        <h5>${resume.name}</h5>
                        <p>${resume.salary}</p>
                        <a href="/resumes/${resume.id}" class="btn btn-primary">Подробнее</a>
                    </div>
                </div>
            </#list>
        </div>
    </#if>

</@main.layout>
