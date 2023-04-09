package log;

import java.util.List;

import jason.asSemantics.*;
import jason.asSyntax.Plan;
import jason.asSyntax.Term;
import jason.asSyntax.Trigger;

public class LoggerAg extends Agent implements GoalListener, CircumstanceListener {

    @Override
    public void initAg() {
        super.initAg();

        // add listeners
        getTS().addGoalListener(this);
        getTS().getC().addEventListener(this);
    }

    @Override // from Agent class
    public Option selectOption(List<Option> options) {
        printLog("[OPTION]] for "+getTS().getC().getSelectedEvent().getTrigger()+" are: \n"+options);
        return super.selectOption(options);
    }

    // Goal  Listener Interface

    @Override
    public void goalStarted(Event goal) {
        printLog("goal "+goal.getTrigger()+" started!");
    }

    @Override
    public void goalFailed(Trigger goal, Term reason) {printLog("goal " + goal + "failed");}

    // Circumstance Listener Interface

    @Override
    public void intentionAdded(Intention i) {
        CircumstanceListener.super.intentionAdded(i);
        printLog("new intention added " + i);
    }

    @Override
    public void eventAdded(Event e) {
        printLog("new event "+e.getTrigger());
    }

    // TODO: see other methods of Goal & Circumstance Listeners

    void printLog(String m) {
//        if (!m.contains("+!jcm::")) // filter some msgs
            System.out.println("log: "+m);
    }
}
