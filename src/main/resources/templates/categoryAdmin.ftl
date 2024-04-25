<#import "managet_parts_templ/templ_manager.ftl" as p>
<@p.pages>

    <h2>Сторінка адміністрування категорій</h2>

    <hr>
    <h4>Форма для додавання нових категорій</h4>

    <form action="/saveNewCategory" method="post">

        <label for="name">Name</label><br>
        <input type="text" name="name" placeholder="name" id="name"><br>
        <#--        <br>-->
        <label for="description">Description</label><br>
        <input type="text" name="description" placeholder="description" id="description"><br>
        <#--        <br>-->
        <label for="image">Image</label><br>
        <input type="text" name="image" placeholder="image" id="image"><br>
        <br>

        <input type="submit" value="addNewCategory">

    </form>
    <hr>
    <br>
    <h4> Перегляд, оновлення та видалення категорій </h4>
    <table class="table table-striped">
        <thead>
        <tr>
            <td>id</td>
            <td>name</td>
            <td>descr</td>
            <td>image</td>
            <td>update</td>
            <td>delete</td>
        </tr>
        </thead>
        <tbody>
        <#list categories as category>
            <tr>

                <form action="/updateCategory" method="post">

                    <td>${category.id}</td>
                    <td><input type="text" name="name" value="${category.name}"></td>
                    <td><input type="text" name="description" value="${category.description}"></td>
                    <td><input type="text" name="image" value="${category.image}"></td>
                    <td>

                        <input type="hidden" name="id" value="${category.id}">
                        <input type="submit" value="update"></td>
                </form>

                <td>
                    <form action="/deleteCategory" method="post">
                        <input type="hidden" name="id" value="${category.id}">
                        <input type="submit" value="delete">
                    </form>
                </td>
            </tr>
        </#list>

        </tbody>
    </table>
    <hr>
    <br>
    <h4>Очистка всіх категорій</h4>
    <form method="post" action="deleteAllCategory">
        <button type="submit"> Delete All Category </button>
    </form>


</@p.pages>

