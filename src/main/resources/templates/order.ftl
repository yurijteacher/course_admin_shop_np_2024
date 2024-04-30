<#import "templ/templ.ftl" as p>
<@p.pages>

    <h1> Order </h1>

    <h2> Інформація про користувача</h2>
    <table class="table">

        <thead>
        <tr>
            <th>Ім'я</th>
            <th>Прізвище</th>
            <th>Телефон</th>
            <th>Email</th>
        </tr>
        </thead>
        <tbody>
        <#if client??>
            <#if client.firstName??>
                <tr>
                    <td>${client.firstName}</td>
                    <td>${client.lastName}</td>
                    <td>${client.phone}</td>
                    <td>${client.email}</td>
                </tr>
            </#if>
        </#if>
        </tbody>
    </table>


    <h2> Інформація про замовлення </h2>

    <table class="table">

        <thead>
        <tr>
            <th>image</th>
            <th>name</th>
            <th>quantity</th>
            <th>price</th>
            <th>value</th>
        </tr>
        </thead>
        <tbody>


        <#if cart??>
            <#list cart as item>
                <#if item.product.name??>
                    <tr>
                        <td><img src="${item.product.image}" alt="${item.product.name}" height="30px"></td>
                        <td>${item.product.name}</td>
                        <td>${item.quantity}</td>
                        <td>${item.product.price}</td>
                        <td>${item.product.price * item.quantity}</td>
                    </tr>
                </#if>
            </#list>
        </#if>
        </tbody>
    </table>

    <p> Варість замовлення : ${total} </p>
    <p> Кількість асотиментних позицій у замовленні: ${el}</p>


    <form action="/buy" method="post">
    <h2> Вибір способу оплати </h2>
    <select name="payment">
        <option value="1">Готівка</option>
        <option value="2">Банківська карта</option>
    </select>

    <h2> Вибір способу доставки </h2>
    <select name="delivery">
        <option value="1">Самовивіз</option>
        <option value="2">Нова пошта</option>
        <option value="3">Укрпошта</option>
    </select>

    <button type="submit">Підтведити замовлення</button>
    </form>



</@p.pages>