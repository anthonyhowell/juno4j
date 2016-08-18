package juno4j.delegation;

public class ChainableDelegate<T> implements Comparable<ChainableDelegate> {

    private Integer order;

    private ChainableDelegate<T> forward;


    public ChainableDelegate(Integer order) {
        this.order = order;
    }

    public Integer getOrder() {
        return order;
    }

    public ChainableDelegate<T> getForward() {
        return forward;
    }

    public void setForward(ChainableDelegate<T> forward) {
        this.forward = forward;
    }

    @Override
    public int compareTo(ChainableDelegate o) {
        return order.compareTo(o.getOrder());
    }

}
