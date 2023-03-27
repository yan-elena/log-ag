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

    // TODO: see other methods from  AgArch to Override
}
