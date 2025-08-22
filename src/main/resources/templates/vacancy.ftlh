<#import "layout.ftlh" as main>
<@main.layout>
    <select class="form-select mb-3" aria-label="Default select example" onchange="window.location=this.value">
        <option selected>Сортировка</option>
        <option value="/vacancy/sorted?sort=name">Сортировка по имени</option>
        <option value="/vacancy/sorted?sort=createdDate">Сортировка по дате публикации</option>
        <option value="/vacancy/sorted?sort=respondedCount">Сортировка по количеству откликов</option>
    </select>

    <ul class="pagination">
        <li class="page-item"><a class="page-link" href="/vacancy/sorted?page=0&size=3">Previous</a></li>
        <li class="page-item"><a class="page-link" href="/vacancy/sorted?page=1&size=3">1</a></li>
        <li class="page-item"><a class="page-link" href="/vacancy/sorted?page=2&size=3">2</a></li>
        <li class="page-item"><a class="page-link" href="/vacancy/sorted?page=3&size=3">3</a></li>
        <li class="page-item"><a class="page-link" href="/vacancy/sorted?page=4&size=3">4</a></li>
        <li class="page-item"><a class="page-link" href="/vacancy/sorted?page=5&size=3">Next</a></li>
    </ul>

    <h2 class="mb-4">Вакансии</h2>
    <div class="row">
        <#list vacancies as vacancy>
            <div class="col-md-4 mb-3">
                <div class="card p-3">
                    <h5>${vacancy.name}</h5>
                    <p>${vacancy.description}</p>
                    <p>
                        Зарплата: $${vacancy.salary?string["#,##0.00"]} <br>
                        Статус:
                        <#if vacancy.active?? && vacancy.active>
                            <span class="badge bg-success">Активная</span>
                        <#else>
                            <span class="badge bg-secondary">Неактивная</span>
                        </#if> <br>
                        Дата публикации: ${vacancy.createdDate} <br>
                    </p>
                    <a href="/vacancy/${vacancy.id}" class="btn btn-primary">Подробнее</a>
                </div>
            </div>
        </#list>
    </div>
</@main.layout>
