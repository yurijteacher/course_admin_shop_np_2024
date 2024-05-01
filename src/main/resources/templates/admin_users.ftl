<#import "admin_parts_templ/templ_admin.ftl" as p>
<@p.pages>

    <h2> Адміністування користувачів </h2>


    <table>
        <thead>
        <tr>
            <th>id</th>
            <th>Username</th>
            <th>Password</th>
            <th>Poles</th>
        </tr>
        </thead>
        <tbody>
        <#if users??>
            <#list users as user>
                <tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                    <td><#if user.rolesset??>
                        <#list user.rolesset as role>
                            ${role.name};
                        </#list>

                    </#if></td>
                </tr>
            </#list>
        </#if>

        </tbody>


    </table>



</@p.pages>