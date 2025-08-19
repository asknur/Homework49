<#import "layout.ftlh" as main>
    <#macro resume>
<@main.layout>
    <h2 class="mb-4">Мои резюме</h2>
    <div class="row">
        <#list resumes as resume>
            <div class="col-md-4 mb-3">
                <div class="card p-3">
                    <h5>${resume.name}</h5>
                    <p>${resume.salary}</p>
                    <a href="/resumes/${resume.id}" class="btn btn-primary">Подробнее</a>
                </div>
            </div>
        </#list>
    </div>
    <>
</@main.layout>
</#macro>