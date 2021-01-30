package OperationSystems;

import Interfaces.SystemRules;

import java.io.IOException;

public class Mac implements SystemRules {
    @Override
    public boolean systemExclusionRules(String OS) throws IOException {
        return true;
    }

    @Override
    public void writePropValuesToStrings() throws IOException {

    }
}
