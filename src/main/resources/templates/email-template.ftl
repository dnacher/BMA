<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Sending Email with Freemarker HTML Template Example</title>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
    <link href='css/style.css' rel='stylesheet' type='text/css'>

    <!-- use the font -->
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            font-size: 48px;
        }
    </style>
</head>
<body style="margin: 0; padding: 0;">

    <table align="center" border="0" cellpadding="0" cellspacing="0" width="600" style="border-collapse: collapse;">
        <tr>
            <td align="center" bgcolor="#1192ab" style="padding: 40px 0 30px 0;">
<#--                <img src="cid:logo.png" alt="http://memorynotfound.com" style="display: block;" />-->
            </td>
        </tr>
        <tr>
            <#-- downEmail -->
            <#if emailObject.downEmail?size gt 0>
                <p>People who are not attending</p>
                <table align="center" border="0" cellpadding="0" cellspacing="0" width="600" style="border-collapse: collapse;">
                    <tr class="th">
                        <th>Fullname</th>
                        <th>Attendance</th>
                    </tr>
                    <#list emailObject.downEmail as downEmailItem>
                        <tr>
                            <td>${downEmailItem.fullName}</td>
                            <td>${downEmailItem.attendance}</td>
                        </tr>
                    </#list>
                </table><br>
            </#if>

            <#-- upEmail -->
            <#if emailObject.upEmail?size gt 0>
                <p>People who start attending again</p>
                <table align="center" border="0" cellpadding="0" cellspacing="0" width="600" style="border-collapse: collapse;">
                    <tr class="th">
                        <th>Fullname</th>
                        <th>Attendance</th>
                    </tr>
                    <#list emailObject.upEmail as upEmailItem>
                        <tr>
                            <td>${upEmailItem.fullName}</td>
                            <td>${upEmailItem.attendance}</td>
                        </tr>
                    </#list>
                </table><br>
            </#if>

            <#-- z -->
            <#if emailObject.z?size gt 0>
                <p>People who are persisten in their attendance</p>
                <table align="center" border="0" cellpadding="0" cellspacing="0" width="600" style="border-collapse: collapse;">
                    <tr class="th">
                        <th>Fullname</th>
                        <th>Attendance</th>
                    </tr>
                    <#list emailObject.z as zItem>
                        <tr>
                            <td>${zItem.fullName}</td>
                            <td>${zItem.attendance}</td>
                        </tr>
                    </#list>
                </table><br>
            </#if>

            <#-- lastReminder -->
            <#if emailObject.lastReminder?size gt 0>
                <p>Last reminder, these members are not attending for 3 Sundays now</p>
                <table align="center" border="0" cellpadding="0" cellspacing="0" width="600" style="border-collapse: collapse;">
                    <tr class="th">
                        <th>Fullname</th>
                        <th>Attendance</th>
                    </tr>
                    <#list emailObject.lastReminder as lastReminderItem>
                        <tr>
                            <td>${lastReminderItem.fullName}</td>
                            <td>${lastReminderItem.attendance}</td>
                        </tr>
                    </#list>
                </table><br>
            </#if>
        </tr>
        <tr>
            <td bgcolor="#006180" style="padding: 30px 30px 30px 30px;">
                <p >${signature}</p>
                <p>${location}</p>
            </td>
        </tr>
    </table>

</body>
</html>