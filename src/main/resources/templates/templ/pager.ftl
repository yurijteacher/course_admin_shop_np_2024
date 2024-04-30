<#macro pager url page>


    <nav aria-label="...">
        <ul class="pagination">
            <li class="page-item">
                <a class="page-link" tabindex="-1" href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>

            <#list 1..page.getTotalPages() as p>
                <#if (p-1) == page.getNumber()>
                    <li class="page-item active" aria-current="page">
                        <a class="page-link" href="#" tabindex="-1"> ${p} </a>
                    </li>
                <#else>
                    <li class="page-item">
                        <a class="page-link" tabindex="-1" href="${url}?page=${p-1}"> ${p}
                        </a>
                    </li>
                </#if>
            </#list>

        </ul>
    </nav>


</#macro>