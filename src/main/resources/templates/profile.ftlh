<#import "layout.ftlh" as main>
<@main.layout>


<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Личный кабинет</title>
    <link rel="stylesheet" href="../static/styles/profile.css">
</head>

<#if user??>
    <div class="profile-header">
        <#if user.photo??>
            <img src="${user.photo}" class="profile-photo" alt="Фото профиля">
        <#else>
            <img src="/default-avatar.jpg" class="profile-photo" alt="Фото профиля">
        </#if>

        <div>
            <h1>${user.name!''}</h1>
            <p>${user.email!''}</p>
            <p>${user.phone!''}</p>
            <button class="button" onclick="openEditModal()">Редактировать профиль</button>
        </div>
    </div>

    <h2>Мои резюме</h2>

    <#-- Проверяем и выводим список резюме -->
    <#if resumes?? && resumes?has_content>
        <#list resumes as resume>
            <div class="resume-card">
                <h3>${resume.name!''}</h3>
                <p>Обновлено: ${(resume.createdDate)}</p>
                <p>Статус: <#if resume.active>Опубликовано<#else>Не опубликовано</#if></p>

                <button class="button">Редактировать</button>
                <button class="button">Обновить</button>
                <#if resume.active>
                    <button class="button">Снять с публикации</button>
                <#else>
                    <button class="button">Опубликовать</button>
                </#if>
            </div>
        </#list>
    <#else>
        <p>У вас пока нет резюме</p>
    </#if>

    <button class="button" style="background-color: #2196F3;">+ Создать новое резюме</button>
<#else>
    <p>Пользователь не найден</p>
</#if>

<script>
    function openEditModal() {
        alert("Здесь будет форма редактирования профиля");
    }
</script>
</@main.layout>