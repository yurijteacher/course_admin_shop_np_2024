<#import "templ/templ.ftl" as p>
<@p.pages>
    <h2> Cart </h2>

    <table class="table table-striped table-hover">
        <tbody>
        <tr>
            <th>id</th>
            <th>image</th>
            <th>name</th>
            <th>quantity</th>
            <th>price</th>
            <th>value</th>
            <th>update</th>
            <th>delete</th>
        </tr>
        </tbody>
        <tbody>
        <#if cart??>
            <#list cart as item>
                <#if item.product.name??>
                    <tr>
                        <form action="/updateItemInCart" method="post">
                            <input type="hidden" name="id" value="${item.product.id}">
                            <td>${item.product.id}</td>
                            <td><img src="${item.product.image}" alt="${item.product.name}" height="30px"></td>
                            <td>${item.product.name}</td>
                            <td><input type="number" value="${item.quantity}" name="quantity" min="0" step="1"></td>
                            <td>${item.product.price}</td>
                            <td>${item.product.price * item.quantity}</td>
                            <td>
                                <button type="submit" class="btn btn-success">Update</button>
                            </td>
                        </form>

                        <form action="/deleteItemFromCart" method="post">
                            <td>
                                <input type="hidden" name="id" value="${item.product.id}">
                                <button type="submit" class="btn btn-success">Delete</button>
                            </td>
                        </form>
                    </tr>
                </#if>
            </#list>
        </#if>
        </tbody>
    </table>

    <h5> total: [${total}] </h5>
    <h5> el: [${el}] </h5>


    <h5> Очистити кошик </h5>
    <form method="post" action="/deleteAllItem">
        <button class="btn btn-success" type="submit">Delete all</button>
    </form>

    <form method="get" action="/order">
        <button type="submit">Order</button>
    </form>


</@p.pages>