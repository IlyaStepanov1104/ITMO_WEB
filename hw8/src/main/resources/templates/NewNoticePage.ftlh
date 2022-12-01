<#import "commons.ftlh" as c>

<@c.page>
    <#if user??>
        <div class="notice form-box" style="float: left; width:70%">
            <div class="header">Notice</div>
            <div class="body">
                <form method="post" action="" class="form-notice">
                    <div style="text-align: center;"><textarea name="content" rows="10" style="width: 95%">${noticeForm.content!}</textarea></div>
                    <@c.error "noticeForm.content"/>
                    <div class="button-field" style="margin: 10px auto;">
                            <div style="text-align: center;"><input type="submit" value="Add"></div>
                        </div>
                </form>
            </div>
        </div>
    </#if>
</@c.page>
