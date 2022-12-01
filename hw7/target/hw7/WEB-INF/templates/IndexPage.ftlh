<#import "commons.ftlh" as c>

<@c.page>
    <main>
        <article>
            <template>
                <div class="title"></div>
                <div class="inf"></div>
                <div class="text" style="white-space: pre-wrap"></div>
                <ul class="attachment">
                    <li>Announcement of <a href="#">Codeforces Round #510 (Div. 1)</a></li>
                    <li>Announcement of <a href="#">Codeforces Round #510 (Div. 2)</a></li>
                </ul>
                <div class="footer">
                    <div class="left">
                        <img src="img/voteup.png" title="Vote Up" alt="Vote Up"/>
                        <span class="positive-score">+173</span>
                        <img src="img/votedown.png" title="Vote Down" alt="Vote Down"/>
                    </div>
                    <div class="right">
                        <img src="img/date_16x16.png" title="Publish Time" alt="Publish Time"/>
                        2 days ago
                        <img src="img/comments_16x16.png" title="Comments" alt="Comments"/>
                        <a href="#">68</a>
                    </div>
                </div>
            </template>
        </article>
    </main>
    <script>
        makerequest({action: "findAll"}, null, function (response) {
            response["articles"].forEach(function (article) {
                const $tr = $($("template").prop("content")).clone();
                $tr.find(".title").text(article["title"]);
                $tr.find(".inf").text("By " + article["userLogin"] + " " + article["creationTime"]);
                $tr.find(".text").text(article["text"]);
                // $tr.find("tr").attr("data-userId", user["id"]);
                $("article").append($tr);
            })
        })
    </script>
</@c.page>
