package bdd;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import states.ClockState;
import states.Context;
import states.Mode;
import states.timer.AbstractTimer;
import states.timer.IdleTimer;

import static org.junit.jupiter.api.Assertions.*;

public class TestScenarios {

    private Context context;
    private ClockState current;

    @Given("the timer context is initialised")
    public void the_timer_context_is_initialised() {
        context = new Context();
        AbstractTimer.resetInitialValues();
        current = context.currentState;
    }

    @Then("the timer mode is {string}")
    public void the_timer_mode_is(String expected) {
        assertEquals(Mode.valueOf(expected), current.getMode());
    }

    @Then("the timer state is IdleTimer")
    public void the_timer_state_is_idle_timer() {
        assertSame(IdleTimer.Instance(), current);
    }

    @Then("the timer value is {int}")
    public void the_timer_value_is(Integer expected) {
        assertEquals(expected.intValue(), AbstractTimer.getTimer());
    }

    @Then("the mem timer value is {int}")
    public void the_mem_timer_value_is(Integer expected) {
        assertEquals(expected.intValue(), AbstractTimer.getMemTimer());
    }
}