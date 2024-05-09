<#import "managet_parts_templ/templ_manager.ftl" as p>
<@p.pages>

    <h2>Сторінка адміністрування продукції</h2>


    <form action="/upload" method="post" enctype="multipart/form-data">
        <input type="file" name="fileToUpload" id="fileToUpload">
        <br><br>
        <input type="submit" value="Завантажити файл" name="submit">
    </form>

    <hr>
    <h4>Форма для додавання нової продукції</h4>

    <form action="/saveNewProduct" method="post">

        <label for="name">Name</label><br>
        <input type="text" id="name" name="name" placeholder="name"><br>

        <label for="description">description</label><br>
        <input type="text" id="description" name="description" placeholder="description"><br>

        <label for="price">price</label><br>
        <input type="number" id="price" name="price" placeholder="price"><br>

        <label for="link">link</label><br>
        <input type="text" id="link" name="link" placeholder="link"><br>

        <select name="category">
            <#list categories as category>
                <option value="${category.id}">${category.name}</option>
            </#list>
        </select>


        <input type="submit" value="addNewProduct">

    </form>
    <hr>
    <br>
    <h2>Перегляд, оновлення та видалення даних</h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <td>id</td>
            <td>name</td>
            <td>descr</td>
            <td>image</td>
            <td>price</td>
            <td>category</td>
            <td>update</td>
            <td>delete</td>
        </tr>


        </thead>
        <tbody>
        <#list products as product>
            <form action="/updateProduct" method="post">
                <tr>
                    <td>${product.id}</td>
                    <input type="hidden" name="id" value="${product.id}">
                    <td><input type="text" name="name" value="${product.name}"></td>
                    <td><input type="text" name="description" value="${product.description}"></td>
                    <td><input type="text" name="image" value="${product.image}"></td>
                    <td><input type="number" name="price" value="${product.price?c}"></td>
                    <td>


                        <select name="category">
                            <#if categories??>
                                <#list categories as c>
                                    <#if product.categorie.id==c.id>
                                        <option value="${c.id}" selected>${c.name}</option>
                                    <#else>
                                        <option value="${c.id}">${c.name}</option>
                                    </#if>
                                </#list>
                            </#if>
                        </select>

                        <#--                <input type="text" name="category" value="${product.categorie.name}">-->


                    </td>
                    <td><input type="submit" value="update"></td>
            </form>
            <td>

                <form method="post" action="/deleteProduct">
                    <input type="hidden" name="id" value="${product.id}">
                    <input type="submit" value="delete">
                </form>

            </td>
            </tr>
        </#list>


        </tbody>

    </table>

</@p.pages>
