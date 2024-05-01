<#import "admin_parts_templ/templ_admin.ftl" as p>
<@p.pages>

    <h2> Оновлення ролей користувачів </h2>

    <table>
        <thead>
        <tr>
            <th>id</th>
            <th>Username</th>
<#--            <th>Password</th>-->
            <th>Poles</th>
            <th>Select roles</th>
            <th>Update</th>
        </tr>
        </thead>
        <tbody>
        <#if users??>
            <#list users as user>
                <tr>
                    <form action="/updateRolesUsers" method="post">
                        <input type="hidden" id="id" name="id" value="${user.id}">

                        <td>${user.id}</td>
                        <td>${user.username}</td>
<#--                        <td>${user.password}</td>-->

                        <td>
                            <#if user.rolesset??>
                                <#list user.rolesset as role>
                                    ${role.name};
                                </#list>
                            </#if>
                        </td>
                        <td>
                            <select name="role">
                                <#if roles??>
                                <#list roles as r>
                                <option value="${r.id}">${r.name}</option>
                                </#list>
                                </#if>
                            </select>
                        </td>
                        <td>

                            <input type="submit" value="add">
                        </td>
                    </form>
                </tr>
            </#list>
        </#if>

        </tbody>


    </table>



</@p.pages>