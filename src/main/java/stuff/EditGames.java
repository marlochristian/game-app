package stuff;

import entity.Games;
import service.GamesService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class EditGames implements Serializable {
    private String name;
    private int year;
    private String company;
    private String genre;

    @EJB
    private GamesService gamesService;
    private transient Games gameToUpdate;

    public void populateView(long gamesId){
        gameToUpdate = gamesService.findById(gamesId);
        this.setName(gameToUpdate.getName());
        this.setYear(gameToUpdate.getYear());
        this.setCompany(gameToUpdate.getCompany());
        this.setGenre(gameToUpdate.getGenre());
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getYear(){
        return year;
    }

    public void setYear(int year){
        this.year = year;
    }

    public String getCompany(){
        return company;
    }

    public void setCompany(String company){
        this.company = company;
    }

    public String getGenre(){
        return genre;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    public String save(){
        Games createdGame = new Games(name, year, company, genre);
        if(gameToUpdate != null){
            createdGame.setId(gameToUpdate.getId());
            gamesService.update(createdGame);
        }
        else{
            gamesService.create(createdGame);
        }
        nullifyFields();
        return "/games.xhtml?faces-redirect=true";
    }

    private void nullifyFields(){
        gameToUpdate = null;
        this.setName(null);
        this.setYear(0);
        this.setCompany(null);
        this.setGenre(null);
    }
}
