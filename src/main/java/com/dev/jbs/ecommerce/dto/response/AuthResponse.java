package com.dev.jbs.ecommerce.dto.response;

public class AuthResponse extends BasicResponse{

    public static BasicResponse usuarioNoEncontrado(){
        return new BasicResponse()
                .builder()
                .status(404)
                .message("Usuario no encontrado")
                .build();

    }
    public static BasicResponse passwordIncorrecto(){
        return new BasicResponse()
                .builder()
                .status(401)
                .message("Constraseña incorrecta")
                .build();

    }

}
