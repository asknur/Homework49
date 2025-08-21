<#import "spring.ftl" as spring>
<#macro layout>

    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Job Search</title>
        <link rel="stylesheet" href="/static/styles/style.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q"
                crossorigin="anonymous"></script>
    </head>

    <body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark shadow-sm">
        <div class="container-fluid">
            <a class="navbar-brand fw-bold" href="/">Jobs Search</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">

                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" href="/vacancy">Вакансии</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/resume">Резюме</a>
                    </li>
                </ul>

                <form class="d-flex me-3" action="/search" method="get">
                    <input class="form-control me-2" type="search" name="q" placeholder="Поиск вакансии..." aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Поиск</button>
                </form>

                <#assign known = SPRING_SECURITY_CONTEXT?? >
                <#if known>
                    <#assign user = SPRING_SECURITY_CONTEXT.authentication.principal
                    name = user.getUsername()
                    >
                    <#if user??>
                        <a href="/profile/${name}" class="text-light m-2 m-sm-0">
                            Hello, ${name}

                            <#list user.authorities as auth>
                                <span class="text-danger">${auth}</span>
                                <#if auth?has_next>
                                    /
                                </#if>
                            </#list>
                        </a>
                        <form action="/logout" method="post">
                            <button type="submit" class="btn btn-outline-info m-2"
                                    id="logout">
                                Выйти
                            </button>
                        </form>
                    </#if>
                <#else>
                    <a href="/auth/login" class="btn btn-outline-light me-2">Войти</a>
                    <a href="/auth/register" class="btn btn-primary">Зарегистрироваться</a>
                </#if>

            </div>
        </div>
    </nav>

    <div class="container py-4">
        <#nested spring>
    </div>

    </body>
    </html>

</#macro>
