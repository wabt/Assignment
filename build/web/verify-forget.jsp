<%-- 
    Document   : verify-forget
    Created on : Mar 5, 2024, 2:02:20 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Fruitables - Vegetable Website Template</title>
        <link href="css/verify.css" rel="stylesheet">
    </head>
    <body>


        <!--        <div class='content-area'>
                    <p>
                        I see this type of input from time to time. You can see it in the wild at palces like <a href="https://disneyplus.com/begin">disneyplus.com/begin</a>. The weird part about it is that you can backspace between the fields, and copy and paste a long code into it. Not sure if there is a better way to do this style of input. If you know a way please leave a comment :)
                    </p>
                    <p>Try copying/pasting this: <code>123456</code></p>
        
                </div>-->
        <!--onsubmit="onSubmit(event)"-->
        <form class="content-area" action="forgetpassword" method="post">
            <h4>Verify Code</h4>
            <!--            <h5>Welcome Back!</h5>-->
            <p>

                As an added security mesure, please enter the 6-character code sent to your email.
            </p>
            <!--            <p><a href='#'>Need help?</a></p>-->
            <fieldset class='number-code'>
                <legend>Security Code</legend>
                <div>
                    <input name='code' class='code-input' required/>
                    <input name='code' class='code-input' required/>
                    <input name='code' class='code-input' required/>
                    <input name='code' class='code-input' required/>
                    <input name='code' class='code-input' required/>
                    <input name='code' class='code-input' required/>
                </div>
            </fieldset>
            <p><a href='#'>Resend Code</a></p>
            <input type="submit" value="Submit">
        </form>


        <script src="js/verify.js"></script>
    </body>
</html>
