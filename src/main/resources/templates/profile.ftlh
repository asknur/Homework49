<#import "layout.ftlh" as main>

<@main.layout>
    <div class="container mt-4">
        <#list users as user>
            <div class="card p-4 shadow-sm mb-4">
                <h3 class="text-center mb-4">
                    <#if user.account_type == 'applicant'>
                        Личный кабинет Соискателя
                    <#else>
                        Личный кабинет Работодателя
                    </#if>
                </h3>

                <div class="d-flex align-items-center justify-content-between mb-4 flex-wrap">

                    <div class="d-flex align-items-center mb-3">
                        <img src="${user.avatar! 'https://cdn-icons-png.flaticon.com/512/9203/9203764.png'}"
                             alt="photo" class="rounded-circle me-3" style="width: 80px; height: 80px;">
                        <div>
                            <h4>
                                <#if user.account_type == 'applicant'>
                                    ${user.name} ${user.surname!''}
                                <#else>
                                    ${user.name! 'Name'}
                                </#if>
                            </h4>
                            <#if user.account_type == 'applicant' && user.age??>
                                <p class="text-muted mb-0">Возраст: ${user.age}</p>
                            </#if>
                            <p class="text-muted mb-0">${user.email}</p>
                        </div>
                    </div>

                    <div class="d-flex gap-2 flex-wrap">
                        <a href="/profile/edit" class="btn btn-success">Редактировать</a>
                        <#if user.account_type == 'applicant'>
                            <a href="/resume/create" class="btn btn-danger">Создать резюме</a>
                            <a href="/responses" class="btn btn-outline-primary position-relative">
                                Отклики
                                <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                            </span>
                            </a>
                        <#else>
                            <a href="/vacancy/create" class="btn btn-danger">Создать вакансию</a>
                        </#if>
                    </div>
                </div>

                <div class="row g-3">
                    <#if user.account_type == 'applicant'>
                        <#list resumes as resume>
                            <div class="col-md-4">
                                <div class="card p-3 h-100">
                                    <h6>${resume.name}</h6>
                                    <p class="text-muted mb-2">Дата обновления: ${resume.createdDate}</p>
                                    <div class="d-flex gap-2">
                                        <a href="/resumes/update/${resume.id}" class="btn btn-outline-primary btn-sm">Обновить</a>
                                        <a href="/resumes/edit/${resume.id}" class="btn btn-outline-success btn-sm">Ред.</a>
                                    </div>
                                </div>
                            </div>
                        </#list>
                    <#else>

                        <#list vacancies as vacancy>
                            <div class="col-md-4">
                                <div class="card p-3 h-100">
                                    <h6>${vacancy.name}</h6>
                                    <p class="text-muted mb-2">Дата обновления: ${vacancy.updatedTime}</p>
                                    <div class="d-flex gap-2">
                                        <a href="/vacancies/update/${vacancy.id}" class="btn btn-outline-primary btn-sm">Обновить</a>
                                        <a href="/vacancies/edit/${vacancy.id}" class="btn btn-outline-success btn-sm">Ред.</a>
                                    </div>
                                </div>
                            </div>
                        </#list>
                    </#if>
                </div>
            </div>
        </#list>
    </div>
</@main.layout>
