package Players;

import enums.Signs;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Player {
    private Signs signs; // камень ножницы бумага
    private String name;
    private int numberOfRoundsWon;
}
