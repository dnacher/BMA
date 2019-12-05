<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Attendance Status</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <style type="text/css">
        <#include "css/style.css">
    </style>
    <#import "macros/utils.ftl" as u>
</head>
<body style="margin: 0; padding: 0;">
    <table align="center" border="0" cellpadding="0" cellspacing="0" width="600" style="border-collapse: collapse;">
        <tr>
            <@u.header/>
        </tr>
        <tr>
            <#-- downEmail -->
            <#if emailObject.downEmail?size gt 0>
                <p>People who are not attending</p>
                <table border="2" cellpadding="0" cellspacing="0" width="600" style="border-collapse: collapse;">
                    <@u.tableHeader/>
                    <#list emailObject.downEmail as downEmailItem>
                        <tr>
                            <td>${downEmailItem.fullName}</td>
                            <@u.attendanceListCreator downEmailItem.attendance/>
                        </tr>
                    </#list>
                </table><br>
            </#if>
            <#-- upEmail -->
            <#if emailObject.upEmail?size gt 0>
                <p>People who start attending again</p>
                <table border="2" cellpadding="0" cellspacing="0" width="600" style="border-collapse: collapse;">
                    <@u.tableHeader/>
                    <#list emailObject.upEmail as upEmailItem>
                        <tr>
                            <td>${upEmailItem.fullName}</td>
                            <@u.attendanceListCreator upEmailItem.attendance/>
                        </tr>
                    </#list>
                </table><br>
            </#if>
            <#-- z -->
            <#if emailObject.z?size gt 0>
                <p>People who are inconstant in their attendance</p>
                <table border="2" cellpadding="0" cellspacing="0" width="600" style="border-collapse: collapse;">
                    <@u.tableHeader/>
                    <#list emailObject.z as zItem>
                        <tr>
                            <td>${zItem.fullName}</td>
                            <@u.attendanceListCreator zItem.attendance/>
                        </tr>
                    </#list>
                </table><br>
            </#if>
            <#-- lastReminder -->
            <#if emailObject.lastReminder?size gt 0>
                <p>Last reminder, these members are not attending for 3 Sundays now</p>
                <table border="2" cellpadding="0" cellspacing="0" width="600" style="border-collapse: collapse;">
                    <@u.tableHeader/>
                    <#list emailObject.lastReminder as lastReminderItem>
                        <tr>
                            <td>${lastReminderItem.fullName}</td>
                            <@u.attendanceListCreator lastReminderItem.attendance/>
                        </tr>
                    </#list>
                </table><br>
            </#if>
        </tr>
        <tr>
            <td class="footerMail">
                <div class="iconResources">Icons made by
                    <a style="color: white" href="https://www.flaticon.com/authors/roundicons" title="Roundicons">Roundicons</a>
                    from
                    <a style="color: white" href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a>
                </div>
            </td>
        </tr>
    </table>

</body>
</html>