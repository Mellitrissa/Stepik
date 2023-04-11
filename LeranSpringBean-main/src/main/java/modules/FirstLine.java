package modules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FirstLine {
    @Autowired
            public FirstLine(SecondLine nextLine) {
        this.nextLine = nextLine;
    }
    SecondLine nextLine;

    @Override
    public String toString() {
        return "Я помню чудное мгновенье:\n" + nextLine;
    }
}
