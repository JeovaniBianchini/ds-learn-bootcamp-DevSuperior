package com.devsuperior.dslearnbds.services;

import com.devsuperior.dslearnbds.entities.User;
import com.devsuperior.dslearnbds.repositories.UserRepository;
import com.devsuperior.dslearnbds.services.exceptions.ForbiddenException;
import com.devsuperior.dslearnbds.services.exceptions.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {   //Classe para autorização customizada a nivel de serviço

    @Autowired
    private UserRepository userRepository;

    //Método para retornar o usuario logado
    @Transactional(readOnly = true)
    public User authenticated(){
        try {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();  //busca do usuario
            return userRepository.findByEmail(username);                                         //retorna o usario atribuido na string
        }
        catch (Exception e){
            throw new UnauthorizedException("user is not authenticated");
        }
    }

    //Método para verificar se o id do usario logado é o mesmo do id que está buscando.
    public void validateSelfOrAdmin(Long userId){
        User user = authenticated();
        if (!user.getId().equals(userId) && !user.hasRole("ROLE_ADMIN")){      //Se o id não for o mesmo e não tiver o perfil de Admin retorna uma excessão que não está autorizado.
            throw new ForbiddenException("User is not authorized");
        }
    }

}
