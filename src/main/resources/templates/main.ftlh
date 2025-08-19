<#import "layout.ftlh" as main>
<@main.layout>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item"><a class="page-link" href="#">Previous</a></li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item"><a class="page-link" href="#">Next</a></li>
        </ul>
    </nav>
    <h2 class="mb-4">Главная страница</h2>
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
</@main.layout>