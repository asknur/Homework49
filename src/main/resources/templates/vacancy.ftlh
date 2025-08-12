<#import "layout.ftlh" as main>
<@main.layout>
    <h2 class="mb-4">Вакансии</h2>
    <div class="row">
        <#list vacancies as vacancy>
            <div class="col-md-4 mb-3">
                <div class="card p-3">
                    <h5>${vacancy.name}</h5>
                    <p>${vacancy.description}</p>
                    <a href="/vacancies/${vacancy.id}" class="btn btn-outline-primary btn-sm">Подробнее</a>
                </div>
            </div>
        </#list>
    </div>
</@main.layout>