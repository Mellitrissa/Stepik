package modules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SecondLine {
    ThirdLine thirdLine;

    @Autowired
    public SecondLine(ThirdLine thirdLine) {
        this.thirdLine = thirdLine;
    }

    @Override
    public String toString() {
        return "Передо мной явилась ты,\n" + thirdLine;
    }
}
