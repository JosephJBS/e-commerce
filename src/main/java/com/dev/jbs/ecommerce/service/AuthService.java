package com.dev.jbs.ecommerce.service;

import com.dev.jbs.ecommerce.dto.response.BasicResponse;
import com.dev.jbs.ecommerce.model.Usuario;

public interface AuthService {
    BasicResponse login(String username, String password);
    BasicResponse register(Usuario usuario);
}
