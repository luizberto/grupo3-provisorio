package br.com.sporty.api.SportyAPI;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    List<Usuario> listaUser = new ArrayList<>();


    @PostMapping("/jogador")
    public String addUserJogador(@RequestBody UsuarioJogador u){
        listaUser.add(u);
        u.setId(listaUser.size());
        return "Cadastrado";
    }
    @PostMapping("/dono")
    public String addUserDono(@RequestBody UsuarioDono u){
        listaUser.add(u);
        u.setId(listaUser.size());
        return "Cadastrado";
    }
    @GetMapping()
    public List<Usuario> exibirUsers(){
        return listaUser.stream()
                .sorted(Comparator.comparing(Usuario::getId))
                .collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id){
        for(Usuario user: listaUser){
            if(user.getId() == id){
                listaUser.remove(user);
                return "Usuario removido";
            }
        }
        return "Usuario não encontrado";
    }


}
