<#macro attendanceListCreator attendance>
    <#list 0..<attendance?length as i>
        <#assign c = attendance[i]>
        <#if c = '1'>
            <td>1
<#--                <img class="attendance-icon" src="cid:checked" alt="checked"/>-->
            </td>
        <#elseif c = '0'>
            <td>0
<#--                <img src="cid:cancel" alt="cancel"/>-->
            </td>
        <#else>
            <td>X
<#--                <img class="attendance-icon" src="cid:loading" alt="loading"/>-->
            </td>
        </#if>
    </#list>
</#macro>

<#macro tableHeader>
    <tr>
        <th>Fullname</th>
        <th>Attendance</th>
        <th>Attendance</th>
        <th>Attendance</th>
        <th>Attendance</th>
    </tr>
</#macro>

<#macro header>
    <td class="headerMail">
        1
    </td>
</#macro>