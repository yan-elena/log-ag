package log;

import jason.architecture.*;
import jason.asSemantics.*;
import jason.asSyntax.*;

import java.util.*;

public class LoggerArch extends AgArch {

    @Override
    public void act(ActionExec action) {
        System.out.println("log: doing "+action);

        super.act(action);
    }

    @Override
    public void reasoningCycleFinished() {
        if (getTS().getC().getAction() != null)  {
            System.out.println("log: doing "+getTS().getC().getAction().getActionTerm());
        }
        //System.out.println("log:  "+getAgArchClassesChain());
    }

    // TODO: see other methods from  AgArch to Override
}
