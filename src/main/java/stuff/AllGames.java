package stuff;

import entity.Games;
import service.GamesService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class AllGames {
    private List<Games> games;

    @EJB
    private GamesService gamesService;

    @PostConstruct
    public void init(){
        games = new ArrayList<>();
        games.addAll(gamesService.getAll());
    }

    public List<Games> getGames(){
        return games;
    }

    public void setGames(List<Games> games){
        this.games = games;
    }

    public String deleteGame(long id){
        gamesService.delete(gamesService.findById(id));
        return "/games.xhtml?faces-redirect=true";
    }

    public String redirectToEditGame(){
        return "/editGame.xhtml?faces-redirect=true";
    }
}
