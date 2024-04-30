<#import "templ/templ.ftl" as p>
<@p.pages>

    <#import "templ/pager.ftl" as c>

    <h2> Products by Category </h2>


    <@c.pager url page/>

    <div class="row row-cols-2 row-cols-md-4 g-4">

        <#if page.content??>
            <#list page.content as product>
                <form action="/addToCart" method="post">
                <div class="col">
                    <div class="card">

                        <input type="hidden" name="id" value="${product.id}">
                        <img src="${product.image}" class="card-img-top" alt="${product.name}">
                        <div class="card-body text-center">
                            <h5 class="card-title">${product.name}</h5>
                            <p class="card-text"> ${product.description} </p>
                            <p> Price: ${product.price}</p>
                            <p> <input type="number" name="quantity" min="0" step="1" value="1"></p>
                            <p> ${product.categorie.name} </p>
                        </div>
                        <button type="submit">AddToCard</button>

                    </div>
                </div>
                </form>
            </#list>
        </#if>
    </div>

    <div class="pt-2">
<#--    <@c.pager url page/>-->
    </div>

</@p.pages>