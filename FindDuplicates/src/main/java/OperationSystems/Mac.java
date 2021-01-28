package OperationSystems;

import Interfaces.SystemRules;

import java.io.IOException;

public class Mac implements SystemRules {
    @Override
    public boolean systemExclusionRules(String OS) throws IOException {
        return false;
    }

    @Override
    public void writePropValuesToStrings() throws IOException {

    }
}
