<#import "layout.ftlh" as main>
<@main.layout>
    <div class="container mt-4">
        <h2 class="mb-4">Личный кабинет</h2>
        <#list users as user>
        <div class="card p-4 shadow-sm">
            <div class="d-flex align-items-center mb-4">
                <img src="https://cdn-icons-png.flaticon.com/512/9203/9203764.png" alt="photo"
                     class="rounded-circle me-4"
                     style="width: 80px; height: 80px;">
                <div>
                    <h4>${user.name} ${user.surname!''}</h4>
                    <p class="text-muted mb-1">${user.email}</p>
                    <#if user.age??>
                        <p class="text-muted">Возраст: ${user.age}</p>
                    </#if>
                </div>
            </div>

            <div class="d-flex gap-2">
                <a href="/profile/edit" class="btn btn-primary">Редактировать профиль</a>
                <#if user.account_type == 'CANDIDATE'>
                    <a href="/resumes/create" class="btn btn-success">Создать резюме</a>
                </#if>
            </div>
        </div>
        </#list>
    </div>
</@main.layout>