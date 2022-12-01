<#-- @ftlvariable name="curUser" type="ru.itmo.wp.domain.User" -->

<#import "commons.ftlh" as c>

<@c.page>
    <#if curUser??>
        <div class="user-box">
            <div class="user-info">
                <span class="user-name"><a href="/user/${curUser.id}">${curUser.login}</a></span>
                <ul>
                    <li>id: ${curUser.id}</li>
                    <li>login: ${curUser.login}</li>
                    <li>creation time: ${curUser.creationTime}</li>
                </ul>
            </div>
        </div>
    <#else>
        No such user
    </#if>
</@c.page>