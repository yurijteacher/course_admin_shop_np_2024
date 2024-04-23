<#import "user_parts_templ/templ_user.ftl" as p>
<@p.pages>

    <h2> Auth </h2>

    <div class="row">

        <div class="col-3"></div>


        <div class="col-6">
            <form action="/login" method="post">

                <label for="username">Username</label>
                <input type="text" name="username" placeholder="user" id="username"><br>

                <label for="password">Password</label>
                <input type="text" name="password" placeholder="pass" id="password"><br>


                <input type="submit" value="add">

                <a href="/saveNewPasswordByUsernameAndEmail"> Відновлення паролю </a>

            </form>
        </div>

        <div class="col-3"></div>
    </div>

</@p.pages>