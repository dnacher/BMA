<#macro attendanceListCreator attendance>
    <#list 0..<attendance?length as i>
        <#assign c = attendance[i]>
        <#if c = '1'>
            <td class="table-cell">
                <img class="attendance-icon" src="cid:checked" alt="checked"/>
            </td>
        <#elseif c = '0'>
            <td class="table-cell">
                <img class="attendance-icon" src="cid:cancel" alt="cancel"/>
            </td>
        <#else>
            <td class="table-cell">
                <img class="attendance-icon" src="cid:loading" alt="loading"/>
            </td>
        </#if>
    </#list>
</#macro>

<#macro tableHeader>
    <tr class="header-color">
        <th class="fullname">Fullname</th>
        <th class="header">Airport</th>
        <th class="header">Airport</th>
        <th class="header">Airport</th>
        <th class="header">Airport</th>
    </tr>
</#macro>

<#macro header>
    <td class="headerMail">
    </td>
</#macro>