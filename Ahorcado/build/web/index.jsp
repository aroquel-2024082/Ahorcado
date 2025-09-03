<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Juego del Ahorcado</title>
    <link rel="stylesheet" href="css/ahorcado.css">
</head>
<body>
    <div class="login-container">
        <div class="login-card">
            <div class="user-avatar">
                <div class="avatar-circle">
                    <div class="user-icon">
                        <div class="head"></div>
                        <div class="body"></div>
                    </div>
                </div>
            </div>

            <form action="login" method="post" class="login-form">
                <div class="input-group">
                    <div class="input-container">
                        <div class="icon user-field-icon">
                            <div class="user-small-icon">
                                <div class="small-head"></div>
                                <div class="small-body"></div>
                            </div>
                        </div>
                        <input type="text" 
                               id="username" 
                               name="username" 
                               placeholder="Username"
                               required>
                    </div>
                </div>

                <div class="input-group">
                    <div class="input-container">
                        <div class="icon lock-icon">
                            <div class="lock-body"></div>
                            <div class="lock-shackle"></div>
                        </div>
                        <input type="password" 
                               id="password" 
                               name="password" 
                               placeholder="Password"
                               required>
                        <div class="eye-icon">
                            <div class="eye">
                                <div class="eyeball"></div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="form-options">
                    <label class="remember-me">
                        <input type="checkbox" name="remember">
                        <span class="checkmark"></span>
                        <span class="remember-text">Remember me</span>
                    </label>
                    <a href="#" class="forgot-password">Forgot password?</a>
                </div>

                <button type="submit" class="login-btn">
                    <a href="ahorcado.jsp">Ingresar</a>
                </button>
            </form>
        </div>
    </div>
</body>
</html>