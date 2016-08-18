package juno4j.delegation;

import java.util.ArrayList;
import java.util.Collections;

public class DelegateList extends ArrayList<ChainableDelegate> {

    public void sort() {
        sort((o1, o2) -> o1.compareTo(o2));
    }

    public ChainableDelegate delegateForLastResponder(ChainableDelegate d1) {
        sort();
        Collections.reverse(this);

        DelegateList chain = new DelegateList();
        chain.add(d1);

        this.stream().filter(d2 -> interfaceMatches(d1, d2)).forEachOrdered(d2 -> chainDelegate(chain, d2));

        chain.sort();

        return chain.get(0);
    }

    private void chainDelegate(DelegateList chain, ChainableDelegate delegate) {

        if (chain.size() > 0) {
            ChainableDelegate prev = chain.get(chain.size() - 1);

            if (prev != null) {
                delegate.setForward(prev);
            }
        }

        chain.add(delegate);
    }

    private boolean interfaceMatches(ChainableDelegate d1, ChainableDelegate d2) {
        Class<?>[] i1 = d1.getClass().getInterfaces();
        Class<?>[] i2 = d2.getClass().getInterfaces();

        if (i1.length == 0 || i2.length == 0) {
            return false;
        }

        if (i1[0].getSimpleName().equals(i2[0].getSimpleName())) {
            return true;
        }

        return false;
    }

}
