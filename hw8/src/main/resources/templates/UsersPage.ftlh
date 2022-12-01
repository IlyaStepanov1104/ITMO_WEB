<#-- @ftlvariable name="users" type="ru.itmo.wp.domain.User[]" -->
<#-- @ftlvariable name="user" type="ru.itmo.wp.domain.User" -->
<#import "commons.ftlh" as c>

<@c.page>
    <div class="users datatable">
        <div class="caption">User</div>
        <table>
            <thead>
            <tr>
                <th>Id</th>
                <th>Login</th>
                <th>Created</th>
                <#if user??>
                    <th>Disabled/Enable</th>
                </#if>
            </tr>
            </thead>
            <tbody>
            <#if users?size==0>
                <tr class="noData">
                    <td colspan="3">
                        No data
                    </td>
                </tr>
            <#else>
                <#list users as u>
                <tr>
                    <td class="id"><a href="/user/${u.id}">${u.id}</a></td>
                    <td class="login">${u.login}</td>
                    <td class="creationTime">${u.creationTime}</td>
                    <#if user??>
                        <td>
                            <form method="post" actions="/user/changeDisable" name="disableForm">
                                <input type="hidden" name="userD" value="${u.disabled?string}">
                                <input type="hidden" name="curId" value="${u.id}">
                                <#if u.disabled>
                                    <input type="hidden" id="disabled" name="disabled" value="false">
                                    <input type="submit" value="Enable">
                                <#else>
                                    <input type="hidden" id="disabled" name="disabled" value="true">
                                    <input type="submit" value="Disable">
                                </#if>
                            </form>
                        </td>
                    </#if>
                </tr>
                </#list>
            </#if>
            </tbody>
        </table>
    </div>
</@c.page>
