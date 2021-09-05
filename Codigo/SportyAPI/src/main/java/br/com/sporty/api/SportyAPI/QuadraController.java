package br.com.sporty.api.SportyAPI;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/quadra")
public class QuadraController {

    List<br.com.joao.c13adsajoaovitorrosa01201126.Quadra> listaQuadra = new ArrayList<>();

    @GetMapping()
    public List<br.com.joao.c13adsajoaovitorrosa01201126.Quadra> exibirQuadra(){
        return listaQuadra.stream()
                .sorted(Comparator.comparing(br.com.joao.c13adsajoaovitorrosa01201126.Quadra::getId))
                .collect(Collectors.toList());
    }
    @PostMapping()
    public String addQuadra(@RequestBody br.com.joao.c13adsajoaovitorrosa01201126.Quadra q){
        listaQuadra.add(q);
        q.setId(listaQuadra.size());
        return "Quadra cadastrada";
    }
    @DeleteMapping()
    public String deleteQuadra(@PathVariable int id){
        for(br.com.joao.c13adsajoaovitorrosa01201126.Quadra q: listaQuadra){
            if(q.getId() == id){
                listaQuadra.remove(q);
                return "Quadra removida";
            }
        }
        return "Quadra não encontrada";
    }


    @GetMapping("/{id}/partida")
    public List<br.com.joao.c13adsajoaovitorrosa01201126.Partida> exibirPartidas(@PathVariable int id){
        Boolean encontrado = false;
        for(br.com.joao.c13adsajoaovitorrosa01201126.Quadra q: listaQuadra){
            return new ArrayList<>(q.getPartidas());
        }
        return null;
    }
    @PostMapping("/{id}/partida")
    public String addPartida(@PathVariable int id, @RequestBody br.com.joao.c13adsajoaovitorrosa01201126.Partida p){

        for(br.com.joao.c13adsajoaovitorrosa01201126.Quadra q: listaQuadra){
            if(q.getId() == id){
                q.addPartida(p);
                p.setId(q.getPartidas().size());
                return "Partida criada";
            }
        }
        return "Quadra não encontrada";
    }
    @DeleteMapping("/{id}/partida/{idPartida}")
    public String deletePartida(@PathVariable int id, @PathVariable int idPartida){
        for(br.com.joao.c13adsajoaovitorrosa01201126.Quadra q: listaQuadra){
            if(q.getId() == id) {
                for (br.com.joao.c13adsajoaovitorrosa01201126.Partida p : q.getPartidas()) {
                    if (p.getId() == idPartida) {
                        q.deletePartida(p);
                        return "Partida deletada";
                    }
                }
            }
        }
        return "Partida não encontrada";
    }

}
