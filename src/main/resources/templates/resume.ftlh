<#import "layout.ftlh" as main>
<@main.layout>
    <select class="form-select mb-3" aria-label="Default select example" onchange="window.location=this.value">
        <option selected>Сортировка</option>
        <option value="/resume/sorted?sort=name">Сортировка по имени</option>
        <option value="/resume/sorted?sort=createdDate">Сортировка по дате публикации</option>
    </select>

    <ul class="pagination">
        <li class="page-item"><a class="page-link" href="/resume/sorted?page=0&size=3">Previous</a></li>
        <li class="page-item"><a class="page-link" href="/resume/sorted?page=1&size=3">1</a></li>
        <li class="page-item"><a class="page-link" href="/resume/sorted?page=2&size=3">2</a></li>
        <li class="page-item"><a class="page-link" href="/resume/sorted?page=3&size=3">3</a></li>
        <li class="page-item"><a class="page-link" href="/resume/sorted?page=4&size=3">4</a></li>
        <li class="page-item"><a class="page-link" href="/resume/sorted?page=5&size=3">Next</a></li>
    </ul>

    <h2 class="mb-4">Мои резюме</h2>
    <div class="row">
        <#list resumes as resume>
            <div class="col-md-4 mb-3">
                <div class="card p-3">
                    <h5>${resume.name}</h5>
                    <p>
                        Зарплата: $${resume.salary?string["#,##0.00"]} <br>
                        Статус:
                        <#if resume.active?? && resume.active>
                            <span class="badge bg-success">Активный</span>
                        <#else>
                            <span class="badge bg-secondary">Неактивный</span>
                        </#if> <br>
                        Дата публикации: ${resume.createdDate}
                    </p>
                    <a href="/resumes/${resume.id}" class="btn btn-primary">Подробнее</a>
                </div>
            </div>
        </#list>
    </div>
</@main.layout>
