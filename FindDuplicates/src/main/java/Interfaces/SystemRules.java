package Interfaces;

import java.io.IOException;

public interface SystemRules {
    boolean systemExclusionRules(String OS) throws IOException;
    void writePropValuesToStrings() throws IOException;
}
