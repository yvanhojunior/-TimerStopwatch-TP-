package states;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class ClockStateTest {



    private static final class TestableClockState extends ClockState {

        TestableClockState() {}

        TestableClockState(boolean ringing) {
            setRigging(ringing);
        }

        ClockState callDoIt() {
            return doIt();
        }

        @Override
        public ClockState left() {
            return this;
        }

        @Override
        public String getDisplayString() {
            return "stub";
        }

        @Override
        public Mode getMode() {
            return null;
        }
    }

    @Test
    @DisplayName("ClockState.up() returns the same instance by default")
    void upReturnsThis(){
        ClockState s = new TestableClockState();
        assertSame(s, s.up());

    }

    @Test
    @DisplayName("ClockState.right() returns the same instance by default")
    void rightReturnsThis() {
        ClockState s = new TestableClockState();
        assertSame(s, s.right());
    }

    @Test
    @DisplayName("ClockState.doIt() covers ringing branch when isRigging=true")
    void doItRingingBranch() {
        ClockState s = new TestableClockState(true).callDoIt();
        assertSame(TestableClockState.class, s.getClass());
    }

    @Test
    @DisplayName("ClockState.doIt() covers non-ringing branch when isRigging=false")
    void doItNotRingingBranch() {
        ClockState s = new TestableClockState(false).callDoIt();
        assertSame(TestableClockState.class, s.getClass());
    }
}
