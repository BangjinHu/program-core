package theory.backtraces;

import java.util.*;

public class Kettle {

    // 水壶问题，a b升的水壶，如何能满足target
    public static void main(String[] args) {

    }

    private boolean canMeasureWater(int x, int y, int target) {
        if (target == 0) {
            return true;
        }
        if (x + y < target) {
            return false;
        }

        State initState = new State(0, 0);
        Queue<State> queue = new LinkedList<>();
        Set<State> visited = new HashSet<>();

        queue.add(initState);
        visited.add(initState);

        while (!queue.isEmpty()) {
            State head = queue.poll();

            int curX = head.getX();
            int curY = head.getY();

            if (curX == target || curY == target || curX + curY == target) {
                return true;
            }

            List<State> nextStates = getNextStates(curX, curY, x, y);
            for (State nextState : nextStates) {
                if (!visited.contains(nextState)) {
                    queue.offer(nextState);
                    visited.add(nextState);
                }
            }
        }
        return false;
    }

    private List<State> getNextStates(int curX, int curY, int x, int y) {

        List<State> nextStates = new ArrayList<>(8);

        State nextState1 = new State(x, curY);
        State nextState2 = new State(curX, y);

        State nextState3 = new State(0, curY);
        State nextState4 = new State(curX, 0);

        State nextState5 = new State(curX - (y - curY), y);
        State nextState6 = new State(0, curX + curY);

        State nextState7 = new State(x, curY - (x - curX));
        State nextState8 = new State(curX + curY, 0);

        if (curX < x) {
            nextStates.add(nextState1);
        }

        if (curY < y) {
            nextStates.add(nextState2);
        }

        if (curX > 0) {
            nextStates.add(nextState3);
        }

        if (curY > 0) {
            nextStates.add(nextState4);
        }

        if (curX - (y - curY) > 0) {
            nextStates.add(nextState5);
        }
        if (curY - (x - curX) > 0) {
            nextStates.add(nextState7);
        }

        if (curX + curY < y) {
            nextStates.add(nextState6);
        }
        if (curX + curY < x) {
            nextStates.add(nextState8);
        }

        return nextStates;
    }


    private class State {
        private final int x;
        private final int y;

        public State(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public String toString() {
            return "State{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            State state = (State) o;
            return x == state.x && y == state.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(getX(), getY());
        }
    }
}
