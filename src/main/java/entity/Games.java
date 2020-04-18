package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@NamedQueries({
        @NamedQuery(name = "findAllGames", query = "SELECT g FROM Games g")
})
public class Games {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private int year;
    private String genre;
    private String company;

    public Games(String name, int year, String company, String genre){
        this.name = name;
        this.year = year;
        this.company = company;
        this.genre = genre;
    }
}
