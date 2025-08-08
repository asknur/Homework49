<#import "layout.ftlh" as main>
<@main.layout>
    <h2 class="mb-4">Редактирование резюме</h2>
    <#list resumes as resume>
    <form method="post" action="/resumes/edit/${resume.id}">
        <div class="mb-3">
            <label for="title" class="form-label">Название</label>
            <input type="text" id="title" name="title" class="form-control" value="${resume.name!}">
        </div>
        <div class="mb-3">
            <label for="description" class="form-label">Описание</label>
            <textarea id="description" name="description" class="form-control">${resume.salary!}</textarea>
        </div>
    </#list>
        <button type="submit" class="btn btn-success">Сохранить</button>
    </form>
</@main.layout>