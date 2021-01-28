package OperationSystems;

import Interfaces.SystemRules;

import java.io.IOException;

public class Linux implements SystemRules {
    @Override
    public boolean systemExclusionRules(String OS) throws IOException {
        return false;
    }

    @Override
    public void writePropValuesToStrings() throws IOException {

    }
}
