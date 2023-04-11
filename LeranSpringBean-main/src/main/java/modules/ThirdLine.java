package modules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ThirdLine {
    FourthLine fourthLine;

   @Autowired
    public void setFourthLine(FourthLine fourthLine) {
        this.fourthLine = fourthLine;
    }

    @Override
    public String toString() {
        return "Как мимолетное виденье,\n" + fourthLine;
    }
}
