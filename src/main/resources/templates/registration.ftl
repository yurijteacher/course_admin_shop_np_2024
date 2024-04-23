<#import "user_parts_templ/templ_user.ftl" as p>
<#import "/spring.ftl" as spring>
<@p.pages>

    <h2> Сторінка реєстрації </h2>

    <div class="row">

        <div class="col-3"></div>

        <div class="col-6">
    <form action="/registration" method="post">

        <@spring.bind "users"/>

        <label for="username">Username</label><br>
        <@spring.formInput "users.username" ' placeholder="username"'/><br>
        <@spring.showErrors "<br>"/><br>

        <label for="password">Password</label><br>
        <@spring.formInput "users.password" ' placeholder="password"'/><br>
        <@spring.showErrors "<br>"/><br>
        <br>

        <@spring.bind "clients"/>
        <label for="firstName">first name</label><br>
        <@spring.formInput "clients.firstName" ' placeholder="first name"'/><br>
        <@spring.showErrors "<br>"/>

        <label for="lastName">last name</label><br>
        <@spring.formInput "clients.lastName" ' placeholder="last name"'/><br>
        <@spring.showErrors "<br>"/>

        <label for="phone">phone</label><br>
        <@spring.formInput "clients.phone" ' placeholder="phone"'/><br>
        <@spring.showErrors "<br>"/>

        <label for="email">email</label><br>
        <@spring.formInput "clients.email" ' placeholder="email"'/><br>
        <@spring.showErrors "<br>"/>

        <label for="age">age</label><br>
        <@spring.formInput "clients.age"/><br>
        <@spring.showErrors "<br>"/>


        <input type="submit" value="addNewUser">

    </form>
        </div>

        <div class="col-3"></div>

    </div>


</@p.pages>