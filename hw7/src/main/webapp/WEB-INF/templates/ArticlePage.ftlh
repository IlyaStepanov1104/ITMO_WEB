<#import "commons.ftlh" as c>

<@c.page>
    <div class="article">
        <div class="body">
            <form method="post" action="">
                <input type="hidden" name="action" value="makeArticle"/>
                <div class="field">
                    <div class="name">
                        <label for="article">Article</label>
                    </div>
                    <div class="title">
                        <input id="title" name="title"/>
                    </div>
                    <div class="text">
                        <textarea id="text" name="text" rows="5" cols="30"></textarea>
                    </div>
                </div>
                <div class="error"></div>
                <div class="button-field">
                    <input type="submit" value="Send">
                </div>
            </form>
        </div>
    </div>
        <script>
            $(function () {
                $(".article").submit(function () {
                    const title = $(this).find("input[name='title']").val();
                    const text = $(this).find("textarea[name='text']").val();
                    const $error = $(this).find(".error");
                    makerequest({action: "makeArticle", title: title, text:text}, $error);
                    return false;
                });
            })
        </script>
</@c.page>