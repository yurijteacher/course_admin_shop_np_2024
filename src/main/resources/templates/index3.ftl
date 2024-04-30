<#import "templ/templ.ftl" as p>
<@p.pages>

    <h2>${hello}</h2>

    <div class="row row-cols-2 row-cols-md-4 g-4">
        <div class="col">
            <div class="card">
                <img src="/static/images/user1.jpg" class="card-img-top" alt="user1">
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card">
                <img src="/static/images/user2.jpg" class="card-img-top" alt="user2">
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card">
                <img src="/static/images/user1.jpg" class="card-img-top" alt="user3">
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content.</p>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card">
                <img src="/static/images/user2.jpg" class="card-img-top" alt="user4">
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                </div>
            </div>
        </div>
    </div>


</@p.pages>