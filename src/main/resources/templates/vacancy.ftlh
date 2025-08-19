<#import "layout.ftlh" as main>
<@main.layout>
    <select class="form-select" aria-label="Default select example" onchange="window.location=this.value">
        <option selected>Сортировка</option>
        <option value="/vacancies/sorted?sort=date">Сортировка по дате публикации</option>
        <option value="/vacancies/sorted?sort=responds">Сортировка по количествну откликов</option>
    </select>
    <ul class="pagination">
        <li class="page-item"><a class="page-link" href="vacancies/sorted?page=0&size=3&sort=createdAt,desc">Previous</a></li>
        <li class="page-item"><a class="page-link" href="vacancies/sorted?page=0&size=3&sort=createdAt,desc">1</a></li>
        <li class="page-item"><a class="page-link" href="#">2</a></li>
        <li class="page-item"><a class="page-link" href="#">3</a></li>
        <li class="page-item"><a class="page-link" href="#">Next</a></li>
    </ul>
    <h2 class="mb-4">Вакансии</h2>
    <div class="row">
        <#list vacancies as vacancy>
            <div class="col-md-4 mb-3">
                <div class="card p-3">
                    <h5>${vacancy.name}</h5>
                    <p>${vacancy.description}</p>
                    <a href="/vacancies/${vacancy.id}" class="btn btn-primary">Подробнее</a>
                </div>
            </div>
        </#list>
    </div>
</@main.layout>