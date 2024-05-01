<#import "admin_parts_templ/templ_admin.ftl" as p>
<@p.pages>

    <h2> Зміна логіна і пароля </h2>

    <table>
        <thead>
        <tr>
            <th>id</th>
            <th>Username</th>
            <th>Password</th>
            <th>Poles</th>
            <th>Update</th>
        </tr>
        </thead>
        <tbody>
        <#if users??>
            <#list users as user>
                <tr>

                   <form action="/updateUsers" method="post">
                    <input type="hidden" id="id" name="id" value="${user.id}">

                    <td>${user.id}</td>
                    <td><input type="text" id="username" name="username" value="${user.username}"></td>
                    <td><input type="text" id="password" name="password" placeholder="Введіть новий пароль"></td>

                    <td>
                        <#if user.rolesset??>
                            <#list user.rolesset as role>
                                ${role.name};
                            </#list>
                        </#if>
                    </td>
                    <td>

                       <input type="submit" value="update">
                    </td>
                   </form>
                </tr>
            </#list>
        </#if>

        </tbody>


    </table>



</@p.pages>