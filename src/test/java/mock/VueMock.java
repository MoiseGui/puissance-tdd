package mock;

import view.Vue;

public class VueMock implements Vue {
    @Override
    public void write(String message) {

    }

    @Override
    public int read() {
        return 0;
    }
}
