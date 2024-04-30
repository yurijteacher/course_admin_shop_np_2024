<#import "templ/templ.ftl" as p>
<@p.pages>

    <#import "templ/pager.ftl" as c>




    <h2>Category</h2>

    <@c.pager url page/>

    <div class="row row-cols-2 row-cols-md-4 g-4">

        <#if page.content??>
            <#list page.content as category>
                <div class="col">

                    <div class="card">
                        <a href="/category/${category.id}">
                            <img src="${category.image}" class="card-img-top" alt="${category.name}">
                        </a>
                        <div class="card-body">
                            <h5 class="card-title">${category.name}</h5>
                            <p class="card-text"> ${category.description} </p>
                        </div>
                    </div>
                </div>
            </#list>
        </#if>
    </div>

    <div class="pt-3">
<#--    <@c.pager url page/>-->
    </div>

</@p.pages>